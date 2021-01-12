package com.neo;import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;import com.neo.generator.student.entity.Student;import com.neo.generator.student.service.impl.StudentServiceImpl;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.context.junit4.SpringRunner;import java.util.ArrayList;import java.util.List;/** * Created by cainiao on 2021/1/7 10:46 下午 */@SpringBootTest@RunWith(SpringRunner.class)public class SampleGet {    @Autowired    private StudentServiceImpl studentService;    @Test    public void saveBatch(){        List<Student> students = createBatchStudent("小三", 10);        System.out.println(studentService.saveBatch(students));    }    // 根据 ID 查询    @Test    public void getById(){        System.out.println(studentService.getById(31));    }    // 根据 Wrapper，查询一条记录。结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")    @Test    public void getOne(){        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>()                .eq("name","打的费")                .last("limit 1");        System.out.println(studentService.getOne(queryWrapper));    }    // 根据 Wrapper，查询一条记录    @Test    public void getMap(){        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>()                .eq("name","打的费")                .last("limit 1");        System.out.println(studentService.getMap(queryWrapper));    }    public List<Student> createBatchStudent(String studentName,int insertCount){        List<Student> list = new ArrayList<>();        for (int i=0;i<insertCount;i++){            Student student = new Student();            student.setName(studentName+"_"+i);            student.setAge(String.valueOf(i));            list.add(student);        }        return list;    }}