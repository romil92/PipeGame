package SearchAlgo;

import java.util.ArrayList;
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
}