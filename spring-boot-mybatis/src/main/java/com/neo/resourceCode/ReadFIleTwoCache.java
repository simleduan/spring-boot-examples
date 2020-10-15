package com.neo.resourceCode;

import com.neo.generator.dao.PersonMapper;
import com.neo.generator.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * create by xiaocai on 2020/9/25 14:23
 *是否应该使用二级缓存？
 * 那么究竟应该不应该使用二级缓存呢？先来看一下二级缓存的注意事项：
 *
 * 缓存是以namespace为单位的，不同namespace下的操作互不影响。
 * insert,update,delete操作会清空所在namespace下的全部缓存。
 * 通常使用MyBatis Generator生成的代码中，都是各个表独立的，每个表都有自己的namespace。
 * 多表操作一定不要使用二级缓存，因为多表操作进行更新操作，一定会产生脏数据。
 *
 * https://www.cnblogs.com/cxuanBlog/p/11333021.html
 **/
public class ReadFIleTwoCache {
    public static void main(String[] args) throws Exception {
        levelTwoCache();//一级缓存测试
    }

    /**
     * 单个用户查询
     * @throws Exception
     */
    private static void levelTwoCache() throws Exception{
        String path = "mybatis/mybatis-config-two-cache.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //第一个sqlSession
        SqlSession sqlSessionOne = sqlSessionFactory.openSession();
        PersonMapper mapperOne = sqlSessionOne.getMapper(PersonMapper.class);
        Person person = mapperOne.selectByPrimaryKey(1);
        System.out.println(person);
        sqlSessionOne.commit();
        //第二个Sqlsession
        SqlSession sqlSessionTwo = sqlSessionFactory.openSession();
        PersonMapper mapperTwo = sqlSessionTwo.getMapper(PersonMapper.class);
        Person person2 = mapperTwo.selectByPrimaryKey(1);
        System.out.println(person2);
    }

    private static Person createPerson() {
        Person person = new Person();
        person.setName("哈哈");
        person.setPolicyNo("2525775");
        person.setHometown("哈南");
        return person;
    }

}
