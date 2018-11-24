package cn.happy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
   public static String format(Date date,String str){
	   SimpleDateFormat sdf=new SimpleDateFormat(str);
	   return sdf.format(date);
   }
}
