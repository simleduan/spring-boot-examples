package com.neo;

import com.sinosig.sunflower.fw.util.ThreadLocalUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: TODO
 * @Author 樊斌
 * @Date 2020/8/11
 * @Version V1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private Environment environment;

    @org.junit.Test
    public void test(){
        String property = environment.getProperty("clientId", "unknown");
        System.out.println(property);
        System.out.println(ThreadLocalUtil.getInstance().getTraceId().toString());
    }
}
