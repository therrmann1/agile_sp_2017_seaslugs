package org.cvtc.soundBoard;


// Just a class to test the audio player.
public class SoundTest {
	
	public static void randomSound(int sound) {
		String[] soundFiles = {"hi-1.wav", "hi-2.wav", "hi-3.wav", "hi-4.wav", "hi-5.wav", "churchOrgan.wav",
							   "werewolf.wav", "zombies.wav", "Vampire_Monk.wav", "laugh.wav", "Alpaca_Mating_Call.wav",
							   "Blastwave_FX_BoxingBellRing_S08SP.136.wav", "Blastwave_FX_ExplosionCrash_S08WA.132.wav",
							   "Blastwave_FX_ExplosionMetalDebris_HV.243.wav", "Cat_Meowing.wav", "Crickets.wav",
							   "hawk_screeching.wav", "puppy-barking.wav", "sport_air_horn_reverb.wav", "transportation_boat_horn_dry_004.wav"};
		
		AudioPlayer audioPlayer = new AudioPlayer();
		
		audioPlayer.playSound(soundFiles[sound]);
	}

}
