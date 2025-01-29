package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Socket socket = new Socket("10.5.104.43", 23456);
			System.out.println("Connected to server!");
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			out.println("getIkastetxeak");
			System.out.println("Petición enviada al servidor");
			
			List<Ikastetxeak> response = (List<Ikastetxeak>) ois.readObject();
			
			for (Ikastetxeak ikastetxea : response) {
				System.out.println(ikastetxea.toString());
			}
			
			
				
			System.out.println("Closing communication");
			socket.close();
		} catch (Exception e) {
			
		}
			
	
		// CLogin cLogin = new CLogin();		
	}

}
