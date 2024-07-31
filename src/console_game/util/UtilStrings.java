package console_game.util;

import console_game.characters.Attribute;

public class UtilStrings {
    public static void printMenu() {
        System.out.println("Ты в меню!\n" +
                "Нажмите указанные клавиши для продолжения:\n" +
                "1. Просмотреть информацию об атрибутах\n" +
                "2. Правила игры\n" +
                "3. Выбрать атрибут" +
                "0. Выход\n");
        switch (Util.scan.nextInt()) {
            case 1:
                System.out.println(Attribute.STRENGTH.getTitle() + ": " + Attribute.STRENGTH.getInformationAboutAttribute() + "\n" +
                        Attribute.AGILITY.getTitle() + ": " + Attribute.AGILITY.getInformationAboutAttribute() + "\n" +
                        Attribute.UNIVERSAL.getTitle() + ": " + Attribute.UNIVERSAL.getInformationAboutAttribute());
            case 2:
                System.out.println("Это пошаговая консольная игра против ботов, у вас на выбор есть 3 атрибута:\n" +
                        "Сила: Количество здоровья увеличенно на 10%");
        }
    }
}
