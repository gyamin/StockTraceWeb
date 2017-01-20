# Dockerの利用

## はじめに
ローカルの開発で必要なDBサーバなどをDockerで作成する。     
その他の環境はansibleを利用し、インフラを構成。

## 前提
前提としてMacにはDockerがインストールされていること。

## Dockerの利用

### Redisコンテナ

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
CONTAINER ID        IMAGE                  COMMAND                  CREATED             STATUS                      PORTS                    NAMES
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