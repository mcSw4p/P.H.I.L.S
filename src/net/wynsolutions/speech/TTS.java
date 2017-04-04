package net.wynsolutions.speech;

import java.util.ArrayList;
import java.util.List;

import net.wynsolutions.Container;

public class TTS {
	
	private static List<String> messages = new ArrayList<String>();
	
	public TTS() {
		new Thread(() -> {
			System.out.println("Starting new speech thread.");
			for(;;){
				System.out.flush();
				if(!(messages.size() == 0)){
					System.out.println("Speaking message: \'" + messages.get(0) + "\'");
					Container.getTTSAdapter().speak(messages.get(0));
					messages.remove(0);
				}
			}
		}).start();
	}

	public static void speak(String txt){
		messages.add(txt);
	}
	
}
