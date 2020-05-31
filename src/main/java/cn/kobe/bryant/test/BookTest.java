package cn.kobe.bryant.test;

import cn.kobe.bryant.Dao.BookDao;
import cn.kobe.bryant.Dao.BookDaoImpl;
import cn.kobe.bryant.Dao.UserDao;
import cn.kobe.bryant.Dao.UserDaoImpl;
import cn.kobe.bryant.domain.Books;
import cn.kobe.bryant.domain.User;
import cn.kobe.bryant.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.awt.*;
import java.awt.print.Book;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BookTest {
    @Test
    public void test() throws SQLException, ClassNotFoundException {



    }

    @Test
    public void test1() throws UnsupportedEncodingException {
        String url = "%e8%a7%a3%e5%bf%a7%e6%9d%82%e8%b4%a7%e5%ba%97";
        url = URLDecoder.decode(url,"utf-8");
        URLEncoder.encode("url","utf-8");
        System.out.println(url);
    }
}
