package model.modals;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import model.Horarios;
import model.utilities.ServerUtils;

public class MOrdutegiaKontsultatu {
	// Conexion con el servidor
		private ServerUtils server;
		private Socket socket;
		
		// Escribir al servidor
		private PrintWriter pw;
		
		// Lectura de mensajes del servidor
		private ObjectInputStream ois;
			
		public MOrdutegiaKontsultatu() {
			server = new ServerUtils();
		}
		
		public ArrayList<Horarios> getHorariosByIrakasleId(int id) {
			try {
				socket = server.connect();
				pw = new PrintWriter(socket.getOutputStream(), true);
				
				ois = new ObjectInputStream(socket.getInputStream());
				
				pw.println("scheduleTeacher/" + id);
							
				ArrayList<Horarios> response = (ArrayList<Horarios>) ois.readObject();			
			
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
