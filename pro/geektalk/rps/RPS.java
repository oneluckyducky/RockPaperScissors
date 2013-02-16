package pro.geektalk.rps;

import java.util.Random;
import java.util.Scanner;

import pro.geektalk.rps.utils.Generator;
import pro.geektalk.rps.utils.Misc;
import pro.geektalk.rps.utils.Timer;

public class RPS {
	// 1 - rock
	// 2 - paper
	// 3 - scissors
	
	static Timer timer = new Timer(0);
	static Random r = new Random();
	static Scanner input = new Scanner(System.in);
	static boolean play = true;
	static Generator gen;

	public static void main(String[] args) {
		Misc.printIntro();
		while (play) {
			System.out.print("What's your choice?\n");
			final String userInput = input.next();
			if (!userInput.isEmpty()) {
				if (userInput.equalsIgnoreCase("stop")) {
					play = !play;
					onStop();
					break;
				}
				if (!Misc.isEntryValid(userInput)) {
					Misc.throwError("Not a valid input, try again! :)");
				} else {
					gen = new Generator(r.nextInt(2) + 1);
					Vars.computerChoice = gen.getComputerChoice();
					Misc.setUserChoice(userInput);
					if (Vars.playerChoice == Vars.computerChoice) {
						Misc.printMessage("[TIE]", "It was a tie!");
						Vars.ties++;
					} else if (Vars.playerChoice == 1) {
						if (Vars.computerChoice == 2) {
							// lose -> paper covers rock
							Misc.printMessage("[LOSE]",
									"Paper covers rock!\n\n");
							Vars.loses++;
						}
						if (Vars.computerChoice == 3) {
							// win -> rock breaks scissors
							Misc.printMessage("[WIN]",
									"Rock breaks scissors!\n\n");
							Vars.wins++;
						}
					} else if (Vars.playerChoice == 2) {
						if (Vars.computerChoice == 1) {
							// win -> paper covers rock
							Misc.printMessage("[WIN]", "paper covers rock!\n\n");
							Vars.wins++;
						}
						if (Vars.computerChoice == 3) {
							// lose -> scissors cuts paper
							Misc.printMessage("[LOSE]",
									"Scissors cuts paper!\n\n");
							Vars.loses++;
						}
					} else if (Vars.playerChoice == 3) {
						if (Vars.computerChoice == 1) {
							// lose -> rock breaks scissors
							Misc.printMessage("[LOSE]",
									"Rock breaks scissors\n\n");
							Vars.loses++;
						}
						if (Vars.computerChoice == 2) {
							// win -> scissors cuts paper
							Misc.printMessage("[WIN]",
									"Scissors cuts paper!\n\n");
							Vars.wins++;
						}
					}
				}
			} else {
				Misc.throwError("Not a valid input, try again! :)");
			}
		}
	}

	public static void onStop() {
		Misc.printMessage(String.format(
				"\nWins - %d\nLoses - %d\nTies - %d\nThank you for playing RPS! Brought"
						+ " to you from Hack Community for Deque's contest!\nYou played for %s ",
				Vars.wins, Vars.loses, Vars.ties, timer.toElapsedString()));
	}
}
