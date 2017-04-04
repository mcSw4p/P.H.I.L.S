package net.wynsolutions.app;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import net.wynsolutions.alerts.Alarms;
import net.wynsolutions.inputs.InputHandler;
import net.wynsolutions.speech.TTS;

public class InputApp extends KeyAdapter{

	private JFrame frame;
	private JTextArea textField;
	private JLabel jlb, jlb2, jlb3, jlb4;
	
	public InputApp() {
		this.frame = new JFrame("P.H.I.L.S");
		new Alarms();
	}
	
	public void createandShowGUI(){
		
		this.frame.getContentPane().setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.Y_AXIS));
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TTS.speak("Setting up application. I will soon be fully operational.");
		this.frame.setLocation(new java.awt.Point(100, 100));

		textField = new JTextArea();
		textField.addKeyListener(this);
		textField.setToolTipText("Enter text for phils to act on.");
		textField.setPreferredSize(new Dimension(this.frame.getWidth(), 1));
		
		JScrollPane scrollPane = new JScrollPane(textField);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jlb = new JLabel("Philips Hue Intelligent Lighting System", SwingConstants.CENTER);
		jlb2 = new JLabel("Setup complete.");
		jlb3 = new JLabel("IP:");
		jlb4 = new JLabel("UserID:");
		
		jlb.setPreferredSize(new Dimension(this.frame.getWidth(), 30));
		jlb2.setPreferredSize(new Dimension(this.frame.getWidth(), 40));
		jlb3.setPreferredSize(new Dimension(this.frame.getWidth(), 15));
		jlb4.setPreferredSize(new Dimension(this.frame.getWidth(), 15));
		
		//Add Items to frame
		
		this.frame.getContentPane().add(jlb);
		this.frame.getContentPane().add(jlb2);
		this.frame.getContentPane().add(scrollPane);
		this.frame.getContentPane().add(jlb3);
		this.frame.getContentPane().add(jlb4);

		this.frame.setPreferredSize(new Dimension(500, 500));
		this.frame.setResizable(false);
		this.frame.pack();
		
		new Thread(new Runnable(){
			@Override public void run() {
				try {
					System.out.println("Starting delay thread.");
					Thread.sleep(5000);
					frame.setVisible(true);
					Thread.sleep(3000);
					jlb2.setText("How may I help you today?");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}).start();
	}
	
	public void setIPText(String ip){
		jlb3.setText("IP: " + ip);
	}
	
	public void setUserIDText(String id){
		jlb4.setText("UserID: " + id);
	}
	
	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent event){
		if(event.getKeyCode() == event.VK_ENTER){
	    	InputHandler inh = new InputHandler(textField.getText());
	    	textField.setText("");
	    	jlb2.setText("<html><p>" + inh.getAnswer() + "</p></html>");
		}
	}

}
