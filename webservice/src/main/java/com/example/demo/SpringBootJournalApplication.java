package com.example.demo;

import com.example.demo.domain.Journal;
import com.example.demo.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringBootJournalApplication {
    @Bean
    InitializingBean saveData(JournalRepository repo){
        return()->{
            repo.save(new Journal("스프링 부트 입문","스프링 공부 시작","02/06/2018"));
            repo.save(new Journal("스프링 프로젝트 샘플","스프링 샘플!","02/07/2018"));
            repo.save(new Journal("스프링 부트 구조","스프링 구조를 알아보자","02/08/2018"));
            repo.save(new Journal("스프링 부트 클라우드", "클라우드요", "02/09/2018"));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);
    }
}
