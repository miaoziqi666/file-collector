package com.souhu.filecollector;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@MapperScan("com.souhu.filecollector.api.dao")
@SpringBootApplication
public class FileCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileCollectorApplication.class, args);
    }

}
