package finaltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GA.Ga;
import GA.Population;
import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Game.Behavior;

public class PopulationTest {
	ArrayList<String> trytest;
	 	@Before
	    public void setUp() throws Exception {
	        trytest=generate();
	    }

	    @After
	    public void testAfter() throws Exception {
	    }
	    
	    @Test
	    public void getPatternTest() {
	    	System.out.println("do individual test");
	    	assertEquals("-4 0,-4 4,-5 5,0 -4,4 -4,4 0,-3 -3,-2 -2,2 0,0 -1", trytest.get(2));
	    	assertEquals("0 -4,1 1,0 -1,2 2,-2 -2", trytest.get(0));
	    	assertEquals("-4 4,2 0,0 -2,-2 0,3 3,0 -1,-2 2,0 4,-1 1,-1 0", trytest.get(1));
	    }
	    
	    /**
	     * if check value>maxgeneration, return true, else return false
	     */
	    @Test
	    public void getGeneration() {
	    	Ga ga=new Ga();
			String tryp=trytest.get(0);
			System.out.println("*test generation pattern: " + trytest.get(3));
			final Game.Behavior generations = Game.run(0L, tryp);
			System.out.println("*get generation:"+generations.generation);
			assertEquals(ga.check(generations.generation), true);
			
			String tryp2=trytest.get(1);
			System.out.println("*test generation pattern2: " + trytest.get(4));
			final Game.Behavior generations2 = Game.run(0L, tryp2);
			System.out.println("*get generation2:"+generations2.generation);
			assertEquals(ga.check(generations2.generation), true);

	    }
	    
	    @Test
	    public void convertPatternTest() {
	    	System.out.println("do convert test");
	    	Population p = new Population();
	    	String s1="1100111110001000110010001000011010101010";
			String s2="00111101010010101100011011100110100110101100001000101100000011110010010011100100";
			String s3="11111101001111010011111111001111011011110101101110111100101010010101100011000001";
			
	    	assertEquals(true, p.convertPattern(s3).containsValue("-4 0,-4 4,-5 5,0 -4,4 -4,4 0,-3 -3,-2 -2,2 0,0 -1"));
	    	assertEquals(true, p.convertPattern(s1).containsValue("0 -4,1 1,0 -1,2 2,-2 -2"));
	    	assertEquals(true, p.convertPattern(s2).containsValue("-4 4,2 0,0 -2,-2 0,3 3,0 -1,-2 2,0 4,-1 1,-1 0"));
	    	
	    }
	    
	    
	public ArrayList<String> generate(){
		String s1="1100111110001000110010001000011010101010";
		String s2="00111101010010101100011011100110100110101100001000101100000011110010010011100100";
		String s3="11111101001111010011111111001111011011110101101110111100101010010101100011000001";
		//Population p=new Population();
		ArrayList<String> toPattern=new ArrayList<>();
		toPattern.addAll(new Population().convertPattern(s1).values());//try.get(0)
		toPattern.addAll(new Population().convertPattern(s2).values());//try.get(1)
		toPattern.addAll(new Population().convertPattern(s3).values());//try.get(2)
		toPattern.add(s1);//try.get(3)
		toPattern.add(s2);//try.get(4)
		toPattern.add(s3);//try.get(5)
		return toPattern;
	}
}
