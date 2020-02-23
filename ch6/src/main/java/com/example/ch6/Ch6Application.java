package com.example.ch6;

import com.example.ch6.model.UserEntity;
import com.example.ch6.model.UserRole;
import com.example.ch6.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.security.auth.login.Configuration;
import java.util.List;

@SpringBootApplication
public class Ch6Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(Ch6Application.class, args);
        UserRepository userRepository=context.getBean(UserRepository.class);
        userRepository.save(new UserEntity("윤사장",60, UserRole.ADMIN));
        userRepository.save(new UserEntity("홍현희",33, UserRole.ADMIN));
        userRepository.save(new UserEntity("이홍련",27, UserRole.ADMIN));
        userRepository.save(new UserEntity("차미홍",65, UserRole.ADMIN));
        userRepository.save(new UserEntity("철수",44, UserRole.ADMIN));
        userRepository.save(new UserEntity("영희",60, UserRole.ADMIN));
        userRepository.save(new UserEntity("데니스",60, UserRole.ADMIN));

        List<UserEntity> resultlist=userRepository.findAllLike("%홍%");
        for(UserEntity n:resultlist){
            System.out.println(n.getUserName());
        }
    }

}
