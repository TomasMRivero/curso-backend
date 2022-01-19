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

    @Value(value = "${user.test.email}")
    private String userMail;

    @Value(value = "${user.test.phone}")
    private String userPhone;

    public void updateUserConfig(String userRoleParam, String userMailParam, String userPhoneParam){
        userRole = userRoleParam;
        userMail = userMailParam;
        userPhone = userPhoneParam;
        configSubject.notifyObserver(ConfigType.USER);
    }

    public String getUserRole(){
        return userRole;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }
}
