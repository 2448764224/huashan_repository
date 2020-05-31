package cn.kobe.bryant.web.servlet.book;

import cn.kobe.bryant.domain.ResultInfo;
import cn.kobe.bryant.domain.User;
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
import java.awt.print.Book;
import java.io.IOException;

@WebServlet("/giveBookCommentLikeServlet")
public class giveBookCommentLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int comment_id = Integer.parseInt(request.getParameter("comment_id"));
        boolean isCanceled = Boolean.parseBoolean(request.getParameter("isCanceled"));
        User user = (User) request.getSession().getAttribute("user");
        ResultInfo info = new ResultInfo();
        BookService service = new BookServiceImpl();
        if(user == null){
            System.out.println("未登录");
        }else{
            if(isCanceled){
              service.giveLikeToBookComment(comment_id,user.getId());
            }else{
               service.deleteUserLike(comment_id,user.getId());
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
