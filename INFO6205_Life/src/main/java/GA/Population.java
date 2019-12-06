package GA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.jenetics.BitChromosome;
import io.jenetics.BitGene;
import io.jenetics.Genotype;
import io.jenetics.util.Factory;

public class Population {

	/**
	 * get population pattern: <bites, points>
	 * @return
	 */
	public HashMap<String,String> getPattern(int populationsize){
		/**
		 * <bits,pattern points>
		 */
		HashMap<String,String> startPointList=new HashMap<>();
		int countlist=0;
		while(countlist<populationsize) {
			/**
			 *  Define the genotype (factory) suitable for the problem.
			 */
			int NumberOfPoint = (int)(Math.random() * 20) + 5;
			//int NumberOfPoint = 5;
	        //System.out.println(NumberOfPoint);
	        Factory<Genotype<BitGene>> gtf =
	                Genotype.of(BitChromosome.of(8, 0.5),NumberOfPoint);
	/**
	 * define 000 north ;
	 *      100 northeast;
	        010 east;
	        011 southeast;
	        110 south;
	        101 southwest;
	        111 west ;
	        001 northwest;  then count the number of 1 as steps of move.
	 */
//	   
//	        System.out.println(gtf);
	        String trans = gtf.toString();
//	        System.out.println("trans:"+trans);
	        String regEx="[^0-9]";
	        Pattern p = Pattern.compile(regEx);  
	        Matcher m = p.matcher(trans);
	        String transStr = (m.replaceAll("").trim()).toString();
	        String transStrcopy=transStr;
//	        System.out.println(transStr);
//	        System.out.println(transStr.length());
	        ArrayList<String> compareList = new ArrayList<String>(); 
	        boolean duplicate = false;
	        String point = "";
	        while(transStr.length()>0) {
	        	String s1 = transStr.substring(0, 8);
	            //System.out.println("get:"+s1);
	            /**
	             *  determine the direction
	             */
	            String s2 = s1.substring(0, 3);
//	            System.out.println(s2);
	            String rest2 = s1.substring(3);
//	            System.out.println(rest2);
	            char[] transArray = rest2.toCharArray();
	            /**
	             * determine moves
	             */
	            int count = 0;
	            
	            String compare = "";
	            for(int i=0;i<transArray.length;i++) {
	            	if(transArray[i]=='1') {
	            		count = count+1;
	            	}
	            }
//	            System.out.println(count);
	            
	            if (s2.equals("000")) {
	            	compare = "0 ".concat(String.valueOf(count));
	            	point = point.concat(compare);

	            }
	            else if(s2.equals("010")) {
	            	compare = String.valueOf(count).concat(" 0");
	            	point = point.concat(compare);

	            }
	            else if(s2.equals("001")) {
	            	compare = "-".concat(String.valueOf(count))+" ".concat(String.valueOf(count));
	            	point = point.concat(compare);
	          
	            }
	            else if(s2.equals("100")) {
	            	compare = String.valueOf(count)+" ".concat(String.valueOf(count));
	            	point = point.concat(compare);
	          
	            }
	            else if(s2.equals("110")) {
	            	compare = "0 -".concat(String.valueOf(count));
	            	point = point.concat(compare);
	            
	            }
	            else if(s2.equals("111")) {
	            	compare = "-"+String.valueOf(count).concat(" 0");
	            	point = point.concat(compare);
	            	
	            }
	            else if(s2.equals("101")) {
	            	compare = "-".concat(String.valueOf(count))+" -".concat(String.valueOf(count));
	            	point = point.concat(compare);
	            }
	            else {
	            	compare = String.valueOf(count)+" -".concat(String.valueOf(count));
	            	point = point.concat(compare);
	            	
	            }
	           	transStr = transStr.substring(8);
	           	if(transStr.length()>0) {point = point.concat(",");}
	           	for(int j=0; j<compareList.size();j++) {
	           		if(compareList.get(j).equals(compare)) {
	           			duplicate = true;
	           			break;
	           		}
	           	}
	           	compareList.add(compare);
	            if(duplicate==true) {break;}
	        }
        
        
         if(duplicate==false) {
         startPointList.put(transStrcopy, point);
         System.out.println("pattern:"+transStrcopy);
         countlist++;
         System.out.println("points:"+point);
             }
		}
		return startPointList;
 }
	
	public HashMap<String,String> convertPattern(String bitspattern){
		HashMap<String,String>afterConvert = new HashMap<>();
		String trans = bitspattern.toString();
//        System.out.println("trans:"+trans);
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);  
        Matcher m = p.matcher(trans);
        String transStr = (m.replaceAll("").trim()).toString();
        String transStrcopy=transStr;
//        System.out.println(transStr);
//        System.out.println(transStr.length());
        ArrayList<String> compareList = new ArrayList<String>(); 
        boolean duplicate = false;
        String point = "";
        while(transStr.length()>0) {
        	String s1 = transStr.substring(0, 8);
            //System.out.println("get:"+s1);
            /**
             *  determine the direction
             */
            String s2 = s1.substring(0, 3);
//            System.out.println(s2);
            String rest2 = s1.substring(3);
//            System.out.println(rest2);
            char[] transArray = rest2.toCharArray();
            /**
             * determine moves
             */
            int count = 0;
            
            String compare = "";
            for(int i=0;i<transArray.length;i++) {
            	if(transArray[i]=='1') {
            		count = count+1;
            	}
            }
//            System.out.println(count);
            
            if (s2.equals("000")) {
            	compare = "0 ".concat(String.valueOf(count));
            	point = point.concat(compare);

            }
            else if(s2.equals("010")) {
            	compare = String.valueOf(count).concat(" 0");
            	point = point.concat(compare);

            }
            else if(s2.equals("001")) {
            	compare = "-".concat(String.valueOf(count))+" ".concat(String.valueOf(count));
            	point = point.concat(compare);
          
            }
            else if(s2.equals("100")) {
            	compare = String.valueOf(count)+" ".concat(String.valueOf(count));
            	point = point.concat(compare);
          
            }
            else if(s2.equals("110")) {
            	compare = "0 -".concat(String.valueOf(count));
            	point = point.concat(compare);
            
            }
            else if(s2.equals("111")) {
            	compare = "-"+String.valueOf(count).concat(" 0");
            	point = point.concat(compare);
            	
            }
            else if(s2.equals("101")) {
            	compare = "-".concat(String.valueOf(count))+" -".concat(String.valueOf(count));
            	point = point.concat(compare);
            }
            else {
            	compare = String.valueOf(count)+" -".concat(String.valueOf(count));
            	point = point.concat(compare);
            	
            }
           	transStr = transStr.substring(8);
           	if(transStr.length()>0) {point = point.concat(",");}
           	
           	for(int j=0; j<compareList.size();j++) {
           		if(compareList.get(j).equals(compare)) {
           			duplicate = true;
           			break;
           		}
           	}
           	compareList.add(compare);
            if(duplicate==true) {break;}
        }
    
    
     if(duplicate==false) {
     //startPointList.add(point);
     afterConvert.put(transStrcopy, point);
         }
		return afterConvert;
	}
}
