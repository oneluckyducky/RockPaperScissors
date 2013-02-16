package pro.geektalk.rps.utils;

import pro.geektalk.rps.Vars;

public class Generator {

	static long time;

	public Generator(long num) {
		time = num;
	}

	public int getComputerChoice() {
		if (time == 1) {
			// Misc.printMessage("PAPER " + time);
			return 2;
		} else if (time == 2) {
			// Misc.printMessage("SCISSORS " + time);
			return 3;
		} else if (time == 3) {
			// Misc.printMessage("ROCK " + time);
			return 1;
		} else {
			Vars.computerChoice = Vars.playerChoice;
			return Vars.computerChoice;
		}
	}

}
