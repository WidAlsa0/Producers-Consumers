package graphics;

import java.awt.Color;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.shapes.AStringModel;
import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"plate",
	"text"
})
@EditablePropertyNames({
	"plate",
	"text"
})
public class APlate implements Plate {
	
	String INIT_PLATE_STRING = "images/12.png";
	int INIT_PLATE_X = 50;
	int INIT_PLATE_Y = 40;
	int INIT_PLATE_HEIGHT = 50;
	int INIT_PLATE_WIDTH = 40;
	
	String INIT_PLATE_TEXT = "";
	int INIT_TEXT_X = 95;
	int INIT_TEXT_Y = 70;
	
	int TEXT_X_OFFSET = 45;
	int TEXT_Y_OFFSET = 30;
	
	OEShapeModel plate;
	FlexibleTextShape text;
	
	
	public APlate() {
		plate = new AnImageModel(INIT_PLATE_STRING);
		text = new AStringModel(INIT_PLATE_TEXT);
		text.setX(INIT_TEXT_X);
		text.setY(INIT_TEXT_Y);
		text.setColor(Color.WHITE);
		
		plate.setX(INIT_PLATE_X);
		plate.setY(INIT_PLATE_Y);
		plate.setHeight(INIT_PLATE_HEIGHT);
		plate.setWidth(INIT_PLATE_WIDTH);
		
	}
	
	public APlate(int queue) {
		plate = new AnImageModel(INIT_PLATE_STRING);
		text = new AStringModel(String.valueOf(queue));
		text.setX(INIT_TEXT_X);
		text.setY(INIT_TEXT_Y);
		text.setColor(Color.WHITE);
		
		plate.setX(INIT_PLATE_X);
		plate.setY(INIT_PLATE_Y);
		plate.setHeight(INIT_PLATE_HEIGHT);
		plate.setWidth(INIT_PLATE_WIDTH);
	}
	
	@Override
	public OEShapeModel getPlate() {
		return plate;
	}
	
	@Override
	public FlexibleTextShape getText() {
		return text;
	}
	
	@Override
	public void setText(FlexibleTextShape newString) {
		text = newString;
	}
	
	@Override
	public void setPlate(OEShapeModel newPlate) {
		plate = newPlate;
	}
	
	@Override
	public void move(int newX, int newY) {
		plate.setX(plate.getX() + newX);
		plate.setY(plate.getY() + newY);
		text.setX(text.getX() + newX);
		text.setY(text.getY() + newY);
	}
	
	@Override
	public void moveTo(int newX, int newY) {
		plate.setX(newX);
		plate.setY(newY);
		text.setX(newX+TEXT_X_OFFSET);
		text.setY(newY+TEXT_Y_OFFSET);
	}
	
	public static void main(String[] args) {
		final Plate plate = new APlate();
		OEFrame editor = ObjectEditor.edit(plate);
		editor.getDrawComponent().setBackground(Color.DARK_GRAY);
		editor.showDrawPanel();
	}

}
