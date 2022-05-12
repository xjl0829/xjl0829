package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @Auther: xjl
 * @Date: 2022/5/11 - 13:36
 * @Description: com.nowcoder.community.dao
 * @Version: 1.8
 */
@Repository
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "mybatis!";
    }

}
