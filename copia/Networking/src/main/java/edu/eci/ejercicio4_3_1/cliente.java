package edu.eci.ejercicio4_3_1;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class cliente {
	
	public static void main(String[] args) throws IOException {
		
		Socket clientSocket;
		try {
			clientSocket = new Socket("127.0.0.1", 30000);
			PrintWriter out = null;
			BufferedReader in = null;
			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			} catch (UnknownHostException e) {
				System.err.println("Host errado");
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Couldn't get I/O for " + "the connection to: localhost.");
				System.exit(1);
			}
			
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			while ((userInput = stdIn.readLine()).length() != 0) {
				out.println(userInput);
				System.out.println(in.readLine());

			}
			out.close();
			in.close();
			stdIn.close();
			clientSocket.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		;

	}


}
