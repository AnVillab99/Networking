package ejercicio4.ejercicio4_3;

import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException {
		servidor s = new servidor();
		cliente c = new cliente();
		s.iniciar();
		c.inicia();
		
	}
	

}
