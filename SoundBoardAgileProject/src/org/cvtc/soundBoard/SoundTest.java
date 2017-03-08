package org.cvtc.soundBoard;


// Just a class to test the audio player.
public class SoundTest {
	
	static AudioPlayer audioPlayer = new AudioPlayer();
	
	public static void randomSound(int sound) {
		
		String[] soundFiles = {"hi-1.wav", "hi-2.wav", "hi-3.wav", "hi-4.wav", "hi-5.wav", "Spoopy1.wav",
							   "Spoopy2.wav", "Spoopy3.wav", "Spoopy4.wav", "Spoopy5.wav", 
							   "Animal1.wav", "Animal2.wav", "Animal3.wav", "Animal4.wav", "Animal5.wav",
							   "Fart1.wav", "Fart2.wav", "Fart3.wav", "Fart4.wav", "Fart5.wav",
							   "Blastwave_1.wav", "Blastwave_2.wav", "Blastwave_3.wav", "Blastwave_4.wav", "Blastwave_5.wav", "Rick_Roll.wav",
							   "Horn_1.wav", "Horn_2.wav", "Horn_3.wav", "Horn_4.wav", "Horn_5.wav"};

		audioPlayer.playSound(soundFiles[sound]);
	}
	
	public static void stopSound() {
		
		audioPlayer.stopSound();
	}

}
