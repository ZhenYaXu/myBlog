package cn.xustars.quartz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xustars.quartz.entity.QrtzJobDetails;
import cn.xustars.quartz.repository.QrtzJobDetailsRepository;

@Service
public class QrtzJobDetailService {

	@Autowired
	private QrtzJobDetailsRepository qrtzJobDetailsRepository;
	
	@Transactional
	public List<QrtzJobDetails> getAll(){
		return qrtzJobDetailsRepository.findAll();
	}
	
}
