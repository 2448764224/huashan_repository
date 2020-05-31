package cn.kobe.bryant.service;

import java.util.List;

public interface MovieService {
    public List<java.util.Map<String, Object>> findMovieByCategory(String search_region, String search_category, String year,String form);

    public List popularMovie();

    public List popluarListMovie();
}
