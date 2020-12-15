package com.yili.test;

import java.sql.*;

public class TestJdbc02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8";
        String username = "root";


        String password = "979yili.";

        //1.加载驱动：
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.编写SQL
        String sql_one = "insert into users (id, name, password, email, birthday) values (?,?,?,?,?)";

        //4.预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql_one);

        //5.输出数据
        preparedStatement.setInt(1,4);
        preparedStatement.setString(2,"陈六");
        preparedStatement.setString(3,"123456");
        preparedStatement.setString(4,"5555@qq.com");
        preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));

        int update = preparedStatement.executeUpdate();
        System.out.println("修改了"+update+"行数据");
        //6.退出这个连接池
        preparedStatement.close();
        connection.close();

    }
}
