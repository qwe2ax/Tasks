package console_game.characters;

import console_game.actions.Actions;
import console_game.util.Util;

public class Player extends Character {

    private final Attribute attribute;
    private int healthPoints = 1000;
    private int minDamage = 110;
    private int maxDamage = 440;
    private final double blockPercentage = 0.4;

    public Player(Attribute attribute) {
        this.attribute = attribute;
        this.minDamage = (int) (minDamage + (minDamage * attribute.getDamageMultiplier()));
        this.maxDamage = (int) (maxDamage + (maxDamage * attribute.getDamageMultiplier()));
        this.healthPoints = (int) (healthPoints + (healthPoints * attribute.getHealthPointsMultiplier()));

    }

    @Override
    public void attack(Character enemy) {
        Actions.attack(getDamageFromAttack(), enemy);
    }

    @Override
    public int getDamageFromAttack() {
        int damage = Util.random.nextInt(maxDamage - minDamage + 1) + minDamage;
        if (attribute.isHasDoubleDamage()) {
            return Util.isDouble() ? damage * 2 : damage;
        }
        return damage;
    }

    public double getBlockPercentage() {
        if (attribute.isHasDoubleBlock()) {
            return Util.isDouble() ? 0 : blockPercentage;
        }
        return blockPercentage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Attribute getAttribute() {
        return attribute;
    }
}
