package console_game.characters;

import console_game.util.Util;

public enum Attribute {
    STRENGTH("Сила", """
            Кол-во здоровья увеличено на 10%, шанс 20% при блокировании заблокировать x2 урона.
             Способность дает возможность наносить 50% урона при блокировании следующие 3 блока
            """),
    AGILITY("Ловкость", """
            Сила атаки увеличена на 10%, шанс 10% нанести х2 урона при атаке.
             Активация способности гарантированно увеличивает наносимый урон в 2 раза на следующий ход(складывается с пассивной способностью)
            """),
    UNIVERSAL("Универсальность", """
            Кол-во здоровья увеличено на 10%, сила атаки увеличена на 10%.
            Способность уменьшает получаемый урон на 30% на следующие 3 хода
            """);

    private final String title;
    private final String informationAboutAttribute;
    private final double healthPointsMultiplier;
    private final double damageMultiplier;
    private final boolean hasDoubleDamage;
    private final boolean hasDoubleBlock;
    private final int armor;
    private final int ability;

    Attribute(String title, String informationAboutAttribute) {
        this.title = title;
        this.informationAboutAttribute = informationAboutAttribute;
        this.healthPointsMultiplier = Double.parseDouble(Util.getPropertyValue("attribute." + this.name().toLowerCase() + ".health_points_multiplier"));
        this.damageMultiplier = Double.parseDouble(Util.getPropertyValue("attribute." + this.name().toLowerCase() + ".damage_multiplier"));
        this.hasDoubleDamage = Boolean.parseBoolean(Util.getPropertyValue("attribute." + this.name().toLowerCase() + ".has_double_damage"));
        this.hasDoubleBlock = Boolean.parseBoolean(Util.getPropertyValue("attribute." + this.name().toLowerCase() + ".has_double_block"));
        this.armor = Integer.parseInt(Util.getPropertyValue("attribute." + this.name().toLowerCase() + ".armor"));
        this.ability = Integer.parseInt(Util.getPropertyValue("attribute." + this.name().toLowerCase() + ".ability"));
    }


    public static Attribute getRandomAttribute() {
        return values()[Util.random.nextInt(values().length)];
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
