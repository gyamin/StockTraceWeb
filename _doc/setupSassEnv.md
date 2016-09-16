#Sass Environment Setup By Ruby Gem

## 環境準備

0. はじめに

    1. Node.jsの準備
    Node.jsをnodebrew環境でインストールする。

1. sassコンパイル(Gulp利用編)
sassファイルのコンパイル、jsファイルの難読化などのにGulpを利用する場合の、セットアップ方法を記載する。

    1. gulpのインストール
    ```
    $ cd ./stockTraceWeb/app/src/main/webapp
    # globalにインストール
    $ npm install --global gulp-cli
    # プロジェクトディレクトリにインストール
    $ npm init
    $ npm install --save-dev gulp
    ```

    2. gulp-sassのインストール
    ```
    $ npm install gulp-sass --save-dev
    ```

    3. gulpfile.jsの作成
    gulpで実行するジョブ内容を記載したgulpfile.jsを作成する。
    ```
    $ touch gulpfile.js
    ```

    4. gulpの実行
    ```
    $ gulp
    [02:21:31] Using gulpfile ~/Develop/Repos/stockTraceWeb/app/src/main/webapp/gulpfile.js
    [02:21:31] Starting 'sass'...
    [02:21:31] Finished 'sass' after 9.01 ms
    [02:21:31] Starting 'default'...
    [02:21:31] Finished 'default' after 30 μs
    ```

2. bower
フロントサイドで利用するパッケージ群の管理にbowerを利用する。

    1. bowerインストール
    `$ npm install -g bower`
    ```
    $ cd app/src/main/webapp/
    $ npm install -g bower
    └── bower@1.7.9
    ```

    2. bower.jsonの作成
    ```
    $ cd ./stockTraceWeb/app/src/main/webapp/resorces
    $ bower init
    ```

    3. bowerで利用するパッケージのインストール
    ```
    $ bower install jquery#2 --save
    bower cached        https://github.com/jquery/jquery-dist.git#2.2.4
    bower validate      2.2.4 against https://github.com/jquery/jquery-dist.git#2
    bower install       jquery#2.2.4
    jquery#2.2.4 bower_components/jquery

    $ bower install bootstrap --save
    bower cached        https://github.com/twbs/bootstrap.git#3.3.6
    bower validate      3.3.6 against https://github.com/twbs/bootstrap.git#*
    bower install       bootstrap#3.3.6
    bootstrap#3.3.6 bower_components/bootstrap
    └── jquery#2.2.4
    ```

    3. パッケージの利用
    bowerコマンドでインストールしたパッケージは、bower_components/パッケージ名で保存される。
    以下のようにhtmlからインポートして利用できる。
    ```scss
    @import "./../bower_components/reset-css/_reset";
    @import "./../bower_components/bootstrap/dist/css/bootstrap.min.css";
    ```

    ```javascript
    <script src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js" />"></script>
    ```

3. babelの利用
    1. gulp-babelのインストール
    ```
    $ npm install --save-dev gulp-babel babel-preset-es2015
    ```