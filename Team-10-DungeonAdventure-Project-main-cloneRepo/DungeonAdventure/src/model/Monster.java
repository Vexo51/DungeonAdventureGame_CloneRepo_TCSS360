package model;





/**
 * This class represents a Monster type of character (inherit from DungeonCharacter).
 *
 *
 *
 * @author Dung Nguyen
 * @version 11/26/2023
 */
public class Monster extends DungeonCharacter{


    /**
     * The percentage chance to heal for the monster character.
     */
    private double myChanceToHeal;


    /**
     * The minimum heal point for the monster character.
     */
    private int myMinHealPoint;

    /**
     * The maximum heal point for the monster character.
     */
    private int myMaxHealPoint;


    /**
     * The health point of the monster character (use to make sure Monster won't over heal)
     */
    private int myMonsterHealthPoint;

    /**
     the healing result of monster whenever they heal themselves.
     */
    private String myMonsterHealResult;



    /**
     * Constructs a monster with a specified
     * stats/fields from DungeonCharacter (the parent class) such as Character name, health point, attack speed,
     * the min and the max damage a character can do, the accuracy (chance to hit) for a character.
     *
     * Initialize monster specified fields such the chance to heal as a monster, the minimum heal point,
     * the maximum heal point, the monster health point.
     *
     *
     * @param theMonsterName capture the character name of your monster character
     * @param theHitPoints capture the health points of your monster/DungeonCharacter
     * @param theAttackSpeed capture the attack speed of your monster character
     * @param theMinDamage capture the minimum damage your monster character can do
     * @param theMaxDamage capture the maximum damage your monster character can do
     * @param theAccuracy capture the chance to hit of your monster character
     * @param theChanceToHeal capture the chance to heal of your monster character
     * @param theMinPointToHeal capture minimum heal point your monster character
     * @param theMaxPointToHeal capture maximum heal point your monster character
     */
    public Monster(final String theMonsterName, final int theHitPoints,
                   final int theMinDamage, final int theMaxDamage,
                   final int theAttackSpeed, final double theAccuracy,
                   final int theMinPointToHeal, final int theMaxPointToHeal,
                   final double theChanceToHeal){

        super(theMonsterName, theHitPoints, theMinDamage, theMaxDamage, theAttackSpeed, theAccuracy);
        myMonsterHealthPoint = theHitPoints;
        setMonsterMinHealPoint(theMinPointToHeal);
        setMonsterMaxHealPoint(theMaxPointToHeal);
        setMonsterChanceToHeal(theChanceToHeal);

    }

    /**
     * Returns the chance to heal of the Monster character.
     *
     * @return the chance to heal of the Monster character
     */
    public double getMonsterChanceToHeal(){
        return myChanceToHeal;
    }


    /**
     * Set the minimum heal point of the Monster character.
     *
     * @param theMinHealPoint capture minimum heal point of the Monster character.
     */
    protected void setMonsterMinHealPoint(final int theMinHealPoint){
        if (theMinHealPoint < 0) {
            throw new IllegalArgumentException("The minimum heal point passed to setMonsterMinHealPoint was negative.");
        }
        myMinHealPoint = theMinHealPoint;
    }



    /**
     * Set the maximum heal point of the Monster character.
     *
     * @param theMaxHealPoint capture maximum heal point of the Monster character.
     */
    protected void setMonsterMaxHealPoint(final int theMaxHealPoint){
        if (theMaxHealPoint < 0 || theMaxHealPoint < myMinHealPoint) {
            throw new IllegalArgumentException("The maximum heal point passed to setMonsterMaxHealPoint was negative." +
                    "Max heal point also should not be set to be less than min heal point");
        }
        myMaxHealPoint = theMaxHealPoint;
    }


    /**
     * Set the chance to heal for the Monster character.
     *
     * @param theChanceToHeal capture the chance to heal of the Monster character.
     */
    protected void setMonsterChanceToHeal(final double theChanceToHeal){
        if(theChanceToHeal > 100.0 || theChanceToHeal <= 0){
            throw new IllegalArgumentException("the chance to heal was either greater than 100 percent or less than or equal to 0.");

        }
        myChanceToHeal = theChanceToHeal / 100;
    }



    /**
     * Return a random generated heal value based on the Monster character's range of minimum and maximum heal point
     *
     *
     * @return the integer generated heal amount
     */
    protected int generateHealValue(){
        int healAmount = MY_RANDOM.nextInt((myMaxHealPoint+1) - myMinHealPoint) + myMinHealPoint;

        // Making sure Monster won't heal pass their maximum hit points
        if(healAmount + getHitPoints() > myMonsterHealthPoint){
            healAmount = myMonsterHealthPoint - getHitPoints();
        }
        return healAmount;


    }

    /**
     * Returns the percentage chance to trigger a healing for the monster character.
     *
     * @return true if the monster character successfully heal; false otherwise
     */
    protected boolean checkChanceToHeal(){
        return MY_RANDOM.nextDouble() < myChanceToHeal;
    }



    /**
     * Based on its health, check to see whether the monster character requires a passive heal.
     * If the monster's health point is depleted or the monster fainted, it cannot heal.
     * Otherwise, based on chance, the monster may receive a successful generate amount of healing
     * to its health point or fail to heal at all.
     *
     *
     *
     */
    public void heal(){
        int healAmount = generateHealValue();

        if (getHitPoints() == myMonsterHealthPoint){
            myMonsterHealResult = getCharacterName() + "'s health (" + getHitPoints() + ") is full so cannot heal";

        } else if (isAlive() && getHitPoints() < myMonsterHealthPoint) {

            if (checkChanceToHeal()){
                myMonsterHealResult = getCharacterName() + " healed for " + healAmount + "(" + getHitPoints() + " + " + healAmount + ")\n";
                increaseHitPoints(healAmount);
                myMonsterHealResult += getCharacterName() + "'s health is now " + getHitPoints();
                myMonsterHealthPoint  += healAmount;
            } else {
                myMonsterHealResult = getCharacterName() + " failed to heal";
            }
        }

    }

    /**
     * Returns healing result of the Monster character.
     *
     * @return healing result of the Monster character.
     */
    public String getHealResult(){
        return myMonsterHealResult;
    }



}