
package com.test.practice;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class Program1 {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		System.out.println(base62Encode(Long.valueOf("1669600554407112332")));
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		byte[] messageDigest = md.digest("16696005544071669600554407166960055440716696005544071669600554407".getBytes());
		
		BigInteger no = new BigInteger(1, messageDigest);
		
		
		String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        
        //System.out.println("Your HashCode Generated by MD5 is: " + hashtext);
        
        //System.out.println(base62Encode(Long.valueOf(hashtext)));
	}
	
	public static void Base62Encode() {
		System.out.println(Instant.now().toEpochMilli());
	}
	

	private static String base62Encode(long value) {
		String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    StringBuilder sb = new StringBuilder();
	    while (value != 0) {
	        sb.append(base62.charAt((int)(value % 62)));
	        value /= 62;
	    }
	    while (sb.length() < 6) {
	        sb.append(0);
	    }
	    return sb.reverse().toString();
	}

}
