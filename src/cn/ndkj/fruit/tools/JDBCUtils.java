package cn.ndkj.fruit.tools;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection() throws SQLException,ClassNotFoundException
    {
        //1.注册数据库的驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.通过DriverManager获取数据库连接
        String url="jdbc:mysql://localhost:3306/fruit?serverTimezone=GMT%2B8&useSSL=false";
        String username="root";
        String password="1234";
        Connection conn=DriverManager.getConnection(url,username,password);
        return conn;
    }
    //适合于添加，删除，修改操作后资源释放
    public static void release(Connection conn, Statement stmt)
    {
        if (stmt!=null)
        {
            try{
                stmt.close();
            }catch (SQLException e)
            {e.printStackTrace();}
            stmt=null;
        }
        if (conn!=null)
        {
            try{
                conn.close();
            }catch (SQLException e)
            {e.printStackTrace();}
            conn=null;
        }
    }
    //适合于查询后资源释放
    public static void release(Connection conn, Statement stmt, ResultSet rs)
    {
        if (rs!=null)
        {
            try{
                rs.close();
            }catch (SQLException e)
            {e.printStackTrace();}
            rs=null;
        }
        release(conn,stmt);
    }
}
