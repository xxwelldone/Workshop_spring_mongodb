package com.xxwelldone.workshopmongo.config;

import com.xxwelldone.workshopmongo.dto.UserDto;
import com.xxwelldone.workshopmongo.model.User;
import com.xxwelldone.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        UserDto x = new UserDto();
        x.setName("wes");
        x.setEmail("test1");
        userService.save(x);
        System.out.println("teste");

    }
}