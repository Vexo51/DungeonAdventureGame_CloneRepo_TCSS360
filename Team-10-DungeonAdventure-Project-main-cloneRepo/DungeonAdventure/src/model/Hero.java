package model;


/**
 for using Array list
 */
import java.util.ArrayList;



/**
 * This class represents a hero type of character (inherit from DungeonCharacter).
 *
 *
 *
 * @author Dung Nguyen
 * @version 11/05/2023
 */

public abstract class Hero extends DungeonCharacter {




    /**
     the amount of healing potions the Hero character has.
     */
    private int myHealingPotions;

    /**
     the amount of vision potions the Hero character has.
     */
    private int myVisionPotions;


    /**
     Array list of Pillar Pieces Found by the Hero Character.
     */
    private final ArrayList<String> myFoundPillars = new ArrayList<String>();

    /**
     * The chance to block for the hero character.
     */
    private double myChanceToBlock;


    /**
     the attack result of Hero whenever they attack another DungeonCharacter(Monster).
     */
    private String myHeroAttackResult;





    /**
     * Constructs a hero with a specified
     * stats/fields from DungeonCharacter (the parent class) such as Character name, health point, attack speed,
     * the min and the max damage a character can do, the chance to hit for a character.
     *
     * Initialize hero specified fields such the hero's name, the hero's hit points
     * and chance to block as a hero.
     *
     *
     *
     * @param theCharacterName capture the character name of your hero character
     * @param theHitPoints capture the hit points of your hero character
     * @param theAttackSpeed capture the attack speed of your hero character
     * @param theMinDamage capture the minimum damage your hero character can do
     * @param theMaxDamage capture the maximum damage your hero character can do
     * @param theAccuracy capture the chance to hit of your hero character
     * @param theChanceToBlock capture the chance to block of your hero character
     */

    protected Hero(final String theCharacterName, final int theHitPoints,
                final int theMinDamage, final int theMaxDamage,
                final int theAttackSpeed, final double theAccuracy,
                final double theChanceToBlock){

        super(theCharacterName, MY_RANDOM.nextInt(theHitPoints - (theHitPoints - 25)) + (theHitPoints - 25),
                theMinDamage, theMaxDamage, theAttackSpeed, theAccuracy );

        setMyChanceToBlock(theChanceToBlock);

    }




    /**
     * Returns the amount of healing potions the Hero character has.
     *
     * @return the amount of healing potions the Hero character has
     */
    public int getHealingPotions(){
        return myHealingPotions;
    }

    /**
     * Returns the amount of vision potions the Hero character has.
     *
     * @return the amount of vision potions the Hero character has
     */
    public int getVisionPotions(){
        return myVisionPotions;
    }


    /**
     * Returns the chance to block of the Hero character.
     *
     * @return the chance to block of the Hero character
     */
    public double getMyChanceToBlock(){
        return myChanceToBlock;
    }


    /**
     * Returns the array list of Pillar Pieces found by the Hero character.
     *
     * @return the array list of Pillar Pieces found by the Hero character.
     */
    public ArrayList<String> getFoundPillarsOfOOP(){
        return myFoundPillars;
    }



    /**
     * collect an amount of healing potions found by the Hero character
     * and add that amount to Hero's storage of healing potions
     *
     * @param theHealingPotions capture the amount of healing potions found by your Hero character
     */
    public void collectHealingPotions(final int theHealingPotions){
        if (theHealingPotions < 0){
            throw new IllegalArgumentException("The number of healing potions shouldn't be less than 0");
        }
        myHealingPotions += theHealingPotions;
    }


    /**
     * use one healing potion and subtract it from the Hero's storage
     */
    public void useHealingPotion() {
        myHealingPotions--;
    }

