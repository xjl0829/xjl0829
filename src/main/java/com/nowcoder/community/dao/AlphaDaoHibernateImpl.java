package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @Auther: xjl
 * @Date: 2022/5/11 - 13:33
 * @Description: com.nowcoder.community.dao
 * @Version: 1.8
 */
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }

}
