package com.lovo.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot的入口

@SpringBootApplication
public class StartMain {

    public static void main(String[] args) {
        //启动springboot
        SpringApplication.run(StartMain.class,args);
    }
}
