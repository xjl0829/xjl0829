package com.nowcoder.community.mapper;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: xjl
 * @Date: 2022/5/11 - 23:01
 * @Description: com.nowcoder.community.mapper
 * @Version: 1.8
 */

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    //@Param注解用于给参数起别名
    //如果只有一个参数，并且在<if>里使用，则必须起别名
    int selectDiscussPostRows(@Param("userId") int userId);




}
