package main;
/**
 *It represents the finish line in a race track, where race cars and Formula One cars complete the race.
 */
public class FinishLine {
    private RaceCar[] racecars;
    private FormulaOne[]  formulaOnes;
   
    /**
     * Constructs a FinishLine object with the provided arrays of race cars and Formula One cars.
     * @param racecars Array of race cars participating in the race.
     * @param formulaOnes Array of Formula One cars participating in the race.
     */
    public FinishLine(RaceCar[] racecars, FormulaOne[] formulaOnes) {
      this.racecars = racecars;
      this.formulaOnes = formulaOnes;
    }
    
    /**
     * Marks the specified race car as finished when it crosses the finish line.
     * @param racecar The race car crossing the finish line.
     */
	public void enterFinishLine(RaceCar racecar) {
	  racecar.setFinished(true);  // Set the finished status of the race car to true
	}
	
	/**
     * Marks the specified Formula One car as finished when it crosses the finish line.
     * @param formulaOne The Formula One car crossing the finish line.
     */
	public void enterFinishLine(FormulaOne formulaOne) {
	
	  formulaOne.setFinished(true); // Set the finished status of the Formula One car to true
    }
	
	/**
     * Checks if all participating cars have finished the race.
     * @return True if all cars have finished the race, otherwise False.
     */
	public boolean finished() {
	  int count = 0;
	// Count the number of finished race cars
	  for (int i = 0; i < racecars.length; i++) {
	    if (this.racecars[i].getFinished()) {
	      count++;
	    }
	  }
	  
	  // Count the number of finished Formula One cars
	  for (int i = 0; i < formulaOnes.length; i++) {
        if (this.formulaOnes[i].getFinished()) {
          count++;
        }
      }
	  
	  // Check if the count of finished cars matches the total number of cars participating in the race
	  return count == formulaOnes.length + racecars.length;
	}
}

