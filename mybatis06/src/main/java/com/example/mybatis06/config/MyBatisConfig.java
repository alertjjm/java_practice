package com.example.mybatis06.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.example.mybatis06.repository"})
public class MyBatisConfig {
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setName("jpubtestdb")
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema-hsqldb.sql")
                .addScript("data-hsqldb.sql")
                .build();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //sqlSessionFactoryBean.setConfigLocation((new PathMatchingResourcePatternResolver().getResource("classpath:sample/mapper/mybatis-config.xml")));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:sample/mapper/userMapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
