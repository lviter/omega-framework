package com.omega.framework.springboot.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author: lviter
 * @desc:sql操作基础类
 * @date:2022/6/9
 */
@Service
public class SqlBaseService {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Integer saveData() {
        long start = System.currentTimeMillis();
        Connection connection = sqlSessionTemplate.getConnection();
        String sql = "insert into mymillion values(null,?,?,?,NOW())";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            //  不断产生sql
            for (int i = 0; i < 1000000; i++) {
                ps.setString(1, Math.ceil(Math.random() * 1000000) + "");
                ps.setString(2, Math.ceil(Math.random() * 1000000) + "");
                ps.setString(3, UUID.randomUUID().toString());  //  UUID该类用于随机生成一串不会重复的字符串
                ps.addBatch();  //  将一组参数添加到此 PreparedStatement 对象的批处理命令中。
            }
            int[] ints = ps.executeBatch();//   将一批命令提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。
            //  如果数组长度不为0，则说明sql语句成功执行，即百万条数据添加成功！
            if (ints.length > 0) {
                System.out.println("已成功添加一百万条数据！！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();  //  再次获取系统时间
        System.out.println("所用时长:" + (end - start) / 1000 + "秒");
        return 1;
    }


}
