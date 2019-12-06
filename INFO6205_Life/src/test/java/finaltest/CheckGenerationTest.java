package finaltest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import GA.Ga;
import GA.Population;
import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Game.Behavior;

public class CheckGenerationTest {

	/**
	 * if return true, generation <10000
	 */
	@Test
	public void testCheck() {
		Population p=new Population();
		Ga ga=new Ga();
		String pattern="11111000101001011100000101111001100111100011101110010101000100000011001001110100";
		HashMap<String,String> runPattern=p.convertPattern(pattern);
		String tryp=runPattern.get(pattern);
		System.out.println("*test generation pattern: " + tryp);
		final Game.Behavior generations = Game.run(0L, tryp);
		System.out.println("*get generation:"+generations.generation);
		assertEquals(ga.check((int)generations.generation), true);
		
		String pattern2="0011111100000000100001101001101001110000";
		HashMap<String,String> runPattern2=p.convertPattern(pattern2);
		String tryp2=runPattern2.get(pattern2);
		System.out.println("*test generation pattern2: " + tryp2);
		final Game.Behavior generations2 = Game.run(0L, tryp2);
		System.out.println("*get generation2:"+generations2.generation);
		assertEquals(ga.check((int)generations2.generation), true);
		//0011111100000000100001101001101001110000110100000001001011001001
		
		String pattern3="0101011111000000111000110101000000011111011100100001000100000100";
		HashMap<String,String> runPattern3=p.convertPattern(pattern3);
		String tryp3=runPattern3.get(pattern3);
		System.out.println("*test generation pattern2: " + tryp3);
		final Game.Behavior generations3 = Game.run(0L, tryp3);
		System.out.println("*get generation3:"+generations3.generation);
		assertEquals(ga.check((int)generations3.generation), false);
		//0101011111000000111000110101000000011111011100100001000100000100
		
		
		}
}
