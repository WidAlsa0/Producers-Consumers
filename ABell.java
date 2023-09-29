package graphics;

import java.awt.Color;

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
	"bell",
	"text"
})
@EditablePropertyNames({
	"bell",
	"text"
})
public class ABell implements Bell {
	int INIT_BELL_HEIGHT = 25;
	int INIT_BELL_WIDTH = 25;
	int INIT_BELL_X = 50;
	int INIT_BELL_Y = 40;

	String INIT_BELL_IMAGE = "images/bell.png";
	String INIT_BELL_TEXT = "";
	
	int INIT_TEXT_X = 65;
	int INIT_TEXT_Y = 40;

	int TEXT_X_OFFSET = 45;
	int TEXT_Y_OFFSET = 30;
	
	OEShapeModel bell;
	FlexibleTextShape text;
	
	public ABell() {
		bell = new AnImageModel(INIT_BELL_IMAGE);
		bell.setHeight(INIT_BELL_HEIGHT);
		bell.setWidth(INIT_BELL_WIDTH);
		bell.setX(INIT_BELL_X);
		bell.setY(INIT_BELL_Y);
		
		text = new AStringModel(INIT_BELL_TEXT);
		text.setX(INIT_TEXT_X);
		text.setY(INIT_TEXT_Y);
		text.setColor(Color.WHITE);
	}
	
	@Override
	public OEShapeModel getBell() {
		return bell;
	}
	
	@Override
	public FlexibleTextShape getText() {
		return text;
	}
	
	@Override
	public void setBell(OEShapeModel newBell) {
		bell = newBell;
	}
	
	@Override
	public void setText(FlexibleTextShape newText) {
		text = newText;
	}
	
	@Override
	public void move(int newX, int newY) {
		bell.setX(bell.getX() + newX);
		bell.setY(bell.getY() + newY);
		text.setX(text.getX() + newX);
		text.setY(text.getY() + newY);
	}
	
	@Override
	public void moveTo(int newX, int newY) {
		bell.setX(newX);
		bell.setY(newY);
		text.setX(newX+TEXT_X_OFFSET);
		text.setY(newY+TEXT_Y_OFFSET);
	}
	
	
}
