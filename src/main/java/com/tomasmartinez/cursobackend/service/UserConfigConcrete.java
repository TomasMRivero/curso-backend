package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.controller.ConfigController;
import com.tomasmartinez.cursobackend.util.ConfigObserver;
import com.tomasmartinez.cursobackend.util.ConfigType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConfigConcrete implements InitializingBean, ConfigObserver {


    private static final Logger logger = LogManager.getLogger(UserConfigConcrete.class);

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
            this.email = configService.getUserMail();
            this.phone = configService.getUserPhone();
            logger.warn("New config: { role: " +
                    this.role +  ", email: " +
                    this.email + ", phone: " +
                    this.phone + " }");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        configSubject.addObserver(this);
    }
}
