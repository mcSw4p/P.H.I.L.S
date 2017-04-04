package net.wynsolutions.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {
	
	private String hueHubIP, hueUserID;
	private int hueHubPort;

	public Config() {
		this.load();
	}
	
	private void load(){
		 Properties props = new Properties();
		    InputStream is = null;
		 
		    // First try loading from the current directory
		    try {
		        File f = new File("server.xml");
		        is = new FileInputStream( f );
		    }
		    catch ( Exception e ) { is = null; }
		 
		    try {
		        if ( is == null ) {
		            // Try loading from classpath
		            is = getClass().getResourceAsStream("server.xml");
		        }
		 
		        // Try loading properties from the file (if found)
		        props.loadFromXML( is );
		    }
		    catch ( Exception e ) { 
		    	e.printStackTrace();
		    }
		 
		    hueHubIP = props.getProperty("ServerAddress", "192.168.0.1");
		    hueHubPort = new Integer(props.getProperty("ServerPort", "8080"));
		    hueUserID  = props.getProperty("UserID", "xxxxxx");
	}
	
	public void saveParamChangesAsXML() {
	    try {
	        Properties props = new Properties();
	        props.setProperty("ServerAddress", hueHubIP);
	        props.setProperty("ServerPort", ""+hueHubPort);
	        props.setProperty("UserID", hueUserID);
	        File f = new File("server.xml");
	        OutputStream out = new FileOutputStream( f );
	        props.storeToXML(out, "Configuration file for PHILS");
	    }
	    catch (Exception e ) {
	        e.printStackTrace();
	    }
	}
	
}
