package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService{

	//HAS-A Relation with IItemDao
	@Autowired
	private IItemDao dao;
	
	//save operation
	@Transactional
	public Integer saveItem(Item item) {
		return dao.saveItem(item);
	}

	//update Operation
	@Transactional
	public void updateItem(Item item) {
		dao.updateItem(item);
	}

	//delete operation
	@Transactional
	public void deleteItem(Integer itemId) {
		dao.deleteItem(itemId);
	}

	//get one Record
	@Transactional(readOnly=true)
	public Item getOneItem(Integer itemId) {
		return dao.getOneItem(itemId);
	}

	//load All Records
	@Transactional(readOnly=true)
	public List<Item> getAllItems() {
		return dao.getAllItems();
	}

}
