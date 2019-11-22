package com.sitech.family;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.sitech.family.custqryservice.mapper")
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class CustqryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustqryserviceApplication.class, args);
    }
}
