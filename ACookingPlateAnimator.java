package animations;

import graphics.Plate;
import util.misc.ThreadSupport;

public class ACookingPlateAnimator implements CookingPlateAnimator {
	
	public ACookingPlateAnimator() {
		
	}
	
	public void cook(Plate plate, int size, int pause) {
		plate.getPlate().setWidth(0);
		plate.getPlate().setHeight(0);
		int increment = 0;
		while (increment <= size) {
			plate.getPlate().setHeight(increment);
			plate.getPlate().setWidth(increment);
			ThreadSupport.sleep(pause);
			increment++;
		}
		
		ThreadSupport.sleep(10000);
	}
	
	public void eat(Plate plate, int size, int pause) {
		ThreadSupport.sleep(4000);
		int increment = 40;
		while (increment != 0) {
			plate.getPlate().setHeight(increment);
			plate.getPlate().setWidth(increment);
			ThreadSupport.sleep(pause);
			increment--;
		}
	}

}
