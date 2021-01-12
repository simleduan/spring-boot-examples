package com.neo.generator.student.service.impl;

import com.neo.generator.student.entity.Student;
import com.neo.generator.student.mapper.StudentMapper;
import com.neo.generator.student.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 菜鸟
 * @since 2021-01-08
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
