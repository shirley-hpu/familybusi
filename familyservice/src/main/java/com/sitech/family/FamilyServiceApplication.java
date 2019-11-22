package com.sitech.family;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.sitech.family.familyservice.mapper")
@EnableSwagger2
public class FamilyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyServiceApplication.class, args);
    }
}
