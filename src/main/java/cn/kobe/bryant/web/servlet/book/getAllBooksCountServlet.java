package cn.kobe.bryant.web.servlet.book;

import cn.kobe.bryant.domain.ResultInfo;
import cn.kobe.bryant.service.BookService;
import cn.kobe.bryant.service.BookServiceImpl;
import cn.kobe.bryant.service.UserService;
import cn.kobe.bryant.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;

@WebServlet("/getAllBooksCountServlet")
public class getAllBooksCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService service = new BookServiceImpl();
        String text = request.getParameter("category");
        int i = 0;
        if("全部".equals(text) ){
            i = service.getAllBooksCount();
        }else{
            if("其他".equals(text)){
                i = service.getCountByOther();
            }else {
                    i = service.getCount(text);
            }
        }

        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        info.setErrorMsg(String.valueOf(i));
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
