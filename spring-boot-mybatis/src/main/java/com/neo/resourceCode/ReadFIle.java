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
 **/
public class ReadFIle {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int count = 1000;
//        inserOne();//插入一条数据
//        getField();//获取ResultMap字段
        levelOneCache();//一级缓存测试
        long end = System.currentTimeMillis();
        System.out.println("插入"+count+"条记录耗时"+(end-start));
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
        System.out.println(person.getName());
        PersonMapper mapper11 = sqlSession.getMapper(PersonMapper.class);
        Person person30 = mapper11.selectByPrimaryKey(2);
        System.out.println(person30.getName());
    }

    /**
     * 批量插入1000条数据
     * @param count
     * @throws Exception
     */
    private static void simpleInsert(int count) throws Exception{
        String path = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        for (int i=0;i<count;i++){
            Person person = new Person();
            person.setName("卡卡麦提"+i);
            person.setAge(i);
            person.setGender(i%2==0?"boy":"girl");
            person.setHometown(i%2==0?"北京":"富士樱花山");
            person.setCreateTime(new Date());
            person.setPolicyNo("510988896__"+i);
            mapper.insert(person);
        }
        sqlSession.commit();

    }

    /**
     * 批量插入1000条数据
     * @param count
     * @throws Exception
     */
    private static void batchInsert(int count) throws Exception{
        String path = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        for (int i=0;i<count;i++){
            Person person = new Person();
            person.setName("卡卡麦提"+i);
            person.setAge(i);
            person.setGender(i%2==0?"boy":"girl");
            person.setHometown(i%2==0?"北京":"富士樱花山");
            person.setCreateTime(new Date());
            person.setPolicyNo("510988896__"+i);
            mapper.insert(person);
        }
        sqlSession.commit();
    }

    /**
     * 单个用户查询
     * @throws Exception
     */
    private static void inserOne() throws Exception{
        String path = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        int i = 10;
        Person person = new Person();
        person.setName("卡卡麦提"+i);
        person.setAge(i);
        person.setGender(i%2==0?"boy":"girl");
        person.setHometown(i%2==0?"北京":"富士樱花山");
        person.setCreateTime(new Date());
        person.setPolicyNo("510988896__"+i);
        mapper.insert(person);
        sqlSession.commit();
    }

    /**
     * 单个用户查询
     * @throws Exception
     */
    private static void getField() throws Exception{
        String path = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Set<String> mappedColumns = sqlSession.getConfiguration().getResultMap("com.neo.generator.dao.PersonMapper.BaseResultMap").getMappedColumns();
        Iterator<String> iterator = mappedColumns.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        XNode xNode = sqlSession.getConfiguration().getSqlFragments().get("com.neo.generator.dao.PersonMapper.Base_Column_List");
        System.out.println(xNode);
    }
}
