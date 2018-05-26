package com.zhiqi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiqi.dao.TrainDao;
import com.zhiqi.model.PageBean;
import com.zhiqi.model.Train;
import com.zhiqi.service.TrainService;

@Service("trainService")
public class TrainServiceImpl implements TrainService {

	@Resource
	private TrainDao trainDao;
	
	@Override
	public List<Train> trainList(PageBean pageBean, Train s_train) {
		// TODO Auto-generated method stub
		return trainDao.trainList(pageBean, s_train);
	}

	@Override
	public int trainCount(Train s_train) {
		// TODO Auto-generated method stub
		return trainDao.trainCount(s_train);
	}

	@Override
	public Train loadById(int id) {
		// TODO Auto-generated method stub
		return trainDao.loadById(id);
	}

	@Override
	public void add(Train train) {
		// TODO Auto-generated method stub
		trainDao.add(train);
	}

	@Override
	public void update(Train train) {
		// TODO Auto-generated method stub
		trainDao.update(train);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		trainDao.delete(id);
	}

}
