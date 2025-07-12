package model;




/**
 for using Random class
 */
import java.util.Random;


/**
 * This class represents a Dungeon character.
 *
 *
 *
 * @author Dung Nguyen
 * @version 11/05/2023
 */
public abstract class DungeonCharacter {


    /**
     A class constant for generating random output (either integer or double)
     that is visible to other classes.
     */
    public final static Random MY_RANDOM = new Random();

    /**
     the name of the character.
     */
    private String myName;

    /**
     the hit points of the character.
     */
    private int myHitPoints;

    /**
     the minimum damage the character can do.
     */
    private int myMinDamage;

    /**
     the maximum damage the character can do.
     */
    private int myMaxDamage;

    /**
     the attack speed of the character.
     */
    private int myAttackSpeed;

    /**
     the chance to hit (accuracy) of the character.
     */
    private double myAccuracy;



    /**
     * Constructs a DungeonCharacter with a specified
     * stats/fields such as Character name, health point, attack speed,
     * the min and the max damage a character can do,the chance to hit for a character.
     *
     *
     * @param theCharacterName capture the character name of your character
     * @param theHitPoints capture the hit points of your character
     * @param theAttackSpeed capture the attack speed of your character
     * @param theMinDamage capture the minimum damage your character can do
     * @param theMaxDamage capture the maximum damage your character can do
     * @param theAccuracy capture the chance to hit (accuracy) of your character
     */
    protected DungeonCharacter(final String theCharacterName, final int theHitPoints,
                            final int theMinDamage, final int theMaxDamage,
                            final int theAttackSpeed, final double theAccuracy){
        setName(theCharacterName);
        setHitPoints(theHitPoints);
        setMinDamage(theMinDamage);
        setMaxDamage(theMaxDamage);
        setAttackSpeed(theAttackSpeed);
        setAccuracy(theAccuracy);

    }


    /**
     * Returns name of the character.
     *
     * @return the name of the character
     */
    public String getCharacterName(){
        return myName;
    }


    /**
     * Returns hit points of the character.
     *
     * @return the hit points of the character
     */
    public int getHitPoints(){
        return myHitPoints;
    }


    /**
     * Returns the minimum damage the character can do.
     *
     * @return the minimum damage the character can do
     */
    public int getMinDamage(){
        return myMinDamage;
    }


    /**
     * Returns the maximum damage the character can do.
     *
     * @return the maximum damage the character can do
     */
    public int getMaxDamage(){
        return myMaxDamage;
    }


    /**
     * Returns attack speed of the character.
     *
     * @return the attack speed of the character
     */
    public int getAttackSpeed(){
        return myAttackSpeed;
    }


    /**
     * Returns the chance to hit (accuracy) of the character.
     *
     * @return the chance to hit (accuracy) of the character
     */
    public double getAccuracy(){
        return myAccuracy;
    }


    /**
     * Set the name of the character.
     *
     * @param theName capture the name of your character
     */
    protected void setName(final String theName){
        if (theName == null || theName.length() == 0) {
            throw new IllegalArgumentException("Name passed to setName was null or empty");
        }
        myName = theName;
    }


    /**
     * Set the hit points of the character.
     *
     * @param theHitPoints capture the hit points of your character
     */
    protected void setHitPoints(final int theHitPoints){
        if (theHitPoints <= 0) {
            throw new IllegalArgumentException("Character's health points shouldn't be set to negative or zero");
        }
        myHitPoints = theHitPoints;
    }


    /**
     * Set the minimum damage the character can do.
     *
     * @param theMinDamage capture the minimum damage your character can do
     */
    protected void setMinDamage(final int theMinDamage){
        if (theMinDamage < 0 ) {
            throw new IllegalArgumentException("the Minimum damage was a negative or zero. Minimum damage should be greater than or equal to 0.");
        }

        myMinDamage = theMinDamage;
    }


    /**
     * Set the maximum damage the character can do.
     *
     * @param theMaxDamage capture the maximum damage your character can do
     */
    protected void setMaxDamage(final int theMaxDamage){
        if (theMaxDamage > 100 || theMaxDamage < 0 || theMaxDamage < myMinDamage){
            throw new IllegalArgumentException("the Max damage should be greater than zero and no greater than 100. Max damage should not be set the same as min damage");
        }

        myMaxDamage = theMaxDamage;
    }



