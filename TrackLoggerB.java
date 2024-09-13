package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.RaceCar;
import main.FormulaOne;

/**
 * This logger will be used by the RaceTrack to record all events that occur during the race. This class will handle printing for you, therefore,
 * you should not be printing in RaceTrack.java. If you are failing the JUnit tests, make sure that you are actually using this class to log events 
 * instead of just printing events to the console. If you want to be printing in PitStop, FinishLine make sure that you pass the same instance of the
 * logger you use in the RaceTrack to those classes. ALL events in a race should be recorded in the same logger (i.e. PitStop, FinishLine should not
 * have their own loggers). 

 */
public class TrackLoggerB {

	/**
	 * List of Sets of events that occur at each tick.	
	 */
	private List<Set<String>> tickOutputs;

	/**
	 * Constructs a logger for the beginning of the race. 
	 */
	public TrackLoggerB() {
		tickOutputs = new ArrayList<Set<String>>();
	}
	

	/**
	 * Logs the beginning of a new tick for the logger & prints this to the console. 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logNewTick()</p>
	 * <p>// some code to run a tick (such as tick() in RaceTrack)</p>
	 */
	public void logNewTick() {
		tickOutputs.add(new HashSet<String>());
		System.out.println("Tick " + tickOutputs.size());
	}

	/**
	 * Logs that a car has entered a pitstop in the current tick & prints this to the console.
	 * @param car a RaceCar entering a PitStop 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logEnterPit(car)</p>
	 * <p>// some code to put 'car' into a PitStop</p>
	 */
	public void logEnterPit(RaceCar car) {
		tickOutputs.get(tickOutputs.size() - 1).add(enterPitStr(car));
		System.out.println(enterPitStr(car));
	}
	
	/**
	 * Logs that a car has exited a pitstop in the current tick & prints this to the console.
	 * @param car a RaceCar exiting a PitStop 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logExitPit(car)</p>
	 * <p>// some code to take 'car' out of a PitStop</p>
	 */
	public void logExitPit(RaceCar car) {
		tickOutputs.get(tickOutputs.size() - 1).add(exitPitStr(car));
		System.out.println(exitPitStr(car));
	}
	
	/**
	 * Logs that a car has been damaged in the current tick & prints this to the console.
	 * @param car a RaceCar that's been damaged 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logDamaged(car)</p>
	 * <p>// some code to put 'car' into a damaged state</p>
	 */
	public void logDamaged(RaceCar car) {
		tickOutputs.get(tickOutputs.size() - 1).add(damagedStr(car));
		System.out.println(damagedStr(car));
	}
	
	/**
	 * Logs that a car has finished the race in a certain place in the current tick & prints this to the console.
	 * @param car a RaceCar entering a PitStop 
	 * @param place the place 'car' finished in 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logFinish(car, place)</p>
	 * <p>// some code to put 'car' in a finished state (such as into a FinishLine)</p>
	 */
	public void logFinish(RaceCar car, int place) {
		tickOutputs.get(tickOutputs.size() - 1).add(finishedStr(car, place));
		System.out.println(finishedStr(car, place));
	}
	
	/**
	 * Logs that a RaceTrack finished a race with a given score. You should have this log occur after the final tick and is expected to be an event
	 * that occurs in the final tick. Also, this will print that the game ended with a certain score. 
	 * <p><b>Usage: </b></p>
	 * <p>// code to execute the last tick (may be part of a loop)</p>
	 * <p>logger.logScore(pts)</p>
	 * <p>// race over </p>
	 * @param pts the number of points as a result of the race lasting some no. of ticks, with some no. of cars, etc. 
	 */
	public void logScore(int pts) {
		tickOutputs.get(tickOutputs.size() - 1).add(scoreStr(pts));
		System.out.println("\n" + scoreStr(pts));
	}
	
	// ************************************ The following methods are for part B vehicles *******************************************
	
