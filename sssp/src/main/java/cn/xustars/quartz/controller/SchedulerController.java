package cn.xustars.quartz.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xustars.quartz.entity.QrtzCronTriggers;
import cn.xustars.quartz.entity.QrtzJobDetails;
import cn.xustars.quartz.entity.QrtzTriggers;
import cn.xustars.quartz.service.CronTriggerService;
import cn.xustars.quartz.service.QrtzJobDetailService;
import cn.xustars.quartz.service.SchedulerService;
import cn.xustars.quartz.service.TriggerService;
import cn.xustars.quartz.utils.RetObj;

@Controller
@RequestMapping("/trigger")
public class SchedulerController {

	// 日志记录器
	public final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private TriggerService triggerService;
	@Autowired
	private SchedulerService schedulerService;
	@Autowired
	private QrtzJobDetailService qrtzJobDetailService;
	@Autowired
	private CronTriggerService cronTriggerService;


	@RequestMapping("/save")
	@ResponseBody
	public RetObj save(String triggerName,String cronExpression) {
		System.out.println("++++ add");
		RetObj retObj = new RetObj();
		retObj.setFlag(false);
		try {
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
		} catch (Exception e) {
			retObj.setMsg("cron表达式有误，不能被解析！");
			return retObj;
		}
		
		schedulerService.schedule(triggerName, cronExpression);

		retObj.setFlag(true);
		return retObj;
	}
	
	@RequestMapping("/showSave")
	public String showSave() {

		return "trigger/saveTrigger";
	}
	
	/**
	 * 跳转到trigger列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showTriggerList")
	public String showTriggerList(Model model){
		List<QrtzTriggers> triggerList = triggerService.getAll();
		model.addAttribute("triggerList", triggerList);
		return "trigger/triggerList";
	}
	
	/**
	 * 跳转到jobDetail列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showJobDetailsList")
	public String showJobDetailsList(Model model){
		List<QrtzJobDetails> jobDetailList = qrtzJobDetailService.getAll();
		List<String> cronExpressionList = cronTriggerService.getAllCronExpression();
		model.addAttribute("jobDetailList", jobDetailList);
		model.addAttribute("cronExpressionList", cronExpressionList);
		return "trigger/jobDetailList";
	}
	
	/**
	 * 跳转到crontrigger列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showCronTriggerList")
	public String showCronTriggerList(Model model){
		List<QrtzCronTriggers> cronTriggerList = cronTriggerService.getAll();
		model.addAttribute("cronTriggerList", cronTriggerList);
		return "trigger/cronTriggerList";
	}
	

	/**
	 * 根据名称和组别处理 Tigger  (暂停 恢复 删除)
	 * @param triggerName
	 * @param group
	 */
	@RequestMapping("/doTriggerByType")
	@ResponseBody
	public RetObj doTriggerByType(String type,String triggerName,String group){

		RetObj retObj = new RetObj();
		if(type.equals("pause")){
			schedulerService.pauseTrigger(triggerName, group);
		}else if(type.equals("resume")){
			schedulerService.resumeTrigger(triggerName, group);
		}else if(type.equals("remove")){
			boolean rs = schedulerService.removeTrigdger(triggerName, group);
			if (rs) {
				retObj.setFlag(true);
				return retObj;
			} else {
				retObj.setMsg("删除失败！");
				return retObj;
			}
		}else{
			retObj.setMsg("操作类型错误 ");
			return retObj;
		}
		
		retObj.setFlag(true);
		return retObj;
	}

}
