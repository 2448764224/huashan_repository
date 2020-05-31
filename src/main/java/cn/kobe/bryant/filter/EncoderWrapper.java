package cn.kobe.bryant.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncoderWrapper extends HttpServletRequestWrapper {
    public EncoderWrapper(HttpServletRequest request) {
        super(request);
    }
    @Override
    public String getParameter(String name){
        String string = getRequest().getParameter(name);
        if(getRequest().getParameter(name).contains("<")){
            string = string.replaceAll("<","&lt;");
        }
        if(getRequest().getParameter(name).contains(">")){
            string = string.replaceAll(">","&gt;");
        }
        return  string;
    }
}
