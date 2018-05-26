package com.zhiqi.service;

import java.util.List;

import com.zhiqi.model.DataDicType;
import com.zhiqi.model.PageBean;

public interface DataDicTypeService {
	
	public List<DataDicType> dataDicTypeList(PageBean pageBean,DataDicType s_dataDicType);
	public int dataDicTypeCount(DataDicType s_dataDicType);
	public void add(DataDicType dataDicType);
	public void update(DataDicType dataDicType);
	public void delete(int id);
	public DataDicType loadById(int id);
}
