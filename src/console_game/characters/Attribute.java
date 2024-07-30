package console_game.characters;

public enum Attribute {
    STRENGTH("Кол-во здоровья увеличено на 10%, шанс 20% при блокировании заблокировать x2 урона"),
    AGILITY("Сила атаки увеличена на 10%, шанс 10% нанести х2 урона при атаке"),
    UNIVERSAL("Кол-во здоровья увеличено на 10%, сила атаки увеличена на 10%");

    private final String informationAboutAttribute;

    Attribute(String informationAboutAttribute) {
        this.informationAboutAttribute = informationAboutAttribute;
    }

    public String getInformationAboutAttribute() {
        return informationAboutAttribute;
    }
}
