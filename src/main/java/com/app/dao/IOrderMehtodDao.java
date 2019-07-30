package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMehtodDao {
	public Integer saveOrderMethod(OrderMethod orderMethod);
	public void updateOrderMethod(OrderMethod orderMethod);
	public void deleteOrderMethod(Integer orderMethodId);
	
	public OrderMethod getOneOrderMethod(Integer orderMethodId);
	public List<OrderMethod> getAllOrderMethods();
	
	public List<Object[]> getOrderMethodExecuteTypeCount();

}
