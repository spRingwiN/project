package com.netease.course.util;

import java.io.UnsupportedEncodingException;

public class GeneralTool {
	
	private static String charset="utf-8";
	
	public static byte[] strToByte(String s){
		byte[] result=null;
		try {
			 result= s.getBytes(charset);
		} catch (UnsupportedEncodingException e) {	
			e.printStackTrace();
		}
		return result;
	}
	public static String byteToStr(byte[] b){
		
		String result=null;
		try {
			result=new String(b,charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static long douToLon(double d){
		
			d=(double)Math.round(d*100)/100;			
			return (long)(d*100);
	}
	public static double lonToDou(long m){
		
		return ((double)m)/100;
	}
}
