package org.cvtc.soundBoard;


// Just a class to test the audio player.
public class Sound {
	static String[] soundFiles = {"hi-1.wav", "hi-2.wav", "hi-3.wav", "hi-4.wav", "hi-5.wav", "churchOrgan.wav",
							   "werewolf.wav", "zombies.wav", "Shock.wav", "laugh.wav"};
	public static void randomSound(int sound) {
		
		
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.playSound(soundFiles[sound]);
	}
	public static int soundFilesCount(){
		
		return soundFiles.length;
	}

}
