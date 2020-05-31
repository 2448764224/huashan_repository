package cn.kobe.bryant.web.servlet.book;

import cn.kobe.bryant.domain.Comment;
import cn.kobe.bryant.domain.Comments;
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
import java.util.List;

@WebServlet("/getBookCommentServlet")
public class GetBookCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String book_name = request.getParameter("name");
        String order = request.getParameter("category");
        BookService bookService = new BookServiceImpl();
        List list = bookService.findComment(book_name,order);
        Comments comments = new Comments();
        comments.setList(list);
        boolean[] flag = new boolean[list.size()];
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            for(int i = 0 ;i< flag.length; i++){
                flag[i] = false;
            }
        }
        else{
            for(int i = 0 ; i<flag.length; i ++){
                String id = String.valueOf(user.getId());
                if(list.get(i).toString().contains("user_id="+String.valueOf(user.getId()))){
                    flag[i] = true;
                }
                else {
                    flag[i]= false;
                }
            }
        }
        comments.setIsDelete(flag);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),comments);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
