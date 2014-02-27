package com;

import java.io.Reader;

import com.dao.UserDao;
import com.dao.UserDaoIiBatisImpl;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.model.User;

public class TestMain {

    static
    {
        System.out.println("########### Yeah. main method is there. ###########");
    }

    public static void main(String[] args) throws Exception
	{
		UserDao manager = new UserDaoIiBatisImpl();
		
		Reader reader = Resources.getResourceAsReader("sql-maps-config.xml");
		SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (reader);
		
		User user = new User();
		user.setId(1);
		user.setName("Demo User");
		user.setPassword("password");
		user.setEmail("xyz@pqr.com");
		user.setStatus(1);
		
		manager.addUser(user,sqlmapClient);
		
		User createdUser = manager.getUserById(1, sqlmapClient);
		System.out.println(createdUser.getEmail());
		
		manager.deleteUserById(1, sqlmapClient);
	}
}
