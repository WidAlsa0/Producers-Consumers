package graphics;

import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;

public interface Plate {

	OEShapeModel getPlate();
	FlexibleTextShape getText();
	void setPlate(OEShapeModel newPlate);
	void setText(FlexibleTextShape newString);
	void move(int newX, int newY);
	public void moveTo(int newX, int newY);

}
