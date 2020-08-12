package com.neo.dao;

import com.neo.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description: TODO
 * @Author 樊斌
 * @Date 2020/8/12
 * @Version V1.0
 **/
public interface UserInfoCrudRepository extends CrudRepository<UserInfo,Long> {
}
