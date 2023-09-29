package animations;

import graphics.Plate;

public interface CookingPlateAnimator {
	public void cook(Plate plate, int size, int pause);
	public void eat(Plate plate, int size, int pause);
}
