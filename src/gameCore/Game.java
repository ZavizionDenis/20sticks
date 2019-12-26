package gameCore;

import java.util.Scanner;

public class Game
{
    private static CompLogic compLogic;
    private static int stickCount;

    public Game() {
        compLogic = new CompLogic();
        stickCount = 20;
    }

    public void startGame () {
        int gamerStickCountChoice = 0;

        while (!isGameOver()) {
            Message.showStickCount(stickCount);

            int compStickCountChoice = getNextStepComp(gamerStickCountChoice);
            stickCount -= compStickCountChoice;

            if (isGameOver()) {
                break;
            }

            gamerStickCountChoice = getNextStepGamer();
            stickCount -= gamerStickCountChoice;
        }
    }

    private int getNextStepComp(int gamerStickCountChoice) {
        int stickCountChoice = compLogic.getChoiceStickCount(gamerStickCountChoice);
        Message.showCompChoiceStickCount(stickCountChoice);
        return stickCountChoice;
    }

    private int getNextStepGamer() {
        boolean isValidStickCount = false;
        int stickCountChoice = 0;

        while (!isValidStickCount) {
            Message.showStickCount(stickCount);
            Message.showGamerRequestStickCount();
            stickCountChoice = new Scanner(System.in).nextInt();
            if (!isValidStickCountChoice(stickCountChoice)) {
                Message.showGamerErrorStickCount();
            } else {
                isValidStickCount = true;
            }
        }

        return stickCountChoice;
    }

    private boolean isValidStickCountChoice (int stickCountChoice) {
        final int MIN_STICK_COUNT = 1;
        final int MAX_STICK_COUNT = 3;
        return stickCountChoice >= MIN_STICK_COUNT && stickCountChoice <= MAX_STICK_COUNT;
    }

    private boolean isGameOver() {
        if (stickCount == 1) {
            Message.showGameOver();
            return true;
        }
        return false;
    }
}