package com.neo;

import com.neo.valueannotation.DemoConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTwo {
    @Autowired
    private DemoConfig demoConfig;

    @org.junit.Test
    public void test(){
        System.out.println(demoConfig.toString());
    }
}
