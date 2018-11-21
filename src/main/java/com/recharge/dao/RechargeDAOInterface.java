package com.recharge.dao;

import java.util.List;
import java.util.Map;

import com.recharge.model.RechargeForm;

public interface RechargeDAOInterface {
	
	public int saveTransaction(RechargeForm rf);
	public List<RechargeForm> getAllTransaction(RechargeForm rf);
///	public int updateBalance(RechargeForm rf);


}
