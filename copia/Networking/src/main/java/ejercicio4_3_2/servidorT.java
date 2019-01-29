package ejercicio4_3_2;

import java.net.*;
import java.io.*;

public class servidorT {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(30000);

		} catch (IOException e) {
			System.err.println("Could not listen on port: 30000.");
			System.exit(1);
		}

		
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		
		
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String inputLine;
		String outputLine;
		String op = "cos";
		while ((inputLine = in.readLine()).length() != 0) {
			if (inputLine.equals("bye")) {
				break;
			}
			double ans = 0.0;
			try {
				double num = Math.toRadians(Double.valueOf(inputLine));
				
				
				
				
				if(op.equals("sin")) {
					ans = Math.sin(num);
				}
				else if(op.equals("cos")) {
					ans = Math.cos(num);
				}	
				else if(op.equals("tan")) {
					ans = Math.tan(num);
				}
				System.out.println("ans "+ans);
				outputLine = "Respuesta: " + ans;
				out.println(outputLine);
			} catch (NumberFormatException e) {
				if(inputLine.contains("fun:")) {
					op = inputLine.substring(inputLine.length()-3);	
					out.println("Operacion cambiada a:"+op);
				}
				
				
			}	
			
		
			
			
			
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
		serverSocket.close();
		

	}

}
