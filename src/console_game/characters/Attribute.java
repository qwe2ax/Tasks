package console_game.characters;

public enum Attribute {
    STRENGTH( "Сила", "Кол-во здоровья увеличено на 10%, шанс 20% при блокировании заблокировать x2 урона",
            0.10, 0, false, true),
    AGILITY("Ловкость",  "Сила атаки увеличена на 10%, шанс 10% нанести х2 урона при атаке",
            0, 0.10, true, false),
    UNIVERSAL("Универсальность", "Кол-во здоровья увеличено на 10%, сила атаки увеличена на 10%",
            0.10, 0.10, false, false);

    private final String title;
    private final String informationAboutAttribute;
    private final double healthPointsMultiplier;
    private final double damageMultiplier;
    private final boolean hasDoubleDamage;
    private final boolean hasDoubleBlock;

    Attribute(String title, String informationAboutAttribute, double healthPointsMultiplier, double damageMultiplier, boolean isDoubleDamage, boolean hasDoubleBlock) {
        this.title = title;
        this.informationAboutAttribute = informationAboutAttribute;
        this.healthPointsMultiplier = healthPointsMultiplier;
        this.damageMultiplier = damageMultiplier;
        this.hasDoubleDamage = isDoubleDamage;
        this.hasDoubleBlock = hasDoubleBlock;
    }

    public String getInformationAboutAttribute() {
        return informationAboutAttribute;
    }

    public String getTitle() {
        return title;
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
