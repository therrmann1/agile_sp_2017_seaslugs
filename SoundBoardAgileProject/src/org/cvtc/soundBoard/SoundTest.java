package org.cvtc.soundBoard;


// Just a class to test the audio player.
public class SoundTest {
	
	public static void randomSound(int sound) {
		String[] soundFiles = {"hi-1.wav", "hi-2.wav", "hi-3.wav", "hi-4.wav", "hi-5.wav", "churchOrgan.wav",
							   "werewolf.wav", "zombies.wav", "Vampire_Monk.wav", "laugh.wav"};
		
		AudioPlayer audioPlayer = new AudioPlayer();
		
		audioPlayer.playSound(soundFiles[sound]);
	}

}
