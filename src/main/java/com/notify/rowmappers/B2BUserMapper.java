package com.notify.rowmappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;

import com.notify.model.B2BUser;


public class B2BUserMapper  implements RowMapper {    
	 
	public B2BUser mapRow(ResultSet rs,int rownumber) throws SQLException {    
		
		    	B2BUser b2bUser = new B2BUser();
		    	b2bUser.setB2b_user_id(rs.getInt("b2b_user_id"));
				b2bUser.setEmail(rs.getString("email"));
				b2bUser.setFirstName(rs.getString("firstname"));
				b2bUser.setLastName(rs.getString("lastname"));
				b2bUser.setPassword(rs.getString("password"));
				b2bUser.setActive(rs.getInt("active"));
				b2bUser.setMobile(rs.getString("mobile"));
				b2bUser.setRole(rs.getString("role"));
				return b2bUser;
				
}     

}
