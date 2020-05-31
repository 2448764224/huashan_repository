package cn.kobe.bryant.service;

import cn.kobe.bryant.Dao.UserDao;
import cn.kobe.bryant.Dao.UserDaoImpl;
import cn.kobe.bryant.domain.ReadExperience;
import cn.kobe.bryant.domain.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements  UserService {
    private UserDao dao  = new UserDaoImpl();
    @Override
    public int registerUser(User user) {
        if(dao.UserIsExist(user.getUsername())){
            return  -1;
        }
        else {
            return dao.registerUser(user);
        }
    }

    @Override
    public boolean UserIsExist(String username) {
        return dao.UserIsExist(username);
    }

    @Override
    public User login(String username, String password) {
        return dao.login(username,password);
    }


    @Override
    public List<Map<String, Object>> getReadExperience(int id) {
        return  dao.getReadExperiecnec(id);
    }

    @Override
    public void addReadExperience(ReadExperience readExperience) {
        dao.addReadExperience(readExperience);
    }
}
