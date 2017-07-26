package cn.xustars.quartz.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xustars.quartz.entity.QrtzTriggers;
import cn.xustars.quartz.repository.QrtzTriggerRepository;

@Service
public class TriggerService {

	@Autowired
	private QrtzTriggerRepository qrtzTriggerRepository;
	
	@Transactional
	public List<QrtzTriggers> getAll(){
		return qrtzTriggerRepository.findAll();
	}
	
}
