package com.enchantment.eaas.dao;

import com.enchantment.eaas.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liushuang on 2016/9/12.
 */
@Component
public class AccountDAO {
    @Autowired
    private SqlSession session;

    public Account selectById(int id) {
        return session.selectOne("selectAccountById", id);
    }
}
