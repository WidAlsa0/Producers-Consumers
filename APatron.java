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
	"patron",
	"table"
})
@EditablePropertyNames({
})
public class APatron implements Patron {
	Avatar patron;
	Table table;
	
	int INIT_X_OFFSET = 10;
	int INIT_Y_OFFSET = 25;
	
	public APatron() {
		patron = new AnAvatar();
		table = new ATable();
		table.move(INIT_X_OFFSET, INIT_Y_OFFSET);
	}
	
	public Avatar getPatron() {
		return patron;
	}
	
	public Table getTable() {
		return table;
	}
	
	public void move(int newX, int newY) {
		patron.move(newX, newY);
		table.move(newX, newY);
	}
	
	public static void main(String[] args) {
		final Patron thisPatron = new APatron();
		OEFrame editor = ObjectEditor.edit(thisPatron);
		editor.getDrawComponent().setBackground(Color.DARK_GRAY);
		editor.showDrawPanel();
	}

}
