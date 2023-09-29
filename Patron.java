package graphics;

public interface Patron {

	public Avatar getPatron();
	public Table getTable();
	public void move(int newX, int newY);
	
}
