package main;
/**
 * This class represents a race car with specific speed and strength attributes.
 * It can move, get damaged, and keep track of its location and status in a race.
 */
public class RaceCar {
	 private int speed;
	 private int strength;
	 private int location;
	 private boolean isDamaged; 
	 private boolean isFinished;
	 private final int DAMAGED_SPEED; //speed of the car when it is damaged

	    /**
	     * Constructs a RaceCar with the specified speed and strength.
	     * @param speed The speed of the race car (between 30 and 55).
	     * @param strength The strength of the race car (between 2 and 4).
	     */
    public RaceCar(int speed, int strength) {
        this.speed = checkSpeed(speed);
        this.strength = checkStrength(strength);
        this.location = 0;
        this.isDamaged = false;
        this.isFinished = false;
        this.DAMAGED_SPEED = calculateDamagedSpeed();
    }
    /**
     * Validates and returns the speed within the allowed range.
     * @param speed The input speed.
     * @return The valid speed between 30 and 55.
     */
    private int checkSpeed(int speed) {
        if (speed > 55) {
            return 55;
        } else if (speed < 30) {
            return 30;
        } else {
            return speed;
        }
    }
    /**
     * Validates and returns the strength within the allowed range.
     * @param strength The input strength.
     * @return The valid strength between 2 and 4.
     */
    private int checkStrength(int strength) {
        if (strength > 4) {
            return 4;
        } else if (strength < 2) {
            return 2;
        } else {
            return strength;
        }
    }
    /**
     * Calculates and returns the speed of the car when it is damaged.
     * @return The speed when the car is damaged.
     */
    private int calculateDamagedSpeed() {
        return this.speed - (this.strength * 5);
    }

    /**
     * Constructs a RaceCar with default attributes.
     */
	public RaceCar() {
	  this.speed = 40; //Default speed is 40
	  this.strength = 3; //Default strength is 3
	  DAMAGED_SPEED = this.speed - (strength * 5);
	  location = 0;
	  isFinished = false;
	  isDamaged = false;
	}
	
	

    /**
     * Sets the damaged status of the race car.
     * @param isDamaged True if the car is damaged, otherwise returns false.
     */
	public void setDamaged(boolean isDamaged) {
	  this.isDamaged = isDamaged;
	}
	
	 /**
     * Returns the damaged status of the race car.
     * @return True if the car is damaged, otherwise returns false.
     */
	public boolean getDamaged() {
      return this.isDamaged;
    }
	
	/**
     * Returns the current location of the race car.
     * @return The current location.
     */
	public double getLocation() {
		return this.location;
	}
	
	  /**
     * Moves the race car forward in the race. If the car is damaged, it moves at a reduced speed.
     */
	public void move() {
		  if (isDamaged) {
		    this.location += DAMAGED_SPEED;
		    }
		  else {
		    this.location += this.speed;
		  }
		}
	
	/**
     * Sets the location of the race car.
     * @param location The new location of the car in the race.
     */
	public void setLocation(int location) {
      this.location = location;
    }
	

    /**
     * Sets the finished status of the race car.
     * @param isFinished True if the car has finished the race, otherwise False.
     */
	public void setFinished(boolean isFinished) {
	  this.isFinished = isFinished;
	}
	
	/**
     * Returns the finished status of the race car.
     * @return True if the car has finished the race, otherwise False.
     */
	public boolean getFinished() {
      return this.isFinished;
    }
	
	 /**
     * Returns a string representation of the race car.
     * @return A string in the format "RaceCar[speed]/[strength]".
     */
	public String toString() {
		return "RaceCar" + this.speed + "/" + this.strength;
	}
}
