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



    /**
     the healing result of the Priestess whenever they heal themselves.
     */
    private String myHealResult;

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

        super(theName, 75, 25, 45,
                5, 70.0, 30.0);

    }


    /**
     * Priestess's special skill is healing themselves from 20 to 40 hit points
     * This special skill cannot be use on any other DungeonCharacter(monster) except the Priestess
     * or else the special skill will fail
     *
     */
    public void heal(){

        int healAmount = MY_RANDOM.nextInt(40 - 20) + 20;

        // making sure that only the priestess can heal themselves and not the monster
        if (isAlive()){
            myHealResult = getCharacterName() + " heals themselves for " + healAmount
                                                  + "(" + getHitPoints() + " + " + healAmount + ")\n";
            increaseHitPoints(healAmount);
            myHealResult += getCharacterName() + "'s current health: " + getHitPoints();
        }


    }

    /**
     * Returns healing result of the Priestess character.
     *
     * @return healing result of the Priestess character.
     */
    public String getHealingResult(){
        return myHealResult;
    }


}
