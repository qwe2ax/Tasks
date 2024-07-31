package console_game.characters;

import console_game.actions.Actions;
import console_game.util.Util;



public abstract class Character {
    Attribute attribute;
    int minDamage;
    int maxDamage;
    int healthPoints;
    double blockPercentage;

    public void attack(Character enemy) {
        Actions.attack(getDamageFromAttack(), enemy);
    }

    public void block() {
        Actions.block();
    }


    public int getDamageFromAttack() {
        return Util.random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public double getBlockPercentage() {
        return blockPercentage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
