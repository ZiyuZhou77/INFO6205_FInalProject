package edu.neu.coe.info6205.life.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopPattern {

	ArrayList<String> toppattern;
	ArrayList<Long> count;
//	public TopPattern(ArrayList top) {
//		this.toppattern=new ArrayList<>();
//		this.count=new ArrayList<>();
//	}
	public void setTop(ArrayList top) {
		this.toppattern=top;
	}
	public ArrayList<String> getTop() {
		return toppattern;
	}
	public void setCount(ArrayList count) {
		this.count=count;
	}
	public ArrayList<Long> getCount() {
		return count;
	}
}
