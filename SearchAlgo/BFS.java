package SearchAlgo;

import java.util.HashSet;
import java.util.ArrayList;

public class BFS<T> implements Searcher<T> {
		private ArrayList<State<T>> _open;
		private HashSet<State<T>> _closed;
	
	public BFS() {
			super();
			// TODO Auto-generated constructor stub
		}

	@Override
	public String solve(State<T> problem) {
	_open=new ArrayList<State<T>>();	
	_closed=new HashSet<State<T>>();
	
	_open.add(problem);
	State<T> temp;
	
	while(!_open.isEmpty()) {
		temp=_open.remove(0);
		_closed.add(temp);
		if(temp.isGoal()) {
		return temp.getSolution();
			
		}
		ArrayList<State<T>> tempChild=temp.getNeighbors();
		while(!tempChild.isEmpty()) {
			temp=tempChild.remove(0);
			if(!_closed.contains(temp)) {
				_open.add(temp);
			}
			
		}
		
		
	}
	return null;
	}

	
}
