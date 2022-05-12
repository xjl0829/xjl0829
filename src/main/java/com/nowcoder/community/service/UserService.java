package com.nowcoder.community.service;

import com.nowcoder.community.entity.User;
import com.nowcoder.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: xjl
 * @Date: 2022/5/12 - 0:11
 * @Description: com.nowcoder.community.service
 * @Version: 1.8
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int userId){
        return userMapper.selectById(userId);
    }

}
