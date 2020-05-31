package cn.kobe.bryant.web.servlet.diary;

import cn.kobe.bryant.domain.NewWorld;
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
import java.util.Map;

@WebServlet("/readAllExperienceServlet")
public class ReadAllExperienceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService service = new BookServiceImpl();
        List<NewWorld> list = service.findAllReadExperience();
        for(int i = 0 ; i<list.size(); i++){
            String str = list.get(i).getRead_experience();
            String [] strs = str.split("\n");
            StringBuffer buffer =  new StringBuffer();
            for(String s : strs){
                int num = 0;
                for(int j = 0 ; j<s.length(); j++){
                    if(s.charAt(j) == '\t' ){
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
            list.get(i).setRead_experience(buffer.toString());
        }
        if(list != null){
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(),list);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
