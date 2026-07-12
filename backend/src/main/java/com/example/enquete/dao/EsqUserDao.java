package com.example.enquete.dao;

import com.example.enquete.entity.EsqUser;
import org.seasar.doma.AccessLevel;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao(accessLevel = AccessLevel.PUBLIC)
@ConfigAutowireable
public interface EsqUserDao {

    // IDでユーザーを取得するメソッド
    @Select
    EsqUser selectById(String esqId);
}
