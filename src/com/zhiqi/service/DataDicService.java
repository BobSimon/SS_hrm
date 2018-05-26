package com.zhiqi.service;

import java.util.List;

import com.zhiqi.model.DataDic;
import com.zhiqi.model.PageBean;

public interface DataDicService {
	
	public List<DataDic> dataDicList(PageBean pageBean,DataDic s_dataDic);
	public int dataDicCount(DataDic s_dataDic);
	public DataDic loadById(int id);
	public void add(DataDic dataDic);
	public void update(DataDic dataDic);
	public void delete(int id);
	public boolean existDataDicTypeByDataDicId(int id);
	
}
