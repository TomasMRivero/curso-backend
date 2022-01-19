package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.UserConfig;
import com.tomasmartinez.cursobackend.service.ConfigService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/config")
public class ConfigController {

    private static final Logger logger = LogManager.getLogger(ConfigController.class);

    @Autowired
    ConfigService configService;

    @PutMapping("/users")
    UserConfig updateUserConfig(@RequestBody UserConfig userConfig){
        logger.info("PUT Request received");
        configService.updateUserConfig(userConfig.getRole(), userConfig.getEmail(), userConfig.getPhone());
        return userConfig;
    }

}
