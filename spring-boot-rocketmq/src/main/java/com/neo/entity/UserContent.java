package com.neo.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * create by xiaocai on 2021/3/8 11:21
 **/
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
@Getter
@Setter
public class UserContent {
    private String username;
    private String pwd;
}
