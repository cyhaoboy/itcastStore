package com.example.itcaststore.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import org.junit.jupiter.api.Test;


/**
 * 数据源工具
 */
public class DataSourceUtils {
    private static DataSource dataSource ;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    static {
        try {
            Properties properties = new Properties();
            InputStream is = DataSourceUtils.class.getClassLoader().getResourceAsStream("itca.properties");

            properties.load(is);
            dataSource  = DruidDataSourceFactory.createDataSource(properties);
        } catch ( Exception e) {
            e.printStackTrace();
        }


    }
    @Test
public  void test()
{
    getDataSource();
}
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 当DBUtils需要手动控制事务时，调用该方法获得一个连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = dataSource.getConnection();
            tl.set(con);
        }
        return con;
    }

    /**
     * 开启事务
     *
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException {
        Connection con = getConnection();
        if (con != null)
            con.setAutoCommit(false);
    }

    /**
     * 从ThreadLocal中释放并且关闭Connection,并结束事务
     *
     * @throws SQLException
     */
    public static void releaseAndCloseConnection() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.commit();
            tl.remove();
            con.close();
        }
    }

    /**
     * 事务回滚
     *
     * @throws SQLException
     */
    public static void rollback() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.rollback();
        }
    }
}
