package com.recharge.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessException.*; 
import org.springframework.jdbc.core.ResultSetExtractor;import org.springframework.jdbc.core.RowMapper;

import com.recharge.model.RechargeForm;
import com.recharge.model.User;  

public class RechargeDAO implements RechargeDAOInterface
{
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int saveTransaction(RechargeForm rf)
	{
		System.out.println("in save data..");
		String query="insert into transactions values('"+rf.getUserId()+"','"+rf.getMobileNo()+"','"+rf.getAmount()+"','"+rf.getOperator()+"')";
		return jdbcTemplate.update(query);
	}
	
	public List<RechargeForm> getAllTransaction(RechargeForm rf){  
		 String sql="select * from Transactions where mobile=?"; 
		 
		 return jdbcTemplate.query(sql, new Object[] {rf.getMobileNo()}, new RowMapper<RechargeForm>(){  
			    public RechargeForm mapRow(ResultSet rs, int rownumber) throws SQLException {  
			        RechargeForm e=new RechargeForm();  
			      //  e.setMobileNo(rs.getInt(2)); 
			        e.setMobileNo(rs.getLong(2));
                     e.setAmount(rs.getInt(3));
                     e.setOperator(rs.getString(4));
                     
                    
			        System.out.println(e.getAmount());
			        return e;  
			    }  
			    }); 		 
		 
	 }  
	
	public User checkBalance(RechargeForm rf){  
		System.out.println("inside dao"+rf.getUserId());
		 String sql="select * from users where users_pk="+rf.getUserId(); 
		 
		 return (User)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class) ); 	 
		 
	 }
	
	public int updateBalance(int balance, RechargeForm rf){  
		System.out.println("inside update balance "+balance +" "+rf.getUserId());
	    String sql="update Users set balance='"+balance+"' where users_pk="+rf.getUserId()+"";  
	    return jdbcTemplate.update(sql);  
	}  
	

}  