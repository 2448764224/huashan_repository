package cn.kobe.bryant.Dao;

import cn.kobe.bryant.domain.ReadExperience;
import cn.kobe.bryant.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public int registerUser(User user);

    public boolean UserIsExist(String username);

    public User login(String username, String password);

    public List<Map<String, Object>> getReadExperiecnec(int id);

    public void addReadExperience(ReadExperience readExperience);
}
