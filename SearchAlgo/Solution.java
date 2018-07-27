package SearchAlgo;

import java.util.ArrayList;

public class Solution {

	private ArrayList<String> solution;
	public Solution() {
		solution=new ArrayList<String>();
	}
	public void addMove(String move) {
		solution.add(move);
	}
	
	public String getSolution() {
		String fSolution= "";
		for(String s:solution) {
			fSolution += s + ",";
			fSolution += "," ;
		}
		return fSolution;
		
	}
}
