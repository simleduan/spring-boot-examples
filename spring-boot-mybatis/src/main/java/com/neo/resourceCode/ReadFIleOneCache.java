package com.neo.resourceCode;

import com.neo.generator.dao.PersonMapper;
import com.neo.generator.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * create by xiaocai on 2020/9/25 14:23
 *
 **/
public class ReadFIleOneCache {
    public static void main(String[] args) throws Exception {
        levelOneCache();//一级缓存测试
    }

    /**
     * 单个用户查询
     * @throws Exception
     */
    private static void levelOneCache() throws Exception{
        String path = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        Person person = mapper.selectByPrimaryKey(1);
        System.out.println(person);

        PersonMapper mapper2 = sqlSession.getMapper(PersonMapper.class);
        Person person30 = mapper2.selectByPrimaryKey(1);
        System.out.println(person30);

        Person person1 = createPerson();
        mapper2.insert(person1);



        PersonMapper mapper3 = sqlSession.getMapper(PersonMapper.class);
        Person person3 = mapper3.selectByPrimaryKey(1);
        System.out.println(person3);

        PersonMapper mapper4 = sqlSession.getMapper(PersonMapper.class);
        Person person4 = mapper4.selectByPrimaryKey(1);
        System.out.println(person4);

        sqlSession.commit();
    }

    private static Person createPerson() {
        Person person = new Person();
        person.setName("哈哈");
        person.setPolicyNo("2525775");
        person.setHometown("哈南");
        return person;
    }

}
