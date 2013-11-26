package ch.uzh.inf01.cobol.mealy;

import java.util.Scanner;


public class MealyMachine {

    private static void printState(AbstractState pState) {
        System.out.println(pState.getClass().getSimpleName() + ": " + pState.output());
    }

    public static void main(String... pArgs) {
        AbstractState state = new State1();
        printState(state);
        String input = null;
        Scanner scanner = new Scanner(System.in);
        while ((input = scanner.nextLine()) != null) {
            // Until an empty line is entered
            if (input.isEmpty()) {
                break;
            }
            // process each char of the input string
            for (char c : input.toCharArray()) {
                // create a new state based on the input
                state = state.nextState(c);
                printState(state);
            }
        }

        System.exit(0);
    }

}
