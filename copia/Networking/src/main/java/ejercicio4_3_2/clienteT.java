package ejercicio4_3_2;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class clienteT {
	
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

			System.out.println("Ingrese un numero o una funcion de con este formato: fun:sin "+"\n"+" Para salirse escriba bye");
			while ((userInput = stdIn.readLine()) != null) {
				out.println(userInput);
				if(userInput.equals("bye")) break;
				System.out.println(in.readLine());
				
				System.out.println("Ingrese un numero o una funcion de con este formato: fun:sin "+ "\n"+" Para salirse escriba bye");
				

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
