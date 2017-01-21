# Dockerによる開発環境構築

## はじめに
ローカルの開発で必要なDBサーバなどをDockerで作成する。     
その他の環境はansibleを利用し、インフラを構成。

## 前提
前提としてMacにはDockerがインストールされていること。

## 環境構築

### Redis

#### イメージの検索/取得
+ イメージの検索
```
$ docker search redis
NAME                      DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
redis                     Redis is an open source key-value store th...   3268      [OK]       
sameersbn/redis                                                           41                   [OK]
```

+ イメージの取得
```
$ docker pull redis
```

#### コンテナの作成
+ 作成(起動)
--nameで作成するコンテナに名前をつけている。
```
$ docker run --name stocktraceWeb-redis -d -p 6379:6379 redis redis-server --appendonly yes
3fcd86bc2b2dea3f8f29b00a6cf2d11f1fddd1c50fccc35d779a8d800dda395b
```

+ 確認
```
$ docker ps
CONTAINER ID        IMAGE                  COMMAND                  CREATED             STATUS              PORTS                    NAMES
3fcd86bc2b2d        redis                  "docker-entrypoint.sh"   4 seconds ago       Up 2 seconds        0.0.0.0:6379->6379/tcp   stocktraceWeb-redis
```

#### コンテナの起動/停止
+ 停止
```
$ docker stop stocktraceWeb-redis
stocktraceWeb-redis
```
```
$ docker ps -a
CONTAINER ID        IMAGE                  COMMAND                  CREATED             STATUS                       PORTS                    NAMES
3fcd86bc2b2d        redis                  "docker-entrypoint.sh"   24 minutes ago      Exited (0) 58 seconds ago                            stocktraceWeb-redis
```

+ 起動
```
$ docker ps -a
CONTAINER ID        IMAGE                  COMMAND                  CREATED             STATUS              PORTS                    NAMES
3fcd86bc2b2d        redis                  "docker-entrypoint.sh"   25 minutes ago      Up 2 seconds        0.0.0.0:6379->6379/tcp   stocktraceWeb-redis
```

#### クライアントから接続
```
$ redis-cli -h 127.0.0.1
127.0.0.1:6379>
```

### PostgreSQL(Dockerfileを利用)

#### Dockerfileの作成
env/docker/postgres/Dockerfile を参照。

#### buildの実行
```bash
$ cd ./env/docker/postgres/Dockerfile
$ docker build -t debian:postgres .
Sending build context to Docker daemon 33.28 kB
Step 1 : FROM debian
...
```

```bash
$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED              SIZE
debian              postgres            c0f8f9a7b40e        About a minute ago   323.8 MB
```

#### コンテナの起動
```bash
$ docker run -d -p 5432:5432 --name postgres debian:postgres
001dd5fd1f497a2f8347a57929ed9d12dd30c85c54a43c4d79b54084be9bf740
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
001dd5fd1f49        debian:postgres     "/usr/lib/postgresql/"   31 seconds ago      Up 29 seconds       0.0.0.0:5432->5432/tcp   postgres
```

#### ローカルからの接続
```bash
$ psql -h 127.0.0.1 -U admin stock_trace
Password for user admin: 
psql (9.4.1, server 9.4.10)
SSL connection (protocol: TLSv1.2, cipher: ECDHE-RSA-AES256-GCM-SHA384, bits: 256, compression: off)
Type "help" for help.

stock_trace=# 
```

### docker-composeの利用

#### docker-compose.ymlファイルを準備
```yaml
version: '2'
services:
  postgres:
    build: ./postgres
    image: "debian:stockWeb-postgres"
    ports:
      - "5432:5432"
    container_name: stockWeb-postgres
```

#### buildの実行
```bash
$ docker-compose up
Building postgres
Step 1 : FROM debian
 ---> e5599115b6a6
Step 2 : MAINTAINER gaymin
...
stockWeb-postgres | 2017-01-21 16:57:56 UTC [1-1] LOG:  database system is ready to accept connections
stockWeb-postgres | 2017-01-21 16:57:56 UTC [10-1] LOG:  autovacuum launcher started
^CGracefully stopping... (press Ctrl+C again to force)
```

#### 確認
```bash
$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED              SIZE
debian              stockWeb-postgres   1883e7406956        About a minute ago   323.8 MB

$ docker ps -a
CONTAINER ID        IMAGE                      COMMAND                  CREATED              STATUS                          PORTS               NAMES
a19c5ab894f8        debian:stockWeb-postgres   "/usr/lib/postgresql/"   About a minute ago   Exited (0) About a minute ago                       stockWeb-postgres
```

#### composeの開始
```bash
$ docker-compose start
Starting postgres ... done

$ docker ps
CONTAINER ID        IMAGE                      COMMAND                  CREATED             STATUS              PORTS                    NAMES
a19c5ab894f8        debian:stockWeb-postgres   "/usr/lib/postgresql/"   2 minutes ago       Up 38 seconds       0.0.0.0:5432->5432/tcp   stockWeb-postgres

$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
debian              stockWeb-postgres   1883e7406956        3 minutes ago       323.8 MB
```



# Docker利用のサンプル

### PostgreSQLサーバの構築

```bash
$ docker pull debian
```

コンテナで作業ができるように-tiオプションをつけ、コンテナを起動。
```bash
$ docker run -ti --name stocktraceWeb-postgres debian /bin/bash
root@883f6725f745:/# 
```

#### コマンドを実行してみる
```bash
root@4037fd2379c8:/# apt update
Get:1 http://security.debian.org jessie/updates InRelease [63.1 kB]  
Get:2 http://security.debian.org jessie/updates/main amd64 Packages [434 kB]  
...
```

#### PostgreSQLのインストール
```bash
root@4037fd2379c8:/# apt install postgresql-9.4
Reading package lists... Done
Building dependency tree... Done
...
```

#### 変更を保存する
docker commitコマンドを利用して、コンテナをイメージとして保存する。        
docker commit [ -m メッセージ] コンテナID ベースイメージ:タグ

```bash
$ docker commit -m 'Install PostgreSQL' 4037fd2379c8 debian:postgres
sha256:614b725fab2c724b2a2e92ad9f3a7a3e0bed61a0335436f006c81fa67765707b
```
imageを確認すると、保存したイメージが作成されている。
```bash
$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
debian              postgres            614b725fab2c        16 hours ago        300.1 MB
redis               latest              45c3ea2cecac        3 days ago          182.9 MB
debian              latest              e5599115b6a6        4 days ago          123 MB
```
保存したイメージdebian:postgres を指定してコンテナを起動。ちゃんとPostgreSQLがインストールされたままとなっている。
```bash
$ docker run -it debian:postgres /bin/bash
root@87cb15b6bc53:/# 
root@87cb15b6bc53:/# ls -l /var/lib/postgresql/9.4/main/
total 72
-rw------- 1 postgres postgres    4 Jan 20 20:41 PG_VERSION
drwx------ 5 postgres postgres 4096 Jan 20 20:41 base
drwx------ 2 postgres postgres 4096 Jan 20 20:41 global
...
```
