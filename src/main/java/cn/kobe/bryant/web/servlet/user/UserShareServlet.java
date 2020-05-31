package cn.kobe.bryant.web.servlet.user;

import cn.kobe.bryant.domain.ReadExperience;
import cn.kobe.bryant.domain.ResultInfo;
import cn.kobe.bryant.domain.User;
import cn.kobe.bryant.service.UserService;
import cn.kobe.bryant.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/userShareServlet")
public class UserShareServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> map = req.getParameterMap();
        ReadExperience readExperience = new ReadExperience();
        try {
            BeanUtils.populate(readExperience,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:sss");
        String time = dateFormat.format(new Date());
        readExperience.setTime(time);
        UserService userService = new UserServiceImpl();

        String str = readExperience.getRead_experience();
        String [] strs = str.split("\n");
        StringBuffer buffer =  new StringBuffer();
        for(String s : strs){
            int num = 0;
            for(int j = 0 ; j<s.length(); j++){
                if(s.charAt(j) == 32 ){
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

        readExperience.setRead_experience(buffer.toString());
        System.out.println(readExperience.getRead_experience());
        User user = (User) req.getSession().getAttribute("user");
        readExperience.setUse_id(user.getId());
        userService.addReadExperience(readExperience);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setFlag(true);
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(),resultInfo);
    }
}
