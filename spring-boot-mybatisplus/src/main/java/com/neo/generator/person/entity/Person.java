package com.neo.generator.person.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 菜鸟
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自己
     */
    private String self;

    /**
     * 妻子
     */
    private String wife;

    /**
     * 父亲
     */
    private String father;

    /**
     * 母亲
     */
    private String mother;

    /**
     * 兄弟
     */
    private String brother;

    /**
     * 朋友
     */
    private String friend;


}
