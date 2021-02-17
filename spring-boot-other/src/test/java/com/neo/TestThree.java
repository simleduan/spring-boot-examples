package com.neo;

import com.neo.valueannotation.DemoConfig;
import com.neo.valueannotation.DemoConfigTwo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestThree {
    @Autowired
    private DemoConfigTwo demoConfigTwo;

    @org.junit.Test
    public void test(){
        System.out.println(demoConfigTwo.toString());
    }
}
