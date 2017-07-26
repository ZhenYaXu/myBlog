package cn.xustars.quartz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.xustars.quartz.entity.QrtzTriggers;

public interface QrtzTriggerRepository extends JpaRepository<QrtzTriggers, Serializable>{
	
}
