package edu.eci.ejercicio4_3_1;

import java.net.*;
import java.io.*;

public class servidor {

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
		Integer outputLine;
		while ((inputLine = in.readLine()).length() != 0) {
			
			outputLine = Integer.valueOf(inputLine)*Integer.valueOf(inputLine);
			out.println(outputLine);
			if (inputLine.equals("Bye.")) {
				break;
			}
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
		serverSocket.close();
		

	}

}
