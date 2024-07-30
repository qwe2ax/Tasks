package console_game.characters;

import console_game.actions.Actions;

public abstract class Character {
    Attribute attribute;
    int minDamage;
    int maxDamage;
    int healthPoints;
    double blockPercentage;

    public void attack(Character enemy) {
        Actions.attack(this.minDamage, this.maxDamage, null);
    }

    public void block() {
        Actions.block();
    }


    public double getBlockPercentage() {
        return blockPercentage;
    }
}
