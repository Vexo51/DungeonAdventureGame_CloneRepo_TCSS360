package model;

import java.util.Random;

/**
 * This class will represent all the Rooms inside the
 * dungeon maze.
 *
 * @author Tyler Nguyen
 * @version 11-16-23
 */

public class Room {

    /**
     * For any Random value info.
     */
    private final Random myRand = new Random();

    /**
     * If the Room has a healing potion.
     */
    private boolean myHasHealingPotion;

    /**
     * If the Room has a vision potion.
     */
    private boolean myHasVisionPotion;

    /**
     * The value the healing potion will do.
     */
    private int myHealingAmount;

    /**
     * If the Room has a pit.
     */
    private boolean myHasPit;

    /**
     * The amount of Damage the pit will inflict.
     */
    private int myPitDamage;

    /**
     * If the Room is an Entrance.
     */
    private boolean myIsEntrance;

    /**
     * If the Room is the Exit.
     */
    private boolean myIsExit;

    /**
     * If the Room contains a OO Pillar.
     */
    private boolean myHasOOPillar;

    /**
     * If the Room has a North Door.
     */
    private boolean myNorthDoor;

    /**
     * If the Room has a East Door.
     */
    private boolean myEastDoor;

    /**
     * If the Room has a South Door.
     */
    private boolean mySouthDoor;

    /**
     * If the Room has a West Door.
     */
    private boolean myWestDoor;

    /**
     * The specific OO Pillar a Room contains.
     */
    private String mySpecificOOPillar;

    /**
     * Default constructor for the Room.
     */
    public Room() {
        myHasHealingPotion = false;
        myHasVisionPotion = false;
        myHasPit = false;
        myIsEntrance = false;
        myIsExit = false;
        myHasOOPillar = false;
        myNorthDoor = false;
        myEastDoor = false;
        mySouthDoor = false;
        myWestDoor = false;
    }

    /**
     * Constructs the Room with all the following details relating to the Room.
     *
     * @param theHasHealingPotion is if the Room contains a healing potion.
     * @param theHasVisionPotion is if the Room contains a vision potion.
     * @param theHasPit is if the Room contains a pit.
     * @param thePitDamage is the amount of damage the pit will do if there is a pit.
     * @param theIsEntrance will show if the Room is an entrance.
     * @param theIsExit will show if the Room is an exit.
     * @param theHasOOPillar will show if the Room has an OO Pillar.
     * @param theNorthDoor will show if the Room has a North Door.
     * @param theEastDoor will show if the Room has a East Door.
     * @param theSouthDoor will show if the Room has a South Door.
     * @param theWestDoor will show if the Room has a West Door.
     * @param theSpecificOOPillar will show the specific OO Pillar the Room contains.
     */
    public Room(final boolean theHasHealingPotion, final boolean theHasVisionPotion, final boolean theHasPit, final int thePitDamage
        , final boolean theIsEntrance, final boolean theIsExit, final boolean theHasOOPillar
        , final boolean theNorthDoor, final boolean theEastDoor, final boolean theSouthDoor
        , final boolean theWestDoor, final String theSpecificOOPillar) {
        myHasHealingPotion = theHasHealingPotion;
        myHasVisionPotion = theHasVisionPotion;
        myHasPit = theHasPit;
        if (myHasPit) {
            myPitDamage = thePitDamage;
        } else {
            myPitDamage = 0;
        }
        myIsEntrance = theIsEntrance;
        myIsExit = theIsExit;
        myHasOOPillar = theHasOOPillar;
        mySpecificOOPillar = theSpecificOOPillar;
        myNorthDoor = theNorthDoor;
        myEastDoor = theEastDoor;
        mySouthDoor = theSouthDoor;
        myWestDoor = theWestDoor;
//        if (myHasOOPillar) {
//            mySpecificOOPillar = pillarGenerate();
//        }
    }


    /**
     * This will tell us if the Room contains a
     * healing potion or not.
     *
     * @return if Room contains healing potion or not.
     */
    public boolean getHasHealingPotion() {
        return myHasHealingPotion;
    }

    /**
     * This will adjust the Room's status
     * of having or not having a healing potion.
     *
     * @param theHasHealingPotion is if the Room will contain the healing potion or not.
     */
    public void setHasHealingPotion(final boolean theHasHealingPotion) {
        myHasHealingPotion = theHasHealingPotion;
    }

    /**
     * This will give us the random healing amount.
     *
     * @return the healing amount.
     */
    public int getHealingAmount() {
        return myHealingAmount = myRand.nextInt(5, 16);
    }

//    public void setHealingAmount() {
//        myHealingAmount = rand.nextInt(5, 16);
//    }

    /**
     * This will tell us if the Room contains
     * a vision potion or not.
     *
     * @return if the Room contains a vision potion or not.
     */
    public boolean getHasVisionPotion() {
        return myHasVisionPotion;
    }

