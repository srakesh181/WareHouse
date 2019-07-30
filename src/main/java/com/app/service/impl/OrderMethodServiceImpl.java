package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMehtodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	
	//HAS-A Relation with IOrderMethodDa
	@Autowired
	private IOrderMehtodDao dao;

	//save operation
	@Transactional
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		return dao.saveOrderMethod(orderMethod);
	}

	//update operation
	@Transactional
	public void updateOrderMethod(OrderMethod orderMethod) {
		dao.updateOrderMethod(orderMethod);
	}

	//delete opertion
	@Transactional
	public void deleteOrderMethod(Integer orderMethodId) {
		dao.deleteOrderMethod(orderMethodId);
	}

	//get opertion
	@Transactional(readOnly=true)
	public OrderMethod getOneOrderMethod(Integer orderMethodId) {
		return dao.getOneOrderMethod(orderMethodId);
	}

	//loadAoo operation
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}

	@Override
	public List<Object[]> getOrderMethodExecuteTypeCount() {

		List<Object[]> list = dao.getOrderMethodExecuteTypeCount();
	
		return list;
	}

}
