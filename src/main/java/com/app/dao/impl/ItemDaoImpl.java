package com.app.dao.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	//HAS-A Relation with HibernateTemplate
	@Autowired
	private HibernateTemplate ht;
	
	//save operation
	
	public Integer saveItem(Item item) {
		return (Integer) ht.save(item);
	}

	//update operation
	public void updateItem(Item item) {
		ht.update(item);
	}

	//delete operation
	public void deleteItem(Integer itemId) {
		ht.delete(new Item(itemId));
	}

	// get one Record
	public Item getOneItem(Integer itemId) {
		return ht.get(Item.class, itemId);
	}

	//get All Records
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

}
