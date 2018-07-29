package Server;


import SearchAlgo.Searcher;
import SearchAlgo.State;

public class PipeGameSolver<T> implements Solver<T> {

	private Searcher<T> _algorithm;
	
	public PipeGameSolver(Searcher<T> algorithm) {
		_algorithm=algorithm;
		
	}

	@Override
	public String solve(State<T> problem) {
		
		return _algorithm.solve(problem);
	}

	
}
