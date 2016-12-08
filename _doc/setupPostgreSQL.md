# PostgreSQLセットアップ

### 概要
PostgreSQLをCentOS7にインストールする。

### インストール

+ PostgreSQLリポジトリの追加
```
# rpm -ivh https://download.postgresql.org/pub/repos/yum/9.4/redhat/rhel-7-x86_64/pgdg-centos94-9.4-2.noarch.rpm
```

+ PostgreSQLのインストール
```
# yum install postgresql94-server postgresql94
```

### セットアップ
+ データベースクラスタの作成
```
# su - postgres
$ /usr/pgsql-9.4/bin/initdb 
```

+ データベースの起動/停止
```
$ /usr/pgsql-9.4/bin/pg_ctl -D /var/lib/pgsql/9.4/data -l logfile start
サーバは起動中です。
$ /usr/pgsql-9.4/bin/pg_ctl -D /var/lib/pgsql/9.4/data -l logfile stop
サーバ停止処理の完了を待っています....完了
サーバは停止しました
```

+ 自動起動設定
```
# systemctl enable postgresql-9.4.service
```

+ systemctlからの起動/停止
```
# systemctl start postgresql-9.4.service
# systemctl status postgresql-9.4.service
● postgresql-9.4.service - PostgreSQL 9.4 database server
   Loaded: loaded (/usr/lib/systemd/system/postgresql-9.4.service; enabled; vendor preset: disabled)
   Active: active (running) since 日 2016-05-15 04:42:06 JST; 5s ago
   ...
# systemctl stop postgresql-9.4.service
```

+ firewalld設定
```
# firewall-cmd --add-port=5432/tcp --permanent
success
# firewall-cmd --list-all
public (default)
  interfaces: 
  sources: 
  services: dhcpv6-client ssh
  ports: 5432/tcp 80/tcp
  masquerade: no
  forward-ports: 
  icmp-blocks: 
  rich rules: 
```

+ postgresql接続設定
pg_hba.conf、postgresql.confをNetwork環境に合わせて変更。

+ postgresqlユーザの作成
```
$ sudo su - postgres
$ psql
psql (9.6.1)
"help" でヘルプを表示します.

# create role developer login password 'パスワード';
CREATE ROLE
```

+ データベースの作成
```
# create database データベース名 owner = developer;
CREATE DATABASE
```

## データのインポート
```
$ ls -l
合計 12644
-rw-r--r--. 1 gyamin gyamin 12944629 12月  7 11:15 20161206_010201_stock_trace.dump.gz
$ dropdb -U postgres stock_trace
$ createdb -U postgres stock_trace --owner=developer
$ gunzip -c 20161206_010201_stock_trace.dump.gz | psql -U postgres stock_trace
```