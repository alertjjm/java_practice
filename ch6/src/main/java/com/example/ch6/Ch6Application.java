package com.example.ch6;

import com.example.ch6.model.UserEntity;
import com.example.ch6.model.UserRole;
import com.example.ch6.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.security.auth.login.Configuration;

@SpringBootApplication
public class Ch6Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(Ch6Application.class, args);
        UserRepository userRepository=context.getBean(UserRepository.class);
        userRepository.save(new UserEntity("윤사장",60, UserRole.ADMIN));
        UserEntity user=userRepository.findByUserName("윤사장");
        System.out.println("나이: "+user.getAge()+" "+"이름: "+user.getUserName()+" 생성일: "+user.getCreatedAt());
    }

}