    /**
     * Set the attack speed of the character.
     *
     * @param theAttackSpeed capture the attack speed of your character
     */
    protected  void setAttackSpeed(final int theAttackSpeed){
        if (theAttackSpeed <= 0){
            throw new IllegalArgumentException("the attack speed was negative or zero. " +
                                               "It should always be positive and greater than zero");
        }
        myAttackSpeed = theAttackSpeed;

    }


    /**
     * Set the chance to hit (accuracy) of the character.
     *
     * @param theAccuracy capture the accuracy of your character
     */
    protected void setAccuracy(final double theAccuracy){
        if(theAccuracy > 100.0 || theAccuracy <= 0){
            throw new IllegalArgumentException("the accuracy was either greater than 100 percent or less than or equal to 0.");

        }
        myAccuracy = theAccuracy / 100.0;
    }


    /**
     * Subtract the hit point of the character base on the damages amount and
     * check if the character is alive and report it.
     *
     *
     *
     * @param theSubtractedValue capture the integer damage amount
     */
    protected void subtractHitPoints(final int theSubtractedValue) {
        if (theSubtractedValue < 0) {
            throw new IllegalArgumentException("theSubtractedValue was negative");
        }

        myHitPoints -= theSubtractedValue;
        if (!isAlive()){
            myHitPoints = 0;
            System.out.println(myName + " has fainted.");
        }
    }

    /**
     * Increase your character's health based on an amount of hit points.
     *
     * @param theAmount capture an integer amount of hit points to add to your character's health
     */
    protected void increaseHitPoints(final int theAmount){
        if (theAmount < 0) {
            throw new IllegalArgumentException("theAmount shouldn't be less than 0 when adding to hit points");
        }
        myHitPoints += theAmount;
    }


    /**
     * Return whether the character successfully hit or miss an attack.
     *
     * @return true if the character hit an attack; false otherwise
     */
    protected boolean hasAttackHit(){
        return MY_RANDOM.nextDouble() <= myAccuracy;
    }


    /**
     * Return whether the character is alive or not
     * based on whether their hit points reaches 0 or below it.
     *
     * @return true if my character is alive; false otherwise
     */
    public boolean isAlive(){
        return myHitPoints > 0;
    }


    /**
     * Return a random generated damage value based on the character's range of minimum and maximum damage
     *
     *
     * @return the integer generated damage value
     */
    protected int generateDamagesValue(){
        return MY_RANDOM.nextInt((myMaxDamage+1) - myMinDamage) + myMinDamage;
    }



    /**
     * A DungeonCharacter will deal an attack toward another DungeonCharacter (the opponent)
     * the attack will generate a damage value to be applied toward an opponent
     * the attack will have a chance to hit or miss the opponent.
     *
     *
     *
     * @param theOpponent capture a DungeonCharacter to be attack by another DungeonCharacter
     */
    public void Attack(DungeonCharacter theOpponent){
        if (theOpponent == null) {
            throw new IllegalArgumentException("the opponent DungeonCharacter passed to attack was null");
        }

        if(isAlive() && theOpponent.isAlive()){
            int damage = generateDamagesValue();

            if(hasAttackHit()){
                System.out.println("Success! " + myName + " hits " + theOpponent.getCharacterName()
                        + " for " + damage + " damages! (" + theOpponent.getHitPoints() + " - " + damage + ")");
                theOpponent.subtractHitPoints(damage);
            } else {
                System.out.println(myName + " missed the attack on " + theOpponent.getCharacterName());
            }
        }



    }


    /**
     * Return a string containing character's name, hit points, damage range, attack speed and accuracy
     *
     * @return a string containing character's name, hit points, damage range, attack speed and accuracy
     */
    public String toString(){
        return "Name: " + myName + "\n"
                + "HP: " + myHitPoints + "\n"
                + "Damage range: " + myMinDamage + "-" + myMaxDamage + "\n"
                + "Attack speed: " + myAttackSpeed + "\n"
                + "Accuracy: " + myAccuracy + "(" + myAccuracy*100 + "%)" + "\n";
    }


}