package com.mee.service;


import com.mee.common.util.SeqGenUtil;
import com.mee.core.dao.DBSQLDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/***
 * 多数据源事务测试
 */
@SpringBootTest
@ActiveProfiles("dev")
public class TmpTranslationTest {

    @Resource
    private DBSQLDao DBSQLDao;

    @Test
    public void test01()throws Exception{
        this.insert();
    }

    public void  insert()throws Exception{
        Map<String,Object> insetParam1 = new HashMap<String,Object>(2,1){{
            put("id", SeqGenUtil.genSeq());
            put("name","hello~");
        }};
        int  insert1Count = DBSQLDao.create("com.mee.xml.tmp.insert",insetParam1);
        System.out.println("======>insert1Count:"+insert1Count);
    }
}
