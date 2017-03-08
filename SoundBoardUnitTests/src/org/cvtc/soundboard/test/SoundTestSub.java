package org.cvtc.soundboard.test;

import org.cvtc.soundBoard.AudioPlayer;

public class SoundTestSub {
static AudioPlayer audioPlayer = new AudioPlayer();
	
	public static void randomSound(int sound) {
		
		String[] soundFiles = {"silent.wav"};

		audioPlayer.playSound(soundFiles[sound]);
	}
	
	public static void stopSound() {
		
		audioPlayer.stopSound();
	}
}
