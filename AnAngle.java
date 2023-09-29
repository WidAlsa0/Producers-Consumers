package graphics;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.OEShapeModel;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.misc.ThreadSupport;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"left",
	"right"
})
@EditablePropertyNames({
	
})
public class AnAngle implements Angle {

	int init_left = 2;
	int init_right = 1;
	int init_radius = 60;
	OEShapeModel left;
	OEShapeModel right;
	
	public AnAngle() {
		left = new ALineModel();
		right = new ALineModel();
		left.setRadius(init_radius);
		right.setRadius(init_radius);
		left.setAngle(init_left);
		right.setAngle(init_right);
		left.setX(50);
		left.setY(50);
		right.setX(50);
		right.setY(50);
	}
	
	@Override
	public OEShapeModel getLeft() {
		return left;
	}
	
	@Override
	public OEShapeModel getRight() {
		return right;
	}
	
	@Override
	public void moveTo(int newX, int newY) {
		right.setX(newX);
		right.setY(newY);
		left.setX(newX);
		left.setY(newY);
		
	}
	
	public void animateLegs(OEShapeModel leg) {
//		AngleAnimator animator = new AnAngleAnimator();
//		AnAngleCommand command = new AnAngleCommand(animator, leg, 4, 500, 500);
//		Thread thread = new Thread (command);
//		thread.start();
	}
	
	public static void main(String[] args) {
		final AnAngle legs = new AnAngle();
		OEFrame editor = ObjectEditor.edit(legs);
		editor.showDrawPanel();
	}

}
