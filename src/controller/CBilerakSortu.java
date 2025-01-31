package controller;

import java.util.ArrayList;

import model.Users;
import model.modals.MBilerakSortu;
import view.VBilerakSortu;

public class CBilerakSortu {
	
	private VBilerakSortu vBilerakSortu;
	private MBilerakSortu mBilerakSortu;
	
	public CBilerakSortu() {
	

		mBilerakSortu = new MBilerakSortu();
		
		ArrayList<Users> userList = mBilerakSortu.getIkasleakByIrakasleId(1);
		
		vBilerakSortu = new VBilerakSortu(userList);
		vBilerakSortu.setVisible(true);

		start();
	}
	
	private void start() {
		setListeners();
	}
	
	private void setListeners() {

	}

}
