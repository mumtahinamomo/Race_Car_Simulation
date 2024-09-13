package main;

/**
 * This class manages the movements of cars, pit stops, and the finish line, and logs the events occurring during the race.
 */
public class RaceTrack {
	int finishposition; // Stores the place where the latest car finished
    int ticks; // Counts the  number of ticks done 
    RaceCar[] racecars; 
    FormulaOne[] formulaOnes;  
    PitStop pitStop;
    FinishLine finishLine;
    int pitStopLocation; 
	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerB logger;
	
	/**
     * Constructs a RaceTrack with no cars and initializes the pit stop, finish position, and tick count.
     */
	public RaceTrack() {
		logger = new TrackLoggerB(); // DO NOT REMOVE THIS LINE
		racecars = new RaceCar[0];
		formulaOnes = new FormulaOne[0];
		setCars(racecars, formulaOnes);
		pitStop = new PitStop();
		finishposition = 0;
		ticks = 0;
	}
	/**
     * Sets the racecars for this race track and initializes the finish line.
     * @param racecars Array of RaceCar objects.
     */
	public void setCars(RaceCar[] racecars) {
		  this.racecars = new RaceCar[racecars.length];
	      for (int i = 0; i < racecars.length; i++) {
	        this.racecars[i] = racecars[i];
	      }
	      this.formulaOnes = new FormulaOne[0]; // No FormulaOne cars here
	     
	      finishLine = new FinishLine(this.racecars, formulaOnes);
		}
		
	/**
     * Sets the racecars and formula one cars for this race track and initializes the finish line.
     * @param racecars Array of RaceCar objects.
     * @param formulaOnes Array of FormulaOne objects.
     */
		public void setCars(RaceCar[] racecars, FormulaOne[] formulaOnes) {
		  this.racecars = new RaceCar[racecars.length];
		  for (int i = 0; i < racecars.length; i++) {
		    this.racecars[i] = racecars[i];
		  }
		  
		  this.formulaOnes = new FormulaOne[formulaOnes.length];
		  for (int i = 0; i < formulaOnes.length; i++) {
	        this.formulaOnes[i] = formulaOnes[i];
	      }
		 
		  finishLine = new FinishLine(this.racecars, this.formulaOnes);
		}
		
		/**
	     * Advances the state of the race by one tick, moving cars, handling pit stops, and checking for collisions.
	     */
		public void tick() {
			// Handle movement of RaceCar and pit stops
		  for (int i = 0; i < racecars.length; i++) {
			  // Only consider cars that are not in the pit stop and not finished
		    if (pitStop.getRaceCarsInPitStop()[i] == 0 && !racecars[i].getFinished()) {
		    	// Calculate the pit stop location for damaged cars
		      if (racecars[i].getDamaged() && racecars[i].getLocation() % 100 < 75) {
		        pitStopLocation = ((int)(racecars[i].getLocation() / 100) * 100) + 75; 
		      } else if (racecars[i].getDamaged() && racecars[i].getLocation() % 100 > 75) {
		        pitStopLocation = ((int)((racecars[i].getLocation() + 100) / 100) * 100) + 75;
		      } 
		      
		      racecars[i].move();
		      
		   // Enter pit stop if damaged and at the pit stop location
		      if ((racecars[i].getLocation() >= pitStopLocation) 
		            && racecars[i].getDamaged()) {
		          logger.logEnterPit(racecars[i]);
		          pitStop.enterPitStop(racecars[i], i, pitStopLocation);
		      }
		      
		      // Finish the race if the car reaches or exceeds the finish line
		      if (racecars[i].getLocation() >= 1000) {
		        finishLine.enterFinishLine(racecars[i]);
		        logger.logFinish(racecars[i], ++finishposition);
		      }
		    }
		  }
		  
		   // Handle movement of FormulaOnes Car and pit stops
		  for (int i = 0; i < formulaOnes.length; i++) {
			  // Only consider cars that are not in the pit stop and not finished
	        if (pitStop.getFormulaOnesInPitStop()[i] == 0 && !formulaOnes[i].getFinished()) {
	        // Calculate the pit stop location for damaged cars
	          if (formulaOnes[i].getDamaged()) {
	            pitStopLocation = ((int)(formulaOnes[i].getLocation() / 100) * 100) + 75; 
	          } else if (racecars[i].getDamaged() && racecars[i].getLocation() % 100 > 75) {
	            pitStopLocation = ((int)((racecars[i].getLocation() + 100) / 100) * 100) + 75;
	          }
	          
	          
	          formulaOnes[i].move();
	          
	          
	          if ((formulaOnes[i].getLocation() >= pitStopLocation) 
	              && formulaOnes[i].getDamaged()) {
	            logger.logEnterPit(formulaOnes[i]);
	            pitStop.enterPitStop(formulaOnes[i], i, pitStopLocation);
	        }
	       // Finish the race if the car reaches the finish line
	          if (formulaOnes[i].getLocation() >= 1000) {
	            finishLine.enterFinishLine(formulaOnes[i]);
	            logger.logFinish(formulaOnes[i], ++finishposition);
	          }
	        }
	      }
	      
		// Handle exit of RaceCars from pit stops
		  for (int  i = 0; i < pitStop.getRaceCarsInPitStop().length; i++) {
		    if (pitStop.getRaceCarsInPitStop()[i] == 3) {
	          logger.logExitPit(racecars[i]);
	          pitStop.exitPitStop(racecars[i], i);
	          racecars[i].move();
	          if (racecars[i].getLocation() >= 1000) {
	            finishLine.enterFinishLine(racecars[i]);
	            logger.logFinish(racecars[i], ++finishposition);
	          }
	        } else if (pitStop.getRaceCarsInPitStop()[i] == 1 
	            || pitStop.getRaceCarsInPitStop()[i] == 2) {
	          pitStop.moveTickPitStop(racecars[i], i);
	        }
		  }
		// Handle exit of FormulaOne cars from pit stops
	      for (int  i = 0; i < pitStop.getFormulaOnesInPitStop().length; i++) {
	        if (pitStop.getFormulaOnesInPitStop()[i] == 3) {
	          logger.logExitPit(formulaOnes[i]);
	          pitStop.exitPitStop(formulaOnes[i], i);
	          formulaOnes[i].move();
	          if (formulaOnes[i].getLocation() >= 1000) {
	            finishLine.enterFinishLine(formulaOnes[i]);
	            logger.logFinish(formulaOnes[i], ++finishposition);
	          }
	        } else if (pitStop.getFormulaOnesInPitStop()[i] == 1 
	            || pitStop.getFormulaOnesInPitStop()[i] == 2) {
	          pitStop.moveTickPitStop(formulaOnes[i], i);
	        } 
	      }
	   // Check for collisions between cars
		  checkCollision();
		}
		
