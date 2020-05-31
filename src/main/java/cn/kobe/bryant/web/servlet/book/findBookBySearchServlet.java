package cn.kobe.bryant.web.servlet.book;

import cn.kobe.bryant.service.BookService;
import cn.kobe.bryant.service.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findBookBySearchServlet")
public class findBookBySearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String limit = request.getParameter("limit");
        String currentPage = request.getParameter("currentPage");
        text = text.trim();
        BookService service = new BookServiceImpl();
        List list = service.findAll(text,Integer.parseInt(currentPage),Integer.parseInt(limit));
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
