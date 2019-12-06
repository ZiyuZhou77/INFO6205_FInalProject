package GA;

import java.util.HashMap;

import edu.neu.coe.info6205.life.base.Game;
//import edu.neu.coe.info6205.life.library.OurLibrary;
   
public class Main {
	static HashMap<String,Integer> putpattern;
	static HashMap<String,String> trypattern;
	static HashMap<String,Integer> putpattern2;
	static HashMap<String,String> trypattern2;
	static HashMap<String,String> testp;
	
	private static final int PopulationSize = 20;
	
	public static void main(String args[]) {
		Ga ga=new Ga();
		Population population=new Population();
		
		putpattern=new HashMap<>();
		trypattern=new HashMap<>();
		HashMap<String,String>getpattern=population.getPattern(PopulationSize);
		 /**
	     * runpattern: points, getpatternkey: bit
	     * */
		for(String getpatternkey:getpattern.keySet()) {
		    String runpattern=getpattern.get(getpatternkey);
		   
			final Game.Behavior generations = Game.run(0L, runpattern);
			System.out.println("\n///run next///"+generations.generation+" generation.");

		    putpattern.put(getpatternkey, (int)generations.generation);
		    trypattern.put(getpatternkey, runpattern);
		    
		}
		
		/**
		 * check generation, if generation has >max, terminate, else do while loop until finding generation>10000
		 */
		testp=new HashMap<>();
		testp=ga.Selection(ga.GetfitnessScore(putpattern), trypattern);
		int checkint=ga.decideTermination(putpattern);
	if(checkint==0) {
		int i=0;
		while(checkint==0) {
			++i;
			HashMap<String,String> getmutate=new HashMap<>();
			getmutate=ga.mutate(testp);
			HashMap<String, String> newPatternList=population.getPattern(PopulationSize/2);
			for(String getKey:getmutate.keySet()) {
				String getValue=getmutate.get(getKey);
				newPatternList.put(getKey, getValue);
			}
			putpattern2=new HashMap<>();
			trypattern2=new HashMap<>();
		
			for(String getpatternkey2:newPatternList.keySet()) {
				String runpattern2=newPatternList.get(getpatternkey2);
				final Game.Behavior generations = Game.run(0L, runpattern2);
				System.out.println("\n///run next 222222///"+generations.generation+" generation.");
			    putpattern2.put(getpatternkey2, (int)generations.generation);
			    trypattern2.put(getpatternkey2, runpattern2);
			    
			}
			checkint=ga.decideTermination(putpattern2);
			testp=ga.Selection(ga.GetfitnessScore(putpattern2), trypattern2);
		}
		
		System.out.println("i:"+i);
		}
	
	}
}
