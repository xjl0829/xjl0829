package com.nowcoder.community;

import com.nowcoder.community.entity.User;
import com.nowcoder.community.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: xjl
 * @Date: 2022/5/11 - 20:17
 * @Description: com.nowcoder.community
 * @Version: 1.8
 */

@RunWith (SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest  {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testSelectUserByName(){
        User user = userMapper.selectByName("liubei1");
        System.out.println(user);
    }

    @Test
    public void testSelectUserByEmail(){
        User user = userMapper.selectByEmail("@163.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("ls");
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void testUpdateHeader(){
        int i = userMapper.updateHeader(102, "123");
        System.out.println(i);
    }

    @Test
    public void testUpdateStatus(){
        int i = userMapper.updateStatus(102, 3);
        System.out.println(i);
    }

    @Test
    public void testUpdatePassword(){
        int i = userMapper.updatePassword(102, "0829");
        System.out.println(i);
    }

}
