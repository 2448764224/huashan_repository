package cn.kobe.bryant.Dao;

import cn.kobe.bryant.domain.Movie;
import cn.kobe.bryant.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MovieDaoImpl implements  MovieDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<java.util.Map<String, Object>> findMovieByCategory(String search_region, String search_category, String year,String form) {
        if(search_region.equals("所有地区")){
            search_region = "%%";
        }
        else {
            search_region = "%"+search_region+"%";
        }

        if(form.equals("所有形式")){
            form = "%%";
        }
        else {
            form = "%"+form+"%";
        }


        if(search_category.equals("所有类型")){
            search_category = "%%";
        }
        else {
            search_category = "%"+search_category+"%";
        }
        String Upper_limit= "";
        String lower_limit="";
        if(year.equals("所有年代")){
            year = "2000-01-01";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Upper_limit = dateFormat.format(new Date());
            lower_limit = "1900-01-01";
        }
        else{
            Upper_limit = Integer.valueOf(year.substring(0,4))+10+"-01-01";
            lower_limit = Integer.valueOf(year.substring(0,4))-10+"-01-01";
        }
        String sql = "select * from movies where 1=1 and form like ?  and   region like ? and movie_type like ? and release_date between ?  and ? ";
        return  template.queryForList(sql,form,search_region,search_category,lower_limit,Upper_limit);
    }

    @Override
    public List popularMovie() {
        List list = null;
        try {
            String sql = "SELECT * FROM movies ORDER BY  collect DESC LIMIT 6;";
            list = template.queryForList(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List popularListMovie() {
        List list = null;
        try {
            String sql = "SELECT * FROM movies ORDER BY visit DESC LIMIT 10;";
            list = template.queryForList(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
