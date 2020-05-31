package cn.kobe.bryant.service;

import cn.kobe.bryant.Dao.MovieDao;
import cn.kobe.bryant.Dao.MovieDaoImpl;

import java.util.List;

public class MovieServiceImpl implements  MovieService {
    private MovieDao movieDao = new MovieDaoImpl();
    @Override
    public List<java.util.Map<String, Object>> findMovieByCategory(String search_region, String search_category, String year,String form) {
        return movieDao.findMovieByCategory(search_region,search_category,year,form);
    }

    @Override
    public List popularMovie() {
        return movieDao.popularMovie();
    }

    @Override
    public List popluarListMovie() {
        return movieDao.popularListMovie();
    }
}