    /**
     * This will adjust the Room's status
     * of having or not having a vision potion.
     *
     * @param theHasVisionPotion is if the Room will contain the vision potion or not.
     */
    public void setHasVisionPotion(final boolean theHasVisionPotion) {
        myHasVisionPotion = theHasVisionPotion;
    }

    /**
     * This will tell us if the Room contains
     * a pit or not.
     *
     * @return if the Room contains a pit or not.
     */
    public boolean getHasPit() {
        return myHasPit;
    }

    /**
     * This will adjust the Room's status
     * of having or not having a pit.
     *
     * @param theHasPit is if the Room will contain the pit or not.
     */
    public void setHasPit(final boolean theHasPit) {
        myHasPit = theHasPit;
    }

    /**
     * This will give us the pit damage.
     *
     * @return the inflicted pit damage.
     */
    public int getPitDamage() {
        return myPitDamage;
    }

    /**
     * This will tell us if the Room
     * is an entrance or not.
     *
     * @return if the Room is an entrance or not.
     */
    public boolean getIsEntrance() {
        return myIsEntrance;
    }

    /**
     * This will adjust the Room's status
     * of being an entrance or not.
     *
     * @param theHasEntrance is if the Room is an entrance or not.
     */
    public void setIsEntrance(final boolean theHasEntrance) {
        myIsEntrance = theHasEntrance;
    }

    /**
     * This will tell us if the Room
     * is an exit or not.
     *
     * @return if the Room is an exit or not.
     */
    public boolean getIsExit() {
        return myIsExit;
    }

    /**
     * Thiw will adjust the Room's status
     * of being an exit or not.
     *
     * @param theHasExit is if the Room is an exit or not.
     */
    public void setIsExit(final boolean theHasExit) {
        myIsExit = theHasExit;
    }

    /**
     * This will tell us if the Room
     * contains an OO Pillar.
     *
     * @return if the Room contains OO Pillar or not.
     */
    public boolean getHasOOPillar() {
        return myHasOOPillar;
    }

    /**
     * This will adjust the Room's status
     * of containing an OO Pillar or not.
     *
     * @param theOOPillar is if the Room contains an OO Pillar or not.
     */
    public void setHasOOPillar(final boolean theOOPillar) {
        myHasOOPillar = theOOPillar;
    }

    /**
     * This will give us the specific OO Pillar
     * a Room contains if it has an OO Pillar.
     *
     * @return the specific OO Pillar.
     */
    public String getSpecificOOPillar() {
        return mySpecificOOPillar;
    }

    /**
     * This will set the specific OO Pillar
     * inside the Room containing an OO Pillar.
     *
     * @param theSpecificOOPillar is the specific OO Pillar.
     */
    public void setSpecificOOPillar(final String theSpecificOOPillar) {
        mySpecificOOPillar = theSpecificOOPillar;
    }

    /**
     * This will reset the Room to contain
     * nothing.
     */
    public void resetRoom() {
        setHasHealingPotion(false);
        setHasVisionPotion(false);
        setHasPit(false);
    }

    /**
     * This will tell us if the Room has
     * a North Door or not.
     *
     * @return if the Room has a North Door.
     */
    public boolean getNorthDoor() {
        return myNorthDoor;
    }

    /**
     * This will adjust the Room's status
     * of having a North Door or not.
     *
     * @param theNorthDoor is if the Room has an North Door or not.
     */
    public void setNorthDoor(final boolean theNorthDoor) {
        myNorthDoor = theNorthDoor;
    }

    /**
     * This will tell us if the Room has
     * an East Door or not.
     *
     * @return if the Room has an East Door.
     */
    public boolean getEastDoor() {
        return myEastDoor;
    }

    /**
     * This will adjust the Room's status
     * of having an East Door or not.
     *
     * @param theEastDoor is if the Room has an East Door or not.
     */
    public void setEastDoor(final boolean theEastDoor) {
        myEastDoor = theEastDoor;
    }

    /**
     * This will tell us if the Room has
     * a South Door or not.
     *
     * @return if the Room has a South Door.
     */
    public boolean getSouthDoor() {
        return mySouthDoor;
    }

    /**
     * This will adjust the Room's status
     * of having a South Door or not.
     *
     * @param theSouthDoor is if the Room has a South Door or not.
     */
    public void setSouthDoor(final boolean theSouthDoor) {
        mySouthDoor = theSouthDoor;
    }

    /**
     * This will tell us if the Room has
     * a West Door or not.
     *
     * @return if the Room has a West Door.
     */
    public boolean getWestDoor() {
        return myWestDoor;
    }

    /**
     * This will adjust the Room's status
     * of having a West Door or not.
     *
     * @param theWestDoor is if the Room has a West Door or not.
     */
    public void setWestDoor(final boolean theWestDoor) {
        myWestDoor = theWestDoor;
    }

