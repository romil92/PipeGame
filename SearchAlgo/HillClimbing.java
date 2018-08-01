package SearchAlgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;



public class HillClimbing<T> implements Searcher<T> {

	public String solve(State<T> problem) {
		Stack<State<T>> _open = new Stack<State<T>>();	
		HashSet<State<T>> _closed = new HashSet<State<T>>();
		
		_open.push(problem);
		
		State<T> temp;
		
		while(!_open.isEmpty()) {
			temp=_open.pop();
//			System.out.println(temp.getLocation().getIndex());
			_closed.add(temp);
			if(temp.isGoal()) {
			return temp.getSolution();
				
			}
			ArrayList<State<T>> tempChild=temp.getNeighbors();
			tempChild.sort(problem.getComp());
			while(!tempChild.isEmpty()) {
				temp=tempChild.remove(0);
				if(!_closed.contains(temp)) {
					_open.push(temp);
				}
				
			}
			
			
		}
		return null;
		}
	}


