package com.zhiqi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiqi.dao.ContractDao;
import com.zhiqi.model.Contract;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.ContractService;

@Service("contractService")
public class ContractServiceImpl implements ContractService {

	@Resource
	private ContractDao contractDao;
	
	@Override
	public List<Contract> contractList(PageBean pageBean, Contract s_contract) {
		// TODO Auto-generated method stub
		return contractDao.contractList(pageBean, s_contract);
	}

	@Override
	public int contractCount(Contract s_contract) {
		// TODO Auto-generated method stub
		return contractDao.contractCount(s_contract);
	}

	@Override
	public Contract loadById(int id) {
		// TODO Auto-generated method stub
		return contractDao.loadById(id);
	}

	@Override
	public void add(Contract contract) {
		// TODO Auto-generated method stub
		contractDao.add(contract);
	}

	@Override
	public void update(Contract contract) {
		// TODO Auto-generated method stub
		contractDao.update(contract);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		contractDao.delete(id);
	}

}
