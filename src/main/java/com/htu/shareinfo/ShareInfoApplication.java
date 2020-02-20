package com.htu.shareinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.htu.shareinfo.mapper")
public class ShareInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareInfoApplication.class, args);
    }

}
