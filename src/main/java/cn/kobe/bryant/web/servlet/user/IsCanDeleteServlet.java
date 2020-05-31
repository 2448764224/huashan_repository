package cn.kobe.bryant.web.servlet.user;

import cn.kobe.bryant.domain.ResultInfo;
import cn.kobe.bryant.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/isCanDeleteServlet")
public class IsCanDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String user_id = request.getParameter("id");
        ResultInfo info = new ResultInfo();
        if(user != null){
            int id = user.getId();
            if(user_id.equals(String.valueOf(id))){
                info.setFlag(true);
            }
            else {
                info.setFlag(false);
            }
        }
        else{
            info.setFlag(false);
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
