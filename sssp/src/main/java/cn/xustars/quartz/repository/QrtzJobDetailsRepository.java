package cn.xustars.quartz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xustars.quartz.entity.QrtzJobDetails;

public interface QrtzJobDetailsRepository extends JpaRepository<QrtzJobDetails, Serializable>{
	
}
