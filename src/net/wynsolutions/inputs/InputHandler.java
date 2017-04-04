package net.wynsolutions.inputs;

import java.util.Date;

import net.wynsolutions.alerts.Alarms;
import net.wynsolutions.speech.TTS;

public class InputHandler {

	private String inputString, answer;
	
	public InputHandler(String par1) {
		this.inputString = par1.toLowerCase();
		handle();
	}
	
	private void handle(){
		if(contains("What", "is", "phils") || contains("what", "is", "p.h.i.l.s") || contains("what", "are", "you")){
			answer = "I am a java application, I help control your lighting. Just think of me as that guy in the basement. Hahaha.";
			TTS.speak(answer);
		}else if(contains("what", "is", "date")){
			Date date = new Date();
			if(contains("sql")){
				java.sql.Date dates = new java.sql.Date(date.getTime());
				answer = "The date today is " + dates;
				TTS.speak(answer);
			}else{
				answer = "The date today is " + date;
				TTS.speak(answer);
			}
		}else if(contains("activate", "alarm")){
			if(contains("intruder")){
				answer = "Activating intruder Alarm!";
				System.out.println("Starting Intruder Alarm Thread.");
				Alarms.startIntruderAlarm();
			}else if(contains("noconnection") || contains("nocon")){
				answer = "Activating no connection Alarm!";
				System.out.println("Starting No Connection Alarm Thread.");
				Alarms.startNoConnectionAlarm();
			}else{
				answer = "I am sorry, which alarm would you like to activate?";
			}
			TTS.speak(answer);
		}else if(contains("disarm", "alarm")){
			if(contains("intruder")){
				answer = "Disactivating intruder Alarm!";
				System.out.println("Stopping Intruder Alarm Thread.");
				Alarms.stopIntruderAlarm();
			}else if(contains("noconnection") || contains("nocon")){
				answer = "Disactivating no connection Alarm!";
				System.out.println("Stopping No Connection Alarm Thread.");
				Alarms.stopNoConnectionAlarm();
			}else{
				answer = "I am sorry, which alarm would you like to disarm?";
			}
			TTS.speak(answer);
		}else if(contains("how", "are", "you")){
			answer = "Running smoothly. No hiccups. Thanks for asking.";
			TTS.speak(answer);
		}else if(contains("Thank you", "Thanks")){
			answer = "I am happy to serve you.";
			TTS.speak(answer);
		}else if(contains("hello")){
			answer = "Hello, How are you today?";
			TTS.speak(answer);
		}else{
			answer = "I am sorry. I did not get that.";
			TTS.speak(answer);
		}
	}
	
	private boolean contains(String...  arg){
		
		int l = arg.length, n = 0;
		
		for(String s : arg){
			if(inputString.contains(s.toLowerCase())){
				n++;
			}
		}
		if(n==l)
			return true;
		return false;
	}
	
	public String getAnswer(){
		return answer;
	}
	
}
