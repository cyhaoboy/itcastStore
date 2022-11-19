package com.example.itcaststore.dao;
import java.sql.SQLException;
import java.util.List;

import com.example.itcaststore.domain.User;
import com.example.itcaststore.utils.DataSourceUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDao {
	JdbcTemplate jdbcTemplate=  new JdbcTemplate(DataSourceUtils.getDataSource());
	// 添加用户
	public void addUser(User user) throws SQLException {
		String sql = "insert into user(username,password,gender,email,telephone,introduce,activecode) values(?,?,?,?,?,?,?)";

		int row=jdbcTemplate.update(sql,user.getUsername(), user.getPassword(),
				user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(), user.getActiveCode());

		if (row == 0) {
			throw new RuntimeException();
		}
	}

//	public List<User> queryAllUser() {
//		String sql="select * from user";
//		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
//		return list;
//	}
//		@Test
//		public  void test(){
//			List<User> users=queryAllUser();
//			System.out.println(users);
//		}
	// 根据激活码查找用户
	public User findUserByActiveCode(String activeCode) throws SQLException {
		String sql = "select * from user where activecode=?";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class),activeCode).get(0);

	}

	// 激活用戶
	public void activeUser(String activeCode) throws SQLException {
		String sql = "update user set state=? where activecode=?";
		jdbcTemplate.update(sql,1,activeCode);
	}
	
	//根据用户名与密码查找用户
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
		String sql="select * from user where username=? and password=?";
		return  jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
	}

	public boolean queryByName(String name) {
		String sql="select * from user where username=?";
		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),name);
		if (list.size()!=0){
			return true;
		}else {
			return false;
		}


	}



}
