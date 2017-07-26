package cn.xustars.quartz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.xustars.quartz.entity.QrtzCronTriggers;

public interface QrtzCronTriggerRepository extends JpaRepository<QrtzCronTriggers, Serializable>{
	
	@Query("select cronExpression from QrtzCronTriggers")
	public List<String> getAllCronExpression();
}
