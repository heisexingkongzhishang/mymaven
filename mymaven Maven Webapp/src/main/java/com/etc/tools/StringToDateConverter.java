package com.etc.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/** 自定义字符串---日期类型数据转换器 */
public class StringToDateConverter implements Converter<String, Date> {

	private String datePattern;// 日期格式

	public StringToDateConverter(String datePattern) {
		this.datePattern = datePattern;
	}

	@Override
	public Date convert(String s) {
		Date date = null;
		try {
			date = new SimpleDateFormat(datePattern).parse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
