package controller;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import model.Users;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost", 23456);
			System.out.println("Connected to server!");
			Scanner sc = new Scanner(System.in);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			String txt = sc.nextLine();
			out.println(txt);
			
			Users response = (Users) ois.readObject();
			System.out.println(response.toString());
				
			System.out.println("Closing communication");
			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
