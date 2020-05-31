package cn.kobe.bryant.web.servlet.movie;

import cn.kobe.bryant.service.MovieService;
import cn.kobe.bryant.service.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/movieCategoryServlet")
public class MovieCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search_region = request.getParameter("region");
        if(search_region.contains("所有地区")){
            search_region="所有地区";
        }
        String search_category = request.getParameter("category");
        if(search_category.contains("所有类型")){
            search_category = "所有类型";
        }
        String year = request.getParameter("year");
        if(year.contains("所有年代")){
            year = "所有年代";
        }
        String form = request.getParameter("form");
        if (form.contains("所有形式")) {
            form = "所有形式";
        }


        MovieService movieService = new MovieServiceImpl();
        List<java.util.Map<String, Object>> list = movieService.findMovieByCategory(search_region,search_category,year,form);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
