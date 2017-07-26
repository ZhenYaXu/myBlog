package cn.xustars.quartz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cn.xustars.quartz.entity.QrtzCronTriggers;
import cn.xustars.quartz.repository.QrtzCronTriggerRepository;

@Service
public class CronTriggerService {

	@Autowired
	private QrtzCronTriggerRepository qrtzCronTriggerRepository;
	
	@Transactional
	public List<QrtzCronTriggers> getAll(){
		return qrtzCronTriggerRepository.findAll();
	}
	
	@Transactional
	public List<String> getAllCronExpression(){
		return qrtzCronTriggerRepository.getAllCronExpression();
	}
	
}
