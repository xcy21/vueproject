package com.liujx.testfront.service;

import com.liujx.testfront.dao.LoginDao;
import com.liujx.testfront.entity.Login;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {
    @Resource
    private LoginDao loginDao;

    public Boolean loginConfirm(String username,String password) {
        Boolean flag = false;
        Login login = loginDao.selectByUsername(username);
        if (login==null){
            return flag;
        }
        String s = login.getPassword();
        if (s == ""){
            flag = false;
        }else if (s.equals(password)){
            flag=true;
        }
        return flag;
    }
}
