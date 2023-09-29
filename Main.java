package main;

import java.awt.Color;
import java.lang.reflect.Method;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.attributes.AttributeNames;
import graphics.AProducerConsumerScene;
import graphics.AProducerConsumerScene2;
import graphics.ProducerConsumerScene;
import graphics.ProducerConsumerScene2;

public class Main {
	static ProducerConsumerScene2 scene = new AProducerConsumerScene2();
	
	public static void main(String[] args) {
		animateScene();
	}
	
	public static void animateScene() {
		
		//Adding labels and buttons inside object editor screen
		ObjectEditor.confirmSelectedMethodParameters(false);
		ObjectEditor.setMethodAttribute(AProducerConsumerScene2.class, "initScene", AttributeNames.TOOLBAR_METHOD, true);
		ObjectEditor.setMethodAttribute(AProducerConsumerScene2.class, "initScene", AttributeNames.LABEL, "Init Scene");
		
		//Setting up init scene method in object editor
		try {
			Class[] initSceneArgTypes = {Integer.TYPE, Integer.TYPE};
			Object[] initSceneDefaultArgs = {4, 4};
			String[] initSceneArgNames = {"Number of Patrons", "Number of Chefs"};
			Method initSceneMethod = AProducerConsumerScene2.class.getMethod("initScene", initSceneArgTypes);
			ObjectEditor.registerDefaultParameterValues(initSceneMethod, initSceneDefaultArgs);
			ObjectEditor.registerParameterNames(initSceneMethod, initSceneArgNames);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
		OEFrame editor = ObjectEditor.edit(scene);
		editor.getDrawComponent().setBackground(Color.DARK_GRAY);
		editor.getDrawPanel().setSize(450, 450);
		editor.showDrawPanel();
		
	}

}
