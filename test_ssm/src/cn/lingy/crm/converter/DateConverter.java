package cn.lingy.crm.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");		
		try{
			// 如果转换成功，就直接返回
			return format.parse(arg0);
		}catch(Exception e){
			e.printStackTrace();
		}
		// 如果转换失败，返回null
		return null;
	}

}
