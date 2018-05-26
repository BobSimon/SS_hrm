package com.zhiqi.dao;

import java.util.List;

import com.zhiqi.model.Contract;
import com.zhiqi.model.PageBean;
import com.zhiqi.model.Recruit;

public interface ContractDao {

	public List<Contract> contractList(PageBean pageBean,Contract s_contract);
	public int contractCount(Contract s_contract);
	public Contract loadById(int id);
	public void add(Contract contract);
	public void update(Contract contract);
	public void delete(int id);
}
