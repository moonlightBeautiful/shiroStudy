package com.ims.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author gaoxu
 * @date 2019-05-13 11:19
 * @description ... 类
 */
public class DbUtil {
    /**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shiro?serverTimezone=UTC", "root", "root");
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     * @throws Exception
     */
    public static void closeConn(Connection conn) throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DbUtil.getConn();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("数据库连接失败");
        } finally {
            try {
                DbUtil.closeConn(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
