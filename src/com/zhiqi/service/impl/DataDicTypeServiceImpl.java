package com.zhiqi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiqi.dao.DataDicTypeDao;
import com.zhiqi.model.DataDicType;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.DataDicTypeService;

@Service("dataDicTypeDao")
public class DataDicTypeServiceImpl implements DataDicTypeService {

	@Autowired
	private DataDicTypeDao dataDicTypeDao;
	
	@Override
	public List<DataDicType> dataDicTypeList(PageBean pageBean, DataDicType s_dataDicType) {
		// TODO Auto-generated method stub
		return dataDicTypeDao.dataDicTypeList(pageBean,s_dataDicType);
	}

	@Override
	public int dataDicTypeCount(DataDicType s_dataDicType) {
		// TODO Auto-generated method stub
		return dataDicTypeDao.dataDicTypeCount(s_dataDicType);
	}

	@Override
	public void add(DataDicType dataDicType) {
		// TODO Auto-generated method stub
		dataDicTypeDao.add(dataDicType);
	}

	@Override
	public void update(DataDicType dataDicType) {
		// TODO Auto-generated method stub
		dataDicTypeDao.update(dataDicType);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dataDicTypeDao.delete(id);
	}

	@Override
	public DataDicType loadById(int id) {
		// TODO Auto-generated method stub
		return dataDicTypeDao.loadById(id);
	}

}
