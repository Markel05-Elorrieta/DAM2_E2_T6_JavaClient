package model.modals;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import model.Users;
import model.utilities.MBCrypt;
import model.utilities.ServerUtils;

public class MBilerakSortu {
	// Conexion con el servidor
	private ServerUtils server;
	private Socket socket;
	
	// Escribir al servidor
	private PrintWriter pw;
	
	// Lectura de mensajes del servidor
	private ObjectInputStream ois;
	
	private MBCrypt mBCrypt;
		
	public MBilerakSortu() {
		server = new ServerUtils();
	}
	
	public ArrayList<Users> getIkasleakByIrakasleId(int irakasleId) {

		mBCrypt = new MBCrypt();

		try {
			socket = server.connect();
			pw = new PrintWriter(socket.getOutputStream(), true);

			ois = new ObjectInputStream(socket.getInputStream());

			String toSend = "getIkasleakByIrakasleId/" + irakasleId;
			pw.println(toSend);


			ArrayList<Users> response = (ArrayList<Users>) ois.readObject();
			ois.close();
			pw.close();
			server.close();

			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
