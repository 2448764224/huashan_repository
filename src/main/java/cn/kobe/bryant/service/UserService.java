package cn.kobe.bryant.service;

import cn.kobe.bryant.domain.ReadExperience;
import cn.kobe.bryant.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public int registerUser(User user);
    public boolean UserIsExist(String username);
    public User login(String username, String password);
    public List<Map<String, Object>> getReadExperience(int id);
    public void addReadExperience(ReadExperience readExperience);
}
