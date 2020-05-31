package cn.kobe.bryant.web.servlet.book;
import cn.kobe.bryant.domain.PageBean;
import cn.kobe.bryant.service.BookService;
import cn.kobe.bryant.service.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/libraryCategoryServlet")
public class LibraryCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, ServletException {
        BookService service = new BookServiceImpl();
        int i = service.getAllBooksCount();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
// request.setCharacterEncoding("utf-8");
//         //获取从分类页面传来的数据，以便在数据库中进行查询
//         String text = request.getParameter("text");
//         // 查询内容,防止中文乱码
//         text=new String(text.getBytes("iso-8859-1"),"utf-8");
//         //当前页面
//         int currentPage = Integer.parseInt(request.getParameter("currentPage"));
//         // 定义BookService进行数据库操作
//         BookService service = new BookServiceImpl();
//         List list = null;
//         int totalCount  = 0 ;
//         int totalPage = 0;
//         //如果传入的内容为 "*" 则表示查询全部书籍的内容
//         //如果不是，则进行单个类别的查询
//         if(text.equalsIgnoreCase("*")){
//         //因为对全部书籍查询，所以调用的方法跟查询某个类别不同
//         list = service.findAllBooks(currentPage,5); //返回图书列表
//         totalCount = service.getAllBooksCount();        //返回图书个数
//         totalPage = totalCount % 5 == 0 ? (totalCount / 5): (totalCount / 5) +1;    //总页数
//         }
//         else {
//         list = service.findAll(text,currentPage,5);
//         totalCount = service.getCount(text);
//         totalPage = totalCount % 5 == 0 ? (totalCount / 5): (totalCount / 5) +1;
//         }
//         //为PageBean设置参数，用于进行分页查询
//         PageBean pageBean = new PageBean();
//         pageBean.setCount(list.size()); //每页的个数由查询结果来定，默认是查五个，当结果不足五个是则为查询的图书个数
//         pageBean.setList(list);
//         pageBean.setCurrentPage(currentPage);
//         pageBean.setTotalCount(totalCount);
//         pageBean.setTotalPage(totalPage);
//         //将PageBean类传递给浏览器
//         ObjectMapper mapper = new ObjectMapper();
//         response.setContentType("application/json;charset=utf-8");
//         mapper.writeValue(response.getOutputStream(),pageBean);