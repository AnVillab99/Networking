package ejercicio4.ejercicio4_3;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class cliente {
	public cliente() {}
	
	public void inicia() {

		Socket clientSocket;
		try {
			clientSocket = new Socket("127.0.0.1", 6005);
			PrintWriter out = null;
			BufferedReader in = null;
			String url = JOptionPane.showInputDialog("Entre la URL sin el protocolo");
			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			} catch (UnknownHostException e) {
				System.err.println("Host errado");
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Couldn’t get I/O for " + "the connection to: localhost.");
				System.exit(1);
			}
			
			
			
			
			
			
			
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;

			while ((userInput = stdIn.readLine()) != null) {
				out.println(userInput);
				System.out.println("echo: " + in.readLine());

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
