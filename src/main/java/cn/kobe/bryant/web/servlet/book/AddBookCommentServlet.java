package cn.kobe.bryant.web.servlet.book;

import cn.kobe.bryant.domain.Books;
import cn.kobe.bryant.domain.Comment;
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
import java.awt.print.Book;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addBookCommentServlet")
public class AddBookCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment_text = request.getParameter("comment");
        String [] strs = comment_text.split("\n");
        StringBuffer buffer =  new StringBuffer();
        for(String s : strs){
            int num = 0;
            for(int j = 0 ; j<s.length(); j++){
                if(s.charAt(j) == ' ' ){
                    num++;
                }
                else {
                    break;
                }
            }
            for ( int y = 0 ; y< num ; y++){
                buffer.append("&nbsp;&nbsp;");
            }
            buffer.append(s+"<br>");
        }
        comment_text = buffer.toString();
        String book_name = request.getParameter("name");
        User user = (User) request.getSession().getAttribute("user");
        Comment comment = new Comment();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SSS");
        String time = format.format(new Date());
        comment.setTime(time);
        comment.setBook_comment(comment_text);
        comment.setUser_image(user.getUser_photo());
        comment.setUsername(user.getUsername());
        BookService bookService = new BookServiceImpl();
        Books book = bookService.findBookByName(book_name);
        comment.setBook_id(book.getBook_id());
        comment.setUser_id(user.getId());
        comment.setBook_name(book_name);
        comment.setGood(0);
        System.out.println(comment);
        bookService.addComment(comment);
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
