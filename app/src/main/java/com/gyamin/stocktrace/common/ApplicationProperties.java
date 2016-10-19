package com.gyamin.stocktrace.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
// 読み込むプロパティファイルを指定
@PropertySource("classpath:/application.properties")
public class ApplicationProperties{
    @Autowired
    private Environment env;

    public String get(String key){
        return env.getProperty(key);
    }
}