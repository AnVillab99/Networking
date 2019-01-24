package ejercicio4.ejercicio4_3;

import java.net.*;
import java.io.*;

public class servidor {
	public servidor() {}

	public void iniciar() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6005);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 5000.");
			System.out.println(e);
			System.exit(1);
		}
		System.out.println("bbbbbbbbbbbbb");
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
			System.out.println("cccccccccccccccccccc");
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		PrintWriter out;

		System.out.println("eeeeeeeeeeeeeeeeeeeee");
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine, outputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Mensaje: " + inputLine);
				outputLine = "Respuesta" + inputLine;
				out.println(outputLine);
				if (outputLine.equals("Respuestas: Bye."))
					break;
			}
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();

			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
