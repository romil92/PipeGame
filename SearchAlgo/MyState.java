package SearchAlgo;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class MyState<T> implements State<T>{

	protected ArrayList<T> _matrix;
	protected Location _loc;
	protected Integer _rotation;
	protected State<T> _father;
	protected HashSet<String> _track;
	protected Integer _uristicNum;
	protected int _visited;
	public MyState(ArrayList<T> matrix) {
		char start='0';
		int i=0;
		int co = 0;
		int size=matrix.size();
		while(!(start=='s'||start=='S')&&i<size) {
			for(int j=0;j<matrix.get(i).toString().length()&&!(start=='s'||start=='S');j++) {
			start=matrix.get(i).toString().charAt(j);
			}
			co=i;
			i++;
		}
		_loc=new Location(i-1,co);
		_matrix=new ArrayList<T>(matrix);
		_rotation=0;
		_father=null;
		_track=new HashSet<String>();
		_track.add(_loc.getIndex());
		_uristicNum=0;
		_visited=0;
	}
	
	//must give allocated matrix
	public MyState(ArrayList<T> matrix,Location loc,State<T> father,Integer rotation,Integer uristicNum) {
		_matrix=matrix;
		_loc=new Location(loc);
		_father=father;
		_track=new HashSet<String>(father.getTrack());
		_track.add(loc.getIndex());
		_rotation=rotation;
		_uristicNum=uristicNum;
		_visited=0;
	}


	@Override
	public State<T> getCameFromState() {
		return _father;
		
	}

	@Override
	public Location getLocation() {
		
		return _loc;
	}

	@Override
	public Integer getRotation() {
		// TODO Auto-generated method stub
		return _rotation;
	}

	@Override
	public abstract ArrayList<State<T>> getNeighbors() ;

	@Override
	public Integer getUristicNum() {
		// TODO Auto-generated method stub
		return _uristicNum;
	}

	@Override
	public boolean isGoal() {
		if(_matrix.get(_loc.getRow()).toString().charAt(_loc.getCol())=='g')
			return true;
		return false;
	}

	@Override
	public int visited() {
		// TODO Auto-generated method stub
		return _visited;
	}
/*
	@Override
	public void setFather(State<T> father) {
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public HashSet<String> getTrack() {
		return _track;
	
	}

	@Override
	public void setVisited(int colour) {
		_visited=colour;
		
	}
	public abstract String getSolution();

}
