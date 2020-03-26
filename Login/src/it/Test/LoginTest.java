package it.Test;

import it.Dao.UserDao;
import it.domain.User;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void Dao_LoginTest(){
        User loginuser = new User();
        loginuser.setUsername("root");
        loginuser.setPassword("admin");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginuser);
        System.out.println(user);
    }
}
