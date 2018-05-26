package com.zhiqi.service;

import java.util.List;

import com.zhiqi.model.PageBean;
import com.zhiqi.model.Train;

public interface TrainService {
	public List<Train> trainList(PageBean pageBean,Train s_train);
	public int trainCount(Train s_train);
	public Train loadById(int id);
	public void add(Train train);
	public void update(Train train);
	public void delete(int id);
}
