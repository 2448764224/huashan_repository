package cn.kobe.bryant.Dao;

import java.util.List;

public interface MovieDao {
    public List<java.util.Map<String, Object>>  findMovieByCategory(String search_region, String search_category, String year,String form);

    /**
     * 展示首页的热门电影
     * @return
     */
    public List popularMovie();

    /**
     * 展示首页的热门电影榜单前十
     */
    public List popularListMovie();
}
