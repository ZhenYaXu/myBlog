package cn.xustars.quartz.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(QrtzCronTriggersKey.class)
@Entity
@Table(name="qrtz_cron_triggers")
public class QrtzCronTriggers {
	@Id
	private String schedName;
	@Id
	private String triggerName;
	@Id
	private String triggerGroup;

	private String cronExpression;

	private String timeZoneId;

	public String getSchedName() {
		return schedName;
	}

	public void setSchedName(String schedName) {
		this.schedName = schedName == null ? null : schedName.trim();
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName == null ? null : triggerName.trim();
	}

	public String getTriggerGroup() {
		return triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup == null ? null : triggerGroup.trim();
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression == null ? null : cronExpression.trim();
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId == null ? null : timeZoneId.trim();
	}
}