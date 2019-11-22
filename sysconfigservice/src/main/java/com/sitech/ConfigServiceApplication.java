package com.sitech;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@MapperScan("com.sitech.family.custservice.mapper")
public class ConfigServiceApplication
{
    @Bean
    public Runnable createRunnable(){
        return () -> {System.out.println("Runnable is running");};
    }
    public static void main(String[] args) {
        System.out.println("开始启动工程");
        ApplicationContext ctx =  SpringApplication.run(ConfigServiceApplication.class,args);
        ctx.getBean(Runnable.class).run();
        String[]  beanNames =  ctx.getBeanDefinitionNames();
        System.out.println("beanNames个数："+beanNames.length);
    }
}