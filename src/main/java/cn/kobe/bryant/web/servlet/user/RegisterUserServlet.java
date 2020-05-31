package cn.kobe.bryant.web.servlet.user;

import cn.kobe.bryant.domain.ResultInfo;
import cn.kobe.bryant.domain.User;
import cn.kobe.bryant.service.UserService;
import cn.kobe.bryant.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@MultipartConfig
@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
    private final Pattern fileNameRegex = Pattern.compile("filename=\"(.*)\"");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Part part = request.getPart("user_photo");
        String fileName = "C:\\Users\\asus\\IdeaProjects\\Library\\src\\main\\webapp\\img\\user\\"+getSubmittedFileName(part);
        write(part,fileName);
        //获取从浏览器的表单提交的数据中的验证
        String check_code = request.getParameter("check_code");
        //获取由服务器发送给浏览器的验证码图片的文字
        String CHECKCODE_SERVER = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //定义ResultInfo类，用于存放关于比较的结果的相关信息
        ResultInfo resultInfo = new ResultInfo();
        //忽略大小的比较
       if(check_code.equalsIgnoreCase(CHECKCODE_SERVER)){
            //如果相等， 对用户传入的数据进行验证
            User user = new User();
            user.setUser_photo(fileName);
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //进行注册操作，如果用户存在，则返回false，如果用户不存在，则返回true
            UserService service = new UserServiceImpl();
            boolean flag = service.UserIsExist(user.getUsername());
            if(flag){
                response.sendRedirect("http://localhost:80/library/register.html?msg=9891");
            }else {
                int i  =  service.registerUser(user);
                if(i == -1){
//                resultInfo.setFlag(false);
//                resultInfo.setErrorMsg("用户已存在或用户信息错误");
                    response.sendRedirect("http://localhost:80/library/register.html?msg=9090");
                }else {
                    response.sendRedirect("http://localhost:80/library/index.html");
                }
            }
//            response.setContentType("application/json;charset=utf-8");
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(response.getOutputStream(),resultInfo);
        }
        else {
//            //如果不相等，给服务器返回false，并返回错误信息
//            resultInfo.setFlag(false);
//            resultInfo.setErrorMsg("验证码错误");
//            response.setContentType("application/json;charset=utf-8");
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(response.getOutputStream(),resultInfo);
           response.sendRedirect("http://localhost:80/library/register.html?msg=8888");
        }
    }
    private String getSubmittedFileName(Part part){
        String header = part.getHeader("Content-Disposition");
        Matcher matcher = fileNameRegex.matcher(header);
        matcher.find();
        String fileName = matcher.group(1);
        if(fileName.contains("\\")){
            return  fileName.substring(fileName.lastIndexOf("\\")+1);
        }
        return  fileName;
    }
    private void write(Part part,String fileName){
        try(InputStream in = part.getInputStream();
            OutputStream out = new FileOutputStream(String.format(fileName))){
            byte[] buffer = new byte[1024];
            int length = -1 ;
            while((length = in.read(buffer))!=-1){
                out.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
