package com.neo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private Environment environment;

    @org.junit.Test
    public void test(){
        String property = environment.getProperty("clientId", "unknown");
        System.out.println(property);
    }
}
