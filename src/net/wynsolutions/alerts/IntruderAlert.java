package net.wynsolutions.alerts;

import net.wynsolutions.speech.TTS;

public class IntruderAlert implements Runnable{

	private String message = "Intruder Alert!";
	private boolean running = true;
	
	@Override public void run() {
		System.out.println("Starting new alert thread.");
		while(running){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(running)
				TTS.speak(message);
		}	
	}
	
	public void stop(){
		System.out.println("Intruder alarm disactivated.");
		running = false;	
	}
	
	public void start(){
		System.out.println("Intruder alarm activated.");
		running = true;	
	}
	
	public boolean isRunning(){
		return running;
	}

}
