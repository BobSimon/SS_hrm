package com.zhiqi.dao;

import java.util.List;

import com.zhiqi.model.DataDic;
import com.zhiqi.model.PageBean;

public interface DataDicDao {
	
	public List<DataDic> dataDicList(PageBean pageBean,DataDic s_dataDic);
	public int dataDicCount(DataDic s_dataDic);
	public void add(DataDic dataDic);
	public void update(DataDic dataDic);
	public void delete(int id);
	public DataDic loadById(int id);
	public boolean existDataDicTypeByDataDicId(int id);
}
