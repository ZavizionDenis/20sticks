class CompLogic
{

    int getChoiceStickCount(int gamerStickCountChoice) {
        final int FIRST_STICK_COUNT_CHOICE = 3;
        final int ONE_STEP_ALL_GAMERS_STICK_COUNT = 4;

        if (gamerStickCountChoice == 0) {
            return FIRST_STICK_COUNT_CHOICE;
        }

        return ONE_STEP_ALL_GAMERS_STICK_COUNT - gamerStickCountChoice;
    }
}
