package cn.kobe.bryant.Dao;

import cn.kobe.bryant.domain.ReadExperience;
import cn.kobe.bryant.domain.User;
import cn.kobe.bryant.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements  UserDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int registerUser(User user) {
        int i = -1;
        try{
            String sql = "insert into user(username,password,telephone,qq,email,sex,birthday,user_photo) values(?,?,?,?,?,?,?,?) ";
            i  =  template.update(sql,user.getUsername(),user.getPassword(),user.getTelephone(),user.getQq(),user.getEmail(),user.getSex(),user.getBirthday(),user.getUser_photo());
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean UserIsExist(String username) {
        User user = null;
        try{
            String sql = "select * from user where username = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        }catch (Exception e){

        }
        if(user != null){
            return  true;
        }
        return  false;
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try{
            String sql = " select * from user where username = ? and password = ? ";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        }catch (Exception e){

        }
        return  user;
    }

    @Override
    public List<Map<String, Object>> getReadExperiecnec(int id) {
        String sql = "select read_experience from user_read_experience where use_id = ? ";
        return template.queryForList(sql,id);
    }

    @Override
    public void addReadExperience(ReadExperience readExperience) {
        String sql = "insert into user_read_experience(use_id,read_experience,book_name,author,time,topic) values(?,?,?,?,?,?)";
        template.update(sql,readExperience.getUse_id(),readExperience.getRead_experience(),readExperience.getBook_name(),readExperience.getAuthor(),readExperience.getTime(),readExperience.getTopic());
    }
}