    /**
     * This will create the Rooms randomly for the
     * dungeon maze.
     *
     * @return the randomized Room.
     */
    public Room createRandomRoom() {
        myHasHealingPotion = myRand.nextInt(1, 101) < 10;
        myHasVisionPotion = myRand.nextInt(1, 101) < 10;
        myHasPit = myRand.nextInt(1, 101) < 10;
        myPitDamage = myRand.nextInt(1, 21);
        myNorthDoor = myRand.nextBoolean();
        myEastDoor = myRand.nextBoolean();
        mySouthDoor = myRand.nextBoolean();
        myWestDoor = myRand.nextBoolean();
        return new Room(myHasHealingPotion, myHasVisionPotion, myHasPit, myPitDamage, false, false, false, myNorthDoor, myEastDoor, mySouthDoor, myNorthDoor, "");
    }

//    public Room makeRoomEmpty(Room theRoomLocation) {
//        theRoomLocation.resetRoom();
//        return theRoomLocation;
//    }

    /**
     * This will randomly generate pillars for the
     * Rooms containing an OO Pillar.
     *
     * @return the specific OO Pillar for the Room.
     */
    public String pillarGenerate() {
        int pillarChooser = myRand.nextInt(1, 5);
        if (pillarChooser == 1 ) {
            setSpecificOOPillar("A");
            return getSpecificOOPillar();
        } else if (pillarChooser == 2) {
            setSpecificOOPillar("E");
            return getSpecificOOPillar();
        } else if (pillarChooser == 3) {
            setSpecificOOPillar("I");
            return getSpecificOOPillar();
        } else if (pillarChooser == 4) {
            setSpecificOOPillar("P");
            return getSpecificOOPillar();
        } else {
            pillarGenerate();
        }
        return " ";
    }

    /**
     * This will display what the Room contains.
     *
     * @return the specific symbol that represents what the Room contains.
     */
    public String roomContains() {
        if (getIsEntrance()) {
            return "i";
        } else if (getIsExit()) {
            return "O";
        } else if (getHasPit() && getHasHealingPotion() ||
                getHasPit() && getHasVisionPotion() ||
                getHasHealingPotion() && getHasVisionPotion() ||
                getHasHealingPotion() && getHasVisionPotion() && getHasPit()) {
            return "M";
        } else if (getHasPit()) {
            return "X";
        } else if (getHasVisionPotion()) {
            return "V";
        } else if (getHasHealingPotion()) {
            return "H";
        }
        else if (getHasOOPillar()) {
            return getSpecificOOPillar();
        }
        else {
            return " ";
        }
    }

    /**
     * This will print out the specific room that the
     * adventurer is in.
     *
     * @param theRoom is the current room adventurer is in.
     * @return the String representation of the room.
     */
    public String noVisionString(final Room theRoom) {
        StringBuilder roomDisplay = new StringBuilder();
        if (theRoom.getNorthDoor()) {
            roomDisplay.append("*-");
        } else {
            roomDisplay.append("**");
        }
        roomDisplay.append("*\n");
        if (theRoom.getWestDoor()) {
            roomDisplay.append("|");
        } else {
            roomDisplay.append("*");
        }
        roomDisplay.append("C");
        if (theRoom.getEastDoor()) {
            roomDisplay.append("|");
        } else {
            roomDisplay.append("*");
        }
        roomDisplay.append("\n");
        if (theRoom.getSouthDoor()) {
            roomDisplay.append("*-");
        } else {
            roomDisplay.append("**");
        }
        roomDisplay.append("*");

        return roomDisplay.toString();
    }

    public String yesVisionString(final int theCurrentRow, final int theCurrentColumn) {
        StringBuilder roomDisplay = new StringBuilder();
//        if (theCurrentColumn - 1 != )
//        for (int i = )

        return roomDisplay.toString();
    }

    /**
     * This will print out the Maze.
     *
     * @param theMaze is the complete dungeon maze.
     * @return the String representation of the maze.
     */
    public String toString(final Room[][] theMaze) {
        StringBuilder mazeDisplay = new StringBuilder();
        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
                if (theMaze[i][j].getNorthDoor() && i != 0) {
                    mazeDisplay.append("*-");
                } else {
                    mazeDisplay.append("**");
                }
            }
            mazeDisplay.append("*\n");
            for (int k = 0; k < theMaze[i].length; k++) {
                if (theMaze[i][k].getWestDoor() && k != 0) {
                    mazeDisplay.append("|");
                } else if (!theMaze[i][k].getWestDoor() || k == 0) {
                    mazeDisplay.append("*");
                }
                mazeDisplay.append(theMaze[i][k].roomContains());
            }

            mazeDisplay.append("*\n");
        }
        for (int l = 0; l < theMaze[0].length; l++) {
            mazeDisplay.append("**");
        }
        mazeDisplay.append("*");

        return mazeDisplay.toString();
    }

}
