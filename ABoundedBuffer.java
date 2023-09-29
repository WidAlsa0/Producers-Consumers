package graphics;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.AnOvalModel;
import bus.uigen.shapes.OEShapeModel;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

import java.awt.BasicStroke;
import java.awt.Color;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"circle",
	"lineOne",
	"lineTwo",
	"lineThree",
	"lineFour",
	"lineFive",
	"lineSix",
	"lineSeven",
	"lineEight"
})
@EditablePropertyNames({
})
public class ABoundedBuffer implements BoundedBuffer {
	//Units for centering the circle
	int INIT_X = 420;
	int INIT_Y = 175;
	int INIT_CIRCLE_HEIGHT = 350;
	int INIT_CIRCLE_WIDTH = 350;
	
	//Line one is the left side of the first buffer & right side of the last buffer
	double LINE_ONE_ANGLE = (5*Math.PI)/4;
	int LINE_ONE_X = INIT_X + (INIT_CIRCLE_WIDTH/2);
	int LINE_ONE_Y = 350;
	int LINE_ONE_RADIUS = 176;
	
	//Line two is the right side of the first buffer & left side of the second buffer
	double LINE_TWO_ANGLE = (3*Math.PI)/2;
	
	//Line three is the right side of the second buffer & left side of the third buffer
	double LINE_THREE_ANGLE = (7*Math.PI)/4;
	
	//Line four is the right side of the third buffer & left side of the fourth buffer
	double LINE_FOUR_ANGLE = 0;
	
	//Line five is the right side of the fourth buffer & left side of the fifth buffer
	double LINE_FIVE_ANGLE = (Math.PI/4);
	
	//Line six is the right side of the fifth buffer & left side of the sixth buffer
	double LINE_SIX_ANGLE = (Math.PI/2);
	
	//Line seven is the right side of the sixth buffer & left side of the seventh buffer
	double LINE_SEVEN_ANGLE = (3*Math.PI/4);
	
	//Line eight is the right side of the seventh buffer & left side of the eight buffer
	double LINE_EIGHT_ANGLE = (Math.PI);
	
	OEShapeModel circle;
	OEShapeModel lineOne;
	OEShapeModel lineTwo;
	OEShapeModel lineThree;
	OEShapeModel lineFour;
	OEShapeModel lineFive;
	OEShapeModel lineSix;
	OEShapeModel lineSeven;
	OEShapeModel lineEight;
	
