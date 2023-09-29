package animations;

import graphics.Plate;

public class ACookingPlateCommand implements Runnable {

	CookingPlateAnimator animator;
	Plate plate;
	int size;
	int pause;
	 
	public ACookingPlateCommand(CookingPlateAnimator inAnimator, Plate inPlate, int inSize, int inPause) {
		animator = inAnimator;
		plate = inPlate;
		size = inSize;
		pause = inPause;
	}
	
	@Override
	public void run() {
		if (size>0) {
			animator.cook(plate, size, pause);
		} else {
			animator.eat(plate, size, pause);
		}
	}

}
