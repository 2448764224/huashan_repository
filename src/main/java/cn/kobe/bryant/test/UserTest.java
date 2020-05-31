package cn.kobe.bryant.test;

import cn.kobe.bryant.Dao.UserDao;
import cn.kobe.bryant.Dao.UserDaoImpl;
import cn.kobe.bryant.domain.User;
import org.junit.Test;

public class UserTest {
    @Test
    public void test(){
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("zhangsans");
        user.setPassword("2489754645");
        user.setEmail("2448764224@qq.com");
        user.setQq("2448764224");
        user.setBirthday("2049-04-01");
        user.setSex("男");
        user.setTelephone("18428312512");
        System.out.println(userDao.registerUser(user));
    }
}
