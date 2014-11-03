package qkh.saber.data_process;

import java.util.Calendar;
import java.util.TimeZone;

public class StringDatePell {
	//日期显示
	   
	       private static String mDay;
	       private static String myear;
	       private static String mmoth;
		   private static String mDay1;
		   private static String mDay2;
		   private static String mDay3;
		   private static String mDay4;
		   private static String mh;
		   private static String mm;
		   
		   public String stringDatePell() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   myear = String.valueOf(c.get(Calendar.YEAR));
			   mmoth = String.valueOf(c.get(Calendar.MONTH)+1);
			   mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
			   return myear+"年"+mmoth+"月"+mDay+"日";
			
		}
		   public String stringDatePell1() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   mDay1 = String.valueOf(c.get(Calendar.DAY_OF_MONTH)+1);
			   return mDay1;
			
		}
		   public String stringDatePell2() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   mDay2 = String.valueOf(c.get(Calendar.DAY_OF_MONTH)+2);
			   return mDay2;
			
		}
		   public String stringDatePell3() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   mDay3 = String.valueOf(c.get(Calendar.DAY_OF_MONTH)+3);
			   return mDay3;
			
		}
		   public String stringDatePell4() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   mDay4 = String.valueOf(c.get(Calendar.DAY_OF_MONTH)+4);
			   return mDay4;
			
		}
		   public String stringDatePell5() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   mh = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
			   mm = String.valueOf(c.get(Calendar.MINUTE));
			   return "更新于今天"+mh+"时"+mm+"分";
			
		}
		   public String stringDatePell6() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   myear = String.valueOf(c.get(Calendar.YEAR));
			   mmoth = String.valueOf(c.get(Calendar.MONTH)+1);
			   mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH)+1);
			   return myear+"年"+mmoth+"月"+mDay+"日";
			
		}
		   public String stringDatePell7() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   myear = String.valueOf(c.get(Calendar.YEAR));
			   mmoth = String.valueOf(c.get(Calendar.MONTH)+1);
			   mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH)+2);
			   return myear+"年"+mmoth+"月"+mDay+"日";
			
		}
		   public String stringDatePell8() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   myear = String.valueOf(c.get(Calendar.YEAR));
			   mmoth = String.valueOf(c.get(Calendar.MONTH)+1);
			   mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH)+3);
			   return myear+"年"+mmoth+"月"+mDay+"日";
			
		}
		   public String stringDatePell9() {
			   final Calendar c = Calendar.getInstance();
			   c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			   myear = String.valueOf(c.get(Calendar.YEAR));
			   mmoth = String.valueOf(c.get(Calendar.MONTH)+1);
			   mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH)+4);
			   return myear+"年"+mmoth+"月"+mDay+"日";
			
		}
		   

}
