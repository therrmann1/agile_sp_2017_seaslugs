/**
 * 
 */
package org.cvtc.soundboard.test;


import org.junit.Test;

/**
 * @author Nicholas
 *
 */
public class SoundTestUnitTests {

	/**
	 * Test method for {@link org.cvtc.soundBoard.SoundTest#randomSound(int)}.
	 */
	@Test
	public void testRandomSound() {
		SoundTestSub.randomSound(0);
	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRandomsoundexceptions() {
		SoundTestSub.randomSound(999);
	}

	/**
	 * Test method for {@link org.cvtc.soundBoard.SoundTest#stopSound()}.
	 */
	@Test
	public void testStopSound() {
		SoundTestSub.randomSound(0);
		SoundTestSub.stopSound();
	}

}