	/**
	 * Logs that a car has entered a pitstop in the current tick & prints this to the console.
	 * @param car a FormulaOne entering a PitStop 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logEnterPit(car)</p>
	 * <p>// some code to put 'car' into a PitStop</p>
	 */
	public void logEnterPit(FormulaOne car) {
		tickOutputs.get(tickOutputs.size() - 1).add(enterPitStr(car));
		System.out.println(enterPitStr(car));
	}
	
	
	/**
	 * Logs that a car has exited a pitstop in the current tick & prints this to the console.
	 * @param car a FormulaOne exiting a PitStop 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logExitPit(car)</p>
	 * <p>// some code to take 'car' out of a PitStop</p>
	 */
	public void logExitPit(FormulaOne car) {
		tickOutputs.get(tickOutputs.size() - 1).add(exitPitStr(car));
		System.out.println(exitPitStr(car));
	}
	
	
	/**
	 * Logs that a car has been damaged in the current tick & prints this to the console.
	 * @param car a FormulaOne that's been damaged 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logDamaged(car)</p>
	 * <p>// some code to put 'car' into a damaged state</p>
	 */
	public void logDamaged(FormulaOne car) {
		tickOutputs.get(tickOutputs.size() - 1).add(damagedStr(car));
		System.out.println(damagedStr(car));
	}
	
	
	/**
	 * Logs that a car has finished the race in a certain place in the current tick & prints this to the console.
	 * @param car a FormulaOne entering a PitStop 
	 * @param place the place 'car' finished in 
	 * <p><b>Usage: </b></p>
	 * <p>logger.logFinish(car, place)</p>
	 * <p>// some code to put 'car' in a finished state (such as into a FinishLine)</p>
	 */
	public void logFinish(FormulaOne car, int place) {
		tickOutputs.get(tickOutputs.size() - 1).add(finishedStr(car, place));
		System.out.println(finishedStr(car, place));
	}
	
	

	// **************************************** THE FOLLOWING METHODS SHOULD NOT BE USED AT ALL ********************************************* 

	/**
	 * Gets the Set of events that occurred at a given tick. 
	 * @param tick some tick 
	 * @return the set of events that occurred at tick no. 'tick' 
	 */
	public Set<String> getTickLog(int tick) {
		return tickOutputs.get(tick - 1);
	}

	/**
	 * Gets the String that is logged as the event of a car being damaged & what is printed to the console 
	 * @param car a car 
	 * @return something like "RaceCar 55/3 has been damaged." 
	 */
	public static String damagedStr(RaceCar car) { 
		return car.toString() + " has been damaged.";
	}

	/**
	 * Gets the String that is logged as the event of a car being damaged & what is printed to the console 
	 * @param car a car 
	 * @return something like "FormulaOne 55/3 has been damaged." 
	 */
	public static String damagedStr(FormulaOne car) { 
		return car.toString() + " has been damaged.";
	}


	/**
	 * Gets the String that is logged as the event of a car being entered into a PitStop & what is printed to the console 
	 * @param car a car 
	 * @return something like "RaceCar 55/3 has entered the pit stop." 
	 */
	public static String enterPitStr(RaceCar car) {
		return car.toString() + " has entered the pit stop.";
	}

	/**
	 * Gets the String that is logged as the event of a car being entered into a PitStop & what is printed to the console 
	 * @param car a car 
	 * @return something like "FormulaOne 55/35 has entered the pit stop." 
	 */
	public static String enterPitStr(FormulaOne car) {
		return car.toString() + " has entered the pit stop.";
	}



	/**
	 * Gets the String that is logged as the event of a car leaving a PitStop & what is printed to the console 
	 * @param car a car 
	 * @return something like "RaceCar 55/3 has exited the pit stop." 
	 */
	public static String exitPitStr(RaceCar car) {
		return car.toString() + " has exited the pit stop.";
	}

	/**
	 * Gets the String that is logged as the event of a car leaving a PitStop & what is printed to the console 
	 * @param car a car 
	 * @return something like "FormulaOne 55/3 has exited the pit stop." 
	 */
	public static String exitPitStr(FormulaOne car) {
		return car.toString() + " has exited the pit stop.";
	}


	/**
	 * Gets the String that is logged as the event of a car finishing the race in some place & what is printed to the console 
	 * @param car a car 
	 * @param place the place 'car' finished in 
	 * @return something like "RaceCar 55/35 has finished the race in place 1." 
	 */
	public static String finishedStr(RaceCar car, int place) {
		return car.toString() + " has finished the race in place " + place + ".";
	}

	/**
	 * Gets the String that is logged as the event of a car finishing the race in some place & what is printed to the console 
	 * @param car a car 
	 * @param place the place 'car' finished in 
	 * @return something like "FormulaOne 55/3 has finished the race in place 1." 
	 */
	public static String finishedStr(FormulaOne car, int place) {
		return car.toString() + " has finished the race in place " + place + ".";
	}


	/**
	 * Gets the String that is logged as the event of a RaceTrack finishing a race with a certain score & what is printed to the console 
	 * @param score a score 
	 * @return something like "You scored 100 points." 
	 */
	public static String scoreStr(int score) {
		return "You scored " + score + " points.";
	}
}
