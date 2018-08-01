package SearchAlgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DFS<T> implements Searcher<T> {

	private Stack<State<T>> _open;
	private HashSet<State<T>> _closed;

	
	public DFS() {
		
	}


	@Override
	public String solve(State<T> problem) {
		_open=new Stack<State<T>>();	
		_closed=new HashSet<State<T>>();
		
		_open.push(problem);
		State<T> temp;
		
		while(!_open.isEmpty()) {
			temp=_open.pop();
			_closed.add(temp);
			if(temp.isGoal()) {
			return temp.getSolution();
				
			}
			ArrayList<State<T>> tempChild=temp.getNeighbors();
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

