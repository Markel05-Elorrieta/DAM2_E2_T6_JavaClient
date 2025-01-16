package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MLogin {
	// Conexion con el servidor
	private ServerUtils server;
	private Socket socket;
	
	// Escribir al servidor
	private PrintWriter pw;
	
	// Lectura de mensajes del servidor
	private ObjectInputStream ois;
		
	public MLogin() {
		server = new ServerUtils();
	}
	
	public boolean checkLogin(String email, String password) {
		try {
			socket = server.connect();
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			ois = new ObjectInputStream(socket.getInputStream());
			
			pw.println("loginAndroid/" + email + "/" + password);
			
			System.out.println("Petición enviada al servidor");
						
			Users response = (Users) ois.readObject();			
			
			ois.close();
			pw.close();
			server.close();
			
			if (response != null) {
				GlobalVariables.loggedUser = response;
				
				return true;
			}			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}