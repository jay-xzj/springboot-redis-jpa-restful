package com.crm.comm.cfgdata.base.util;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class DateUtil {
	private static final Log log = LogFactory.getLog(DateUtil.class);

	 /** 
     * 根据年 月 获取对应的月份 天数 
     * */  
    public static int getDaysByYearMonth(int year, int month) {  
          
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    } 
    
    private DateUtil() {
		// util class, prevent from new instance
	}
	public static final String DATETIME    = "yyyy-MM-dd HH:mm:ss";
    public static final String DATENOTIME  = "yyyy-MM-dd";
    public static final String ONLYTIME    = "HH:mm:ss";
    public static final String YEARMONTH = "yyyyMM";
    
    public static final String YYYYMMDDHHMMSS ="yyyyMMddHHmmss";
    
    public static Date getCurrentTime(){
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }
    public static Calendar date2Calendar(Date datetime){
        if(datetime==null)return null;
        Calendar c = Calendar.getInstance();
        c.setTime(datetime);
        return c;
    }
    public static Calendar sqldate2Calendar(java.sql.Date datetime){
        if(datetime==null)return null;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(datetime.getTime());
        return c;
    }
    public static String calendar2String(Calendar time){
        return date2String(time.getTime());
    }
    public static String date2String(Date time,String datepattern){
    	if(StringUtil.isEmpty(datepattern)){
    		datepattern = DATENOTIME;
    	}
    	SimpleDateFormat dateFormat = new SimpleDateFormat(datepattern);
        try{
            return dateFormat.format(time);
        }catch(Exception e){
        	log.error(e);
            return null;
        }
    }
    public static String date2String(Timestamp time,String datepattern){
    	if(StringUtil.isEmpty(datepattern)){
    		datepattern = DATENOTIME;
    	}
    	SimpleDateFormat dateFormat = new SimpleDateFormat(datepattern);
        try{
            return dateFormat.format(time);
        }catch(Exception e){
        	log.error(e);
            return null;
        }
    }
    public static String formatDate(String date,String datepattern){
    	String result = "";
    	if(StringUtil.isNotEmpty(date)){
    		Date date2 = string2Date(date, datepattern);
    		if(date2!= null){
    			result = date2String(date2, datepattern);
    		}
    	}
    	return StringUtil.isEmpty(result)?date:StringUtil.trimToEmpty(result);
    }
    
    
    public static String formatDate(String date,String currentpattern,String datepattern){
        String result = "";
        if(StringUtil.isNotEmpty(date)){
            Date date2 = string2Date(date, currentpattern);
            if(date2!= null){
                result = date2String(date2, datepattern);
            }
        }
        return StringUtil.isEmpty(result)?date:StringUtil.trimToEmpty(result);
    }
    
    public static String formatDateESB(String date,String esbpattern){
        return formatDate(date, DATETIME, esbpattern);
    }
    public static String formatDate(String date){
    	return formatDate(date, DATETIME);
    }
    
    public static Calendar string2Calendar(String strtime){
        Date d = string2Date(strtime);
        if(d != null){
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            return c;
        }
        return null;
    }
    public static Date string2Date(String strtime){
        try{
        	SimpleDateFormat dateFormat = new SimpleDateFormat(DATENOTIME);
            return dateFormat.parse(strtime, new ParsePosition(0));
        }catch(Exception e){log.error(e);}
        return null;
    }
    public static Date string2Date(String strtime,String datepattern){
        try{
        	SimpleDateFormat dateFormat = new SimpleDateFormat(datepattern);
            return dateFormat.parse(strtime, new ParsePosition(0));
        }catch(Exception e){log.error(e);}
        return null;
    }
    public static String date2String(Date time){
        return date2String(time,null);
    }
    
    public static String date2String(Timestamp time){
        return date2String(time,null);
    }
    
    
    public static String getCurrentYear(){
    	Calendar  cl = Calendar.getInstance();
    	int year = cl.get(Calendar.YEAR);
    	return String.valueOf(year);
    }
    
    /**
	 * 判断是否为同一天
	 * 
	 * @return
	 */
	public static boolean isSameDay(Date nowDate, Date date2) {
		boolean result = false;
		if (nowDate == null || date2 == null) 
			return result;
		
		Calendar c1 = Calendar.getInstance();
		c1.setTime(nowDate);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);

		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
				&& c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
				&& c1.get(Calendar.DAY_OF_MONTH) == c2
						.get(Calendar.DAY_OF_MONTH)) {
			result = true;
		}
		return result; //是否需要缓存可用这个开关
	}
	
	 //-----------------------------------------------------------------------
    /**
     * Adds a number of years to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of months to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of weeks to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of days to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of hours to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of minutes to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of seconds to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of milliseconds to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to add to
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
    
    //-----------------------------------------------------------------------
    /**
     * Sets the years field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setYears(Date date, int amount) {
        return set(date, Calendar.YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the months field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setMonths(Date date, int amount) {
        return set(date, Calendar.MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the day of month field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setDays(Date date, int amount) {
        return set(date, Calendar.DAY_OF_MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the hours field to a date returning a new object.  Hours range 
     * from  0-23.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setHours(Date date, int amount) {
        return set(date, Calendar.HOUR_OF_DAY, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the minute field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setMinutes(Date date, int amount) {
        return set(date, Calendar.MINUTE, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Sets the seconds field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setSeconds(Date date, int amount) {
        return set(date, Calendar.SECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the miliseconds field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setMilliseconds(Date date, int amount) {
        return set(date, Calendar.MILLISECOND, amount);
    } 
    
    //-----------------------------------------------------------------------
    /**
     * Sets the specified field to a date returning a new object.  
     * This does not use a lenient calendar.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to set the amount to
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    private static Date set(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        // getInstance() returns a new object, so this method is thread safe.
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(calendarField, amount);
        return c.getTime();
    }
    
    
    public static String dealDateStr(String strDate,String datePattern,int addYear,int addMonth,int addDay){
    	Date date = string2Date(strDate, datePattern);
    	if(addYear!=0){
    		date = addYears(date, addYear);
    	}
    	if(addMonth!=0){
    		date = addMonths(date, addMonth);
    	}
    	if(addDay!=0){
    		date = addDays(date, addDay);
    	}
    	return date2String(date, datePattern);
    }
}
