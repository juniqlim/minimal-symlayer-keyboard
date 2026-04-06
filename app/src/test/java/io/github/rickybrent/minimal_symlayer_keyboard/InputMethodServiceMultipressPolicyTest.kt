package io.github.rickybrent.minimal_symlayer_keyboard

import android.view.KeyEvent
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class InputMethodServiceMultipressPolicyTest {
	@Test
	fun allowsSpaceMultipressWhileKoreanInputIsActive() {
		assertTrue(
			shouldApplyMultipress(
				koreanInputActive = true,
				isPrintingKey = false,
				keyCode = KeyEvent.KEYCODE_SPACE
			)
		)
	}

	@Test
	fun blocksNonSpaceMultipressWhileKoreanInputIsActive() {
		assertFalse(
			shouldApplyMultipress(
				koreanInputActive = true,
				isPrintingKey = true,
				keyCode = KeyEvent.KEYCODE_A
			)
		)
	}

	@Test
	fun keepsExistingMultipressBehaviorOutsideKoreanInput() {
		assertTrue(
			shouldApplyMultipress(
				koreanInputActive = false,
				isPrintingKey = true,
				keyCode = KeyEvent.KEYCODE_A
			)
		)
	}
}
