package com.neo.dao;

import com.neo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: TODO
 * @Author 樊斌
 * @Date 2020/8/12
 * @Version V1.0
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUserName(String userName);

    UserInfo findByUserNameOrEmail(String username, String email);
}
