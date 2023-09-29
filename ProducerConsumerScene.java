package graphics;

import java.util.List;
import java.util.Queue;

import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;

public interface ProducerConsumerScene {
	public List<AChef> getChefList();
	public List<APatron> getPatronList();
	public List<APlate> getPlateList();
	public Queue<APlate> getOtherPlateList();
	public BoundedBuffer getBuffer();
	public Queue<ABell> getQueueBellList();
	public void initScene(int patronAmount, int chefAmount);
	public void cook(OEShapeModel head);
	public void serve();
	public boolean checkIfFull();
	public void changeLineColors(int workingPlatePlace);
	public void resetLineColors();
	public int findPatron(OEShapeModel patronHead);
	public List<ABell> getBellsList();
	public int findBell(int centerY);
	public void order(OEShapeModel bell);
	public int findFirstAvailablePlate();
	public void resetBuffer();
}
