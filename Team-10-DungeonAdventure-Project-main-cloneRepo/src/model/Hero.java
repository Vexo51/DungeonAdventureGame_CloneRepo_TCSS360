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

public abstract class Hero extends DungeonCharacter{


    /**
     the name of the Hero character.
     */
    private String myHeroName;

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
     * The hit points of the hero character.
     */
    private int myHeroHitPoints;


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

    public Hero(final String theCharacterName, final int theHitPoints,
                final int theMinDamage, final int theMaxDamage,
                final int theAttackSpeed, final double theAccuracy,
                final double theChanceToBlock){

        super(theCharacterName, theHitPoints, theMinDamage, theMaxDamage, theAttackSpeed, theAccuracy );
        generateAndSetMyHeroHitPoints(theHitPoints);
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
     * Returns the hit points of the Hero character.
     *
     * @return the hit points of the Hero character
     */
    public int getHeroHitPoints(){
        return myHeroHitPoints;
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
     * Generate random hit points within the range of ((max health - 25) to max health)
     * And then set hit points of the hero character.
     *
     * @param theMaxHitPoint capture hit point of your Hero character
     */
    protected void generateAndSetMyHeroHitPoints(final int theMaxHitPoint){
        int minHitPoint = theMaxHitPoint - 25;
        myHeroHitPoints = MY_RANDOM.nextInt(theMaxHitPoint - minHitPoint) + minHitPoint;
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
     * collect a string representing an OOP Pillar Piece found by the Hero character
     * and add that string piece to the array list of Found Pillars
     *
     * @param theFoundPillar capture the string of a Pillar Piece found by your Hero character
     */
    public void collectFoundPillarOfOOP(final String theFoundPillar){
        if (theFoundPillar == null || !theFoundPillar.equals("A") || !theFoundPillar.equals("E")
                || !theFoundPillar.equals("I") || !theFoundPillar.equals("P")){
            // no pillar was found
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
    protected boolean hasHeroBlock(){
        return MY_RANDOM.nextDouble() <= myChanceToBlock;
    }



    /**
     * Decreasing an amount of hit points from the Hero's health.
     *
     * @param theSubtractedValue capture an integer value of hit points to subtracted from your Hero's health
     */
    public void decreaseHeroHitPoints(final int theSubtractedValue){
        if (theSubtractedValue < 0) {
            throw new IllegalArgumentException("theSubtractedValue was negative");
        }

        myHeroHitPoints -= theSubtractedValue;
        if (!isAlive()){
            myHeroHitPoints = 0;
            System.out.println(getCharacterName() + " has fainted.");
        }
    }

    /**
     * Add an amount of hit points to your Hero's health.
     *
     * @param theAmount capture an integer amount of hit points to add to your Hero's health
     */
    protected void addingHeroHitPoints(final int theAmount){
        if (theAmount < 0) {
            throw new IllegalArgumentException("theAmount shouldn't be less than 0 when adding to hit points");
        }
        myHeroHitPoints += theAmount;
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
    public void Attack(final DungeonCharacter theOpponent) {
        if (theOpponent == null) {
            throw new IllegalArgumentException("the opponent DungeonCharacter passed to attack was null");
        }

        //  check that a hero never gets fewer attacks than a monster
        int numberOfAttacks = getAttackSpeed() / theOpponent.getAttackSpeed();
        if (numberOfAttacks < 1) {
            numberOfAttacks = 1;
            theOpponent.setAttackSpeed(1);
        }

        while (numberOfAttacks >= 1){
            super.Attack(theOpponent);
            numberOfAttacks--;
        }

    }

    /**
     * This will check which direction the adventurer can
     * go to and allow them to move to that location.
     *
     * @param theDungeon is the Dungeon map.
     */
    public void move(Dungeon theDungeon, String theDirection) {
        Room[][] mazeLocations = theDungeon.getMaze();
        Room roomUpdate = new Room();
        if (theDirection.compareToIgnoreCase("Up") == 0) {
            roomUpdate = mazeLocations[theDungeon.getAdventureRow() - 1][theDungeon.getAdventureColumn()];
        } else if (theDirection.compareToIgnoreCase("Right") == 0) {
            roomUpdate = mazeLocations[theDungeon.getAdventureRow()][theDungeon.getAdventureColumn() + 1];
        } else if (theDirection.compareToIgnoreCase("Down") == 0) {
            roomUpdate = mazeLocations[theDungeon.getAdventureRow() + 1][theDungeon.getAdventureColumn()];
        } else if (theDirection.compareToIgnoreCase("Left") == 0) {
            roomUpdate = mazeLocations[theDungeon.getAdventureRow()][theDungeon.getAdventureColumn() - 1];
        }
        theDungeon.setAdventurePosition(roomUpdate);
    }

    /**
     * This gives us the available directions
     * from where the adventurer is.
     *
     * @param theDungeon is the Dungeon map.
     */
    public void availableDirections(Dungeon theDungeon) {
        Room currentRoom = theDungeon.getAdventurePosition();
        ArrayList<String> availableDirections = new ArrayList<>();
        if (currentRoom.getNorthDoor()) {
            availableDirections.add("North Door is Available");
        }
        if (currentRoom.getEastDoor()) {
            availableDirections.add("East Door is Available");
        }
        if (currentRoom.getSouthDoor()) {
            availableDirections.add("South Door is Available");
        }
        if (currentRoom.getWestDoor()) {
            availableDirections.add("West Door is Available");
        }

        for (String availableDirection : availableDirections) {
            System.out.println(availableDirection);
        }
    }

    /**
     * This will tell us if the adventurer
     * is allowed to go a specific direction.
     *
     * @param theDungeon is the Dungeon map.
     * @param theDirection is the direction adventurer wants to go.
     * @return whether the direction is available or not.
     */
    public boolean isValidDirection(Dungeon theDungeon, String theDirection) {
        Room currentRoom = theDungeon.getAdventurePosition();
        if (theDirection.compareToIgnoreCase("Up") == 0 && currentRoom.getNorthDoor()) {
            return true;
        } else if (theDirection.compareToIgnoreCase("Right") == 0 && currentRoom.getEastDoor()) {
            return true;
        } else if (theDirection.compareToIgnoreCase("Down") == 0 && currentRoom.getSouthDoor()) {
            return true;
        } else if (theDirection.compareToIgnoreCase("Left") == 0 && currentRoom.getWestDoor()) {
            return true;
        }
        return false;
    }


    /**
     * Hero will have a special skill to be implements by every child classes that are extends from Hero
     *
     * @param theCharacter capture a DungeonCharacter to use special skill on.
     */
    public abstract void useSpecialSkill(final DungeonCharacter theCharacter);


    /**
     * Return a string containing Hero's name, Hero's hit points,
     * total number of healing potions the Hero has
     * total number of vision potions the Hero has
     * list of OOP pillar pieces found by the Hero
     *
     * @return a string containing Hero's name, Hero's hit points, total # of healing potions, total # of vision potions, list of OOP found pillar pieces
     */
    public String toString(){

        String listOfPillars = "";

        for (int i = 0; i < myFoundPillars.size(); i++){
            listOfPillars = listOfPillars + myFoundPillars.get(i) + " ";
        }

        return "Name: " + getCharacterName() + "\n"
                + "HP: " + myHeroHitPoints + "\n"
                + "Total healing potions: " + myHealingPotions + "\n"
                + "Total vision potions: " + myVisionPotions + "\n"
                + "List of pillars pieces found: " + listOfPillars + "\n";
    }











}
