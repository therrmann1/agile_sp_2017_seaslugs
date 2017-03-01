/**
 * 
 */
package org.cvtc.soundboard.test;

import org.cvtc.soundBoard.AudioPlayer;
import org.junit.Test;

/**
 * @author Nicholas
 *
 */
public class AudioPlayerUnitTests {

	/**
	 * Test method for {@link org.cvtc.soundBoard.AudioPlayer#playSound(java.lang.String)}.
	 */
	@Test
	public void testPlaySound() {
		AudioPlayer testAudio = new AudioPlayer();
		String music = "silent.wav";
		testAudio.playSound(music);
	}

	/**
	 * Test method for {@link org.cvtc.soundBoard.AudioPlayer#stopSound(java.lang.String)}.
	 */
	@Test
	public void testStopSound() {
		AudioPlayer testAudio = new AudioPlayer();
		String music = "silent.wav";
		testAudio.stopSound(music);
	}

}
