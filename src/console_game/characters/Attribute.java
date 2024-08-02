package console_game.characters;

import console_game.util.Util;

public enum Attribute {
    STRENGTH( "Сила", "Кол-во здоровья увеличено на 10%, шанс 20% при блокировании заблокировать x2 урона." +
            " Способность дает возможность наносить 50% урона при блокировании следующие 3 блока",
            0.10, 0, false, true, 50, 3),
    AGILITY("Ловкость",  "Сила атаки увеличена на 10%, шанс 10% нанести х2 урона при атаке. " +
            "Активация способности гарантированно увеличивает наносимый урон в 2 раза на следующий ход(складывается с пассивной способностью)",
            0, 0.10, true, false, 30, 1),
    UNIVERSAL("Универсальность", "Кол-во здоровья увеличено на 10%, сила атаки увеличена на 10%. " +
            "Способность уменьшает получаемый урон на 30% на следующие 3 хода",
            0.10, 0.10, false, false, 40, 2);

    private final String title;
    private final String informationAboutAttribute;
    private final double healthPointsMultiplier;
    private final double damageMultiplier;
    private final boolean hasDoubleDamage;
    private final boolean hasDoubleBlock;
    private final int armor;
    private final int ability;

    Attribute(String title, String informationAboutAttribute, double healthPointsMultiplier, double damageMultiplier, boolean isDoubleDamage,
              boolean hasDoubleBlock, int armor, int ability) {
        this.title = title;
        this.informationAboutAttribute = informationAboutAttribute;
        this.healthPointsMultiplier = healthPointsMultiplier;
        this.damageMultiplier = damageMultiplier;
        this.hasDoubleDamage = isDoubleDamage;
        this.hasDoubleBlock = hasDoubleBlock;
        this.armor = armor;
        this.ability = ability;
    }

    public static Attribute getRandomAttribute() {
        Attribute[] attributes = {Attribute.STRENGTH, Attribute.AGILITY, Attribute.UNIVERSAL};
        return attributes[Util.random.nextInt(attributes.length)];
    }

    public static Attribute selectAttribute() {
        Attribute attribute;
        String text = "\nВыбран атрибут: ";
        switch (Util.scan.next()) {
            case "1":
                attribute = Attribute.STRENGTH;
                System.out.println(text + attribute.getTitle());
                return attribute;
            case "2":
                attribute = Attribute.AGILITY;
                System.out.println(text + attribute.getTitle());
                return attribute;
            case "3":
                attribute = Attribute.UNIVERSAL;
                System.out.println(text + attribute.getTitle());
                return attribute;
            case "4":
                attribute = getRandomAttribute();
                System.out.println("\nВыбран случайный атрибут: " + attribute.getTitle());
                return attribute;
            default:
                System.exit(0);
        }
        return null;
    }

    public int getArmor() {
        return armor;
    }

    public String getInformationAboutAttribute() {
        return informationAboutAttribute;
    }

    public String getTitle() {
        return title;
    }

    public int getAbility() {
        return ability;
    }

    public String getAbilityDescription() {
        return switch (getAbility()) {
            case 3 -> "Игрок использовал способность. Следующие 3 блока наносятся атаки равные 50% урона";
            case 1 -> "Игрок использовал способность. Следующая атака нанесет двойной урон";
            case 2 -> "Игрок использовал способность. Следующие 3 хода получаемый урон снижается на 30%";
            default -> "q";
        };
    }

    public double getHealthPointsMultiplier() {
        return healthPointsMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public boolean isHasDoubleDamage() {
        return hasDoubleDamage;
    }

    public boolean isHasDoubleBlock() {
        return hasDoubleBlock;
    }
}
