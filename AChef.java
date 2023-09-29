package graphics;

import java.awt.Color;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"chef",
	"table"
})
@EditablePropertyNames({
})
public class AChef implements Chef {
	Avatar chef;
	Table table;
	
	int INIT_X_OFFSET = 200;
	int INIT_Y_OFFSET = 25;
	
	public AChef() {
		chef = new AnAvatar();
		table = new ATable();
		table.move(INIT_X_OFFSET, INIT_Y_OFFSET);
	}
	
	public Avatar getChef() {
		return chef;
	}
	
	public Table getTable() {
		return table;
	}
	
	public void move(int newX, int newY) {
		chef.move(newX, newY);
		table.move(newX, newY);
	}
	
	public static void main(String[] args) {
		final Chef thisChef = new AChef();
		OEFrame editor = ObjectEditor.edit(thisChef);
		editor.getDrawComponent().setBackground(Color.DARK_GRAY);
		editor.showDrawPanel();
	}
	
}
