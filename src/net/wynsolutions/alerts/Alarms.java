package net.wynsolutions.alerts;

import net.wynsolutions.speech.TTS;

public class Alarms {
	
	//Intruder
	private static Thread intruThread = null;
	private static IntruderAlert intruRunnable = null;
	
	//No Connection
	private static Thread noConThread = null;
	private static NoConnectionAlert noConRunnable = null;
	
	//Intruder Methods
	public static void startIntruderAlarm(){
		if(intruThread != null && intruRunnable.isRunning()){
			TTS.speak("Intruder Alarm already running.");
			return;
		}
		intruRunnable = new IntruderAlert();
		intruThread = new Thread(intruRunnable);
		intruThread.start();
	}
	
	public static void stopIntruderAlarm(){
		intruRunnable.stop();
		try {
			intruThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//
	
	//No Connection Methods
	
	public static void startNoConnectionAlarm(){
		if(noConThread != null && noConRunnable.isRunning()){
			TTS.speak("No Connection Alarm already running.");
			return;
		}
		noConRunnable = new NoConnectionAlert();
		noConThread = new Thread(noConRunnable);
		noConThread.start();
	}
	
	public static void stopNoConnectionAlarm(){
		noConRunnable.stop();
		try {
			noConThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
