package cn.kobe.bryant.web.servlet.book;

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

/**
 * 用来监视每一条留言，用户是否点赞
 */
@WebServlet("/isGiveLikeServlet")
public class IsGiveLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int coment_id = Integer.parseInt(request.getParameter("comment_id"));
        BookService service = new BookServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        ResultInfo info = new ResultInfo();
        if(user == null){
            System.out.println("未登录");
        }else {
            boolean i = service.isGiveLike(coment_id,user.getId());
            System.out.println(i);
            info.setFlag(i);
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
