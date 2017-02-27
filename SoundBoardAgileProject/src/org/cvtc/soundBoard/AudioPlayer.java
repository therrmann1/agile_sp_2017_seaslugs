package org.cvtc.soundBoard;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class AudioPlayer extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public void playSound(String soundFilePath) {
        
		try {
			
		URL url = this.getClass().getClassLoader().getResource(soundFilePath);
    	
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
		
		Clip clip = AudioSystem.getClip();
		
        // Open audio clip and load samples from the audio input stream.

        clip.open(audioInputStream);

        if(clip.isRunning()){
        	// does nothing already playing
        }else{
        	clip.start();
        }
        
        
        
		 } catch (UnsupportedAudioFileException e) {
				
	         e.printStackTrace();
	
	      } catch (IOException e) {
	
	         e.printStackTrace();
	
	      } catch (LineUnavailableException e) {
	
	         e.printStackTrace();
	
	      }
		
	}
	public void stopSound(String soundFilePath){
		try{
			URL url = this.getClass().getClassLoader().getResource(soundFilePath);
			 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
				
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.stop();
		} catch (UnsupportedAudioFileException e) {
			
	         e.printStackTrace();
	
	      } catch (IOException e) {
	
	         e.printStackTrace();
	
	      } catch (LineUnavailableException e) {
	
	         e.printStackTrace();
	
	      }
	}
	
}
