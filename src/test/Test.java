/*
 * Created on May 9, 2018
 *
 */
package test;

import java.util.Scanner;

import javax.swing.JTextArea;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	private Singer choir;

	public void initializeSingingInThreads(JTextArea textArea) {
		String lyrics1 = "Patty: Because the night";
		String lyrics2 = "Bruce: Belongs to lovers";

		String lyricsChoir = "Choir: Because the night belongs to lust";

		boolean stopIt = false;
		Synchronizer synch = new Synchronizer(true, false, false, textArea);

		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		Performance choirVoicePerformance = new Performance(lyricsChoir, 3200);

		pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
		choir = new Singer("Choir", Voice.CHOIR, choirVoicePerformance, stopIt, synch);
	}

	public void startThreads() {
		pattiSmith.start();
		bruceSpringsteen.start();
		choir.start();
	}
	
	public void stopThreads() {
		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
		choir.setStopIt(true);
	}
}
