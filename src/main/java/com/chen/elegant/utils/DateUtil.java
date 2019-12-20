package com.chen.elegant.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.*;
import java.util.*;

/**
 * 
 * @Title: DateUtil.java
 * @Description:时间处理
 * @author Wangchaoyong
 * @date 上午11:25:53
 * @version V1.0
 */
public class DateUtil {
	public static final long DATE_BASE = 946828800000L;// 基础时间 取 2000-01-03
	// 00:00:00 星期1
	/**
	 * 默认的时间戳格式:{@value}
	 */
	public static final String TIMESTAMPFORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAR_STRING = "yyyy-MM-dd";// 时间格式化字符串
	public static final String DATE_MM_DD_FORMAR_STRING = "MM月dd日";// 时间格式化字符串
	public static final String DATETIME_FORMAR_STRING = "yyyy-MM-dd HH:mm:ss";// 时间格式化字符串
	public static final String TIME_FORMAR_STRING = "HH:mm:ss";// 时间格式化字符串
	public static final String DATE_NOLINE_STRING = "yyyyMMdd";// 时间格式化字符串
	public static final String DATE_YEAL_MM_DD_STRING = "yyyy年MM月dd日HH:mm";// 时间格式化字符串
	public static final String DATEFORMAT = DATE_FORMAR_STRING;
	public static final String DATE_FORMAT_TO_MINUTE = "yyyy-MM-dd HH:mm";//时间格式化至分钟

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAR_STRING);
	public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(DATETIME_FORMAR_STRING);
	public static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAR_STRING);
	public static final SimpleDateFormat timeFormatMD = new SimpleDateFormat(DATE_MM_DD_FORMAR_STRING);
	public static final SimpleDateFormat dateNoLineFormat = new SimpleDateFormat(DATE_NOLINE_STRING);
	public static final SimpleDateFormat dateFormatYMD = new SimpleDateFormat(DATE_YEAL_MM_DD_STRING);
	public static final SimpleDateFormat dateFormatToMinute=new SimpleDateFormat(DATE_FORMAT_TO_MINUTE);

	public static final DateFormat DF_YYYYMMDDHHMMSSSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static final DateFormat DF_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 时间类型转换为字符串 yyyy年MM月dd日HH:mm
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDateYMD(Date date) {
		if (date == null) {
			return "";
		} else {
			return dateFormatYMD.format(date);
		}
	}

	/**
	 * 时间类型转换为字符串 yyyyMMdd
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatNoLineDate(Date date) {
		if (date == null) {
			return "";
		} else {
			return dateNoLineFormat.format(date);
		}
	}

	public static String formatDate(Date date, String format) {
		if (date == null) {
			return "";
		} else {
			return new SimpleDateFormat(format).format(date);
		}
	}

	/**
	 * 时间类型转换为字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		} else {
			return dateFormat.format(date);
		}
	}

	/**
	 * 时间类型转换为字符串 MM月dd日
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDateMD(Date date) {
		if (date == null) {
			return "";
		} else {
			return timeFormatMD.format(date);
		}
	}

	/**
	 * 时间类型转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDateTime(Date date) {
		if (date == null) {
			return "";
		} else {
			return datetimeFormat.format(date);
		}
	}

	/**
	 * 时间类型转换为字符串 HH:mm:ss
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatTime(Date date) {
		if (date == null) {
			return "";
		} else {
			return timeFormat.format(date);
		}
	}

	/**
	 * 按指定格式格式化date
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @author Ajian
	 * @time 2017-4-20 下午4:41:12
	 */
	public static String formateDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * @yhcip:title 得到当前处在当年的第几周
	 * @yhcip:desc 得到当前处在当年的第几周
	 * @return 如18，表示现在是第18周
	 * @author Administrator
	 */
	public static int getWeekOfYear() {
		Calendar oneCalendar = Calendar.getInstance();
		return oneCalendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * @yhcip:title 得到当前是第几月
	 * @yhcip:desc 得到当前是第几月
	 * @return 如4，表示现在是4月
	 * @author Administrator
	 */
	public static int getMonth() {
		Calendar oneCalendar = Calendar.getInstance();
		return oneCalendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 时间转换
	 * 
	 * @param date
	 *            时间
	 * @param format
	 *            格式
	 * @return String
	 */
	public static String format(Date date, String format) {
		if (date == null) {
			return "";
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(date);
		}

	}

	/**
	 * 字符串转换成时间类型 转换后的时间格式 yyyy-MM-dd
	 * 
	 * @param dateString
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parseDate(String dateString) throws ParseException {
		return dateFormat.parse(dateString);
	}

	/**
	 * 字符串转换成时间类型 转换后的时间格式 HH:mm:ss
	 * 
	 * @param dateString
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parseTime(String dateString) throws ParseException {
		return timeFormat.parse(dateString);
	}

	/**
	 * 字符串转换成时间类型 转换后的时间格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateString
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parseDateTime(String dateString) throws ParseException {
		return datetimeFormat.parse(dateString);
	}

	/**
	 * 字符串转换成时间类型
	 * 
	 * @param dateString
	 *            时间
	 * @param format
	 *            格式
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parse(String dateString, String format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(dateString);
	}

	/**
	 * 通过传入时间与当前时间比较，获得时间差值形成文字
	 * 
	 * @param date
	 *            传入时间
	 * @return 串
	 */
	public static String getStringForDate(Date date) {

		String result = "";
		Calendar inputdate = Calendar.getInstance();
		inputdate.setTime(date);
		Calendar now = Calendar.getInstance();

		if (now.get(Calendar.YEAR) == inputdate.get(Calendar.YEAR) && now.get(Calendar.MONTH) == inputdate.get(Calendar.MONTH)) {
			int day = now.get(Calendar.DATE) - inputdate.get(Calendar.DATE);
			switch (day) {
			case 0:
				break;
			case 1:
				result = "昨天";
				break;
			default:
				result = format(inputdate.getTime(), "yyyy年MM月dd日");
				break;
			}
			result = result + format(inputdate.getTime(), "HH:mm");
		} else {
			result = format(inputdate.getTime(), "yyyy年MM月dd日HH:mm");

		}

		return result;
	}

	/**
	 * 通过传入时间与当前时间比较，获得时间差值形成文字(简易)
	 * 
	 * @param date
	 *            传入时间
	 * @return String
	 */
	public static String getSimpleStringForDate(Date date) {
		String result = "";
		Calendar inputdate = Calendar.getInstance();
		inputdate.setTime(date);
		Calendar now = Calendar.getInstance();

		int day = now.get(Calendar.DATE) - inputdate.get(Calendar.DATE);
		switch (day) {
		case 0:
			result = format(inputdate.getTime(), "HH:mm");
			break;
		default:
			result = format(inputdate.getTime(), "yyyy-MM-dd");
			break;
		}

		return result;
	}

	/**
	 * 获得与当前系统时间的相差天数
	 * 
	 * @param date
	 * @return 相差天数 如果传入时间大于当前系统时间为负数
	 */
	public static long compareDate(long date) {
		long result = 0;
		long now = System.currentTimeMillis() - DateUtil.DATE_BASE;// 系统时间 -
		// 基数时间
		long inputdate = date - DateUtil.DATE_BASE;// 最后天数时间

		long day = 1000 * 3600 * 24;
		result = now / day - inputdate / day;
		return result;

	}

	/**
	 * 获得传入两个时间的相差天数
	 * 
	 * @param startDate
	 * @return 相差天数
	 */
	public static long compareDate(long startDate, long endDate) {
		long result = 0;
		long starttime = startDate - DateUtil.DATE_BASE;// 系统时间 -
		long endtime = endDate - DateUtil.DATE_BASE;// 最后天数时间

		long day = 1000 * 3600 * 24;
		result = endtime / day - starttime / day;
		return result;

	}

	/**
	 * 获得传入时间与当前时间的差额，如果大于一天返回"**天前"，如大于一小时返回"**小时"，如果大于一分钟返回"**分钟"
	 *
	 * @param date
	 * @return 相差天数
	 */
	public static String compareDate(String date){
		String followDate="";
		try {
			Date follow = dateFormatToMinute.parse(date);
			Long followTime =follow.getTime();
			long nowTime = System.currentTimeMillis();
			Long dataDifference=nowTime-followTime;//时间差额
			if(dataDifference>86400000){
				dataDifference=dataDifference/86400000;
				followDate=dataDifference+"天前";
			}else if(dataDifference>3600000){
				dataDifference=dataDifference/3600000;
				followDate=dataDifference+"小时前";
			}else if(dataDifference>60000){
				dataDifference=dataDifference/60000;
				followDate=dataDifference+"分钟前";
			}else {
				followDate="刚刚";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return followDate;
	}
	/**
	 * 获得传入两个时间的相差小时
	 * 
	 * @param date
	 * @return 相差小时,只比较了时间,没有比较日期
	 */
	public static float compareHours(long startdate, long enddate) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long diff = enddate - startdate;
		float hour = (float) diff % nd / nh;
		return hour;
	}

	/**
	 * 获得传入两个时间的相差小时
	 * 
	 * @param startdate
	 * @param enddate
	 * @return 相差小时
	 */
	public static float compareHour(long startdate, long enddate) {
		long nh = 1000 * 60 * 60;
		long diff = enddate - startdate;
		float hour = (float) diff / nh;
		return hour;
	}

	/**
	 * 获得与当前系统时间的相差周数
	 * 
	 * @param date
	 * @return 相差周数 如果传入时间大于当前系统时间为负数
	 */
	public static long compareWeek(long date) {
		long result = 0;
		long now = System.currentTimeMillis() - DateUtil.DATE_BASE;// 系统时间 -
		// 基数时间
		long inputdate = date - DateUtil.DATE_BASE;// 最后天数时间

		long week = 1000 * 3600 * 24 * 7;
		result = now / week - inputdate / week;
		return result;
	}

	/**
	 * 获得与当前系统时间的相差月数
	 * 
	 * @param date
	 * @return 相差月数 如果传入时间大于当前系统时间为负数
	 * 
	 * @author 刘宇
	 * @date 2011-05-18
	 */
	public static long compareMonth(long date) {
		return compareMonth(date, System.currentTimeMillis());
	}

	public static long compareMonth(String startDate, String endDate) throws ParseException {
		long start = dateFormat.parse(startDate).getTime();
		long end = dateFormat.parse(endDate).getTime();

		return compareMonth(start, end);
	}

	public static long compareMonth(long startDate, long endDate) {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTimeInMillis(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTimeInMillis(endDate);

		int startYear = startCalendar.get(Calendar.YEAR);
		int startMonth = startCalendar.get(Calendar.MONTH);
		int endYear = endCalendar.get(Calendar.YEAR);
		int endMonth = endCalendar.get(Calendar.MONTH);

		return endYear * 12 + endMonth - startYear * 12 - startMonth;
	}

	/**
	 * 计算年龄
	 * 
	 * @param date
	 *            出生日期
	 * @return
	 */
	public static int calcAge(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar now = Calendar.getInstance();
		int age = now.get(Calendar.YEAR);
		now.setTime(date);
		return age - now.get(Calendar.YEAR);
	}

	/**
	 * 根据生日计算某一个日期的年龄
	 * 
	 * @param date
	 *            出生日期
	 * @param time
	 *            某一个日期 格式 "2017-01-01 20:10:21" 或者 "2017-01-01"
	 * @return
	 * @return int
	 * @author chentianjin
	 * @throws Exception
	 * @date 2017年8月29日
	 */
	public static int calcAge(Date date, String time) {
		if (date == null || StringUtils.isEmpty(time)) {
			return 0;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		Date dayTime = null;
		try {
			dayTime = df.parse(time);
		} catch (Exception e) {
			try {
				dayTime = df2.parse(time);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		Calendar cday = new GregorianCalendar();
		cday.setTime(date);
		int startYear = cday.get(Calendar.YEAR);
		cday.setTime(dayTime);
		int endYear = cday.get(Calendar.YEAR);
		return endYear - startYear;
	}

	/**
	 * 根据传入时间 获得本周第一天（周一)的时间
	 * 
	 * @param date
	 * @return 返回时间 时分秒毫秒为0
	 */
	public static long getFristDayForWeek(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		int tempday = calendar.get(Calendar.DAY_OF_WEEK);
		switch (tempday) {
		case 1:
			// 星期天
			calendar.add(Calendar.DATE, -6);
			break;
		default:
			// 周一到周六
			calendar.add(Calendar.DATE, -(tempday - 2));
			break;
		}
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime().getTime();
	}

	/**
	 * 根据传入时间 获得本周第一天（周一)的时间
	 * 
	 * @return 返回时间 时分秒毫秒为0
	 */
	public static long getFristDayForWeek() {
		return getFristDayForWeek(System.currentTimeMillis());
	}

	/**
	 * 根据传入时间 获得本周最后一天（周日)的时间
	 * 
	 * @param date
	 * @return 返回时间 时分秒毫秒为23:59:59 999
	 */
	public static long getLastDayForWeek(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		int tempday = calendar.get(Calendar.DAY_OF_WEEK);
		switch (tempday) {
		case 1:
			// 星期天
			break;
		default:
			// 周一到周六
			calendar.add(Calendar.DATE, 8 - tempday);
			break;
		}
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime().getTime();
	}

	/**
	 * 根据传入时间 获得本周最后一天（周日)的时间
	 * 
	 * @return 返回时间 时分秒毫秒为23:59:59 999
	 */
	public static long getLastDayForWeek() {
		return getLastDayForWeek(System.currentTimeMillis());
	}

	/**
	 * 根据传入时间 获得此时间所在月的 第一天的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthFristDay(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	/**
	 * 根据传入时间 获得此时间所在月的 最后一天的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthLastDay(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR, calendar.getActualMaximum(Calendar.HOUR));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	/**
	 * 根据传入时间 获得此时间所在年的 第一天的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYearFristDay(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	/**
	 * 根据传入时间 获得此时间所在年的 最后一天的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYearLastDay(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR, calendar.getActualMaximum(Calendar.HOUR));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	/**
	 * 返回查询的开始时间
	 * 
	 * @param date
	 *            查询时间
	 * @return
	 */
	public static String getBeginTime(Date date) {
		return date == null ? "2011-12-01 00:00:00" : datetimeFormat.format(date);
	}

	/**
	 * 返回查询的结束时间
	 * 
	 * @param date
	 *            查询时间
	 * @return
	 */
	public static String getEndTime(Date date) {
		return date == null ? datetimeFormat.format(System.currentTimeMillis()) : datetimeFormat.format(date);
	}

	public static String currentTime() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	public static String currentTime(String formatStr) {
		DateFormat format = new SimpleDateFormat(formatStr);
		return format.format(new Date());
	}

	/**
	 * 两个时间比较，是否相差24小时
	 * 
	 * @param old
	 * @param news
	 * @return true 超过24小时 false 未超过
	 */
	public static boolean compleDate(Date old, Date news) {
		if (old != null && news != null) {
			long oldLong = old.getTime();
			long newsLong = news.getTime();
			long cs = newsLong - oldLong;
			int s = 24 * 60 * 60 * 1000;
			if (cs > s) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 比较两个时间的大小
	 * 
	 * DATE1>DATE2 返回1 DATE2>DATE1 返回-1 DATE2=DATE1 返回0
	 * 
	 * @return
	 * @return int
	 * @author chentianjin
	 * @date 2017年7月19日
	 */
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 给定日期减一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date datedel(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		return date;
	}

	/**
	 * 给定日期加减（单位天）
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateAd(Date date, int i) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, i);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		return date;
	}

	/**
	 * 给定日期加减（单位小时）
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateAddHour(Date date, int i) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, i);// 把日期往后增加一小时.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推小时的结果
		return date;
	}

	/**
	 * 给定时间秒加减
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateAddSecond(Date date, int i) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, i);// 把日期往后增加一秒.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一秒的结果
		return date;
	}
	
	/**
	 * 给定时间分钟加减
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateAddMinute(Date date, int i) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, i);// 把日期往后增加一分钟.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一分钟的结果
		return date;
	}

	/**
	 * unix timestamp转日期
	 * 
	 * @param beginDate
	 * @return
	 */
	public static String timestampToDate(String beginDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sd = sdf.format(new Date(Long.parseLong(beginDate) * 1000));
		return sd;
	}

	/**
	 * 得到某年某周的第一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek() {
		Calendar a = Calendar.getInstance();
		int year = a.get(Calendar.YEAR);
		int week = DateUtil.getWeekOfYear();
		week = week - 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 1);

		Calendar cal = (Calendar) calendar.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime());
	}

	/**
	 * 得到某年某周的最后一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek() {
		Calendar a = Calendar.getInstance();
		int year = a.get(Calendar.YEAR);
		int week = DateUtil.getWeekOfYear();
		week = week - 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 1);
		Calendar cal = (Calendar) calendar.clone();
		cal.add(Calendar.DATE, week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	/**
	 * 取得当前日期所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // MONDAY
		return calendar.getTime();
	}

	/**
	 * 取得当前日期所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Saturday
		return calendar.getTime();
	}

	/**
	 * 把date格式的时间转换成int格式(精确到秒)
	 * 
	 * @param date
	 * @return
	 */
	public static int getTimeMillis(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		if (date != null) {
			aCalendar.setTime(date);
			return (int) (aCalendar.getTimeInMillis() / 1000);
		}
		return 0;
	}

	/**
	 * @yhcip:title 返回指定格式的当前时间
	 * @yhcip:desc 返回指定格式的当前时间 getCurrentTime("yyyy-MM-dd") 返回 2007-04-29
	 * @param format
	 *            时间格式
	 * @return 得到当前时间的指定格式
	 * @author Administrator
	 */
	public static String getCurrentTime(String format) {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat(format);
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}

	/**
	 * @yhcip:title 得到当前时间
	 * @yhcip:desc 得到当前时间
	 * @return 返回当前时间 时间格式如：2007-04-29 11:39:08
	 * @author Administrator
	 */
	public static String getCurrentTime() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}

	/**
	 * 获取指定年月格式字符串的月初
	 *
	 * @param designDate
	 *            指定日期 (格式为 yyyy-MM)
	 * @return 返回 yyyy-MM-dd 格式的字符串日期
	 * @throws ParseException
	 */
	public static String designMonthStart(String designDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(designDate));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	/**
	 * 获取指定年月格式字符串的月末
	 *
	 * @param designDate
	 *            指定日期 (格式为 yyyy-MM)
	 * @return 返回 yyyy-MM-dd 格式的字符串日期
	 * @throws ParseException
	 */
	public static String designMonthEnd(String designDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(designDate));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	/**
	 * 根据所给的起始,终止时间来计算间隔天数
	 *
	 * @param startDate
	 *            开始时间（yyyy-MM-dd）
	 * @param endDate
	 *            结束时间（yyyy-MM-dd）
	 * @return 间隔天数 重载sysframework的DateUtil.java的getIntervalDay方法，原方法有错
	 */
	public static int getIntervalDay(String startDate, String endDate) {
		Date startDate1 = null, enddate1 = null;
		try {
			startDate1 = dateFormat.parse(startDate);
			enddate1 = dateFormat.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		long startdate = startDate1.getTime();
		long enddate = enddate1.getTime();
		long interval = enddate - startdate;
		int intervalday = (int) (interval / (1000 * 60 * 60 * 24));
		return intervalday;
	}

	/**
	 * 根据所给的起始,终止时间来计算间隔天数
	 *
	 * @param startDate
	 * @param endDate
	 * @return 间隔天数 重载sysframework的DateUtil.java的getIntervalDay方法，原方法有错
	 */
	public static int getIntervalDay(Date startDate, Date endDate) {
		long startdate = startDate.getTime();
		long enddate = endDate.getTime();
		long interval = enddate - startdate;
		int intervalday = (int) (interval / (1000 * 60 * 60 * 24));
		return intervalday;
	}

	/**
	 * @yhcip:title 指定时间返回一个字符串，格式为yyyy-MM-dd HH:mm:ss
	 * @yhcip:desc 指定时间返回一个字符串，格式为yyyy-MM-dd HH:mm:ss
	 * @param date
	 *            指定时间
	 * @return 返回一个格式为yyyy-MM-dd HH:mm:ss的串
	 * @author Administrator
	 */
	public static String datetimeToString(Date date) {
		if (date == null) {
			return null;
		}
		String strDate = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIMESTAMPFORMAT);
		strDate = simpleDateFormat.format(date);
		return strDate;
	}

	/**
	 * 根据所给的起始,终止时间来计算间隔月数
	 *
	 * @param startDate
	 *            YYYYMM
	 * @param endDate
	 *            YYYYMM
	 * @return 间隔月数
	 */
	public static int getIntervalMonth(String startDate, String endDate) {
		if (startDate.length() > 6) {
			startDate = fnGetStr4Y2M(startDate);
		}
		if (endDate.length() > 6) {
			endDate = fnGetStr4Y2M(endDate);
		}
		int startYear = Integer.parseInt(startDate.substring(0, 4));
		int startMonth = 0;
		if (startDate.substring(4, 5).equals("0")) {
			startMonth = Integer.parseInt(startDate.substring(5));
		}
		startMonth = Integer.parseInt(startDate.substring(4, 6));

		int endYear = Integer.parseInt(endDate.substring(0, 4));
		int endMonth = 0;
		if (endDate.substring(4, 5).equals("0")) {
			endMonth = Integer.parseInt(endDate.substring(5));
		}
		endMonth = Integer.parseInt(endDate.substring(4, 6));

		int intervalMonth = (endYear * 12 + endMonth) - (startYear * 12 + startMonth);
		return intervalMonth;
	}

	/**
	 * 将日期传返回yyyymm格式
	 */
	public static final String fnGetStr4Y2M(String szStr) {
		String szRst = szStr;
		szRst = szRst.replaceAll("[ \\|\\-:\\.]", "");
		szRst = szRst.substring(0, 6);
		return szRst;
	}

	/**
	 * 根据所给的起始,终止时间来计算间隔月数
	 *
	 * @param startDate
	 * @param endDate
	 * @return 间隔月数
	 */
	public static int getIntervalMonth(Date startDate, Date endDate) {
		return computeMonthOnly(startDate, endDate);
	}

	/**
	 * 计算时间月份间隔，忽略天数和时分秒的差异
	 * <p>
	 * 注意：此方法仅用于计算日期之间<b>间隔<b>数。
	 * <p>
	 * 若用于表达日期之间有多少天/月/年，应按需要在结果之上±1（如期号的统计）
	 *
	 * @param dateBegin
	 *            开始时间
	 * @param dateEnd
	 *            终止时间
	 * @return 月份间隔
	 * @author ChenHao
	 */
	public static int computeMonthOnly(Date dateBegin, Date dateEnd) {
		Calendar ca1 = Calendar.getInstance();
		ca1.setTime(dateBegin);
		ca1.set(Calendar.DATE, 1);
		ca1.set(Calendar.HOUR, 0);
		ca1.set(Calendar.MINUTE, 0);
		ca1.set(Calendar.SECOND, 0);
		ca1.set(Calendar.MILLISECOND, 0);

		Calendar ca2 = Calendar.getInstance();
		ca2.setTime(dateEnd);
		ca2.set(Calendar.DATE, 1);
		ca2.set(Calendar.HOUR, 0);
		ca2.set(Calendar.MINUTE, 0);
		ca2.set(Calendar.SECOND, 0);
		ca2.set(Calendar.MILLISECOND, 0);

		return compute(ca1.getTime(), ca2.getTime(), Calendar.MONTH, true);
	}

	/**
	 * 注意：此方法仅用于计算日期之间<b>间隔<b>数。若用于表达日期之间有多少天/月/年，应按需要在结果之上±1（如期号的统计）
	 * <p>
	 * 使用此方法时，对月份的计算会受具体时间（天）的影响。 <br>
	 * 如：3月2号到4月3号，可能因计算方法的不同，造成结果为1或2。 <br>
	 * 建议使用computeMonthOnly方法替代，该方法会将日期天数置为1进行计算。
	 * <p>
	 * 使用此方法时，对年份的计算会受具体时间（月和天）的影响。 <br>
	 * 如：2002年3月2号到2003年4月3号，可能因计算方法的不同，造成结果为1或2。 <br>
	 * 建议使用computeYearOnly方法替代，该方法会将日期月份和天数置为1进行计算。
	 * <p>
	 * 按照computeFlag参数定义的计算方式，计算第一个日期到第二个日期之间的间隔
	 * <p>
	 * 如果arg1大于arg2返回值大于0，如果arg1等于arg2返回0，如果arg1小于arg2返回值小于0
	 * <p>
	 * 如果参数bExact为false，若计算内容不足年或不足月时，返回值按足年或足月计算，仅对计算年或计算月时有效
	 * <p>
	 * 如果参数bExact为true，若计算内容不足年或不足月时，返回值按不足年或不足月计算，仅对计算年或计算月时有效
	 * <p>
	 * 例如：
	 * <p>
	 * arg1="2002-09-23"，arg2="2002-11-20"
	 * <p>
	 * 若 computeFlag=COMPARE_MONTH，bExact=true，返回-1
	 * <p>
	 * 若 computeFlag=COMPARE_MONTH，bExact=false，返回-2 又：
	 * <p>
	 * arg1="2002-09-23"，arg2="2002-11-24"
	 * <p>
	 * 若 computeFlag=COMPARE_MONTH，bExact=true，返回-2
	 * <p>
	 * 若 computeFlag=COMPARE_MONTH，bExact=false，返回-3 又：
	 * <p>
	 * arg1="2002-09-23"，arg2="2002-11-23"
	 * <p>
	 * 若 computeFlag=COMPARE_MONTH，bExact=true，返回-2
	 * <p>
	 * 若 computeFlag=COMPARE_MONTH，bExact=false，返回-2
	 *
	 * @param arg1
	 *            第一个日期参数
	 * @param arg2
	 *            第二个日期参数
	 * @param compareFlag
	 *            计算内容
	 * @param bExact
	 *            精确计算标志
	 * @return
	 * @author ChenHao
	 */
	private static int compute(Date arg1, Date arg2, int computeFlag, boolean bExact) {
		Calendar ca1 = Calendar.getInstance();
		ca1.setTime(arg1);
		ca1.set(Calendar.HOUR, 0);
		ca1.set(Calendar.MINUTE, 0);
		ca1.set(Calendar.SECOND, 0);
		ca1.set(Calendar.MILLISECOND, 0);

		Calendar ca2 = Calendar.getInstance();
		ca2.setTime(arg2);
		ca2.set(Calendar.HOUR, 0);
		ca2.set(Calendar.MINUTE, 0);
		ca2.set(Calendar.SECOND, 0);
		ca2.set(Calendar.MILLISECOND, 0);

		int elapsed = 0;

		if (ca1.after(ca2)) // date1 > date2
		{
			while (ca1.after(ca2)) {
				ca1.add(computeFlag, -1);

				elapsed--;
			}

			if (bExact) // 进行精确比较
			{
				if (Calendar.MONTH == computeFlag) {
					if (ca1.get(Calendar.DATE) != ca2.get(Calendar.DATE)) {
						elapsed = elapsed + 1;
					}
				}
				if (Calendar.YEAR == computeFlag) {
					if (ca1.get(Calendar.MONTH) != ca2.get(Calendar.MONTH)) {
						elapsed = elapsed + 1;
					} else if (ca1.get(Calendar.DATE) != ca2.get(Calendar.DATE)) {
						elapsed = elapsed + 1;
					}
				}
			}

			return -elapsed;

		} else if (ca1.before(ca2)) {
			// date1 < date2
			while (ca1.before(ca2)) {
				ca1.add(computeFlag, 1);

				elapsed++;
			}

			if (bExact) // 进行精确比较
			{
				if (Calendar.MONTH == computeFlag) {
					if (ca1.get(Calendar.DATE) != ca2.get(Calendar.DATE)) {
						elapsed = elapsed - 1;
					}
				}
				if (Calendar.YEAR == computeFlag) {
					if (ca1.get(Calendar.MONTH) > ca2.get(Calendar.MONTH)) {
						elapsed = elapsed - 1;
					} else if (ca1.get(Calendar.DATE) != ca2.get(Calendar.DATE)) {
						elapsed = elapsed - 1;
					}
				}
			}

			return -elapsed;
		} else {
			// 相等
			return 0;
		}
	}

	/**
	 * @yhcip:title 把字符串根据格式字符串转换为日期
	 * @yhcip:desc 把字符串根据格式字符串转换为日期
	 * @param strDate
	 *            字符串日期
	 * @param srcDateFormat
	 *            日期格式
	 * @return 日期
	 */
	public static Date stringToDate(String strDate, String srcDateFormat) {
		return new SimpleDateFormat(srcDateFormat).parse(strDate, new ParsePosition(0));
	}

	/**
	 * @yhcip:title 将用指定格式的字符串表示的日期转换成日期类型
	 * @yhcip:desc 将用指定格式的字符串表示的日期转换成日期类型
	 * @param strDate
	 *            要转换的日期字符串
	 * @param srcDateFormat
	 *            源日期格式字符串，如：“yyyy-MM-dd HH:mm:ss”，指明strDate包含的日期是什么格式，以便正确解析出日期
	 * @param dstDateFormat
	 *            目标日期格式字符串
	 * @return 日期
	 */
	public static Date stringToDate(String strDate, String srcDateFormat, String dstDateFormat) {

		Date rtDate = null;
		// 用源日期格式字符串，将日期字符串解析成日期类型
		Date tmpDate = new SimpleDateFormat(srcDateFormat).parse(strDate, new ParsePosition(0));
		// 将日期转换成目标格式字符串
		String tmpString = null;
		if (tmpDate != null) {
			tmpString = new SimpleDateFormat(dstDateFormat).format(tmpDate);
		}

		// 将目标日期字符串，转换成日期类型
		if (tmpString != null) {
			rtDate = new SimpleDateFormat(dstDateFormat).parse(tmpString, new ParsePosition(0));
		}
		return rtDate;
	}

	/**
	 * @yhcip:title 返回当前时间
	 * @yhcip:desc 返回当前时间
	 * @return 时间格式：yyyy-MM-dd
	 * @author Administrator
	 */
	public static String getCurDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
		return simpledateformat.format(calendar.getTime());
		// return getBusinessDate();
	}

	/**
	 * @yhcip:title 指定时间，返回一个指定格式的字符串
	 * @yhcip:desc 指定时间，返回一个指定格式的字符串
	 * @param date
	 *            指定时间
	 * @param format
	 *            时间格式
	 * @return 串
	 * @author Administrator
	 */
	public static String datetimeToString(Date date, String format) {
		if (date == null) {
			return null;
		}
		String strDate = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		strDate = simpleDateFormat.format(date);
		return strDate;
	}

	/**
	 * 获得上周第一天日期
	 *
	 * @return String
	 * @author chentianjin
	 * @date 2017年5月31日
	 */
	public static String getMonday() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		cal.add(Calendar.DATE, -1 * 7);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 获取本周第一天
	 *
	 * @return String
	 * @author chentianjin
	 * @date 2018年4月26日
	 */
	public static String getThisWeekMonday() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 获得上周最后一天日期
	 *
	 * @return String
	 * @author chentianjin
	 * @date 2017年5月31日
	 */
	public static String getSunday() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 将每周第一天设为星期一，默认是星期天
		cal.add(Calendar.DATE, -1 * 7);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 获得上个月第一天日期
	 *
	 * @return String
	 * @author chentianjin
	 * @date 2017年5月31日
	 */
	public static String getfirstDayofMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	/**
	 * 获得本月第一天日期
	 *
	 * @return
	 * @return String
	 * @author chentianjin
	 * @date 2018年4月26日
	 */
	public static String getfirstDayofThisMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	/**
	 * 获得本年第一天
	 * @return String
	 * @author chentianjin
	 * @date 2018年6月1日
	 */
	public static String getfirstDayofThisYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}
	/**
	 * 获得上个月最后一天日期
	 *
	 * @return String
	 * @author chentianjin
	 * @date 2017年5月31日
	 */
	public static String getlastDayofMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	/**
	 * 获得昨天日期
	 *
	 * @return String
	 * @author chentianjin
	 * @date 2017年5月31日
	 */
	public static String getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date time = cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time);
	}

	/**
	 * 获取今天之前（含今天）的day天内的日期数组
	 *
	 * @param day
	 *            ( 大于等于 0 )
	 * @param format
	 * @return
	 */
	public static String[] getBeforeDateFromNow(Integer day, String format) {
		String[] dates = null;
		try {
			if (day <= 0) {
				day = 0;
			}
			dates = new String[day];
			Calendar cal = null;
			for (int i = 0; i < day; i++) {
				cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -i);
				dates[day - i - 1] = new SimpleDateFormat(format).format(cal.getTime());
			}
			return dates;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *
	 * @Description: (两个日期中间相差几天,date1-date2)
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDiffDate(Date date1, Date date2) {
		return (int) ((date1.getTime() - date2.getTime()) / (24 * 3600 * 1000));
	}

	/**
	 * 日期相减
	 *
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static int getDifference(String time1, String time2) throws ParseException {
		if (time1 == null || time2 == null || "".equals(time1) || "".equals(time2)) {
			return -1;
		}

		return getDiffDate(parseDate(time1), parseDate(time2));
	}

	/**
	 * 1、本月返回（本月） 2、今年的其他月返回（1月、2月） 3、今年以外的返回（1999年4月）
	 *
	 * @param key
	 *            "2015-02"
	 * @return
	 * @return String
	 * @author chentianjin
	 * @date 2017年7月26日
	 */
	public static String changeMonth(String key) {
		String nowDay = getCurDate();
		if (key.substring(0, 4).equals(nowDay.substring(0, 4))) {
			if (key.substring(5, 7).equals(nowDay.substring(5, 7))) {
				return "本月";
			} else {
				return Integer.parseInt(key.substring(5, 7)) + "月";
			}
		} else {
			return key.substring(0, 4) + "年" + Integer.parseInt(key.substring(5, 7)) + "月";
		}
	}

	/**
	 * 获取2016-04-01 00:00:00时间
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-15 下午3:25:53
	 */
	public static String getMinTime_Str() {
		return "2016-04-01 00:00:00";
	}

	/**
	 * 获取2016-04-01 00:00:00时间
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-15 下午3:25:53
	 */
	public static Date getMinTime_Date() {
		try {
			return new SimpleDateFormat(TIMESTAMPFORMAT).parse(getMinTime_Str());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取昨天最晚时间，返回yyyy-mm-dd hh:mm:ss
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-15 下午3:17:22
	 */
	public static String getYesterdayLastTime_Str() {
		return new SimpleDateFormat(TIMESTAMPFORMAT).format(getYesterdayLastTime_Date());
	}

	/**
	 * 获取昨天最晚时间，返回yyyy-mm-dd hh:mm:ss
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-15 下午3:17:22
	 */
	public static Date getYesterdayLastTime_Date() {
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.DAY_OF_MONTH, tempCal.get(Calendar.DAY_OF_MONTH) - 1);
		tempCal.set(Calendar.HOUR_OF_DAY, 23);
		tempCal.set(Calendar.MINUTE, 59);
		tempCal.set(Calendar.SECOND, 59);
		return tempCal.getTime();
	}

	/**
	 * 获取昨天最早时间，返回yyyy-mm-dd hh:mm:ss
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-20 上午11:17:17
	 */
	public static String getYesterdayStartTime_Str() {
		return new SimpleDateFormat(TIMESTAMPFORMAT).format(getYesterdayStartTime_Date());
	}

	/**
	 * 获取昨天最早时间，返回yyyy-mm-dd hh:mm:ss
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-15 下午3:17:22
	 */
	public static Date getYesterdayStartTime_Date() {
		Calendar tempCal = Calendar.getInstance();
		tempCal.set(Calendar.DAY_OF_MONTH, tempCal.get(Calendar.DAY_OF_MONTH) - 1);
		tempCal.set(Calendar.HOUR_OF_DAY, 0);
		tempCal.set(Calendar.MINUTE, 0);
		tempCal.set(Calendar.SECOND, 0);
		return tempCal.getTime();
	}

	/**
	 * 得到上周开始日期<br>
	 * 以星期一为本周的第一天
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-25 下午4:01:49
	 */
	public static Date getLastWeekStartDate() {
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0) {
			day_of_week = 7;
		}
		cal.add(Calendar.DATE, -day_of_week + 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到上周的结束日期<br>
	 * 以星期天为本周最后一天
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-25 下午4:03:57
	 */
	public static Date getLastWeekEndDate() {
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0) {
			day_of_week = 7;
		}
		cal.add(Calendar.DATE, -day_of_week + 7);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * 获取上月月初日期
	 *
	 * @return
	 */
	public static Date getLastMonthStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取本月月初日期
	 *
	 * @return
	 */
	public static Date getThisMonthStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取上月月末日期
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-25 下午4:09:55
	 */
	public static Date getLastMonthEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 获取本月月末日期
	 *
	 * @return
	 * @author Ajian
	 * @time 2017-4-25 下午4:09:55
	 */
	public static Date getThisMonthEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期当月的最后一天
	 *
	 * @param date
	 * @return
	 */
	public static String getMonthEnd(String date) throws ParseException {
		return getMonthEnd(dateFormat.parse(date).getTime());
	}

	/**
	 * 获取指定日期当月的最后一天
	 *
	 * @param date
	 * @return
	 */
	public static String getMonthEnd(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		// 获取当月最大天数
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最小天数
		calendar.set(Calendar.DAY_OF_MONTH, lastDay);
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取指定日期当月的第一天
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getMonthStart(String date) throws ParseException {
		return getMonthStart(dateFormat.parse(date).getTime());
	}

	/**
	 * 获取指定日期当月的第一天
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getMonthStart(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 返回格式化yyyy-MM-dd HH:mm:ss的日期时间
	 *
	 * @param date
	 * @return
	 * @author Ajian
	 * @time 2017-4-20 下午4:39:59
	 */
	public static String formatDateYYYYMMDDHHMMSS(Date date) {
		return formateDate(date, TIMESTAMPFORMAT);
	}

	/**
	 * 返回格式化yyyy-MM-dd hh:mm:ss的日期
	 *
	 * @param date
	 * @return
	 * @author Ajian
	 * @time 2017-4-20 下午4:40:53
	 */
	public static String formatDateYYYYMMDD(Date date) {
		return formateDate(date, TIMESTAMPFORMAT);
	}

	/**
	 * 获取输入格式的日期字符串，字符串遵循Oracle格式
	 *
	 * @param d
	 *            - 日期
	 * @param format
	 *            - 指定日期格式，格式的写法为Oracle格式
	 * @return 按指定的日期格式转换后的日期字符串
	 */
	public static String dateToString(Date d, String format) {
		if (d == null) {
			return "";
		}
		Hashtable<Integer, String> h = new Hashtable<Integer, String>();
		String javaFormat = new String();
		String s = format.toLowerCase();
		if (s.indexOf("yyyy") != -1) {
			h.put(new Integer(s.indexOf("yyyy")), "yyyy");
		} else if (s.indexOf("yy") != -1) {
			h.put(new Integer(s.indexOf("yy")), "yy");
		}
		if (s.indexOf("mm") != -1) {
			h.put(new Integer(s.indexOf("mm")), "MM");
		}
		if (s.indexOf("dd") != -1) {
			h.put(new Integer(s.indexOf("dd")), "dd");
		}
		if (s.indexOf("hh24") != -1) {
			h.put(new Integer(s.indexOf("hh24")), "HH");
		}
		if (s.indexOf("mi") != -1) {
			h.put(new Integer(s.indexOf("mi")), "mm");
		}
		if (s.indexOf("ss") != -1) {
			h.put(new Integer(s.indexOf("ss")), "ss");
		}

		int intStart = 0;
		while (s.indexOf("-", intStart) != -1) {
			intStart = s.indexOf("-", intStart);
			h.put(new Integer(intStart), "-");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf("/", intStart) != -1) {
			intStart = s.indexOf("/", intStart);
			h.put(new Integer(intStart), "/");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf(" ", intStart) != -1) {
			intStart = s.indexOf(" ", intStart);
			h.put(new Integer(intStart), " ");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf(":", intStart) != -1) {
			intStart = s.indexOf(":", intStart);
			h.put(new Integer(intStart), ":");
			intStart++;
		}

		if (s.indexOf("年") != -1) {
			h.put(new Integer(s.indexOf("年")), "年");
		}
		if (s.indexOf("月") != -1) {
			h.put(new Integer(s.indexOf("月")), "月");
		}
		if (s.indexOf("日") != -1) {
			h.put(new Integer(s.indexOf("日")), "日");
		}
		if (s.indexOf("时") != -1) {
			h.put(new Integer(s.indexOf("时")), "时");
		}
		if (s.indexOf("分") != -1) {
			h.put(new Integer(s.indexOf("分")), "分");
		}
		if (s.indexOf("秒") != -1) {
			h.put(new Integer(s.indexOf("秒")), "秒");
		}

		int i = 0;
		while (h.size() != 0) {
			Enumeration<Integer> e = h.keys();
			int n = 0;
			while (e.hasMoreElements()) {
				i = ((Integer) e.nextElement()).intValue();
				if (i >= n) {
					n = i;
				}
			}
			String temp = (String) h.get(new Integer(n));
			h.remove(new Integer(n));

			javaFormat = temp + javaFormat;
		}
		SimpleDateFormat df = new SimpleDateFormat(javaFormat, new DateFormatSymbols());

		return df.format(d);
	}

	/**
	 * @yhcip:title 将字符串按默认日期格式转换成日期类型
	 * @yhcip:desc 将字符串按默认日期格式转换成日期类型
	 * @param strDate
	 *            字符串日期
	 * @return 日期
	 */
	public static Date stringToDate(String strDate) {
		return stringToDate(strDate, DATEFORMAT);
	}

	/**
	 * @yhcip:title 指定时间，返回一个指定格式的字符串
	 * @yhcip:desc 指定时间，返回一个指定格式的字符串
	 * @param date
	 *            指定时间
	 * @param format
	 *            时间格式
	 * @return 串
	 * @author Administrator
	 */
	public static String datetimeToString2(Date date, String format) {
		if (date == null) {
			return null;
		}
		String strDate = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
		strDate = simpleDateFormat.format(date);
		return strDate;
	}

	/**
	 * 计算时间天数间隔，忽略月份、天数和时分秒的差异
	 * <p>
	 * 注意：此方法仅用于计算日期之间<b>间隔<b>数。
	 * <p>
	 * 若用于表达日期之间有多少天/月/年，应按需要在结果之上±1（如期号的统计）
	 * 
	 * @param dateBegin
	 *            开始时间
	 * @param dateEnd
	 *            终止时间
	 * @return 年份间隔
	 * @author ChenHao
	 */
	public static int computeDateOnly(Date dateBegin, Date dateEnd) {
		Calendar ca1 = Calendar.getInstance();
		ca1.setTime(dateBegin);
		ca1.set(Calendar.HOUR, 0);
		ca1.set(Calendar.MINUTE, 0);
		ca1.set(Calendar.SECOND, 0);
		ca1.set(Calendar.MILLISECOND, 0);

		Calendar ca2 = Calendar.getInstance();
		ca2.setTime(dateEnd);
		ca2.set(Calendar.HOUR, 0);
		ca2.set(Calendar.MINUTE, 0);
		ca2.set(Calendar.SECOND, 0);
		ca2.set(Calendar.MILLISECOND, 0);

		return compute(ca1.getTime(), ca2.getTime(), Calendar.DATE, true);
	}

	/**
	 * 指定日期加减天数，返回计算后的日期
	 * 
	 * @param srcDate
	 *            yyyy-MM-dd
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public static String addDay(String srcDate, int days) throws ParseException {
		Date src = dateFormat.parse(srcDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		calendar.add(Calendar.DATE, days);

		return dateFormat.format(calendar.getTime());
	}

	public static Date addDays(Date date, int amount) {
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}

	private static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	/**
	 * 月份加减
	 * 
	 * @param date
	 * @param offset
	 * @return
	 * @throws ParseException
	 */
	public static String addMonth(String date, int offset) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dateFormat.parse(date).getTime());
		calendar.add(Calendar.MONTH, offset);

		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 验证某个时间字符串是否满足某个格式
	 * 
	 * @param formatStr
	 * @param dateString
	 * @return
	 * @return boolean
	 * @author chentianjin
	 * @date 2018年1月6日
	 */
	public static boolean checkDateFormart(String formatStr, String dateString) {
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = DateUtil.TIMESTAMPFORMAT;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			format.parse(dateString);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
