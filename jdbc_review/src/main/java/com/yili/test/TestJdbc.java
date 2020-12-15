package com.yili.test;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "979yili.";
        //1.加载驱动：
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.向数据库发送SQL的对象CRUD
        Statement statement = connection.createStatement();
        //4.编写SQL
        String sql_one = "select * from users";
        ResultSet set = statement.executeQuery(sql_one);
        //5.输出数据
        while (set.next()){
            System.out.println("id="+set.getObject("id"));
            System.out.println("name="+set.getObject("name"));
            System.out.println("password="+set.getObject("password"));
            System.out.println("email="+set.getObject("email"));
            System.out.println("birthday="+set.getObject("birthday"));
        }
        //6.退出这个连接池
        set.close();
        statement.close();
        connection.close();

    }
}
