package com.neo.dao;

import com.neo.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUserName(String userName);

    UserInfo findByUserNameOrEmail(String username, String email);
}
