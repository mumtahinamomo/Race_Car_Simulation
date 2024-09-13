package main;
/**
 *It represents a Formula One car with attributes such as its speed, strength, location, damage status, and race completion.
 */
public class FormulaOne {
    private int speed;
    private int strength;
    private int location;
    private boolean isDamaged; 
    private boolean isFinished;
    private final int DAMAGED_SPEED; 
    
    /**
     * Constructs a FormulaOne object with the specified speed and strength.
     * @param speed The speed of the Formula One car(between 30 and 70).
     * @param strength The strength of the Formula One car(between 3 and 5).
     */
    public FormulaOne(int speed, int strength) {
        this.speed = checkSpeed(speed);
        this.strength = checkStrength(strength);
        this.isFinished = false;
        this.location = 0;
        this.isDamaged = false;
        this.DAMAGED_SPEED = calculateDamagedSpeed();
    }
    
    /**
     * Validates and returns the speed within the allowed range.
     * @param speed The input speed.
     * @return The valid speed between 30 and 70.
     */
    private int checkSpeed(int speed) {
        if (speed > 70) {
            return 70;
        } else if (speed < 30) {
            return 30;
        } else {
            return speed;
        }
    }
   
    /**
     * Validates and returns the strength within the allowed range.
     * @param strength The input strength.
     * @return The valid strength between 3 and 5.
     */
    private int checkStrength(int strength) {
        if (strength > 5) {
            return 5;
        } else if (strength < 3) {
            return 3;
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
     * Constructs a FormulaOne object with default attributes.
     */
	public FormulaOne() {
      this.speed = 50; //Default speed is 50
      this.strength = 4; //Default strength is 4
      DAMAGED_SPEED = this.speed - (strength * 5);
      location = 0;
      isDamaged = false;
      isFinished = false;
	}
	
	 /**
     * Sets the damaged status of the Formula One car.
     * @param isDamaged True if the car is damaged, false otherwise.
     */
	void setDamaged(boolean isDamaged) {
      this.isDamaged = isDamaged;
    }
    
	/**
     * Returns the damaged status of the Formula One car.
     * @return True if the car is damaged, false otherwise.
     */
	public boolean getDamaged() {
      return isDamaged;
    }
	
	 /**
     * Moves the Formula One car forward in the race. If the car is damaged, it moves at a reduced speed.
     */
	public void move() {
	      if(isDamaged) {
	        this.location += DAMAGED_SPEED;
	      } else {
	        this.location += this.speed;
	      }
	    }
	/**
     * Returns the current location of the car.
     * @return The current location.
     */
	public double getLocation() {
		return this.location;
	}
	
    
	 /**
     * Sets the location of the Formula One car.
     * @param location The new location of the car.
     */
	public void setLocation(int location) {
	  this.location = location;
	}
	

    /**
     * Sets the finished status of the Formula One car.
     * @param isFinished True if the car has finished the race, false otherwise.
     */
	public void setFinished(boolean isFinished) {
	  this.isFinished = isFinished;
	}
	

    /**
     * Returns the finished status of the Formula One car.
     * @return True if the car has finished the race, false otherwise.
     */
	public boolean getFinished() {
      return this.isFinished;
    }
	
	/**
     * Returns a string representation of the Formula One car.
     * @return A string in the format "FormulaOne[speed]/[strength]".
     */
	public String toString() {
	  return "FormulaOne" + this.speed + "/" + this.strength;
	}
}
