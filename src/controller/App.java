package controller;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import model.Ciclos;
import model.Horarios;
import model.Matriculaciones;
import model.Modulos;
import model.Reuniones;
import model.Tipos;
import model.Users;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket socket = new Socket("10.5.104.43", 23456);
			System.out.println("Connected to server!");
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			out.println("testUser");
			System.out.println("Petición enviada al servidor");
			
			Users response = (Users) ois.readObject();
			System.out.println(response.toString());
				
			System.out.println("Closing communication");
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		CLogin cLogin = new CLogin();		
	}

}
