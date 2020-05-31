package cn.kobe.bryant.web.servlet.book;

import cn.kobe.bryant.domain.Books;
import cn.kobe.bryant.domain.PageBean;
import cn.kobe.bryant.service.BookService;
import cn.kobe.bryant.service.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAllBooksServlet")
public class getAllBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String text = request.getParameter("text");
        BookService service = new BookServiceImpl();
        List list = null;
        /**
         * 搜索全部跟按类型搜索不同，所以使用不同的方法
         */
        if("全部".equals(text)){
            list = service.findAllBooks(currentPage,limit);
        }
        else{
            if("其他".equals(text)){
                list = service.findAllBooksByOther(currentPage,limit);
            }else {
                list = service.findAll(text,currentPage,limit);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
