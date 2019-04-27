package com.itheima.web.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 需求：日期转换器
 * @author Diane
 *
 */

public class MyTypeConvert extends StrutsTypeConverter {

	/**
	 * 把字符串数组中的数据转换成日期类型
	 * 
	 * 参数详解：
	 * 		Map context：是OGNL的上下文对象
	 * 		String[] values：要转换的对象
	 * 		Class toClass：目标类型
	 * 
	 */
	
	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		//1.先判断有没有数据
		if(values == null || values.length==0){
			return null;
		}
		//2.取出数组中的第一个元素
		String date = values[0];
		//3.判断目标字节码类型是不是日期类型
		if(toClass == java.util.Date.class){
			//4.使用DateFormat进行转换，返回转换后的结果
			try {
				return format.parse(date);
				
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	
	/**
	 * 把日期转换成字符串
	 * 
	 * 参数详解：
	 * 		Map context：是OGNL的上下文对象
	 * 		Object o：要转换的数据
	 */
	@Override
	public String convertToString(Map context, Object o) {
		
		//1.判断object是不是日期类型
		if(o instanceof Date){// A instanceof B 如果A是null，用instanceof不会报空指针异常
			Date date = (Date) o;
			//2.是日期类型，使用转换器转换成指定格式的字符串，并返回
			return format.format(date);
		}
		return null;
	}
}
