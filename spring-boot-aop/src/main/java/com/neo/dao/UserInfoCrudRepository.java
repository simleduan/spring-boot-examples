package com.neo.dao;

import com.neo.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoCrudRepository extends CrudRepository<UserInfo,Long> {
}
