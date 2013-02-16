package pro.geektalk.rps.utils;

import pro.geektalk.rps.Vars;

public class Misc {

	public static void printIntro() {
		System.out.print("                         Welcome to RPS by Jacob\n");
		System.out.print("'r'/'rock'\n'p'/'paper'\n's'/'scissors'\n");
		System.out.print("Type 'stop' to stop playing\n");
		System.out.print("---------------------------------------------\n\n");

	}

	public static void throwError(final String message) {
		System.out.println(String.format("[ERROR] %s", message));
	}

	public static void printMessage(final String message) {
		System.out.println(String.format("\n\n[MESSAGE] %s", message));
	}

	public static void printMessage(final String tag, final String message) {
		System.out.println(String.format(tag.concat(" %s"), message));
	}

	public static void setUserChoice(final String choice) {
		if (choice.equalsIgnoreCase("r") || choice.equalsIgnoreCase("rock")) {
			Vars.playerChoice = 1;
		} else if (choice.equalsIgnoreCase("p")
				|| choice.equalsIgnoreCase("paper")) {
			Vars.playerChoice = 2;

		} else if (choice.equalsIgnoreCase("s")
				|| choice.equalsIgnoreCase("scissors")) {
			Vars.playerChoice = 3;

		}
	}

	public static boolean isEntryValid(final String entry) {
		return entry.equalsIgnoreCase("r") || entry.equalsIgnoreCase("p")
				|| entry.equalsIgnoreCase("s")
				|| entry.equalsIgnoreCase("rock")
				|| entry.equalsIgnoreCase("paper")
				|| entry.equalsIgnoreCase("scissors");
	}
}
