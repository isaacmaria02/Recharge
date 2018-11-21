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
		 String sql="select * from Transactions"; 
		 
		 return jdbcTemplate.query(sql, new Object[] {rf.getMobileNo()}, new RowMapper<RechargeForm>(){  
			    public RechargeForm mapRow(ResultSet rs, int rownumber) throws SQLException {  
			        RechargeForm e=new RechargeForm();  
			       // e.setMobileNo(rs.getInt(2)); 
                     e.setAmount(rs.getInt(2));
			        System.out.println(e.getAmount());
			        return e;  
			    }  
			    }); 		 
		 
	 }  
	
	public User checkBalance(RechargeForm rf){  
		 String sql="select * from Transactions"; 
		 
		 return (User)jdbcTemplate.queryForObject(sql, new Object[] {rf.getUserId()},new BeanPropertyRowMapper(User.class) ); 	 
		 
	 }
	/*
	public int updateBalance(RechargeForm rf){  
	    String sql="update Data set lname='"+p.getLname()+"' where fname="+p.getFname()+"";  
	    return jdbcTemplate.update(sql);  
	}  */
	

}  