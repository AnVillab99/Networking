package edu.eci.ejercicio1;

import java.net.URL;

public class ejercicio1 {
	

	 public static void main(String[] args) throws Exception {
		 URL google = new URL("http://www.google.com/");
		 System.out.println(google.getProtocol());
		 System.out.println(google.getAuthority());
		 System.out.println(google.getHost());
		 System.out.println(google.getPort());
		 System.out.println(google.getPath());
		 System.out.println(google.getQuery());
		 System.out.println(google.getFile());
		 System.out.println(google.getRef());
		   
	 }
		 

}
