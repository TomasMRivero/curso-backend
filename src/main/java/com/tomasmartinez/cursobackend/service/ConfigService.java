package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.util.ConfigType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Autowired
    ConfigSubject configSubject;

    @Value(value = "${user.test.role}")
    private String userRole;

    public void updateUserConfig(String userRoleParam){
        userRole = userRoleParam;
        configSubject.notifyObserver(ConfigType.USER);
    }

    public String getUserRole(){
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
