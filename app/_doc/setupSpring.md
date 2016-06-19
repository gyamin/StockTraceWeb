# Spring Framework設定

## ベースディレクトリ作成
```
$ mkdir -p app/src/main/java
$ mkdir -p app/src/main/resources
$ mkdir -p app/src/main/webapp
$ cd src/main/java/
$ mkdir -p com/gyamin/stock_trace
$ mkdir -p com/gyamin/stock_trace/controller
$ mkdir -p com/gyamin/stock_trace/dao
$ mkdir -p com/gyamin/stock_trace/bean
$ mkdir -p com/gyamin/stock_trace/searvice
$ mkdir -p com/gyamin/stock_trace/util
```

## mavenセットアップ(pom.xmlの作成)
作成したappディレクトリ内に、pom.xmlファイルを作成し、以下記述する。
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <packaging>war</packaging>
    <groupId>gyamin.sample1</groupId>
    <artifactId>sample1</artifactId>
    <version>1.0-SNAPSHOT</version>
</project>
```

## pom.xmlへのライブラリの追加
mavenで管理するライブラリは、以下のようにdependenciesに追加する。
```
    <dependencies>
        <!-- Spring dependencies -->
        <!-- http://mvnrepository.com/artifact/org.springframework/spring-core -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.2.5.RELEASE</version>
        </dependency>

        <!-- http://mvnrepository.com/artifact/org.springframework/spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>4.2.5.RELEASE</version>
        </dependency>
    </dependencies>
```


