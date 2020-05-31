package cn.kobe.bryant.web.servlet.book;

import cn.kobe.bryant.domain.User;
import cn.kobe.bryant.service.BookService;
import cn.kobe.bryant.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/favouriteBookServlet")
public class FavouriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String book_name = request.getParameter("book_name");
        System.out.println(book_name);
        String isCollection = request.getParameter("isCollection");
        BookService bookService = new BookServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        if(isCollection.equals("true")){
            bookService.collectionFavouriteBook(book_name,user.getId());
        }else{
            bookService.deleteFavouriteBook(book_name,user.getId());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
