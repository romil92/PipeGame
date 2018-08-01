package SearchAlgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public interface State<T> {

	public State<T> getCameFromState();
	public Location getLocation();
	public Integer getRotation();
	public ArrayList<State<T>> getNeighbors();
	public Integer getUristicNum();
	public boolean isGoal();
	public int visited();
	//public void setFather(State<T> father);
	public HashSet<String> getTrack();
	public void setVisited(int colour);
	public String getSolution();
	public Location getGoal();
	public Location getGoalLocation();
	Comparator<? super State<T>> getComp();
	
	class StateComperator<T> implements Comparator<State<T>>
	{

		@Override
		public int compare(State<T> g0, State<T> g1) {
			return(g0.getUristicNum() - g1.getUristicNum());
				
		}
	}
}