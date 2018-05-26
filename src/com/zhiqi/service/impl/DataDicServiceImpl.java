package com.zhiqi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiqi.dao.DataDicDao;
import com.zhiqi.model.DataDic;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.DataDicService;

@Service("dataDicService")
public class DataDicServiceImpl implements DataDicService {

	@Autowired
	private DataDicDao dataDicDao;

	@Override
	public List<DataDic> dataDicList(PageBean pageBean, DataDic s_dataDic) {
		// TODO Auto-generated method stub
		return dataDicDao.dataDicList(pageBean, s_dataDic);
	}

	@Override
	public int dataDicCount(DataDic s_dataDic) {
		// TODO Auto-generated method stub
		return dataDicDao.dataDicCount(s_dataDic);
	}

	@Override
	public DataDic loadById(int id) {
		// TODO Auto-generated method stub
		return dataDicDao.loadById(id);
	}

	@Override
	public void add(DataDic dataDic) {
		// TODO Auto-generated method stub
		dataDicDao.add(dataDic);
	}

	@Override
	public void update(DataDic dataDic) {
		// TODO Auto-generated method stub
		dataDicDao.update(dataDic);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dataDicDao.delete(id);
	}

	@Override
	public boolean existDataDicTypeByDataDicId(int id) {
		// TODO Auto-generated method stub
		return dataDicDao.existDataDicTypeByDataDicId(id);
	}
	
}
