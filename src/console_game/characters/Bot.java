package console_game.characters;

public class Bot {
    private final Attribute attribute = Attribute.UNIVERSAL;
    private int healthPoints = 1100;
    private final int minAttack = 11;
    private final int maxAttack = 33;




    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
