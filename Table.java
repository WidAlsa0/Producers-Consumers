package graphics;

import bus.uigen.shapes.OEShapeModel;

public interface Table {
	public OEShapeModel getHorizontalTop();
	public OEShapeModel getHorizontalBottom();
	public OEShapeModel getVerticalLeft();
	public OEShapeModel getVerticalRight();
	public OEShapeModel getLegOne();
	public OEShapeModel getLegTwo();
	public OEShapeModel getLegThree();
	public OEShapeModel getLegFour();
	public void move(int newX, int newY);
}
