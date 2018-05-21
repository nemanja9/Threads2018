package gui;

import java.awt.EventQueue;

import javax.swing.JTextArea;

import test.Test;

public class GUIKontorler {

	private Test t=new Test();
	
	public Test getT() {
		return t;
	}

	public void setT(Test t) {
		this.t = t;
	}

	public static void main(String[] args) {
		GUIKontorler guiK=new GUIKontorler();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor(guiK);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void inicijalizujThreds(JTextArea textArea) {
		t.initializeSingingInThreads(textArea);
	}
	public void stopThreads() {
		t.stopThreads();
	}
	public void startThreads() {
		t.startThreads();
	}
	
}
