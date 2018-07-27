package Server;

import java.util.ArrayList;

public class WaterMazeNormalizer implements Normalizer {

	private String[] _nWmaze;
	private int [][] _moveMat;
	
	public WaterMazeNormalizer(ArrayList<String> list) {
		int row = list.size() - 1;
		int col = list.get(0).length();
		char tmp;
		
		_nWmaze = new String[row] ;
		_moveMat = new int[row][col];
		for(int i = 0; i < row; i++) {
			_nWmaze[i]="";
			for(int j = 0; j < col; j++) {

				
				tmp = list.get(i).charAt(j);
				if(tmp == '-') {
					_moveMat[i][j] = 0;
					_nWmaze[i] = _nWmaze[i] + "-"; 
				}
				else if(tmp == '|') {
					_moveMat[i][j] = 1;
					_nWmaze[i] = _nWmaze[i] + "-";
				}
				else if(tmp == 'L') {
					_moveMat[i][j] = 0; 
					_nWmaze[i] = _nWmaze[i] + "L";
				}
				else if(tmp == 'J') {
					_moveMat[i][j] = 1;
					_nWmaze[i] = _nWmaze[i] + "L";
				}
				else if(tmp == '7') {
					_moveMat[i][j] = 2;
					_nWmaze[i] = _nWmaze[i] + "L";
				}
				else if(tmp == 'F') {
					_moveMat[i][j] = 3;
					_nWmaze[i] = _nWmaze[i] + "L";
				}
				else if(tmp == 's' || tmp == 'S') {
					_moveMat[i][j] = 0; 
					_nWmaze[i] = _nWmaze[i] + "s";
				}
				else if(tmp == 'g' || tmp == 'G') {
					_moveMat[i][j] = 0; 
					_nWmaze[i] = _nWmaze[i] + "s";
				}
				else {
					_moveMat[i][j] = 0; 
					_nWmaze[i] = _nWmaze[i] + "0";
				}
			}
		}
	}

	public Integer getHash() {
		Integer hash = 0;
		for(String s: _nWmaze) {
			hash += s.hashCode();
		}
		return hash;
	}
	@Override
	public String[] normalize(String[] matrix) {
		// TODO Auto-generated method stub
		return null;
	}

}
