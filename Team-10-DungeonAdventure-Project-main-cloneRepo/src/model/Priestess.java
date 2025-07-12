package model;





/**
 * This class represents a Priestess type of character (inherit from Hero).
 *
 *
 *
 * @author Dung Nguyen
 * @version 11/05/2023
 */
public class Priestess extends Hero {

    private static final int PRIESTESS_HIT_POINTS = 75;
    private static final int PRIESTESS_MIN_DAMAGE = 25;
    private static final int PRIESTESS_MAX_DAMAGE = 45;
    private static final int PRIESTESS_ATTACK_SPEED = 5;
    private static final double PRIESTESS_ACCURACY = 70.0;
    private static final double PRIESTESS_BLOCK_CHANCE = 30.0;

    /**
     * Constructs the Priestess character with a specified
     * stats/fields from DungeonCharacter (the grandparent class) such as character's name, health point, attack speed,
     * the min and the max damage a character can do, the accuracy of a character.
     *
     * Initialize hero (parent-class) specified fields such the chance to block as a hero.
     *
     * @param theName capture the character name for your Priestess
     */
    public Priestess(final String theName){

        super(theName, PRIESTESS_HIT_POINTS, PRIESTESS_MIN_DAMAGE, PRIESTESS_MAX_DAMAGE,
                PRIESTESS_ATTACK_SPEED, PRIESTESS_ACCURACY, PRIESTESS_BLOCK_CHANCE);

    }


    /**
     * Priestess's special skill is healing themselves from 20 to 40 hit points
     * This special skill cannot be use on any other DungeonCharacter(monster) except the Priestess
     * or else the special skill will fail
     *
     * @param theCharacter capture the DungeonCharacter to use special skill on by the Priestess
     */
     @Override
    public void useSpecialSkill(final DungeonCharacter theCharacter){
        if (theCharacter == null) {
            throw new IllegalArgumentException("the DungeonCharacter passed to use heal on was null");
        }
        int healAmount = MY_RANDOM.nextInt(40 - 20) + 20;

        // making sure that only the priestess can heal themselves and not the monster
        if (theCharacter.isAlive() && theCharacter.getCharacterName().equals(getCharacterName())){
            System.out.println(getCharacterName() + " heals themselves for " + healAmount
                                                  + "(" + getHeroHitPoints() + " + " + healAmount + ")");
            addingHeroHitPoints(healAmount);
            System.out.println(getCharacterName() + "'s current health: " + getHeroHitPoints());
        }
        else{
            System.out.println(getCharacterName() + " cannot heal anyone(monster) but themselves.");
        }

    }


}
