package gameCore;

import java.util.InputMismatchException;
import java.util.Scanner;

class GamerLogic
{

    int getChoiceStickCount() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException ex) {
            return 0;
        }
    }
}