# サーバインフラ環境構築

サーバ環境の構築は、ansibleを利用する。

## 環境構築 

env_xxx.ymlファイルを指定し、playbookを実行することで、以下の環境構築が行われる。
+ Nginx
+ Tomcat
+ PostgreSQL
+ その他、ツールパッケージのインストールなど

```
$ cd env/ansible
$ ansible-playbook -i hosts env_local.yml -s
```

## アプリケーションのデプロイ

アプリケーションのデプロイについても、ansibleを利用する。    
+ GitHubからのソースの取得
+ ビルド(warファイルの作成)
+ Webフロント資材のコンパイル、配置
```
$ cd env/ansible
$ ansible-playbook -i hosts deploy_local.yml -s
```