package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.mapper.DiscussPostMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith (SpringRunner.class)
@SpringBootTest
@ContextConfiguration (classes = CommunityApplication.class)
public class discussPostMapperTest {

    @Autowired
    DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0,0,10);
        for(DiscussPost discussPost:discussPosts){
            System.out.println(discussPost);
        }
    }

    @Test
    public void testSelectDiscussPostRows(){
        int i = discussPostMapper.selectDiscussPostRows(3);
        System.out.println(i);
    }
}
