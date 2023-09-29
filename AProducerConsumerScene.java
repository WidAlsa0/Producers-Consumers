package graphics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import animations.ACookingPlateAnimator;
import animations.ACookingPlateCommand;
import animations.AServingPlateAnimator;
import animations.AServingPlateCommand;
import animations.CookingPlateAnimator;
import animations.ServingPlateAnimator;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.AStringModel;
import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;
import util.annotations.EditablePropertyNames;
import util.annotations.Label;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
import util.misc.ThreadSupport;

import java.awt.Color;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"patronList",
	"chefList",
	"buffer",
	"plateList",
	"otherPlateList",
	"bellsList",
	"queueBellList"
})
@EditablePropertyNames({
})
public class AProducerConsumerScene implements ProducerConsumerScene {
	
	//Avatar offsets inside scene
	int[] chefXValues = {120,-50,-50,120};
	int[] chefYValues = {-50,35,210,320};
	int[] patronXValues = {650,850,850,650};
	int[] patronYValues = {-50,35,220,320};
	int[] bellXValues = {680,880,880,680};
	int[] bellYValues = {75,160,345,445};
	int INIT_HEAD_Y = 60;
	int INIT_HEAD_X = 163;
	int INIT_HEAD_HEIGHT = 90;
	int INIT_HEAD_WIDTH = 80;
	int PLATE_OFFSET_X = 30;
	int PLATE_OFFSET_Y = 10;
	int PAUSE = 5;
	
	//Booleans that help with the functionality of the below methods
	boolean INIT_COOK = true;
	boolean full = false;
	int fullPlateOffset = -5;
	
	//Defining the chef and patron images
	String[] chefImages = {"images/0.png","images/1.png","images/2.png","images/3.png"};
	String[] patronImages = {"images/4.png", "images/5.png", "images/6.png", "images/7.png"};
	
	//Buffer arrays
	int[] bufferXValues = {625, 680, 680, 620, 535, 460, 460, 535};
	int[] bufferYValues = {200, 275, 365, 425, 425, 365, 275, 200};
	boolean[] isFull = {false, false, false, false, false, false, false, false};
	
	//The properties of our class
	List<APatron> patronList;
	List<AChef> chefList;
	BoundedBuffer buffer = new ABoundedBuffer();
	List<APlate> plateList;
	Queue<APlate> otherPlateList;
	
	OEShapeModel[] lineArray = {buffer.getLineTwo(), buffer.getLineThree(), buffer.getLineFour(), 
								buffer.getLineFive(), buffer.getLineSix(), buffer.getLineSeven(), 
								buffer.getLineEight(), buffer.getLineOne()};
	
	List<ABell> bellsList;
	Queue<ABell> queueBellList;
	int[] bellValues = {127, 212, 397, 497};
	Queue<Integer> bellIntegerList;
	
	ACookingPlateCommand cookingCommand;
	CookingPlateAnimator cookingAnimator;
	
	AServingPlateCommand servingCommand;
	ServingPlateAnimator servingAnimator;
	
