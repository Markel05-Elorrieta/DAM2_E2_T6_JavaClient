package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerUtils {
	
	private Socket socket;
	private String ip = "10.5.104.34";
	private int port = 23456;	
	
	public Socket connect() {
		try {
			socket = new Socket(ip, port);
			System.out.println("Connected to server!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return socket;
	}
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
