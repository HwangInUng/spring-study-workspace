package com.edu.springmvc2.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
	private static Mybatis instance;

	private SqlSessionFactory factory;

	private Mybatis() {
		String resource = "com/edu/springmvc2/mybatis/mybatis-config.xml";

		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);

			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Mybatis getInstance() {
		if (instance == null) {
			instance = new Mybatis();
		}
		return instance;
	}

	public SqlSession getSqlSession() {
		return factory.openSession();
	}

	public void release(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
}
