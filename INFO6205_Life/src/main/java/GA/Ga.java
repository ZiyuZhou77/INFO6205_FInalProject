package GA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import edu.neu.coe.info6205.life.base.Game;

public class Ga {
	private static final double mutationRate = 0.0001;
	public static final int maxgeneration=10000;

	ArrayList<Integer> countgen=new ArrayList<>();

	/**
	 * second version mutate
	 * @param mutate
	 * @return
	 */

	public HashMap<String,String> mutate(HashMap<String,String> mutate) {
		  HashMap<String,String> mutated  = new HashMap<>();
//		  long seed = System.currentTimeMillis();
		  Random random = new Random(Main.seed);
		  for(String key:mutate.keySet()){
		      StringBuilder ha = new StringBuilder(key);
		      int length = key.length();
		      for(int j=0; j<length;j++){
		    	  double i = random.nextDouble();
		          if(i>mutationRate) {
		       if(key.charAt(j)=='0')
		          ha.replace(j, j+1, "1");
		       else {
		        ha.replace(j, j+1, "0");
		            }
		          }
		       }
		       String newkey = ha.toString();
		       Population p = new Population();
		       mutated.putAll(p.convertPattern(newkey));
		  }
		  
		  return mutated;
		 }
	
	/**
	 * to check the generation, if > max, return true
	 * @param x
	 * @return
	 */

	public boolean check(Integer x) {
		boolean getx=false;
		if(x<maxgeneration) {
			getx=true;
			return getx;
		}else{
			return getx;
		}
	}
	
	/**
	 * fitness function
	 * @param putpattern
	 * @return
	 */

	public HashMap<String, Integer> GetfitnessScore(HashMap<String, Integer> putpattern) {
		HashMap<String,Integer> putpattern2  = new HashMap<>();
		for(String key:putpattern.keySet()){
			  int i = putpattern.get(key).intValue();
			  double d = (1000/(double)(10000-i))*(double)100000;
		      int fitnessScore = (int)d;
		       putpattern2.put(key,fitnessScore);
		  }
		return putpattern2;
	}
	/**
	 * to decide terminate the evolution or not, if generation>max, while loop keep doing evolve
	 * @param patterncheck
	 * @return
	 */
	public int decideTermination(HashMap<String,Integer> patterncheck) {
		Population p=new Population();
		ArrayList<String> finalPoints=new ArrayList<>();
		boolean check=false;
		int checkint=0;
		ArrayList<String> getFinalPattern=new ArrayList<>();
		for(String patternkey:patterncheck.keySet()) {
			int x =patterncheck.get(patternkey);
			if(check(x)==true) {
				checkint+=0;
			}else {
				checkint+=1;
				getFinalPattern.add(patternkey);				
				//break;
			}
		}
		System.out.println("final:"+getFinalPattern);
		for(int i=0;i<getFinalPattern.size();i++) {
			String a=p.convertPattern(getFinalPattern.get(i)).get(getFinalPattern.get(i));
			finalPoints.add(a);
		}
		System.out.println(finalPoints);
		return checkint;
	}
	/**
	 * get top pattern list's points pattern, and put it into list
	 * @param a
	 * @return
	 */
	public ArrayList<String> getTopPattern(List<String> a){
		ArrayList<String> gettop=new ArrayList<>();
		for(String bitsPattern:a) {
			gettop.add(bitsPattern);
	}
		return gettop;
	}
	
	/**
	 * select the better half generation's pattern and do mutate:<bits,points>
	 * @param putpattern2,trypattern
	 * @return
	 */
		public HashMap<String,String> Selection(HashMap<String, Integer> putpattern2, HashMap<String,String> trypattern) {
			HashMap<String,String> toppattern=new HashMap<String,String>();
			List<String> top=new ArrayList<String>();
			List<Map.Entry<String,Integer>> topsList =new ArrayList<Map.Entry<String,Integer>>(putpattern2.entrySet());
			Collections.sort(topsList, new Comparator<Map.Entry<String,Integer>>(){
				public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
					return (int)(o1.getValue()-o2.getValue());
				}
			});
			
			for(int i=topsList.size()-1; i>=topsList.size()-5; i--) {
				top.add(topsList.get(i).getKey());
				countgen.add(topsList.get(i).getValue());
			}
			for(String a:trypattern.keySet()) {
				String toadd=a;
				for(int i=0;i<top.size(); i++) {
					if(top.get(i).equals(toadd)) {
						toppattern.put(a, trypattern.get(a));
					}
				}
			}
			return toppattern;
			}
}