	//The constructor sets the scene with one chef, patron, a buffer, and a plate (not visible)
	public AProducerConsumerScene() {
		patronList = new ArrayList<APatron>();
		chefList = new ArrayList<AChef>();
		//buffer = new ABoundedBuffer();
		plateList = new ArrayList<APlate>();
		otherPlateList = new LinkedList<APlate>();
		bellsList = new ArrayList<ABell>();
		queueBellList = new LinkedList<ABell>();
		bellIntegerList = new LinkedList<Integer>();
		
		patronList.add(0, new APatron());
		OEShapeModel initPatronHead = new AnImageModel(patronImages[0]);
		initPatronHead.setX(INIT_HEAD_X);
		initPatronHead.setY(INIT_HEAD_Y);
		initPatronHead.setHeight(INIT_HEAD_HEIGHT);
		initPatronHead.setWidth(INIT_HEAD_WIDTH);
		patronList.get(0).patron.setHead(initPatronHead);
		patronList.get(0).move(patronXValues[0], patronYValues[0]);
		
		chefList.add(0, new AChef());
		OEShapeModel initChefHead = new AnImageModel(chefImages[0]);
		initChefHead.setX(INIT_HEAD_X);
		initChefHead.setY(INIT_HEAD_Y);
		initChefHead.setHeight(INIT_HEAD_HEIGHT);
		initChefHead.setWidth(INIT_HEAD_WIDTH);
		chefList.get(0).chef.setHead(initChefHead);
		chefList.get(0).move(chefXValues[0], chefYValues[0]);
		
		plateList.add(new APlate());
		plateList.get(0).getPlate().setHeight(0);
		plateList.get(0).getPlate().setWidth(0);
		
		otherPlateList.add(new APlate());
		otherPlateList.peek().getPlate().setHeight(0);
		otherPlateList.peek().getPlate().setWidth(0);
		
		cookingAnimator = new ACookingPlateAnimator();
		servingAnimator = new AServingPlateAnimator();
		
		bellsList.add(new ABell());
		bellsList.get(0).getBell().setHeight(0);
		bellsList.get(0).getBell().setWidth(0);
		
		queueBellList.add(new ABell());
		queueBellList.peek().getBell().setHeight(0);
		queueBellList.peek().getBell().setWidth(0);
		
		bellIntegerList.add(0);
	}
	
	//Producer consumer methods
	
	//Init Scene sets the number of patrons and chefs in the scene
	@Label("Init Scene")
	public void initScene(int patronAmount, int chefAmount) {
		bellsList.clear();
		for (int i=0; i<patronAmount; i++) { 
			APatron patron = new APatron();
			patronList.add(i, patron);
			OEShapeModel newHead = new AnImageModel(patronImages[i]);
			patron.patron.setHead(newHead); 
			newHead.setX(INIT_HEAD_X); 
			newHead.setY(INIT_HEAD_Y);
			newHead.setHeight(INIT_HEAD_HEIGHT);
			newHead.setWidth(INIT_HEAD_WIDTH);
			patron.move(patronXValues[i], patronYValues[i]);
			
			bellsList.add(new ABell());
			bellsList.get(i).move(bellXValues[i], bellYValues[i]);
		}
		for (int i=0; i<chefAmount; i++) {
			AChef chef = new AChef();
			chefList.add(i, chef);
			OEShapeModel newHead = new AnImageModel(chefImages[i]);
			chef.chef.setHead(newHead);
			newHead.setX(INIT_HEAD_X); 
			newHead.setY(INIT_HEAD_Y);
			newHead.setHeight(INIT_HEAD_HEIGHT);
			newHead.setWidth(INIT_HEAD_WIDTH);
			chef.move(chefXValues[i], chefYValues[i]);
		}
	}
	
	//Once the head of an avatar is chosen, it makes the plate that they "cook" appear
	public void cook(OEShapeModel head) {
		if (INIT_COOK) {
			INIT_COOK=!INIT_COOK;
			plateList.remove(0);
			otherPlateList.remove();
		}
		
		int headX = head.getCenterX();
		int headY = head.getCenterY();
		APlate newPlate = new APlate(plateList.size()+1);
		newPlate.getPlate().setHeight(0);
		newPlate.getPlate().setWidth(0);
		plateList.add(newPlate);
		otherPlateList.add(newPlate);
		
		if (full) {
			newPlate.move(headX+PLATE_OFFSET_X, headY+PLATE_OFFSET_Y+fullPlateOffset);
			fullPlateOffset = fullPlateOffset - 5;
		} else {
			newPlate.move(headX+PLATE_OFFSET_X, headY+PLATE_OFFSET_Y);
		}
		
		cookingCommand = new ACookingPlateCommand(cookingAnimator, newPlate, 40, 15);
		Thread thread = new Thread (cookingCommand);
		thread.start();
	}
	
