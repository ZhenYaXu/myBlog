package cn.xustars.myblog.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期处理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * 
	 * 通过当前时间获得唯一的文件名(有可能会重复)
	 * 
	 * @return
	 */

	public static String getUniqueFileNameByTime() {
		Calendar calendar = new GregorianCalendar();
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(calendar.get(Calendar.YEAR)))
				.append(valueOfString(String.valueOf(calendar.get(Calendar.MONTH) + 1), 2))
				.append(valueOfString(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2))
				.append(valueOfString(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)), 2))
				.append(valueOfString(String.valueOf(calendar.get(Calendar.MINUTE)), 2))
				.append(valueOfString(String.valueOf(calendar.get(Calendar.SECOND)), 2))
				.append(valueOfString(String.valueOf(calendar.get(Calendar.MILLISECOND)), 3));
		return sb.toString();

	}

	private static String valueOfString(String str, int len) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len - str.length(); i++) {
			sb.append("0");
		}
		return (sb.length() == 0) ? (str) : (sb.toString() + str);
	}


}
