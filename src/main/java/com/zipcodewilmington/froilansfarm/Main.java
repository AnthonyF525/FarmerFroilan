package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.structures.*;

import java.util.Scanner;

import com.zipcodewilmington.froilansfarm.interfaces.*;
import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;

public class Main {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_ORANGE = "\u001B[38;5;208m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_MAGENTA = "\u001B[35m";

    public static void main(String[] args) {

        // Create a single instance of the farm simulation
        FarmSimulation simulation = new FarmSimulation();
        Scanner scanner = new Scanner(System.in);

        // Header Screen
        flushScreen();
        System.out.println();
        System.out.println();
        System.out.println(ANSI_WHITE + "                            +&-" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                           _.-^-._    .--." + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                        .-'   _   '-. |__|" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                       /     |_|     \\|  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                      /               \\  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                     /|     _____     |\\ |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                      |    |==|==|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "  |---|---|---|---|---|    |--|--|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "  |---|---|---|---|---|    |==|==|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + " ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + ANSI_RESET);
        System.out.println("\n\n" + ANSI_CYAN + "Welcome To Froilan Farm!" + ANSI_RESET);
        System.out.println("\n" + ANSI_WHITE + "This farm has the following inventory:" + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "  * 1 Field" + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "  * 5 Crop Rows" + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "  * 4 Chicken Coops" + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "  * 15 Chickens" + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "  * 3 Stables" + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "  * 10 Horses" + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "  * 2 Farm Vehicles" + ANSI_RESET);
        System.out.println("\n" + ANSI_BLUE + "Froilan is the Farmer" + ANSI_RESET + " and " + ANSI_MAGENTA + "Froilanda is the Pilot." + ANSI_RESET);
        System.out.println("\n" + ANSI_CYAN + "Enjoy their weekly routine!" + ANSI_RESET);
        System.out.println("\n\n" + ANSI_WHITE + "--- Press Enter to begin the week ---" + ANSI_RESET);
        scanner.nextLine();

        // Run Sunday's simulation
        flushScreen();
        simulation.runSunday();
        System.out.println("\n--- Press Enter to run MONDAY ---");
        scanner.nextLine();

        // Run Monday's simulation
        flushScreen();
        simulation.runMonday();
        System.out.println("\n--- Press Enter to run TUESDAY ---");
        scanner.nextLine();

        // Run Tuesday's simulation
        flushScreen();
        simulation.runTuesday();
        System.out.println("\n--- Press Enter to run WEDNESDAY ---");
        scanner.nextLine();

        // Run Wednesday's simulation
        flushScreen();
        simulation.runWednesday();
        System.out.println("\n--- Press Enter to run THURSDAY ---");
        scanner.nextLine();

        // Run Thursday's simulation
        simulation.runThursday();
        System.out.println("\n--- Press Enter to run FRIDAY ---");
        scanner.nextLine();

        // Run Friday's simulation
        simulation.runFriday();
        System.out.println("\n--- Press Enter to run SATURDAY ---");
        scanner.nextLine();

        // Run Saturday's simulation
        simulation.runSaturday();
        System.out.println("\n--- Press Enter to end the week ---");
        scanner.nextLine();
        scanner.nextLine();

        scanner.close();
    }

    public static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
