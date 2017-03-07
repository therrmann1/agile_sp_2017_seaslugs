package org.cvtc.soundboard.test;



import org.cvtc.soundBoard.AudioPlayer;
import org.junit.Test;

public class AudioPlayerUnitTests {

	@Test
	public void testPlaySound() {
		AudioPlayer testAudio = new AudioPlayer();
		testAudio.playSound("silent.wav");
	}

	@Test
	public void testStopSound() {
		AudioPlayer testAudio = new AudioPlayer();
		testAudio.playSound("silent.wav");
		testAudio.stopSound();
	}

}
