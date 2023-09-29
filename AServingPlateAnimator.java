package animations;

import graphics.Plate;
import util.misc.ThreadSupport;

public class AServingPlateAnimator implements ServingPlateAnimator {
	int TEXT_X_OFFSET = 45;
	int TEXT_Y_OFFSET = 30;

	public AServingPlateAnimator() {
		
	}
	
	public void animateServingPlate(Plate aPlate, int pauseTime, int destX, int destY) {
		boolean alt = false;
		
		if (aPlate.getPlate().getY() < destY) {
			
			while (aPlate.getPlate().getX()!=destX || aPlate.getPlate().getY()!=destY) {
				
				if (aPlate.getPlate().getX()!=destX) {
					aPlate.getPlate().setX(aPlate.getPlate().getX()+1);
					aPlate.getText().setX(aPlate.getText().getX()+1);
				}
				
				if (aPlate.getPlate().getY()!=destY && alt == true) {
					aPlate.getPlate().setY(aPlate.getPlate().getY()+1);
					aPlate.getText().setY(aPlate.getText().getY()+1);
				}
				
				ThreadSupport.sleep(pauseTime);
				alt = !alt;
			}
			
		} else {
			
			while (aPlate.getPlate().getX()!=destX || aPlate.getPlate().getY()!=destY) {
				
				if (aPlate.getPlate().getX()!=destX) {
					aPlate.getPlate().setX(aPlate.getPlate().getX()+1);
					aPlate.getText().setX(aPlate.getText().getX()+1);
				}
				
				if (aPlate.getPlate().getY()!=destY && alt == true) {
					aPlate.getPlate().setY(aPlate.getPlate().getY()-1);
					aPlate.getText().setY(aPlate.getText().getY()-1);
				}
				
				ThreadSupport.sleep(pauseTime);
				alt = !alt;
			}
			
		}

		
	}

}
