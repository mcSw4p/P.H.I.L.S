package net.wynsolutions.alerts;

import net.wynsolutions.speech.TTS;

public class NoConnectionAlert implements Runnable{

	private String message = "AHH, I have no internet connection.";
	private boolean running = true;
	
	@Override public void run() {
		System.out.println("Starting new no connection thread.");
		while(running){
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(running)
				TTS.speak(message);
		}	
	}
	
	public void stop(){
		System.out.println("No connection alarm disactivated.");
		running = false;	
	}
	
	public void start(){
		System.out.println("No connection alarm activated.");
		running = true;	
	}
	
	public boolean isRunning(){
		return running;
	}
	
}
