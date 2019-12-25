class Message
{
    static void showStickCount (int stickCount) {
        System.out.printf("На столе осталось %d спичек.%n", stickCount);
    }

    static void showCompChoiceStickCount (int stickCount) {
        System.out.printf(" - Количество выбранных компьютером спичек = %d.%n", stickCount);
    }

    static void showGamerRequestStickCount () {
        System.out.print(" - Ход игрока. Введите количество спичек: ");
    }

    static void showGamerErrorStickCount () {
        System.out.println("Не корректное количество спичек!");
    }

    static void showGameOver () {
        System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
    }
}
