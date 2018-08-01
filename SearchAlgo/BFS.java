package SearchAlgo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;

public class BFS<T> implements Searcher<T> {
		private LinkedList<State<T>> _open;
		private HashSet<State<T>> _closed;
	
	public BFS() {
			super();
			// TODO Auto-generated constructor stub
		}

	@Override
	public String solve(State<T> problem) {
	_closed=new HashSet<State<T>>();
	_open=new LinkedList<State<T>>();
	_open.add(problem);
	State<T> temp;
	
	while(!_open.isEmpty()) {
		temp=_open.remove();
		_closed.add(temp);
		if(temp.isGoal()) {
		return temp.getSolution();
			
		}
		ArrayList<State<T>> tempChild=temp.getNeighbors();
		while(!tempChild.isEmpty()) {
		//	System.out.println(temp.getLocation().getIndex());
			temp=tempChild.remove(0);
			if(!_closed.contains(temp)) {
				_open.add(temp);
			}
			
		}
		//System.out.println( "childs");
		
	}
	return null;
	}

	
}
