# フロントコーディング環境のセットアップ

## 概要
html、css、JavaScriptのフロントコーディングは以下の環境で実装する。  
なお、環境構築に先立って、node環境をセットアップしておく。

+ cssはsass(scss)形式でコーディングし、node-sassでコンパイルする。
+ JavaScriptはTypeScriptでコーディングし、tscコマンドでコンパイルする。
+ タスク管理はnpm scriptsを利用する。(Grunt、Gulpは使わない)
+ jQueryやbootstrapなどのjs、cssライブラリは、bowerで管理する。

## npmセットアップ
```
$ node -v
v5.12.0
$ npm install -g typescript
```

```
$ cd app/src/main/webapp/assets
$ npm init .
$ npm install bower --save
$ npm install typings --save-dev
$ npm install node-sass --save-dev
$ npm install watch --save-dev
```

## bowerによるフロントライブラリのインストール
```
$ ./node_modules/bower/bin/bower init .
$ ./node_modules/bower/bin/bower install jQuery --save
$ ./node_modules/bower/bin/bower install angular#1.5.8 --save
$ ./node_modules/bower/bin/bower install bootstrap --save
```

## Typingsによる型定義の導入
+ 設定ファイルの初期化
    ```
    $ ./node_modules/typings/dist/bin.js init
    $ ls -a
    typings.json
    ```

+ 定義取得
    ```
    $ ./node_modules/typings/dist/bin.js install dt~jquery --save --global
    jquery
    └── (No dependencies)
    
    $ ./node_modules/typings/dist/bin.js install dt~angular --save --global
    typings INFO reference Stripped reference "https://raw.githubusercontent.com/DefinitelyTyped/DefinitelyTyped/17f7f965f515e7085e085b42f7137c06f50f70e9/jquery/jquery.d.ts" during installation from "angular" (main)
    angular
    └── (No dependencies)

    $ ./node_modules/typings/dist/bin.js install dt~bootstrap --save --global
    typings INFO reference Stripped reference "https://raw.githubusercontent.com/DefinitelyTyped/DefinitelyTyped/1f0791147c6c145227b1778bb26781a79d516917/jquery/jquery.d.ts" during installation from "bootstrap" (main)
    bootstrap
    └── (No dependencies)
    ```
