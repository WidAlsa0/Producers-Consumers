package graphics;

import bus.uigen.shapes.OEShapeModel;

public interface BoundedBuffer {
	public OEShapeModel getCircle();
	public OEShapeModel getLineOne();
	public OEShapeModel getLineTwo();
	public OEShapeModel getLineThree();
	public OEShapeModel getLineFour();
	public OEShapeModel getLineFive();
	public OEShapeModel getLineSix();
	public OEShapeModel getLineSeven();
	public OEShapeModel getLineEight();
	public void move(int newX, int newY);
}
