#Sass Environment Setup

## 環境準備
フロントサイドで利用するパッケージ群の管理にbowerを利用する。

1. bower

    1. bowerインストール
    `$ npm install -g bower`
    ```
    $ npm install -g bower
    └── bower@1.7.9 
    ```

    2. bowerで利用するパッケージのインストール
    ```
    $ bower install jquery --save
    $ bower install bootstrap --save
    ```

    3. パッケージの利用
    bowerコマンドでインストールしたパッケージは、bower_components/パッケージ名で保存される。     
    以下のようにhtmlからインポートして利用できる。
    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <title>Title</title>
      <!-- Bootstrap core CSS -->
      <link href="./../../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
      <!--jQuery-->
      <script src="./../../bower_components/jquery/dist/jquery.min.js"></script>
    </head>
    <body>
      <a class="btn btn-default" href="#" role="button">Link</a>
      <button class="btn btn-default" type="submit">Button</button>
      <input class="btn btn-default" type="button" value="Input">
      <input class="btn btn-default" type="submit" value="Submit">
    </body>
    </html>
    ```

2. sassのコンパイル(ruby gem利用)
sassファイルのコンパイルにruby gemを利用する場合の方法を記載する。rbenv環境は事前に準備できているものとして、sassコンパイル環境をセットアップする。

    1. rbenv, gemsetの準備
    ```
    $ rbenv local 2.1.5
    $ echo './vendor/bundle' > .rbenv-gemsets
    ```

    2. sassのインストール
    ```
    $ rbenv exec gem install sass
    Fetching: sass-3.4.22.gem (100%)
    Successfully installed sass-3.4.22
    Parsing documentation for sass-3.4.22
    Installing ri documentation for sass-3.4.22
    Done installing documentation for sass after 5 seconds
    1 gem installed
    $ sass -v
    Sass 3.4.22 (Selective Steve)
    ```
    
    3. scssのコンパイル
    + ファイル単位でコンパイルする
        ```
        $ sass assets/css/pages/search.scss public/assets/css/pages/search.scss
        ```

    + ディレクトリでソースと出力先を指定してコンパイルする
        --watch `sass --watch input:output`
        --watchを利用することで、ソースファイルの変更を監視し、変更すると自動的にコンパイルが行われる。
        ```
        $ sass --watch assets/css:public/assets/css
         Sass is watching for changes. Press Ctrl-C to stop.
        [Listen warning]:
          Listen will be polling for changes. Learn more at https://github.com/guard/listen#polling-fallback.
         Change detected to: assets/css/common/application.scss
              write public/assets/css/common/application.css
              write public/assets/css/common/application.css.map
        ```
        --update `sass --update input:output`
        ```
        $ sass --update assets/css:public/assets/css
              write public/assets/css/common/application.css
              write public/assets/css/common/application.css.map
        ```
    
    