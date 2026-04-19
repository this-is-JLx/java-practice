package test1;

import java.sql.*;

public class JDBCDemo3 {
    //sql注入演示
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql:///mytest";
        String username = "root";
        String password = "12345";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入的用户名和密码
        String name = "张三";
        String psw = "' OR '1'='1";
        /*sql语句变成select * from user where username='张三' and password=''or'1'='1'
        * 导致语句永远为真 */


        String sql = "select * from user where username= ? and password=? ";

        PreparedStatement pstmt= conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,psw);

        ResultSet rs =pstmt.executeQuery();
        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登陆失败");
        }

        pstmt.close();
        rs.close();
        conn.close();
    }
}