		 /**
	     * Checks for collisions between cars on the track and logs any damages.
	     */
		public void checkCollision() { 
		// Check collisions among RaceCars
		  if (racecars.length > 1) {
		    for (int  i = 0; i < racecars.length; i++) {
		      for (int j = 0; j < racecars.length; j++) {
		        if (!(j == i)) { 
		          if (racecars[i].getLocation() % 100 == racecars[j].getLocation() % 100 
		              && pitStop.getRaceCarsInPitStop()[i] == 0 
		              && pitStop.getRaceCarsInPitStop()[j] == 0
		              && !racecars[i].getFinished() 
		              && !racecars[j].getFinished()){
		            if (racecars[i].getDamaged() == false) {
		              logger.logDamaged(racecars[i]);
		              racecars[i].setDamaged(true);
		            }
		            if (racecars[j].getDamaged() == false) {
	                  logger.logDamaged(racecars[j]);
	                  racecars[j].setDamaged(true);
	                }
		          }
		        }
		      }
		    }
		  }
		  // Check collisions among FormulaOne cars
		  if (formulaOnes.length > 1) {
	        for (int  i = 0; i < formulaOnes.length; i++) {
	          for (int j = 0; j < formulaOnes.length; j++) {
	            if (!(j == i)) { 
	              if (formulaOnes[i].getLocation() % 100 == formulaOnes[j].getLocation() % 100 
	                  && pitStop.getFormulaOnesInPitStop()[i] == 0 
	                  && pitStop.getFormulaOnesInPitStop()[j] == 0
	                  && !formulaOnes[i].getFinished() 
	                  && !formulaOnes[j].getFinished()) {
	                if (formulaOnes[i].getDamaged() == false) {
	                  logger.logDamaged(formulaOnes[i]);
	                  formulaOnes[i].setDamaged(true);
	                }
	                if (formulaOnes[j].getDamaged() == false) {
	                  logger.logDamaged(formulaOnes[j]);
	                  formulaOnes[j].setDamaged(true);
	                }
	              }
	            }
	          }
	        }
	      } 
		  
		  // Check collisions between RaceCars and FormulaOne cars
		  for (int  i = 0; i < formulaOnes.length; i++) {
	        for (int j = 0; j < racecars.length; j++) {
	          if (formulaOnes[i].getLocation() % 100 == racecars[j].getLocation() % 100 
	              && pitStop.getFormulaOnesInPitStop()[i] == 0 
	              && pitStop.getRaceCarsInPitStop()[j] == 0
	              && !formulaOnes[i].getFinished() 
	              && !racecars[j].getFinished()) {
	           
	            if (formulaOnes[i].getDamaged() == false) {
	              logger.logDamaged(formulaOnes[i]);
	              formulaOnes[i].setDamaged(true);
	            }
	            if (racecars[j].getDamaged() == false) {
	              logger.logDamaged(racecars[j]);
	              racecars[j].setDamaged(true);
	            }
	          }
	        }
		  }
		}
		
		/**
	     * Runs the race by advancing the state by one tick until all cars have finished, and calculates the final score.
	     */
		public void run() {
		  while (!finishLine.finished()) {
		    logger.logNewTick();
		    tick();
		    ticks++;
		  }
		  calculateScore(ticks);
		}
		
		/**
	     * Calculates the final score based on the number of ticks and the number of cars.
	     * @param ticks The number of ticks taken to complete the race.
	     * @return The final score.
	     */
		public int calculateScore(int ticks) {
		  int score = 1000 - (20 * ticks) + (150 * racecars.length) + (100 * formulaOnes.length);
		  logger.logScore(score);
		  return score;
		}
		
		/**
		 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
		 * @return logger with this track's events 
		 */
		public TrackLoggerB getLogger() {
			return logger;
		} 

	}
