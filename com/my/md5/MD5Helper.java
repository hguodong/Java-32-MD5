package com.my.md5;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Helper {
	
	public static String encode(String str) {
		//MessageDigest类为应用程序提供消息摘要算法的功能
		//messageDigest是安全的单向散列函数，它采取任意大小的数据，并输出固定长度的散列值
		MessageDigest messageDigest = null;
		try {
			/**
			 * 返回指定摘要算法的MessageDigest对象
			 * 此处是返回MD5算法的MessageDigest实例化对象
			 */
			messageDigest = MessageDigest.getInstance("MD5");
			/**
			 * 重置摘要以供进一步使用
			 */
			messageDigest.reset();
			/**
			 * str.getBytes(String charsetName)使用命名的字符集将代码字符串编码为字节序列，将结果存储到新的字节数组中
			 * 使用指定的字节数数组更新摘要
			 * 此处指使用UTF-8编码格式的字节数组，更新摘要
			 */
			messageDigest.update(str.getBytes("UTF-8"));
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/**
		 * 通过最终执行完成哈希运算
		 */
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		/**
		 * 遍历哈希运算结果
		 */
		for (int i = 0; i < byteArray.length; i++) {
			/**
			 * OXFF：表示一个十六进制无符号整数
			 *Integer.toHexString(int i)，将整数转换成字符串，最终返回32位的结果
			 */
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	

	public static void main(String[] args) {
		/**
		 * 移动号段：134,135,136,137,138,139,147,150,151,152,157,158,159,178,182,183,184,187,188
		 */
		int move[] = {134,135,136,137,138,139,147,150,151,152,157,158,159,178,182,183,184,187,188};
		/**
		 * 联通号段：130,131,132,155,156,185,186,145,176
		 */
		int unicom[] = {130,131,132,155,156,185,186,145,176};
		/**
		 * 电信号段：133,153,177,180,181,189，
		 */
		int telecom[] = {133,153,177,180,181,189};
		/*//创建随机对象
		Random random = new Random();
		//获取随机数组索引[0,(len-1)]之间
		int i = random.nextInt(move.length - 1);
		//获取随机数组值
		int movenum = move[i];
		System.out.println(movenum);*/
		//
		/*Random random = new Random();
		String str = String.valueOf(random.nextInt(100000000));
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0;i < 8 - str.length();i++){
			stringBuffer.append(0);
		}
			stringBuffer.append(str);*/
		System.out.println("=============================================================================");
		for (int i = 0;i < move.length;i++){
			String s = String.valueOf(move[i]);
			Random random = new Random();
			String str = String.valueOf(random.nextInt(100000000));
			StringBuffer stringBuffer = new StringBuffer();
			for(int j = 0;j < 8 - str.length();j++){
				stringBuffer.append(0);
			}
			stringBuffer.append(str);
			s+=stringBuffer;
			System.out.println("移动号码："+s+"\t"+"移动号码32位大写加密："+encode(s).toUpperCase());
		}
		System.out.println("=============================================================================");
		for (int i = 0;i < unicom.length;i++){
			String s = String.valueOf(unicom[i]);
			Random random = new Random();
			String str = String.valueOf(random.nextInt(100000000));
			StringBuffer stringBuffer = new StringBuffer();
			for(int j = 0;j < 8 - str.length();j++){
				stringBuffer.append(0);
			}
			stringBuffer.append(str);
			s+=stringBuffer;
			System.out.println("联通号码："+s+"\t"+"联通号码32位大写加密："+encode(s).toUpperCase());
		}
		System.out.println("=============================================================================");
		for (int i = 0;i < telecom.length;i++){
			String s = String.valueOf(telecom[i]);
			Random random = new Random();
			String str = String.valueOf(random.nextInt(100000000));
			StringBuffer stringBuffer = new StringBuffer();
			for(int j = 0;j < 8 - str.length();j++){
				stringBuffer.append(0);
			}
			stringBuffer.append(str);
			s+=stringBuffer;
			System.out.println("电信号码："+s+"\t"+"电信号码32位大写加密："+encode(s).toUpperCase());
		}

		//System.out.println("password:"+encode("460036210841492"));
		//System.out.println("password:"+encode("460036210841492").toUpperCase());
	}
}
