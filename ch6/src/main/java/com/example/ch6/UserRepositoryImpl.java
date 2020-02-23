package com.example.ch6;

import com.example.ch6.model.QUserEntity;
import com.example.ch6.model.UserEntity;
import com.example.ch6.repository.UserRepository;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {
    public UserRepositoryImpl(){
        super(UserEntity.class);
    }
    @Override
    @Autowired
    public void setEntityManager(EntityManager entityManager){
        super.setEntityManager(entityManager);
    }

    @Override
    public List findAllLike(String keryword) {
        QUserEntity qUserEntity=QUserEntity.userEntity;
        JPQLQuery<UserEntity> query=from(qUserEntity);
        List<UserEntity> resultList=query.where(qUserEntity.userName.like(keryword)).fetch();
        return resultList;
    }
}
