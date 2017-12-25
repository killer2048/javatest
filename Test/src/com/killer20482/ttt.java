package com.killer20482;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ttt {
	public static void main(String[] args) {
		aaa();
		System.out.println("_______");
		bbb();
		System.out.println("_______");
		ccc();
		System.out.println("_______");
		ddd();
	}
	private static String a1 = "ab";  
	  
	public static void aaa() {  
	    String s1 = "a";  
	    String s2 = "b";  
	    String s = s1 + s2;  
	    System.out.println(s == a1);  
	    System.out.println(s.intern() == a1);  
	    
	    
	} 
	
	
	private static String a2 = new String("ab");  
	  
    public static void bbb() {  
        String s1 = "a";  
        String s2 = "b";  
        String s = s1 + s2;  
        System.out.println(s == a2);  
        System.out.println(s.intern() == a2);  
        System.out.println(s.intern() == a2.intern());  
    }  
    
    public static void ccc() { 
        String a = "ab";  
        final String bb = "b";  
        String b = "a" + bb;  
        System.out.println(a == b);  
    } 
    
    public static void ddd()   {
    	String a = "aaa";
    	StringBuffer ab = new StringBuffer("aaa");
    	System.out.println(a+ab);
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.MONTH, 2);
    	System.out.println(c);
    	System.out.println(c.getMaximum(Calendar.DAY_OF_MONTH));
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    	System.out.println(f.parse("2016-05-17",new ParsePosition(0)));
    }



}
