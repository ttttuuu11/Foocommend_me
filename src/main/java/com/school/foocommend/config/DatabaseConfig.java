//package com.school.foocommend.config;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class DatabaseConfig {
//	
//	@Autowired
//	private ApplicationContext applicationContext;
//
//	@Bean
//	public DriverManagerDataSource dataSource() {
//		DriverManagerDataSource source = new DriverManagerDataSource();
//		source.setDriverClassName("com.mysql.jdbc.Driver");
//		// 자바 설정으로 쓸 때에는 url에 &을 &amp; 로 치환하면 에러나더라.
//		source.setUrl("jdbc:mysql://127.0.0.1:3306/foocommend");
//		source.setUsername("root");
//		source.setPassword("aa0023541");
//
//		return source;
//	}
//
//	@Bean
//    public DataSourceTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource());
//		sqlSessionFactoryBean
//				.setConfigLocation(applicationContext.getResource("classpath:/mybatis/config/mybatis-config.xml"));
//		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/mapper/*.xml"));
//		
//		return sqlSessionFactoryBean.getObject();
//	}
//
//	@Bean
//    public SqlSession sqlSession() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//        return sqlSessionTemplate;
//    }
//
//}
