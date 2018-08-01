package SearchAlgo;

import java.util.ArrayList;
import java.util.Comparator;

public class PipeGameState<T> extends MyState<T> {
	protected StateComperator<T> _comp;
	
	public PipeGameState(ArrayList<T> matrix, Location loc, State<T> father, Integer rotation, Integer uristicNum) {
		super(matrix, loc, father, rotation, uristicNum);
		_comp=new StateComperator<>();
		// TODO Auto-generated constructor stub
	}

	public PipeGameState(ArrayList<T> matrix) {
		super(matrix);
		_comp=new StateComperator<>();
		// TODO Auto-generated constructor stub
	}

	
	public int getManhDistance(Location l) {
		return super.getManhDistance(l);
	}
	
	public Location getGoal() {
		return super.getGoal();
	}
	@Override//TODO if d'ont work change return value to PipeGameState
	public ArrayList<State<T>> getNeighbors() {
		ArrayList<State<T>> neighbors= new ArrayList<State<T>>();
		neighbors.addAll(getUpNeighbors());
		neighbors.addAll(getDownNeighbors());
		neighbors.addAll(getRightNeighbors());
		neighbors.addAll(getLeftNeighbors());
		return neighbors;
	}

	private ArrayList<PipeGameState<T>> getUpNeighbors(){
		ArrayList<PipeGameState<T>> nList=new ArrayList<PipeGameState<T>>();
	
		char c=this._matrix.get(_loc.getRow()).toString().charAt(_loc.getCol());
		if(this._loc.getRow()>0) {
			Location newLocation=new Location(_loc.getRow()-1,_loc.getCol());
		
			if((c=='L'&& _rotation==0)||(c=='L'&& _rotation==3)||(c=='-'&& _rotation==1)||c=='s') {
				char up=this._matrix.get(_loc.getRow()-1).toString().charAt(_loc.getCol());
				if(!_track.contains(newLocation.getIndex())) {
					if(up=='L') {
						nList.add(new PipeGameState<T>(_matrix, newLocation, this,1, getManhDistance(newLocation)));
						nList.add(new PipeGameState<T>(_matrix, newLocation, this,2, getManhDistance(newLocation)));
			
					}
					if(up=='-') {
						nList.add(new PipeGameState<T>(_matrix, newLocation, this,1, getManhDistance(newLocation)));
					}
					if(up=='g') {
						nList.add(new PipeGameState<T>(_matrix, newLocation, this,0, getManhDistance(newLocation)));
					}
				}
			
			}
	
		}
		return nList;
	}
	
	private ArrayList<PipeGameState<T>> getDownNeighbors(){
			ArrayList<PipeGameState<T>> nList=new ArrayList<PipeGameState<T>>();
			char c=this._matrix.get(_loc.getRow()).toString().charAt(_loc.getCol());
			if(this._loc.getRow()<_matrix.size()-1) {
				Location newLocation=new Location(_loc.getRow()+1,_loc.getCol());
			
				if((c=='L'&& _rotation==1)||(c=='L'&& _rotation==2)||(c=='-'&& _rotation==1)||c=='s') {
					char down=this._matrix.get(_loc.getRow()+1).toString().charAt(_loc.getCol());
					if(!_track.contains(newLocation.getIndex())) {
						if(down=='L') {
							nList.add(new PipeGameState<T>(_matrix, newLocation, this,0, getManhDistance(newLocation)));
							nList.add(new PipeGameState<T>(_matrix, newLocation, this,3, getManhDistance(newLocation)));
				
						}
						if(down=='-') {
							nList.add(new PipeGameState<T>(_matrix, newLocation, this,1, getManhDistance(newLocation)));
						}
						if(down=='g') {
							nList.add(new PipeGameState<T>(_matrix, newLocation, this,0, getManhDistance(newLocation)));
					}
				
				}
		
			}
			
			
		}
			return nList;		
	}
	private ArrayList<PipeGameState<T>> getRightNeighbors(){
		ArrayList<PipeGameState<T>> nList=new ArrayList<PipeGameState<T>>();
		char c=this._matrix.get(_loc.getRow()).toString().charAt(_loc.getCol());
		if(this._loc.getCol()<_matrix.get(0).toString().length()-1) {
				Location newLocation=new Location(_loc.getRow(),_loc.getCol()+1);
		
				if((c=='L'&& _rotation==0)||(c=='L'&& _rotation==1)||(c=='-'&& _rotation==0)||c=='s') {
					char right=this._matrix.get(_loc.getRow()).toString().charAt(_loc.getCol()+1);
					if(!_track.contains(newLocation.getIndex())) {
						if(right=='L') {
							nList.add(new PipeGameState<T>(_matrix, newLocation, this,2, getManhDistance(newLocation)));
							nList.add(new PipeGameState<T>(_matrix, newLocation, this,3, getManhDistance(newLocation)));
			
						}
						if(right=='-') {
							nList.add(new PipeGameState<T>(_matrix, newLocation, this,0, getManhDistance(newLocation)));
						}
						if(right=='g') {
							nList.add(new PipeGameState<T>(_matrix, newLocation, this,0, getManhDistance(newLocation)));
						}
						
				}
				
			}
		}
		
		
		return nList;
		
	
	}
	private ArrayList<PipeGameState<T>> getLeftNeighbors(){
		ArrayList<PipeGameState<T>> nList=new ArrayList<PipeGameState<T>>();
		char c=this._matrix.get(_loc.getRow()).toString().charAt(_loc.getCol());
		if(this._loc.getCol()>0) {
			Location newLocation=new Location(_loc.getRow(),_loc.getCol()-1);
		
			if((c=='L'&& _rotation==2)||(c=='L'&& _rotation==3)||(c=='-'&& _rotation==0)||c=='s') {
				char left=this._matrix.get(_loc.getRow()).toString().charAt(_loc.getCol()-1);
				if(!_track.contains(newLocation.getIndex())) {
					if(left=='L') {
						nList.add(new PipeGameState<T>(_matrix, newLocation, this,0, getManhDistance(newLocation)));
						nList.add(new PipeGameState<T>(_matrix, newLocation, this,1, getManhDistance(newLocation)));
			
					}
					if(left=='-') {
						nList.add(new PipeGameState<T>(_matrix, newLocation, this,0, getManhDistance(newLocation)));
					}
					if(left=='g') {
						nList.add(new PipeGameState<T>(_matrix, newLocation, this,0, getManhDistance(newLocation)));
					}
			
				}
	
			}		
		}	
		return nList;
	}

	@Override
	public String getSolution() {
		String solution=new String();
		solution="";
		PipeGameState<T> temp=this;
		while(temp!=null) {
			solution+=temp.getLocation().getIndex()+","+temp.getRotation().toString()+",";
			temp=(PipeGameState<T>) temp.getCameFromState();
		}
		return solution;
	}

	@Override
	public Comparator<? super State<T>> getComp() {
		// TODO Auto-generated method stub
		return _comp;
	}

	@Override
	public int compareTo(State<T> arg0) {
		 return _uristicNum-arg0.getUristicNum()-_uristicNum;
	}

	
	

	
}