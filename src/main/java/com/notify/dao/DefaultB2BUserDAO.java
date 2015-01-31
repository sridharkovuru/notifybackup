package com.notify.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.notify.model.B2BUser;
import com.notify.rowmappers.B2BUserMapper;

public class DefaultB2BUserDAO  implements B2BUserDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public B2BUser getB2BUser(String email)
	{
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 String SQL = "SELECT user.b2b_user_id,user.firstname,user.lastname,user.password,user.email,user.active,user.mobile ,userRole.role FROM B2BUser as user JOIN USER_ROLES as userRole WHERE  userRole.email = user.email AND user.active=1 AND user.email ='"+email+"'";  
		   SqlParameterSource namedParameters = new MapSqlParameterSource("email", email);  
		
	List<Map<String,Object>> empRows = jdbcTemplate.queryForList(SQL);
	List<B2BUser> b2bUsers = jdbcTemplate.query(SQL, new B2BUserMapper());
	List<String> roles = new ArrayList<String>();
	for(B2BUser user : b2bUsers)
	{
		roles.add(user.getRole());
	} 
	B2BUser b2bUser =null;
	if(b2bUsers != null && !b2bUsers.isEmpty()){
		 b2bUser = b2bUsers.get(0);
		b2bUser.setRoles(roles);
	}
	return b2bUser;
		 
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	

}
