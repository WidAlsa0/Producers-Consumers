package graphics;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.AStringModel;
import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;


@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"arms",
	"legs",
	"torso",
	"head",
	"text"
})
@EditablePropertyNames({
	"arms",
	"legs",
	"torso",
	"head",
	"text"
})
public class AnAvatar implements Avatar {
	int INIT_X = 200;	
	int INIT_ARMS_Y = 150;
	int INIT_LEGS_Y = 190;
	int INIT_TORSO_Y = 150;
	double INIT_TORSO_ANGLE = (Math.PI/2);
	int INIT_TORSO_RADIUS = 40;
	int INIT_HEAD_Y = 60;
	int INIT_HEAD_X = 163;
	int INIT_HEAD_HEIGHT = 90;
	int INIT_HEAD_WIDTH = 80;
	String INIT_HEAD_STRING = "";
//	int INIT_PLATE_X = 50;
//	int INIT_PLATE_Y = 40;
//	int INIT_PLATE_HEIGHT = 50;
//	int INIT_PLATE_WIDTH = 40;
//	String INIT_PLATE_STRING = "images/12.png";
	int INIT_TEXT_X = 130;
	int INIT_TEXT_Y = 80;
	String INIT_TEXT_STRING = "";
	int TABLE_OFFSET_X = 18;
	int TABLE_OFFSET_Y = 25;
	
	Angle arms;
	Angle legs;
	OEShapeModel torso;
	OEShapeModel head;
	FlexibleTextShape text;
//	OEShapeModel plate;
//	Table table;

	public AnAvatar() {
		arms = new AnAngle();
		arms.moveTo(INIT_X, INIT_ARMS_Y);
		arms.getLeft().setColor(Color.WHITE);
		arms.getRight().setColor(Color.WHITE);
		arms.getLeft().setStroke(new BasicStroke(4.0F));
		arms.getRight().setStroke(new BasicStroke(4.0F));
		
		legs = new AnAngle();
		legs.moveTo(INIT_X, INIT_LEGS_Y);
		legs.getLeft().setColor(Color.WHITE);
		legs.getRight().setColor(Color.WHITE);
		legs.getLeft().setStroke(new BasicStroke(4.0F));
		legs.getRight().setStroke(new BasicStroke(4.0F));
		
		torso = new ALineModel();
		torso.setX(INIT_X);
		torso.setY(INIT_TORSO_Y);
		torso.setRadius(INIT_TORSO_RADIUS);
		torso.setAngle(INIT_TORSO_ANGLE);
		torso.setColor(Color.WHITE);
		torso.setStroke(new BasicStroke(4.0F));
		
		head = new AnImageModel(INIT_HEAD_STRING);
		head.setX(INIT_HEAD_X);
		head.setY(INIT_HEAD_Y);
		head.setHeight(INIT_HEAD_HEIGHT);
		head.setWidth(INIT_HEAD_WIDTH);
		
		text = new AStringModel(INIT_TEXT_STRING);
		text.setX(INIT_TEXT_X);
		text.setY(INIT_TEXT_Y);
		text.setColor(Color.WHITE);
		text.setText(INIT_TEXT_STRING);
		
//		plate = new AnImageModel(INIT_PLATE_STRING);
//		plate.setX(INIT_PLATE_X);
//		plate.setY(INIT_PLATE_Y);
//		plate.setHeight(INIT_PLATE_HEIGHT);
//		plate.setWidth(INIT_PLATE_WIDTH);
		
//		table = new ATable();
//		table.move(TABLE_OFFSET_X, TABLE_OFFSET_Y);
	}
	
	@Override
	public Angle getArms() {
		return arms;
	}
	
	@Override
	public void setArms(Angle newArms) {
		arms = newArms;
	}
	
	@Override
	public Angle getLegs() {
		return legs;
	}
	
	@Override
	public void setLegs(Angle newLegs) {
		legs = newLegs;
	}
	
	@Override
	public OEShapeModel getTorso() {
		return torso;
	}
	
	@Override
	public void setTorso(OEShapeModel newTorso) {
		torso = newTorso;
	}
	
	@Override
	public OEShapeModel getHead() {
		return head;
	}
	
	@Override
	public void setHead(OEShapeModel newHead) {
		head = newHead;
	}
	
	@Override
	public FlexibleTextShape getText() {
		return text;
	}
	
	@Override
	public void setText(shapes.FlexibleTextShape newText) {
		String input = newText.getText();
		text.setText(input);
	}
	
//	@Override 
//	public OEShapeModel getPlate() {
//		return plate;
//	}
//	
//	@Override
//	public void setPlate(OEShapeModel newPlate) {
//		plate = newPlate;
//	}
	
//	@Override
//	public Table getTable() {
//		return table;
//	}
//	
//	@Override
//	public void setTable(Table newTable) {
//		table = newTable;
//	}
	
	
	
	@Override
	public void move(int newX, int newY) {
		arms.getLeft().setX(arms.getLeft().getX()+newX);
		arms.getLeft().setY(arms.getLeft().getY()+newY);
		arms.getRight().setX(arms.getRight().getX()+newX);
		arms.getRight().setY(arms.getRight().getY()+newY);
		
		legs.getLeft().setX(legs.getLeft().getX()+newX);
		legs.getLeft().setY(legs.getLeft().getY()+newY);
		legs.getRight().setX(legs.getRight().getX()+newX);
		legs.getRight().setY(legs.getRight().getY()+newY);
		
		torso.setX(torso.getX()+newX);
		torso.setY(torso.getY()+newY);
		
		head.setX(head.getX()+newX);
		head.setY(head.getY()+newY);
		
		text.setX(text.getX()+newX);
		text.setY(text.getY()+newY);
	}
	
	public static void main(String[] args) {
		final Avatar avatar = new AnAvatar();
		OEFrame editor = ObjectEditor.edit(avatar);
		editor.getDrawComponent().setBackground(Color.DARK_GRAY);
		editor.showDrawPanel();
	}
	
}
