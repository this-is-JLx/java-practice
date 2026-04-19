package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取链接
        String url = "jdbc:mysql://localhost:3306/mytest";
        String username = "root";
        String password = "12345";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql="update user set password='111qqq' where id=1";

        //4.获取执行sql的对象Statement
        Statement stmt=conn.createStatement();

        //5.执行sql
        int count =stmt.executeUpdate(sql); //受影响的行数

        //6.处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();
    }
}
