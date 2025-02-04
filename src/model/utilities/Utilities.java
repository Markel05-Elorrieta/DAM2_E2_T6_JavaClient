package model.utilities;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import global.Constants;
import model.Reuniones;

public class Utilities {
	public byte[] encrypt(String text) {
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			DESKeySpec kspec = new DESKeySpec(Constants.CIPHERKEY.getBytes());
			SecretKey ks = skf.generateSecret(kspec);
			
			Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, ks);
			byte[] encVal = c.doFinal(text.getBytes());
			byte[] iv = c.getIV();
			return encVal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ArrayList<Reuniones>> fillArray(ArrayList<Reuniones> reunionesList){
        ArrayList<ArrayList<Reuniones>> reunioak = new ArrayList<ArrayList<Reuniones>>();
        
        // Initialize the structure
        for (int i = 0; i < 5; i++) {
            ArrayList<Reuniones> dayList = new ArrayList<Reuniones>();
            for (int j = 0; j < 5; j++) {
                dayList.add(null); // Add null placeholders
            }
            reunioak.add(dayList);
        }
        
        int x = 0;
        int y = 0;
        	
        	for(int i = 0; i < reunionesList.size(); i++) {
        		if (isInCurrentWeek(reunionesList.get(i).getFecha())) {
        			switch (reunionesList.get(i).getFecha().getDay()) {
        		    case 1:
        		        x = 0;
        		        break;
        		    case 2:
        		        x = 1;
        		        break;
        		    case 3:
        		        x = 2;
        		        break;
        		    case 4:
        		        x = 3;
        		        break;
        		    case 5:
        		        x = 4;
        		        break;
        		}
        		switch (reunionesList.get(i).getFecha().getHours()) {
        			
        		    case 9:
        		        y = 0;
        		        break;
        		    case 10:
        		        y = 1;
        		        break;
        		    case 11:
        		        y = 2;
        		        break;
        		    case 12:
        		        y = 3;
        		        break;
        		    case 13:
        		        y = 4;
        		        break;
        		}
        		
        	    reunioak.get(x).add(y, reunionesList.get(i));
        	 }
        			
       }
        System.out.println(reunioak);
        return reunioak;
	}

	
	private boolean isInCurrentWeek(Timestamp timestamp) {
	    Calendar timestampCalendar = Calendar.getInstance();
	    timestampCalendar.setTime(timestamp);

	    Calendar now = Calendar.getInstance();

	    int currentWeek = now.get(Calendar.WEEK_OF_YEAR);
	    int currentYear = now.get(Calendar.YEAR);

	    int timestampWeek = timestampCalendar.get(Calendar.WEEK_OF_YEAR);
	    int timestampYear = timestampCalendar.get(Calendar.YEAR);

	    return (timestampWeek == currentWeek) && (timestampYear == currentYear);
	}
}
