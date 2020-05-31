package cn.kobe.bryant.web.servlet.book;

import cn.kobe.bryant.domain.MyFavourite;
import cn.kobe.bryant.domain.ResultInfo;
import cn.kobe.bryant.domain.User;
import cn.kobe.bryant.service.BookService;
import cn.kobe.bryant.service.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/collectionServlet")
public class CollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取书名
        String book_name = request.getParameter("book_name");
        //获取在一次浏览器请求时的用户信息，用户信息为登录后的用户信息
        User user = (User) request.getSession().getAttribute("user");
        BookService bookService = new BookServiceImpl();
        /**
         * 取得收藏类的对象，如果为空，表示该书没有被收藏，如果不为空，则表示被收藏，传入参数有两个
         * 1、book_name:要查的书名
         * 2、id:用户id
         * 这两个用来确定某个指定的用户是否收藏了确切的某本书
         */
        MyFavourite myFavourite = bookService.findMyFavourite(book_name,user.getId());
        ResultInfo info = new ResultInfo();
        if(myFavourite == null){
            info.setFlag(false);
        }
        else {
            info.setFlag(true);
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
