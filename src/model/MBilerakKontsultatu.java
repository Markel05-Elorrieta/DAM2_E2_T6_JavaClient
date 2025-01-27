package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MBilerakKontsultatu {
	private ServerUtils server;
	private Socket socket;
	
	// Escribir al servidor
	private PrintWriter pw;
	
	// Lectura de mensajes del servidor
	private ObjectInputStream ois;
		
	public MBilerakKontsultatu() {
		server = new ServerUtils();
	}
	
	public ArrayList<Reuniones> bilerakByTeacher(int id) {
		try {
			socket = server.connect();
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			ois = new ObjectInputStream(socket.getInputStream());
			
			pw.println("bilerakByTeacher/" + id);
						
			ArrayList<Reuniones> response = (ArrayList<Reuniones>) ois.readObject();			
			System.out.println(response);
			ois.close();
			pw.close();
			server.close();
			
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
}