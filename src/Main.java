import java.util.Scanner;

public class Main
{
    private static CompLogic compLogic = new CompLogic();
    private static int stickCount = 20;

    public static void main(String[] args) {
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

    private static int getNextStepComp(int gamerStickCountChoice) {
        int stickCountChoice = compLogic.getChoiceStickCount(gamerStickCountChoice);
        Message.showCompChoiceStickCount(stickCountChoice);
        return stickCountChoice;
    }

    private static int getNextStepGamer() {
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

    private static boolean isValidStickCountChoice (int stickCountChoice) {
        final int MIN_STICK_COUNT = 1;
        final int MAX_STICK_COUNT = 3;
        return stickCountChoice >= MIN_STICK_COUNT && stickCountChoice <= MAX_STICK_COUNT;
    }

    private static boolean isGameOver() {
        if (stickCount == 1) {
            Message.showGameOver();
            return true;
        }
        return false;
    }
}