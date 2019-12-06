package edu.neu.coe.info6205.life.base;

import edu.neu.coe.info6205.life.library.Library;
//import edu.neu.coe.info6205.life.library.OurLibrary;

import org.junit.Test;

import GA.Ga;
import GA.Population;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameTest {

		
		@Test
		public void testRunBlip() {
				String patternName = "Blip";
				System.out.println("Game of Life with starting pattern: " + patternName);
				final String pattern = Library.get(patternName);
				final Game.Behavior generations = Game.run(0L, pattern);
				assertEquals(0, generations.generation);
		}

		@Test
		public void testRunBlinker() {
				String patternName = "Blinker";
				System.out.println("Game of Life with starting pattern: " + patternName);
				final String pattern = Library.get(patternName);
				final Game.Behavior generations = Game.run(0L, pattern);
				assertEquals(new Game.Behavior(2, 0, 1), generations);
		}

		@Test
		public void generation() {
		// TODO implement test
		}
		
}