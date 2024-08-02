package console_game.characters;

import console_game.actions.Actions;
import console_game.util.Util;

public class Hero {

    private final Attribute attribute;
    private int healthPoints;
    private final int minDamage;
    private final int maxDamage;
    private final double blockPercentage;
    private final int armor;
    private final boolean isBot;
    private int abilitiesMoves;
    private int turnCount; // Счетчик ходов для отслеживания кулдауна
    private boolean attackAndBlock;
    private boolean doubleDamageNextTurn;
    private boolean reduceDamage;
    private boolean block;
    private boolean cooldown;

    public Hero(Attribute attribute, boolean isBot, int healthPoints, int minDamage, int maxDamage, double blockPercentage) {
        this.attribute = attribute;
        this.minDamage = (int) (minDamage + (minDamage * attribute.getDamageMultiplier()));
        this.maxDamage = (int) (maxDamage + (maxDamage * attribute.getDamageMultiplier()));
        this.healthPoints = (int) (healthPoints + (healthPoints * attribute.getHealthPointsMultiplier()));
        this.blockPercentage = blockPercentage;
        this.armor = attribute.getArmor();
        this.isBot = isBot;
        this.block = false;
        this.cooldown = false;
    }

    public void attack(Hero opponent) {
        Actions.attack(getDamageFromAttack(), opponent);
        if (doubleDamageNextTurn) {
            doubleDamageNextTurn = false;
            cooldown = true;
            turnCount = -4;
        }
    }

    public void block() {
        if (attackAndBlock) {
            abilitiesMoves++;
            Actions.attack(getDamageFromAttack() / 2, Util.getAnotherPlayer(this));
        }
        Actions.block(this);
    }

    public void useAbility() {
        Actions.useAbility(this);
    }

    public void updateTurn() {
        if (reduceDamage || attackAndBlock) {
            turnCount++;
            if (turnCount == 4) {
                reduceDamage = false;
                attackAndBlock = false;
                cooldown = true;
                turnCount = -3; // Сбросить счетчик ходов после окончания эффекта
            }
        } else if (cooldown) {
            turnCount++;
            if (turnCount == 0) {
                cooldown = false;
            }
        }
    }



    public boolean isAttackAndBlock() {
        return attackAndBlock;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public int getAbilitiesMoves() {
        return abilitiesMoves;
    }

    public void setAbilitiesMoves(int abilitiesMoves) {
        this.abilitiesMoves = abilitiesMoves;
    }

    public void setAttackAndBlock(boolean attackAndBlock) {
        this.attackAndBlock = attackAndBlock;
    }

    public boolean isDoubleDamageNextTurn() {
        return doubleDamageNextTurn;
    }

    public void setDoubleDamageNextTurn(boolean doubleDamageNextTurn) {
        this.doubleDamageNextTurn = doubleDamageNextTurn;
    }

    public boolean isReduceDamage() {
        return reduceDamage;
    }

    public void setReduceDamage(boolean reduceDamage) {
        this.reduceDamage = reduceDamage;
    }

    public boolean isCooldown() {
        return cooldown;
    }

    public void setCooldown(boolean cooldown) {
        this.cooldown = cooldown;
    }

    public boolean isBot() {
        return isBot;
    }

    public int getDamageFromAttack() {
        int damage = Util.random.nextInt(maxDamage - minDamage + 1) + minDamage;
        if (attribute.isHasDoubleDamage()) {
            return Util.isDouble() ? damage * 2 : damage;
        }
        return doubleDamageNextTurn ? damage * 2 : damage;
    }

    public double getBlockPercentage() {
        if (attribute.isHasDoubleBlock()) {
            return Util.isDouble() ? 0 : blockPercentage;
        }
        return blockPercentage;
    }

    public void reduceHealthPoints(int damage) {
        this.healthPoints -= isReduceDamage() ? (int) (damage * 0.7) : damage;
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

    public int getArmor() {
        return armor;
    }

    public void incrementTurnCount() {
        this.turnCount++;
    }
}
