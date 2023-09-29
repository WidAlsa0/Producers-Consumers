package graphics;

import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;

public interface Bell {
	
	public OEShapeModel getBell();
	public FlexibleTextShape getText();
	public void setBell(OEShapeModel newBell);
	public void setText(FlexibleTextShape newText);
	public void move(int newX, int newY);
	public void moveTo(int newX, int newY);
}
