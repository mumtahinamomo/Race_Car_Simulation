package main;
/**
 *It represents a pit stop where race cars and Formula One cars can enter, exit, and be repaired.
 */
public class PitStop {
    private int[] raceCarsInPitStop; 
    private int[] formulaOnesInPitStop;
    /**
     * Constructs a PitStop object with arrays to track race cars and Formula One cars in the pit stop.
     */
    public PitStop() {
      raceCarsInPitStop = new int[10];
      formulaOnesInPitStop = new int[10];
    }
    /**
     * Enters a race car into the pit stop and updates its location and damage status.
     * @param raceCar The race car to enter into the pit stop.
     * @param iRaceCar Index of the race car in the pit stop array.
     * @param locationPitStop The location within the pit stop where the race car enters.
     */
	public void enterPitStop(RaceCar raceCar, int iRaceCar, int locationPitStop) { 
	  raceCarsInPitStop[iRaceCar]++;
	  raceCar.setLocation(locationPitStop);
	  raceCar.setDamaged(false);// Repair any damage to the race car
	}
	
	 /**
     * Enters a Formula One car into the pit stop, updating its location and damage status.
     * @param formulaOne The Formula One car to enter into the pit stop.
     * @param iFormulaOne Index of the Formula One car in the pit stop array.
     * @param locationPitStop The location within the pit stop where the Formula One car enters.
     */
	public void enterPitStop(FormulaOne formulaOne, int iFormulaOne, int locationPitStop) {
      formulaOnesInPitStop[iFormulaOne]++;
      formulaOne.setLocation(locationPitStop);
      formulaOne.setDamaged(false); // Repair any damage to the Formula One car
    }
	 /**
     * Moves the tick for a race car in the pit stop.
     * @param raceCar The race car whose tick is being moved.
     * @param iRaceCar Index of the race car in the pit stop array.
     */
	public void moveTickPitStop(RaceCar raceCar, int iRaceCar) { 
      raceCarsInPitStop[iRaceCar]++;
    }
    
	 
    /**
     * Moves the tick for a Formula One car in the pit stop.
     * @param formulaOne The Formula One car whose tick is being moved.
     * @param iFormulaOne Index of the Formula One car in the pit stop array.
     */
    public void moveTickPitStop(FormulaOne formulaOne, int iFormulaOne) {
      formulaOnesInPitStop[iFormulaOne]++;
    }
    
    /**
     * Exits a race car from the pit stop, updating its count in the pit stop array.
     * @param raceCar The race car to exit from the pit stop.
     * @param iRaceCar Index of the race car in the pit stop array.
     */
	public void exitPitStop(RaceCar raceCar, int iRaceCar) { 
      raceCarsInPitStop[iRaceCar] = 0; // Reset count of race cars in the pit stop
    }
	
	/**
     * Exits a Formula One car from the pit stop, updating its count in the pit stop array.
     * @param formulaOne The Formula One car to exit from the pit stop.
     * @param iFormulaOne Index of the Formula One car in the pit stop array.
     */
    public void exitPitStop(FormulaOne formulaOne, int iFormulaOne) { 
      formulaOnesInPitStop[iFormulaOne] = 0; // Reset count of Formula One cars in the pit stop
    }
    
    
    /**
     * Returns the array tracking the number of race cars in the pit stop.
     * @return The array of race cars in the pit stop.
     */
    public int[] getRaceCarsInPitStop() {
      return raceCarsInPitStop;
    }
    
    /**
     * Returns the array tracking the number of Formula One cars in the pit stop.
     * @return The array of Formula One cars in the pit stop.
     */
    public int[] getFormulaOnesInPitStop() {
      return formulaOnesInPitStop;
    }
}
