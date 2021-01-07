package com.neo.generator.person.service.impl;

import com.neo.generator.person.entity.Person;
import com.neo.generator.person.mapper.PersonMapper;
import com.neo.generator.person.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 菜鸟
 * @since 2021-01-07
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
