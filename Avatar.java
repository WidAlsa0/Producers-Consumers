package graphics;

import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;

public interface Avatar {
	public Angle getArms();
	public void setArms(Angle newArms);
	public Angle getLegs();
	public void setLegs(Angle newLegs);
	public OEShapeModel getTorso();
	public void setTorso(OEShapeModel newTorso);
	public OEShapeModel getHead();
	public void setHead(OEShapeModel newHead);
	public FlexibleTextShape getText();
	public void setText(shapes.FlexibleTextShape newText);
//	public OEShapeModel getPlate();
//	public void setPlate(OEShapeModel newPlate);
//	public Table getTable();
//	public void setTable(Table newTable);
	void move(int newX, int newY);
	
}
