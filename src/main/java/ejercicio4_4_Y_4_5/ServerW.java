package ejercicio4_4_Y_4_5;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

// The tutorial can be found just here on the SSaurel's Blog : 
// https://www.ssaurel.com/blog/create-a-simple-http-web-server-in-java
// Each Client Connection will be managed in a dedicated Thread
public class ServerW {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String main = "paginas/index.html";
		String not_found = "paginas/notFound.html";
		
		BufferedReader in = null;
		PrintStream  out = null;
		BufferedOutputStream dataOut = null;
		String fileRequested = null;
		
		
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(33000);

		} catch (IOException e) {
			System.err.println("Could not listen on port: 33000.");
			System.exit(1);
		}

		

		while (true) {
			Socket clientSocket = null;
			try {				
				clientSocket = serverSocket.accept();
				
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
		
			
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out=new PrintStream(new BufferedOutputStream(clientSocket.getOutputStream()));
			dataOut = new BufferedOutputStream(clientSocket.getOutputStream());
			String inputLine = in.readLine();

			
			StringTokenizer tok = new StringTokenizer(inputLine);
			
			
			try {
				String peticion = tok.nextToken();				
				fileRequested = tok.nextToken();
				if(inputLine ==null) {break;}
				//System.out.println("          file pre "+fileRequested);
				if(fileRequested.endsWith("/")) {
					fileRequested = main;
					}
				else if(fileRequested.endsWith(".jpeg")||fileRequested.endsWith(".jpg") ) {
					//fileRequested="paginas/fileRequested.substring(0,fileRequested.indexOf("."));
					fileRequested="paginas/"+fileRequested+"";
					
				}
				else {
					fileRequested=fileRequested.substring(1);
					System.out.println("file "+fileRequested);
					}		
				
				InputStream inStream=new FileInputStream(fileRequested);
				String cType="text/plain";
				
				//System.out.println("file post "+fileRequested);
				
				if (fileRequested.endsWith(".html")) {cType="text/html";}
				else if (fileRequested.endsWith(".jpeg")||fileRequested.endsWith(".jpg") ) {
					System.out.println("pido jpg.jpg");
					cType="image/jpeg";
					} 
				out.print("HTTP/1.0 200 OK\r\n"+"Content-type: "+cType+"\r\n\r\n");				
				byte[]fileData = new byte[5000];
				int n=inStream.read(fileData);
				while (n>0) {
					out.write(fileData, 0, n);
					n=inStream.read(fileData);
				}
			out.close();
			in.close();
			} catch (Exception e) {
				out.println("HTTP/1.0 404 Not Found\r\n"+"Content-type: text/html\r\n\r\n");
				InputStream stream=new FileInputStream("paginas/notFound.html");
				byte[]fileData = new byte[5000];
				int n=stream.read(fileData);
				while (n>0) {
					out.write(fileData, 0, n);
					n=stream.read(fileData);
				}			
				out.close();

		}
		
			
			
			

		}

}
}