/*
 * Created on May 10, 2018
 *
 */
package music;

import javax.swing.JTextArea;

public class Synchronizer {
    
    private boolean firstVoiceFlag;
    private boolean secondVoiceFlag;
    private boolean choirFlag;
    private JTextArea textArea;

    public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean choirFlag, JTextArea textArea) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag=secondVoiceFlag;
        this.choirFlag=choirFlag;
        this.textArea=textArea;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (!firstVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singSecondVoice(String lyrics, int delay) {
        while (!secondVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singChoir(String lyrics, int delay) {
        while (!choirFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    private String sing(String lyrics, int delay) {
        textArea.append(lyrics+"\n");
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(firstVoiceFlag) {
        	firstVoiceFlag=!firstVoiceFlag;
        	secondVoiceFlag=!secondVoiceFlag;
//        	choirFlag=false;
        	notifyAll();
        	return lyrics;
        }
        if(secondVoiceFlag) {
        	secondVoiceFlag=!secondVoiceFlag;
        	choirFlag=!choirFlag;
//        	firstVoiceFlag=false;
        	notifyAll();
        	return lyrics;
        }
        if(choirFlag) {
        	choirFlag=!choirFlag;
        	firstVoiceFlag=!firstVoiceFlag;
//        	secondVoiceFlag=false;
        	notifyAll();
        	return lyrics;
        }
        return null;
    }

}

