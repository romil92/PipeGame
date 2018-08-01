package SearchAlgo;

public class Location {
Integer _col;
Integer _row;
	public Location(Integer row,Integer col) {
		_col=col;
		_row=row;
		
	}
	public Location(Location l) {
		_col=l.getCol();
		_row=l.getRow();
		
	}
	public Integer getRow() {return _row;}
	public Integer getCol() {return _col;}
	public String getIndex() { 
		return _row.toString()+","+_col.toString();
	}
	public boolean equals(Location arg0) {
		if(_col==arg0._col&&_row==arg0._row)
			return true;
		return false;
	}
}
