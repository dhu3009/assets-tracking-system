package com.dhu.ats;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dhu.ats.mapper")
public class AssetsTrackingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssetsTrackingSystemApplication.class, args);
    }
}
