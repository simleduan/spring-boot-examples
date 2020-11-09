package com.neo.spring.spel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * create by xiaocai on 2020/10/23 16:56
 **/
@Configuration
@Import({GetValue.class})
public class SpelConfig {

    @Bean
    public SpelBean spelBean(){
        return new SpelBean("spelName","我在测试啊");
    }
}