	public void serve() {
		//Checks to see if the buffer is full. If it is, then can't serve.
		resetLineColors();
		if(checkIfFull()) {
			resetLineColors();
			return;
		}
		
		//Do put, it will disable from there
		
		Plate workingPlate = otherPlateList.peek();
		int workingPlatePlace = Integer.valueOf(workingPlate.getText().getText())-1;
		changeLineColors(workingPlatePlace);
		
		servingCommand = new AServingPlateCommand(servingAnimator,workingPlate,PAUSE, bufferXValues[workingPlatePlace], bufferYValues[workingPlatePlace]);
		Thread thread = new Thread(servingCommand);
		thread.start();
		
		isFull[workingPlatePlace] = true;
		otherPlateList.remove();
	}
	
	public void order(OEShapeModel bell) {
		if(checkIfFull()) {
			resetLineColors();
			resetBuffer();
		}
		bellIntegerList.add(0);
		int bellPlace = findBell(bell.getCenterY());
		bellsList.get(bellPlace).getText().setText(String.valueOf(bellIntegerList.size()-1));
		
		int platePlace = findFirstAvailablePlate();
		servingCommand = new AServingPlateCommand(servingAnimator,plateList.get(platePlace),PAUSE, bell.getCenterX() , bell.getCenterY());
		Thread thread = new Thread(servingCommand);
		thread.start();
		
		cookingCommand = new ACookingPlateCommand(cookingAnimator, plateList.get(0), 0, 15);
		Thread eatingThread = new Thread (cookingCommand);
		eatingThread.start();
		plateList.get(0).getText().setText("");
	}
	
	public void eat() {
		plateList.remove(0);
	}
	
	@Override
	@Visible(false)
	public int findBell(int centerY) {
		for(int i=0; i<bellsList.size();i++) {
			if(bellsList.get(i).getBell().getCenterY() == centerY) {
				return i;
			}
		}
		return 0;
	}
	
	@Override
	@Visible(false)
	public int findFirstAvailablePlate() {
		for (int i=0; i<isFull.length;i++) {
			if(isFull[i] == true) {
				return i;
			}
		}
		return 0;
	}
	
	@Override
	@Visible(false)
	public void resetBuffer() {
		
		for (int i=0; i<isFull.length;i++) {
			isFull[i] = false;
		}
	}
	
	@Override
	@Visible(false)
	public int findPatron(OEShapeModel patronHead) {
		return 0;
	}
	
	@Override
	@Visible(false)
	public boolean checkIfFull() {
		for (int i=0; i<isFull.length;i++) {
			if (isFull[i] == false) {
				full = false;
				return full;
			}
		}
		full = true;
		return full;
	}
	
	@Override
	@Visible(false)
	public void changeLineColors(int workingPlatePlace) {
		if(workingPlatePlace == lineArray.length-1) {
			lineArray[workingPlatePlace].setColor(Color.GREEN);
			lineArray[0].setColor(Color.GREEN);
		} else {
			lineArray[workingPlatePlace].setColor(Color.GREEN);
			lineArray[workingPlatePlace+1].setColor(Color.GREEN);
		}
	}
	
	
	@Override
	@Visible(false)
	public void resetLineColors() {
		for (int i=0; i<lineArray.length; i++) {
			lineArray[i].setColor(Color.WHITE);
		}
	}
	
	//Getters for properties of the scene
	@Override
	public List<AChef> getChefList() {
		return chefList;
	}
	
	@Override
	public List<APatron> getPatronList() {
		return patronList;
	}
	
	@Override
	public BoundedBuffer getBuffer() {
		return buffer;
	}
	
	@Override
	public List<APlate> getPlateList() {
		return plateList;
	}	
	
	@Override
	@util.annotations.Visible(false)
	public Queue<APlate> getOtherPlateList() {
		return otherPlateList;
	}
	
	@Override
	public List<ABell> getBellsList() {
		return bellsList;
	}
	
	@Override
	@Visible(false)
	public Queue<ABell> getQueueBellList() {
		return queueBellList;
	}
}
