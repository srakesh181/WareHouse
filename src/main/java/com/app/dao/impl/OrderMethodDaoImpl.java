package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMehtodDao;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMehtodDao {

	//HAS-A Relation with HibernateTemplate
	@Autowired
	private HibernateTemplate ht;
	
	//save operation
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		return (Integer) ht.save(orderMethod);
	}

	//update operation
	public void updateOrderMethod(OrderMethod orderMethod) {
		ht.update(orderMethod);
		
	}

	//delete operation
	public void deleteOrderMethod(Integer orderMethodId) {
		ht.delete(new OrderMethod(orderMethodId));
	}

	//get operation
	public OrderMethod getOneOrderMethod(Integer orderMethodId) {
		return ht.get(OrderMethod.class, orderMethodId);
	}

	//loadAll operation
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public List<Object[]> getOrderMethodExecuteTypeCount() {
		String hql=" select orderMethodExecuteType , count(orderMethodExecuteType) from "+ getClass().getName() +" group by orderMethodExecuteType ";

		List<Object[]> list = (List<Object[]>)ht.find(hql);
		
			return list;
	}

}
