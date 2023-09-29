package graphics;

import java.awt.Color;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.OEShapeModel;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"horizontalTop",
	"horizontalBottom",
	"verticalLeft",
	"verticalRight",
	"legOne",
	"legTwo",
	"legThree",
	"legFour"
})
public class ATable implements Table {
	double INIT_LEGS = Math.PI/2;
	
	int INIT_HT_X = 149;
	int INIT_HT_Y = 150;
	double INIT_HT_ANGLE = Math.PI;
	int INIT_HT_RADIUS = 70;
	
	int INIT_HB_X = 120;
	int INIT_HB_Y = 180;
	double INIT_HB_ANGLE = Math.PI;
	int INIT_HB_RADIUS = 70;
	
	int INIT_VL_X = 150-INIT_HT_RADIUS;
	int INIT_VL_Y = 150;
	double INIT_VL_ANGLE = (3*Math.PI)/4;
	int INIT_VL_RADIUS = 42;
	
	int INIT_VR_X = 149;
	int INIT_VR_Y = 150;
	double INIT_VR_ANGLE = (3*Math.PI)/4;
	int INIT_VR_RADIUS = 42;
	
	int INIT_LEGONE_X = 120-INIT_HB_RADIUS;
	int INIT_LEGONE_Y = 180;
	int INIT_LEGONE_RADIUS = 40;
	
	int INIT_LEGTWO_X = 149-INIT_HT_RADIUS;
	int INIT_LEGTWO_Y = 180;
	int INIT_LEGTWO_RADIUS = 25;
	
	int INIT_LEGTHREE_X = 120;
	int INIT_LEGTHREE_Y = 180;
	int INIT_LEGTHREE_RADIUS = 40;
	
	int INIT_LEGFOUR_X = 149;
	int INIT_LEGFOUR_Y = 150;
	int INIT_LEGFOUR_RADIUS = 45;
	
	
	OEShapeModel horizontalTop;
	OEShapeModel horizontalBottom;
	OEShapeModel verticalLeft;
	OEShapeModel verticalRight;
	OEShapeModel legOne;
	OEShapeModel legTwo;
	OEShapeModel legThree;
	OEShapeModel legFour;
	
	public ATable() {
		horizontalTop = new ALineModel();
		horizontalTop.setX(INIT_HT_X);
		horizontalTop.setY(INIT_HT_Y);
		horizontalTop.setRadius(INIT_HT_RADIUS);
		horizontalTop.setAngle(INIT_HT_ANGLE);
		horizontalTop.setColor(Color.WHITE);
		
		horizontalBottom = new ALineModel();
		horizontalBottom.setX(INIT_HB_X);
		horizontalBottom.setY(INIT_HB_Y);
		horizontalBottom.setRadius(INIT_HB_RADIUS);
		horizontalBottom.setAngle(INIT_HB_ANGLE);
		horizontalBottom.setColor(Color.WHITE);
		
		verticalLeft = new ALineModel();
		verticalLeft.setX(INIT_VL_X);
		verticalLeft.setY(INIT_VL_Y);
		verticalLeft.setRadius(INIT_VL_RADIUS);
		verticalLeft.setAngle(INIT_VL_ANGLE);
		verticalLeft.setColor(Color.WHITE);
		
		verticalRight = new ALineModel();
		verticalRight.setX(INIT_VR_X);
		verticalRight.setY(INIT_VR_Y);
		verticalRight.setRadius(INIT_VR_RADIUS);
		verticalRight.setAngle(INIT_VR_ANGLE);
		verticalRight.setColor(Color.WHITE);
		
		legOne = new ALineModel();
		legOne.setX(INIT_LEGONE_X);
		legOne.setY(INIT_LEGONE_Y);
		legOne.setRadius(INIT_LEGONE_RADIUS);
		legOne.setAngle(INIT_LEGS);
		legOne.setColor(Color.WHITE);
		
		legTwo = new ALineModel();
		legTwo.setX(INIT_LEGTWO_X);
		legTwo.setY(INIT_LEGTWO_Y);
		legTwo.setRadius(INIT_LEGTWO_RADIUS);
		legTwo.setAngle(INIT_LEGS);
		legTwo.setColor(Color.WHITE);
		
		legThree = new ALineModel();
		legThree.setX(INIT_LEGTHREE_X);
		legThree.setY(INIT_LEGTHREE_Y);
		legThree.setRadius(INIT_LEGTHREE_RADIUS);
		legThree.setAngle(INIT_LEGS);
		legThree.setColor(Color.WHITE);
		
		legFour = new ALineModel();
		legFour.setX(INIT_LEGFOUR_X);
		legFour.setY(INIT_LEGFOUR_Y);
		legFour.setRadius(INIT_LEGFOUR_RADIUS);
		legFour.setAngle(INIT_LEGS);
		legFour.setColor(Color.WHITE);
	}
	
	@Override
	public OEShapeModel getHorizontalTop() {
		return horizontalTop;
	}
	
	@Override
	public OEShapeModel getHorizontalBottom() {
		return horizontalBottom;
	}
	
	@Override
	public OEShapeModel getVerticalLeft() {
		return verticalLeft;
	}
	
	@Override
	public OEShapeModel getVerticalRight() {
		return verticalRight;
	}
	
	@Override
	public OEShapeModel getLegOne() {
		return legOne;
	}
	
	@Override
	public OEShapeModel getLegTwo() {
		return legTwo;
	}
	
	@Override
	public OEShapeModel getLegThree() {
		return legThree;
	}
	
	@Override
	public OEShapeModel getLegFour() {
		return legFour;
	}
	
	@Override
	public void move(int newX, int newY) {
		horizontalTop.setX(horizontalTop.getX()+newX);
		horizontalTop.setY(horizontalTop.getY()+newY);
		horizontalBottom.setX(horizontalBottom.getX()+newX);
		horizontalBottom.setY(horizontalBottom.getY()+newY);
		verticalLeft.setX(verticalLeft.getX()+newX);
		verticalLeft.setY(verticalLeft.getY()+newY);
		verticalRight.setX(verticalRight.getX()+newX);
		verticalRight.setY(verticalRight.getY()+newY);
		legOne.setX(legOne.getX()+newX);
		legOne.setY(legOne.getY()+newY);
		legTwo.setX(legTwo.getX()+newX);
		legTwo.setY(legTwo.getY()+newY);
		legThree.setX(legThree.getX()+newX);
		legThree.setY(legThree.getY()+newY);
		legFour.setX(legFour.getX()+newX);
		legFour.setY(legFour.getY()+newY);
	}
	
	public static void main(String[] args) {
		final Table table = new ATable();
		table.move(180, 80);
		OEFrame editor = ObjectEditor.edit(table);
		//editor.getDrawComponent().setBackground(Color.WHITE);
		editor.showDrawPanel();
	}
	
}
