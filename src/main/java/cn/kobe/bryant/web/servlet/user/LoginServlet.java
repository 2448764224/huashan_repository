package cn.kobe.bryant.web.servlet.user;

import cn.kobe.bryant.domain.ResultInfo;
import cn.kobe.bryant.domain.User;
import cn.kobe.bryant.service.UserService;
import cn.kobe.bryant.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String check_code = request.getParameter("check_code");
        String CHECKCODE_SERVER = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER.");
        ResultInfo resultInfo = new ResultInfo();
        if(check_code.equalsIgnoreCase(CHECKCODE_SERVER)){
            UserService userService = new UserServiceImpl();
            User loginUser = userService.login(username,password);
            if(loginUser == null){
                resultInfo.setErrorMsg("用户不存在");
                resultInfo.setFlag(false);
            }
            else{
                request.getSession().setAttribute("user",loginUser);
                resultInfo.setFlag(true);
            }
        }else{
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
        }
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),resultInfo);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
