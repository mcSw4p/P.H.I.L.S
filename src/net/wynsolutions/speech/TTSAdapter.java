package net.wynsolutions.speech;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTSAdapter {

	private static final String VOICENAME_kevin = "kevin16";
	private Voice voice;
	
	public TTSAdapter() {
		  VoiceManager voiceManager = VoiceManager.getInstance();
		  voice = voiceManager.getVoice(VOICENAME_kevin);
		  voice.allocate();	
		  new TTS();
	}
	
	public Voice getVoice(){
		return voice;
	}
	
	public void speak(String text){
		voice.speak(text);
	}
	
}
