package com.neo.moretest.annotationtest;import org.springframework.context.annotation.AnnotationConfigApplicationContext;/** * @Bean是在使用了@Configuration注解的类上被声明的，属于Full @Configuration。 * @Configuration类中的@Bean地方会被CGLIB进行代理。Spring会拦截该方法的执行， * 在默认单例情况下，容器中只有一个Bean，所以我们多次调用user()方法，获取的都是同一个对象。 * * lite @Bean mode模式下， @Bean方法不会被CGLIB代理，所以多次调用user()会生成多个user对象。 */public class FullAndLiteTest {    public static void main(String[] args) {//        fullTest();        liteTest();    }    private static void liteTest() {        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LiteConfig.class);        User bean = context.getBean(User.class);        System.out.println(bean.hashCode());        context.close();    }    private static void fullTest() {        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FullConfig.class);        User bean = context.getBean(User.class);        System.out.println(bean.hashCode());        context.close();    }}