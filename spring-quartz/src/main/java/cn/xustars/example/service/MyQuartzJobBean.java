package cn.xustars.example.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyQuartzJobBean extends QuartzJobBean{

	private static final Logger logger = LoggerFactory.getLogger(MyQuartzJobBean.class);

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Trigger trigger = jobExecutionContext.getTrigger();
		String triggerName = trigger.getKey().getName();
		
		SimpleService simpleService = getApplicationContext(jobExecutionContext).getBean("simpleService",SimpleService.class);
		simpleService.testMethod(triggerName);
		
	}
	

	private ApplicationContext getApplicationContext(final JobExecutionContext jobexecutioncontext) {
		try {
			return (ApplicationContext) jobexecutioncontext.getScheduler().getContext().get("applicationContextKey");
		} catch (SchedulerException e) {
			logger.error("jobexecutioncontext.getScheduler().getContext() error!", e);
			throw new RuntimeException(e);
		}
	}

}