    /**
     * collect a string representing an OOP Pillar Piece found by the Hero character
     * and add that string piece to the array list of Found Pillars
     *
     * @param theFoundPillar capture the string of a Pillar Piece found by your Hero character
     */
    public void collectFoundPillarOfOOP(final String theFoundPillar){
        if (theFoundPillar == null && !theFoundPillar.equals("A") && !theFoundPillar.equals("E")
                && !theFoundPillar.equals("I") && !theFoundPillar.equals("P")){
            // no pillar was found
            throw new IllegalArgumentException("The input string for found pillar was null or wasn't equal to any of the 4 OOP pillars");
        } else {
            myFoundPillars.add(theFoundPillar);
        }
    }


    /**
     * collect an amount of vision potions found by the Hero character
     * and add that amount to Hero's storage of vision potions
     *
     * @param theVisionPotions capture the amount of vision potions found by your Hero character
     */
    public void collectVisionPotions(final int theVisionPotions){
        if (theVisionPotions < 0){
            throw new IllegalArgumentException("The number of vision potions shouldn't be less than 0");
        }
        myVisionPotions += theVisionPotions;
    }


    /**
     * use one vision potion and subtract it from the Hero's storage
     */
    public void useVisionPotion() {
        myVisionPotions--;
    }


    /**
     * Set the chance to block of the hero character.
     *
     * @param theChanceToBlock capture the chance to block of your Hero character
     */
    protected void setMyChanceToBlock(final double theChanceToBlock){
        if(theChanceToBlock > 100.0 || theChanceToBlock <= 0){
            throw new IllegalArgumentException("the chance to block was either greater than 100 percent or less than or equal to 0.");
        }
        myChanceToBlock = theChanceToBlock/100.0;
    }


    /**
     * Return whether the Hero character has blocked an attack or not
     * based on the Hero's chance to block.
     *
     * @return true if Hero blocked the attack; false otherwise
     */
    public boolean hasHeroBlock(){
        return MY_RANDOM.nextDouble() <= myChanceToBlock;
    }


    /**
     * A Hero will deal an attack toward another DungeonCharacter (the opponent)
     * and the amount of attacks is based on the Hero's attack speed
     * where the rule is that the Hero either get to attack more than once based on their attack speed
     * Or they get to attack only once toward the opponent (since we want Hero to never gets fewer attack than a monster)
     *
     *
     * @param theOpponent capture a DungeonCharacter to be attack by another DungeonCharacter
     */
    @Override
    public void attack(final DungeonCharacter theOpponent) {
        if (theOpponent == null) {
            throw new IllegalArgumentException("the opponent DungeonCharacter passed to attack was null");
        }

        myHeroAttackResult = "";

        //  check that a hero never gets fewer attacks than a monster
        int numberOfAttacks = getAttackSpeed() / theOpponent.getAttackSpeed();
        if (numberOfAttacks < 1) {
            numberOfAttacks = 1;
            theOpponent.setAttackSpeed(1);
        }

        while (numberOfAttacks >= 1){
            super.attack(theOpponent);
            if (!theOpponent.isAlive()){
                myHeroAttackResult = getAttackResult();
            } else {
                myHeroAttackResult += getAttackResult() + "\n";
            }
            numberOfAttacks--;
        }

    }


    /**
     * Returns attack result of the Hero character.
     *
     * @return attack result of the Hero character.
     */
    public String getHeroAttackResult(){
        return myHeroAttackResult;
    }



    /**
     * Return a string containing Hero's name, Hero's hit points,
     * total number of healing potions the Hero has
     * total number of vision potions the Hero has
     * list of OOP pillar pieces found by the Hero
     *
     * @return a string containing Hero's name, Hero's hit points, total # of healing potions, total # of vision potions, list of OOP found pillar pieces
     */
    public String heroToString(){

        String listOfPillars = "";

        for (int i = 0; i < myFoundPillars.size(); i++){
            listOfPillars = listOfPillars + myFoundPillars.get(i) + " ";
        }

        return "Name: " + getCharacterName() + "\n"
                + "HP: " + getHitPoints() + "\n"
                + "Total # of healing potions: " + myHealingPotions + "\n"
                + "Total # of vision potions: " + myVisionPotions + "\n"
                + "List of pillars pieces found: " + listOfPillars + "\n";
    }











}
