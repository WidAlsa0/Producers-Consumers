package animations;

import graphics.Plate;

public class AServingPlateCommand implements Runnable {
	
	ServingPlateAnimator animator;
	Plate plate;
	int x;
	int y;
	int pause;
	
	public AServingPlateCommand(ServingPlateAnimator thisAnimator, Plate thisPlate, int thisPause, int newX, int newY) {
		animator = thisAnimator;
		plate = thisPlate;
		pause = thisPause;
		x = newX;
		y = newY;
	}

	@Override
	public void run() {
		animator.animateServingPlate(plate, pause, x, y);
	}

}
