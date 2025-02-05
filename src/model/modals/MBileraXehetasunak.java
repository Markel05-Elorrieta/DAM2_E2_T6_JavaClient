package model.modals;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import model.Ikastetxeak;
import model.Reuniones;
import model.utilities.ServerUtils;

public class MBileraXehetasunak {
	private ServerUtils server;
	private Socket socket;
	
	// Escribir al servidor
	private PrintWriter pw;
	
	// Lectura de mensajes del servidor
	private ObjectInputStream ois;
		
	public MBileraXehetasunak() {
		server = new ServerUtils();
	}
	
	public Ikastetxeak getIkastetxeByCCEN(Reuniones r) {
		try {
			socket = server.connect();
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			ois = new ObjectInputStream(socket.getInputStream());
			
			pw.println("getIkastetxe/" + r.getIdCentro());
						
			Ikastetxeak response = (Ikastetxeak) ois.readObject();		
			
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
