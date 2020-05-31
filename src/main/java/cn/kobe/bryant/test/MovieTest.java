package cn.kobe.bryant.test;

import cn.kobe.bryant.Dao.MovieDao;
import cn.kobe.bryant.Dao.MovieDaoImpl;
import cn.kobe.bryant.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MovieTest {
    @Test
    public void test(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
          MovieDao movieDao = new MovieDaoImpl();
          List<java.util.Map<String, Object>>  list = movieDao.findMovieByCategory("英国","所有类型","所有年代","电影");
          System.out.println(list.size());
    }
}
