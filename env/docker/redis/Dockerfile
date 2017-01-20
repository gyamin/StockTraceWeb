# redis
FROM redis

# 作成者
MAINTAINER Y.Nogami

# Redis 設定
ADD redis.conf /etc/redis.conf

# コンテナ作成時公開ポート番号
EXPOSE 6379

# コンテナ作成時実行コマンド
CMD ["/usr/sbin/php-fpm", "-F"]
