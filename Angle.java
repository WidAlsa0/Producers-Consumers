package graphics;

import bus.uigen.shapes.OEShapeModel;

public interface Angle {

	OEShapeModel getLeft();
	OEShapeModel getRight();
	public void moveTo(int newX, int newY);

}
