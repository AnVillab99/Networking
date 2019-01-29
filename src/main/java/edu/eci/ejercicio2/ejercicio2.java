package edu.eci.ejercicio2;


import java.awt.Desktop;
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;
public class ejercicio2 {
  @SuppressWarnings("resource")
public static void main(String[] args) throws Exception {
	  String url = JOptionPane.showInputDialog("Entre la URL completa");
	  URL URL = new URL(url);	
	  
	  File resultados2 = new File(System.getProperty("user.home")+"/resultados2.html");
	  PrintWriter pw = new PrintWriter(resultados2);
	  File resultados = new File(System.getProperty("user.home")+"/resultados.html");
	  BufferedWriter writer = new BufferedWriter(new FileWriter(resultados));
	  
	  
	  
	  try (BufferedReader reader = new BufferedReader(new InputStreamReader(URL.openStream()))) {
		  String inputLine = null;
		  while ((inputLine = reader.readLine()) != null) {
			  writer.write(inputLine);
			  pw.print(inputLine);
			  pw.write(inputLine);
			  }
		  } catch (IOException x) {
			  System.err.println(x);
			  }
	  writer.close();
	  
	  Desktop.getDesktop().browse(resultados.toURI());
	  Desktop.getDesktop().browse(resultados2.toURI());
	  
	  }
  
  
  
 
}