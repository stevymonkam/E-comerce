package com.stevy.contratti;

import com.stevy.contratti.service.ContraService;
import com.stevy.contratti.service.FileContratService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication {
    @Resource
    FileContratService fileContratService;



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ContraService contraService) {
        return args->{
            fileContratService.deleteAll();
            fileContratService.init();
             //contraService.compareDate3(1l);
             //contraService.ListInterrogazione("2021-09-06","2021-09-06","2021-09-06");


        };
    }

}
