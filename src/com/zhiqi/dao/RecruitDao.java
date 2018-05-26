package com.zhiqi.dao;

import java.util.List;

import com.zhiqi.model.PageBean;
import com.zhiqi.model.Recruit;

public interface RecruitDao {

	public List<Recruit> recruitList(PageBean pageBean,Recruit s_recruit);
	public int recruitCount(Recruit s_recruit);
	public Recruit loadById(int id);
	public void add(Recruit recruit);
	public void update(Recruit recruit);
	public void delete(int id);
	public void setHealth(int id);
	public void setIdcard(int id);
	
	public List<Recruit> recruitListByStateOk();
}