	public ABoundedBuffer() {
		circle = new AnOvalModel();
		circle.setHeight(INIT_CIRCLE_HEIGHT);
		circle.setWidth(INIT_CIRCLE_WIDTH);
		circle.setX(INIT_X);
		circle.setY(INIT_Y);
		circle.setColor(Color.WHITE);
		circle.setStroke(new BasicStroke(2.0F));
		
		lineOne = new ALineModel();
		lineOne.setX(LINE_ONE_X);
		lineOne.setY(LINE_ONE_Y);
		lineOne.setRadius(LINE_ONE_RADIUS);
		lineOne.setAngle(LINE_ONE_ANGLE);
		lineOne.setColor(Color.WHITE);
		lineOne.setStroke(new BasicStroke(2.0F));
		
		lineTwo = new ALineModel();
		lineTwo.setX(LINE_ONE_X);
		lineTwo.setY(LINE_ONE_Y);
		lineTwo.setRadius(LINE_ONE_RADIUS);
		lineTwo.setAngle(LINE_TWO_ANGLE);
		lineTwo.setColor(Color.WHITE);
		lineTwo.setStroke(new BasicStroke(2.0F));
		
		lineThree = new ALineModel();
		lineThree.setX(LINE_ONE_X);
		lineThree.setY(LINE_ONE_Y);
		lineThree.setRadius(LINE_ONE_RADIUS);
		lineThree.setAngle(LINE_THREE_ANGLE);
		lineThree.setColor(Color.WHITE);
		lineThree.setStroke(new BasicStroke(2.0F));
		
		lineFour = new ALineModel();
		lineFour.setX(LINE_ONE_X);
		lineFour.setY(LINE_ONE_Y);
		lineFour.setRadius(LINE_ONE_RADIUS);
		lineFour.setAngle(LINE_FOUR_ANGLE);
		lineFour.setColor(Color.WHITE);
		lineFour.setStroke(new BasicStroke(2.0F));
		
		lineFive = new ALineModel();
		lineFive.setX(LINE_ONE_X);
		lineFive.setY(LINE_ONE_Y);
		lineFive.setRadius(LINE_ONE_RADIUS);
		lineFive.setAngle(LINE_FIVE_ANGLE);
		lineFive.setColor(Color.WHITE);
		lineFive.setStroke(new BasicStroke(2.0F));
		
		lineSix = new ALineModel();
		lineSix.setX(LINE_ONE_X);
		lineSix.setY(LINE_ONE_Y);
		lineSix.setRadius(LINE_ONE_RADIUS);
		lineSix.setAngle(LINE_SIX_ANGLE);
		lineSix.setColor(Color.WHITE);
		lineSix.setStroke(new BasicStroke(2.0F));
		
		lineSeven = new ALineModel();
		lineSeven.setX(LINE_ONE_X);
		lineSeven.setY(LINE_ONE_Y);
		lineSeven.setRadius(LINE_ONE_RADIUS);
		lineSeven.setAngle(LINE_SEVEN_ANGLE);
		lineSeven.setColor(Color.WHITE);
		lineSeven.setStroke(new BasicStroke(2.0F));
		
		lineEight = new ALineModel();
		lineEight.setX(LINE_ONE_X);
		lineEight.setY(LINE_ONE_Y);
		lineEight.setRadius(LINE_ONE_RADIUS);
		lineEight.setAngle(LINE_EIGHT_ANGLE);
		lineEight.setColor(Color.WHITE);
		lineEight.setStroke(new BasicStroke(2.0F));
		
	}
	
	public OEShapeModel getCircle() {
		return circle;
	}
	
	public OEShapeModel getLineOne() {
		return lineOne;
	}
	
	public OEShapeModel getLineTwo() {
		return lineTwo;
	}
	
	public OEShapeModel getLineThree() {
		return lineThree;
	}
	
	public OEShapeModel getLineFour() {
		return lineFour;
	}
	
	public OEShapeModel getLineFive() {
		return lineFive;
	}
	
	public OEShapeModel getLineSix() {
		return lineSix;
	}
	
	public OEShapeModel getLineSeven() {
		return lineSeven;
	}
	
	public OEShapeModel getLineEight() {
		return lineEight;
	}
	
	public void move(int newX, int newY) {
		circle.setX(circle.getX()+newX);
		circle.setY(circle.getY()+newY);
		
		lineOne.setX(lineOne.getX()+newX);
		lineOne.setY(lineOne.getY()+newY);
		
		lineTwo.setX(lineTwo.getX()+newX);
		lineTwo.setY(lineTwo.getY()+newY);
		
		lineThree.setX(lineThree.getX()+newX);
		lineThree.setY(lineThree.getY()+newY);
		
		lineFour.setX(lineFour.getX()+newX);
		lineFour.setY(lineFour.getY()+newY);
		
		lineFive.setX(lineFive.getX()+newX);
		lineFive.setY(lineFive.getY()+newY);
		
		lineSix.setX(lineSix.getX()+newX);
		lineSix.setY(lineSix.getY()+newY);
		
		lineSeven.setX(lineSeven.getX()+newX);
		lineSeven.setY(lineSeven.getY()+newY);
		
		lineEight.setX(lineEight.getX()+newX);
		lineEight.setY(lineEight.getY()+newY);
		
		
	}
	
	public static void main(String[] args) {
		final BoundedBuffer buffer = new ABoundedBuffer();
		OEFrame editor = ObjectEditor.edit(buffer);
		editor.showDrawPanel();
	}

}
