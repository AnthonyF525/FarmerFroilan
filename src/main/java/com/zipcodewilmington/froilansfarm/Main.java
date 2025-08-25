package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.structures.*;

import java.util.Scanner;

import com.zipcodewilmington.froilansfarm.interfaces.*;
import com.zipcodewilmington.froilansfarm.model.*;
import com.zipcodewilmington.froilansfarm.people.*;

public class Main {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_ORANGE = "\u001B[38;5;208m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_MAGENTA = "\u001B[35m";
    private static final String ANSI_LIGHT_PURPLE = "\u001B[38;5;183m";
    private static final String ANSI_BROWN = "\u001B[38;5;130m";
    private static final String ANSI_GRAY = "\u001B[90m";

    public static void main(String[] args) {

        // Create a single instance of the farm simulation
        FarmSimulation simulation = new FarmSimulation();
        Scanner scanner = new Scanner(System.in);

        // Header Screen
        flushScreen();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(ANSI_WHITE + "                             +&-" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                           _.-^-._    .--." + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                        .-'   _   '-. |__|" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                       /     |_|     \\|  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                      /               \\  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                     /|     _____     |\\ |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                      |    |==|==|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "  |---|---|---|---|---|    |--|--|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "  |---|---|---|---|---|    |==|==|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + " ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + ANSI_RESET);
        System.out.println("\n" + ANSI_LIGHT_PURPLE + "Welcome To Froilan Farm!" + ANSI_RESET);
        System.out.println("\n" + ANSI_WHITE + "This farm has the following:" + ANSI_RESET);
        System.out.println("=====================================");
        System.out.println();
        System.out.println("  * " + ANSI_LIGHT_PURPLE + "1" + ANSI_RESET + " Field");
        System.out.println("  * " + ANSI_LIGHT_PURPLE + "5" + ANSI_RESET + " Crop Rows");
        System.out.println("  * " + ANSI_LIGHT_PURPLE + "3" + ANSI_RESET + " Types of Crops:");
        System.out.println("       * " + ANSI_RED + "Tomatoes" + ANSI_RESET);
        System.out.println("       * " + ANSI_YELLOW + "Corn" + ANSI_RESET);
        System.out.println("       * " + ANSI_GREEN + "Spinach" + ANSI_RESET);
        System.out.println("  * " + ANSI_LIGHT_PURPLE + "4" + ANSI_RESET + " Chicken Coops with " + ANSI_LIGHT_PURPLE + "15" + ANSI_RESET + " Chickens:");

        String[] chickenNames = {
            "Henny", "Penny", "Ferdinand", "Chuckles",
            "Peck", "Clucksworth", "Nugget", "Feathers",
            "Squawk", "Rosie", "Peeper", "Scruffy",
            "Squabbles", "Pip", "Chirp"
        };
        for (int i = 0; i < chickenNames.length; i += 2) {
            String first = String.format("     * %-30s", ANSI_BROWN + chickenNames[i] + ANSI_RESET);
            String second = (i + 1 < chickenNames.length)
                ? String.format("* %-30s", ANSI_BROWN + chickenNames[i + 1] + ANSI_RESET)
                : "";
            System.out.println(first + second);
        }

        System.out.println("  * " + ANSI_LIGHT_PURPLE + "3" + ANSI_RESET + " Stables with " + ANSI_LIGHT_PURPLE + "10" + ANSI_RESET + " Horses:");

        // Print horse names, two per line
        String[] horseNames = {
            "Jasper", "Spirit", "Daisy", "Lucky", "Pegasus", "Shadow", "Thunder",
            "Blaze", "Comet", "Star"
        };
        for (int i = 0; i < horseNames.length; i += 2) {
            String first = String.format("     * %-30s", ANSI_BROWN + horseNames[i] + ANSI_RESET);
            String second = (i + 1 < horseNames.length)
                ? String.format("* %-30s", ANSI_BROWN + horseNames[i + 1] + ANSI_RESET)
                : "";
            System.out.println(first + second);
        }
        System.out.println("  * " + ANSI_LIGHT_PURPLE + "2" + ANSI_RESET + " Farm Vehicles:");
        System.out.println("       * Tractor" + ANSI_RESET);
        System.out.println("       * CropDuster" + ANSI_RESET);
        System.out.println("\n" + ANSI_BLUE + "Froilan " + ANSI_RESET + "is the Farmer" + " and " + ANSI_MAGENTA + "Froilanda " + ANSI_RESET + "is the Pilot.");
        System.out.println("\n" + ANSI_LIGHT_PURPLE + "Enjoy their weekly routine!" + ANSI_RESET);
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

        flushScreen();
        System.out.println();
        System.out.println();
        System.out.println(ANSI_WHITE + "                             +&-" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                           _.-^-._    .--." + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                        .-'   _   '-. |__|" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                       /     |_|     \\|  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                      /               \\  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                     /|     _____     |\\ |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "                      |    |==|==|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "  |---|---|---|---|---|    |--|--|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "  |---|---|---|---|---|    |==|==|    |  |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + " ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + ANSI_RESET);
        System.out.println("\n\n" + ANSI_LIGHT_PURPLE + "Thanks for visiting the farm!" + ANSI_RESET);
        System.out.println("\n--- Press Enter to end the simulation ---");
        scanner.nextLine();
        scanner.close();
    }

    public static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
