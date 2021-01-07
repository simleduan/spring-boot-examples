package com.neo.generator.person.controller;


import com.neo.generator.person.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 菜鸟
 * @since 2021-01-07
 */
@RestController
@RequestMapping("/person/person")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @RequestMapping("listMaps")
    public List<Map<String, Object>> listMaps(){
        List<Map<String, Object>> maps = personService.listMaps();
        return maps;
    }
}
