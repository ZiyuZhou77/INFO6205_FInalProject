//package edu.neu.coe.info6205.life.library;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import edu.neu.coe.info6205.life.base.Game;
//import io.jenetics.BitChromosome;
//import io.jenetics.BitGene;
//import io.jenetics.Genotype;
//import io.jenetics.Optimize;
//import io.jenetics.engine.Engine;
//import io.jenetics.engine.EvolutionResult;
//import io.jenetics.util.Factory;
//
//public class OurLibrary {
//	//ArrayList<String> toppattern=new ArrayList<>();
//	
//	ArrayList<Long> countgen=new ArrayList<>();
//	static HashMap<String,Long> putpattern;
//	static HashMap<String,String> trypattern;
//	static HashMap<String,Long> putpattern2;
//	static HashMap<String,String> trypattern2;
//	static HashMap<String,String> testp;
//	
//	public static void main(String args[]) {
//		OurLibrary run = new OurLibrary();
//		//runGame(run.getPattern(10));
//		putpattern=new HashMap<>();
//		trypattern=new HashMap<>();
//		HashMap<String,String>getpattern=run.getPattern(10);
//		 /**
//	     * runpattern: points, getpatternkey: bit
//	     * */
//		for(String getpatternkey:getpattern.keySet()) {
//		    String runpattern=getpattern.get(getpatternkey);
//		   
//			final Game.Behavior generations = Game.run(0L, runpattern);
//			System.out.println("\n///run next///"+generations.generation+" generation.");
//			//hashmap: bits, generations
//			//String trygen=generations.generation+"/"+runpattern;
//		    putpattern.put(getpatternkey, generations.generation);
//		    trypattern.put(getpatternkey, runpattern);
//		    
//		}
//		 //get top 5 hashmap list
//	    //run.getTop5(putpattern, trypattern);
//		/**
//		 * check generation
//		 */
//		testp=new HashMap<>();
//		testp=run.getTop5(putpattern, trypattern);
//		int checkint=checkgeneration(putpattern);
//	if(checkint==0) {
//		//System.out.println("testp:"+testp);
//		int i=0;
//		//int c=0;
//		while(checkint==0) {
//			++i;
//			/**
//			 * do mutate!!!!!
//			 */
//			HashMap<String, String> newPatternList=run.getPattern(5);
//			for(String getKey:testp.keySet()) {
//				String getValue=testp.get(getKey);
//				newPatternList.put(getKey, getValue);
//			}
//			//newPatternList.putAll(testp);
//			System.out.println("new:"+newPatternList);
//			putpattern2=new HashMap<>();
//			trypattern2=new HashMap<>();
//			System.out.println("test put:"+putpattern2);
//		
//			for(String getpatternkey2:newPatternList.keySet()) {
//				String runpattern2=newPatternList.get(getpatternkey2);
//				final Game.Behavior generations = Game.run(0L, runpattern2);
//				System.out.println("\n///run next 222222///"+generations.generation+" generation.");
//			    putpattern2.put(getpatternkey2, generations.generation);
//			    trypattern2.put(getpatternkey2, runpattern2);
////			    putpattern=putpattern2;
////			    trypattern=trypattern2;
//			    
//			}
//			//System.out.println("putpattern:"+putpattern+",put2"+putpattern2);
//			checkint=checkgeneration(putpattern2);
//			testp=run.getTop5(putpattern2, trypattern2);
//		}
//		
//		System.out.println(i);
//		}
//	}
//	public static int checkgeneration(HashMap<String,Long> patterncheck) {
//		boolean check=false;
//		int checkint=0;
//		ArrayList<String> getFinalPattern=new ArrayList<>();
//		for(String patternkey:patterncheck.keySet()) {
//			if(patterncheck.get(patternkey)<20) {
//				checkint+=0;
//			}else {
//				checkint+=1;
//				getFinalPattern.add(patternkey);
//				
//				//break;
//			}
//		}
//		System.out.println("final:"+getFinalPattern);
//		return checkint;
//	}
//	/**
//	 * get top pattern list's points pattern, and put it into list
//	 * @param a
//	 * @return
//	 */
//	public static ArrayList<String> getTopPattern(List<String> a){
//		ArrayList<String> gettop=new ArrayList<>();
//		for(String bitsPattern:a) {
//			gettop.add(bitsPattern);
//	}
//		return gettop;
//	}
//
//	/**
//	 * get pattern
//	 * @return
//	 */
//	public HashMap<String,String> getPattern(int population){
//		//List<String> startPointList = new ArrayList<>();
//		/**
//		 * <bits,pattern points>
//		 */
//		HashMap<String,String> startPointList=new HashMap<>();
//		int countlist=0;
//		while(countlist<population) {
//			/**
//			 * 1.) Define the genotype (factory) suitable for the problem.
//			 */
//			//int NumberOfPoint = (int)(Math.random() * 20) + 5;
//			int NumberOfPoint = 5;
////	        System.out.println(NumberOfPoint);
//	        Factory<Genotype<BitGene>> gtf =
//	                Genotype.of(BitChromosome.of(8, 0.5),NumberOfPoint);
//	/**
//	 * define 000 north ;
//	 *      100 northeast;
//	        010 east;
//	        011 southeast;
//	        110 south;
//	        101 southwest;
//	        111 west ;
//	        001 northwest;  then count the number of 1 as steps of move.
//	 */
////	   
////	        System.out.println(gtf);
//	        String trans = gtf.toString();
////	        System.out.println("trans:"+trans);
//	        String regEx="[^0-9]";
//	        Pattern p = Pattern.compile(regEx);  
//	        Matcher m = p.matcher(trans);
//	        String transStr = (m.replaceAll("").trim()).toString();
//	        String transStrcopy=transStr;
////	        System.out.println(transStr);
////	        System.out.println(transStr.length());
//	        ArrayList<String> compareList = new ArrayList<String>(); 
//	        boolean duplicate = false;
//	        String point = "";
//	        while(transStr.length()>0) {
//	        	String s1 = transStr.substring(0, 8);
//	            //System.out.println("get:"+s1);
//	            /**
//	             *  determine the direction
//	             */
//	            String s2 = s1.substring(0, 3);
////	            System.out.println(s2);
//	            String rest2 = s1.substring(3);
////	            System.out.println(rest2);
//	            char[] transArray = rest2.toCharArray();
//	            /**
//	             * determine moves
//	             */
//	            int count = 0;
//	            
//	            String compare = "";
//	            for(int i=0;i<transArray.length;i++) {
//	            	if(transArray[i]=='1') {
//	            		count = count+1;
//	            	}
//	            }
////	            System.out.println(count);
//	            
//	            if (s2.equals("000")) {
//	            	compare = "0 ".concat(String.valueOf(count));
//	            	point = point.concat(compare);
//
//	            }
//	            else if(s2.equals("010")) {
//	            	compare = String.valueOf(count).concat(" 0");
//	            	point = point.concat(compare);
//
//	            }
//	            else if(s2.equals("001")) {
//	            	compare = "-".concat(String.valueOf(count))+" ".concat(String.valueOf(count));
//	            	point = point.concat(compare);
//	          
//	            }
//	            else if(s2.equals("100")) {
//	            	compare = String.valueOf(count)+" ".concat(String.valueOf(count));
//	            	point = point.concat(compare);
//	          
//	            }
//	            else if(s2.equals("110")) {
//	            	compare = "0 -".concat(String.valueOf(count));
//	            	point = point.concat(compare);
//	            
//	            }
//	            else if(s2.equals("111")) {
//	            	compare = "-"+String.valueOf(count).concat(" 0");
//	            	point = point.concat(compare);
//	            	
//	            }
//	            else if(s2.equals("101")) {
//	            	compare = "-".concat(String.valueOf(count))+" -".concat(String.valueOf(count));
//	            	point = point.concat(compare);
//	            }
//	            else {
//	            	compare = String.valueOf(count)+" -".concat(String.valueOf(count));
//	            	point = point.concat(compare);
//	            	
//	            }
//	           	transStr = transStr.substring(8);
//	           	if(transStr.length()>0) {point = point.concat(",");}
//	           	for(int j=0; j<compareList.size();j++) {
//	           		if(compareList.get(j).equals(compare)) {
//	           			duplicate = true;
//	           			break;
//	           		}
//	           	}
//	           	compareList.add(compare);
////	           	if(compareList.get(0).equals(compare)) {System.out.println("hahaha");}
////	           	System.out.println(compare);
////	           	System.out.println(duplicate);
//	            if(duplicate==true) {break;}
//	        }
//        
//        
//         if(duplicate==false) {
//         //startPointList.add(point);
//         startPointList.put(transStrcopy, point);
//         System.out.println("pattern:"+transStrcopy);
//         countlist++;
//         System.out.println("points:"+point);
//             }
//		}
//		return startPointList;
// }
//
///**
// * get top 5 generation's pattern:bits,points
// * @param putpattern2,trypattern
// * @return
// */
//	public HashMap<String,String> getTop5(HashMap<String, Long> putpattern2, HashMap<String,String> trypattern) {
//		HashMap<String,String> toppattern=new HashMap<String,String>();
//		List<String> top=new ArrayList<String>();
//		List<Map.Entry<String,Long>> topsList =new ArrayList<Map.Entry<String,Long>>(putpattern2.entrySet());
//		Collections.sort(topsList, new Comparator<Map.Entry<String,Long>>(){
//			public int compare(Map.Entry<String,Long> o1,Map.Entry<String,Long> o2){
//				return (int)(o1.getValue()-o2.getValue());
//			}
//		});
//		
//		for(int i=topsList.size()-1; i>=topsList.size()-5; i--) {
//			top.add(topsList.get(i).getKey());
//			
//			countgen.add(topsList.get(i).getValue());
//			//System.out.println("try get top pattern:"+topsList.get(i).getKey());
//		}
//		//System.out.println("trypattern:"+trypattern);
//		for(String a:trypattern.keySet()) {
//			String toadd=a;
//			for(int i=0;i<top.size(); i++) {
//				if(top.get(i).equals(toadd)) {
//					toppattern.put(a, trypattern.get(a));
//				}
//			}
//		}
//		//System.out.println(toppattern);
//		return toppattern;
//		}
//}
