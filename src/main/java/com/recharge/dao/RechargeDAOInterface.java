package com.recharge.dao;

import java.util.List;
import java.util.Map;

import com.recharge.model.RechargeForm;
import com.recharge.model.User;

public interface RechargeDAOInterface {
	
	public int saveTransaction(RechargeForm rf);
	public List<RechargeForm> getAllTransaction(RechargeForm rf);
	public User checkBalance(RechargeForm rf);
	public int updateBalance(int balance, RechargeForm rf);

///	public int updateBalance(RechargeForm rf);


}
