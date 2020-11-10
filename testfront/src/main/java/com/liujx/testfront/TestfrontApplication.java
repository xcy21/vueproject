package com.liujx.testfront;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.liujx.testfront.dao")
public class TestfrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestfrontApplication.class, args);
    }

}
