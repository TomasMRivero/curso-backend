package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.util.ConfigObserver;
import com.tomasmartinez.cursobackend.util.ConfigType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConfigConcrete implements InitializingBean, ConfigObserver {
    @Autowired
    ConfigSubject configSubject;

    @Autowired
    ConfigService configService;

    private String role;
    private String email;
    private String phone;


    @Override
    public void updateConfig(Object event) {
        if (event.equals(ConfigType.USER)){
            this.role = configService.getUserRole();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        configSubject.addObserver(this);
    }
}
