package com.neo;import org.mybatis.spring.annotation.MapperScan;import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;/** * Created by cainiao on 2021/1/7 10:43 下午 */@SpringBootApplication@MapperScan({"com.neo.mapper","com.neo.generator"})public class MybatisPlusApplication {    public static void main(String[] args) {        SpringApplication.run(MybatisPlusApplication.class,args);    }}