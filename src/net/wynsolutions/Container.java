package net.wynsolutions;

import net.wynsolutions.app.InputApp;
import net.wynsolutions.speech.TTS;
import net.wynsolutions.speech.TTSAdapter;

public class Container {

	private static TTSAdapter ttsadapter;
	
	public void onStart(){
		
		ttsadapter = new TTSAdapter();
		
		InputApp iApp = new InputApp();
		iApp.createandShowGUI();
		
		TTS.speak("Setup complete. I am now fully operational.");
		TTS.speak("How may I help you today?");
	}
	
	public void onStop(){
		
	}
	
	public static TTSAdapter getTTSAdapter(){
		return ttsadapter;
	}
	
}
