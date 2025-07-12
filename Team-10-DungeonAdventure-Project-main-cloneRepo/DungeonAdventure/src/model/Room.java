package model;

import java.io.Serializable;
import java.util.Random;

/**
 * This class will represent all the Rooms inside the
 * dungeon maze.
 *
 * @author Tyler Nguyen
 * @version 11-16-23
 */

public class Room implements Serializable {

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
     * This will keep track of the monster.
     */
    private Monster myMonster;

    /**
     * If the Room is an Entrance.
     */
    private boolean myIsEntrance;

    /**
     * If the Room is the Exit.
     */
    private boolean myIsExit;

    /**
     * If the Room contains a OOP Pillar.
     */
    private boolean myHasOOPPillar;

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
     * If the Room contains a monster or not.
     */
    private boolean myHasMonster;

    /**
     * The specific OO Pillar a Room contains.
     */
    private String mySpecificOOPPillar;

    /**
     * Default constructor for the Room.
     */
    public Room() {
        myHasHealingPotion = false;
        myHasVisionPotion = false;
        myHasPit = false;
        myIsEntrance = false;
        myIsExit = false;
        myHasOOPPillar = false;
        myNorthDoor = false;
        myEastDoor = false;
        mySouthDoor = false;
        myWestDoor = false;
        myHasMonster = false;
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
     * @param theHasOOPPillar will show if the Room has an OO Pillar.
     * @param theNorthDoor will show if the Room has a North Door.
     * @param theEastDoor will show if the Room has a East Door.
     * @param theSouthDoor will show if the Room has a South Door.
     * @param theWestDoor will show if the Room has a West Door.
     * @param theSpecificOOPPillar will show the specific OO Pillar the Room contains.
     * @param theHasMonster will show if the Room contains a monster or not.
     */
    public Room(final boolean theHasHealingPotion, final boolean theHasVisionPotion, final boolean theHasPit, final int thePitDamage
        , final boolean theIsEntrance, final boolean theIsExit, final boolean theHasOOPPillar
        , final boolean theNorthDoor, final boolean theEastDoor, final boolean theSouthDoor
        , final boolean theWestDoor, final String theSpecificOOPPillar, final boolean theHasMonster) {
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
        myHasOOPPillar = theHasOOPPillar;
        mySpecificOOPPillar = theSpecificOOPPillar;
        myNorthDoor = theNorthDoor;
        myEastDoor = theEastDoor;
        mySouthDoor = theSouthDoor;
        myWestDoor = theWestDoor;
        myHasMonster = theHasMonster;
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
        myPitDamage = myRand.nextInt(1, 21);
        return myPitDamage;
    }

    public Monster getMonster() {
        return myMonster;
    }

    public void setMonster(Monster theMonster) {
        myMonster = theMonster;
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
    public boolean getHasOOPPillar() {
        return myHasOOPPillar;
    }

    /**
     * This will adjust the Room's status
     * of containing an OO Pillar or not.
     *
     * @param theOOPPillar is if the Room contains an OO Pillar or not.
     */
    public void setHasOOPPillar(final boolean theOOPPillar) {
        myHasOOPPillar = theOOPPillar;
    }

    /**
     * This will give us the specific OO Pillar
     * a Room contains if it has an OO Pillar.
     *
     * @return the specific OO Pillar.
     */
    public String getSpecificOOPPillar() {
        return mySpecificOOPPillar;
    }

    /**
     * This will set the specific OO Pillar
     * inside the Room containing an OO Pillar.
     *
     * @param theSpecificOOPPillar is the specific OO Pillar.
     */
    public void setSpecificOOPPillar(final String theSpecificOOPPillar) {
        mySpecificOOPPillar = theSpecificOOPPillar;
    }

    /**
     * This will reset the Room to contain
     * nothing.
     */
    public void resetRoom() {
        setHasHealingPotion(false);
        setHasVisionPotion(false);
        setHasPit(false);
        setHasMonster(false);
        setHasOOPPillar(false);
    }

    public void collectRoom() {
        setHasHealingPotion(false);
        setHasVisionPotion(false);
        setHasPit(false);
        setHasOOPPillar(false);
    }

    /**
     * This will make the Room have no doors.
     */
    public void closeAllDoors() {
        setNorthDoor(false);
        setEastDoor(false);
        setSouthDoor(false);
        setWestDoor(false);
    }

    /**
     * This will make the Room have all doors.
     */
    public void openAllDoors() {
        setNorthDoor(true);
        setEastDoor(true);
        setSouthDoor(true);
        setWestDoor(true);
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
     * This will tell us if the Room has
     * a monster or not.
     *
     * @return if the Room has a monster.
     */
    public boolean getHasMonster() {
        return myHasMonster;
    }

    /**
     * This will adjust the Room's status
     * of having a monster or not.
     *
     * @param theHasMonster is if the Room has a monster or not.
     */
    public void setHasMonster(final boolean theHasMonster) {
        myHasMonster = theHasMonster;
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
        return new Room(myHasHealingPotion, myHasVisionPotion, myHasPit, myPitDamage, false, false, false, myNorthDoor, myEastDoor, mySouthDoor, myNorthDoor, "", false);
    }

    /**
     * This will randomly generate pillars for the
     * Rooms containing an OO Pillar.
     *
     * @return the specific OO Pillar for the Room.
     */
    public String pillarGenerate() {
        int pillarChooser = myRand.nextInt(1, 5);
        if (pillarChooser == 1 ) {
            setSpecificOOPPillar("A");
            return getSpecificOOPPillar();
        } else if (pillarChooser == 2) {
            setSpecificOOPPillar("E");
            return getSpecificOOPPillar();
        } else if (pillarChooser == 3) {
            setSpecificOOPPillar("I");
            return getSpecificOOPPillar();
        } else if (pillarChooser == 4) {
            setSpecificOOPPillar("P");
            return getSpecificOOPPillar();
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
        else if (getHasOOPPillar()) {
            return getSpecificOOPPillar();
        }
        else {
            return " ";
        }
    }

    /**
     * This will print the room indicated
     *
     * @param theRoom is the Room wanting to be printed.
     * @return the information of the Room.
     */
    public String currentRoomToString(final Room theRoom) {
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
        roomDisplay.append(roomContains());
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

    /**
     * This will print out of all the rooms that
     * surround the current location of the
     * adventurer.
     *
     * @param theMaze is the maze.
     * @param theCurrentRow is the row that the adventurer is on.
     * @param theCurrentColumn is the column that the adventurer is on.
     * @return the surrounding and current room that the adventurer is in.
     */
    public String yesVisionString(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        StringBuilder roomDisplay = new StringBuilder();
        if (isCornerEdge(theMaze, theCurrentRow, theCurrentColumn)) {
            final String cornerLocation = whichCornerEdge(theMaze, theCurrentRow, theCurrentColumn);
            if (cornerLocation.equals("Top Left")) {
                roomDisplay.append(topLeftPrint(theMaze, theCurrentRow, theCurrentColumn));
            } else if (cornerLocation.equals("Top Right")) {
                roomDisplay.append(topRightPrint(theMaze, theCurrentRow, theCurrentColumn));
            } else if (cornerLocation.equals("Bottom Left")) {
                roomDisplay.append(bottomLeftPrint(theMaze, theCurrentRow, theCurrentColumn));
            } else if (cornerLocation.equals("Bottom Right")) {
                roomDisplay.append(bottomRightPrint(theMaze, theCurrentRow, theCurrentColumn));
            }
        } else if (isEdge(theMaze, theCurrentRow, theCurrentColumn)) {
            if (theCurrentRow == 0) {
                roomDisplay.append(topPrint(theMaze, theCurrentRow, theCurrentColumn));
            } else if (theCurrentColumn == 0) {
                roomDisplay.append(leftPrint(theMaze, theCurrentRow, theCurrentColumn));
            } else if (theCurrentRow == theMaze.length - 1) {
                roomDisplay.append(bottomPrint(theMaze, theCurrentRow, theCurrentColumn));
            } else if (theCurrentColumn == theMaze[0].length - 1) {
                roomDisplay.append(rightPrint(theMaze, theCurrentRow, theCurrentColumn));
            }
        } else {
            roomDisplay.append(surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn
                    , theCurrentRow - 1, theCurrentRow + 1, theCurrentColumn - 1, theCurrentColumn + 1));
        }
        return roomDisplay.toString();
    }

    /**
     * This will check if the adventurer's location is
     * an edge or not.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return whether the location is an edge or not.
     */
    private boolean isEdge(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        if (theCurrentRow == 0 || theCurrentRow == theMaze.length - 1) {
            return true;
        } else if (theCurrentColumn == 0 || theCurrentColumn == theMaze[0].length - 1) {
            return true;
        }
        return false;
    }

    /**
     * This will check if the adventurer's location is
     * at the corner of the map.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return whether the location is a corner edge or not.
     */
    private boolean isCornerEdge(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        if (theCurrentRow == 0 && theCurrentColumn == 0 || theCurrentRow == theMaze.length - 1 && theCurrentColumn == theMaze[theCurrentRow].length - 1
            || theCurrentRow == 0 && theCurrentColumn == theMaze[theCurrentRow].length - 1 || theCurrentRow == theMaze.length - 1 && theCurrentColumn == 0) {
            return true;
        }
        return false;
    }

    /**
     * This will tell us which corner the
     * adventurer is in.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return which corner the adventurer is at.
     */
    private String whichCornerEdge(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        if (theCurrentRow == 0 && theCurrentColumn == 0) {
            return "Top Left";
        } else if (theCurrentRow == 0 && theCurrentColumn == theMaze[theCurrentRow].length - 1) {
            return "Top Right";
        } else if (theCurrentRow == theMaze.length - 1 && theCurrentColumn == 0) {
            return "Bottom Left";
        } else if (theCurrentRow == theMaze.length - 1 && theCurrentColumn == theMaze[theCurrentRow].length - 1) {
            return "Bottom Right";
        }
        return "Not Corner";
    }

    /**
     * This will print the rooms that surround
     * the current room the adventurer is in
     * when the vision potion is active.
     *
     * @param theMaze is the maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @param theStartRow is the start row of the room printing.
     * @param theEndRow is the end row of the room printing.
     * @param theStartColumn is the start column of the room printing.
     * @param theEndColumn is the end column of the room printing.
     * @return the surrounding rooms of the adventurer.
     */
    private String surroundingRoomPrinter(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn
            , final int theStartRow, final int theEndRow, final int theStartColumn, final int theEndColumn) {
        StringBuilder mazeDisplay = new StringBuilder();
        for (int i = theStartRow; i <= theEndRow; i++) {
            for (int j = theStartColumn; j <= theEndColumn; j++) {
                if (theMaze[i][j].getNorthDoor() && i != 0) {
                    mazeDisplay.append("*-");
                } else {
                    mazeDisplay.append("**");
                }
            }
            mazeDisplay.append("*\n");
            for (int k = theStartColumn; k <= theEndColumn; k++) {
                if (theMaze[i][k].getWestDoor() && k != 0) {
                    mazeDisplay.append("|");
                } else if (!theMaze[i][k].getWestDoor() || k == 0) {
                    mazeDisplay.append("*");
                }
                if (i == theCurrentRow && k == theCurrentColumn) {
                    mazeDisplay.append("C");
                } else {
                    mazeDisplay.append(theMaze[i][k].roomContains());
                }
            }
            if (theEndColumn != theMaze[i].length - 1) {
                if (theMaze[i][theEndColumn + 1].getWestDoor()) {
                    mazeDisplay.append("|\n");
                } else {
                    mazeDisplay.append("*\n");
                }
            } else {
                mazeDisplay.append("*\n");
            }
        }
        if (theEndRow != theMaze.length - 1) {
            for (int l = theStartColumn; l <= theEndColumn; l++) {
                if (theMaze[theCurrentRow + 2][l].getNorthDoor()) {
                    mazeDisplay.append("*-");
                } else {
                    mazeDisplay.append("**");
                }
            }
        } else {
            for (int l = theStartColumn; l <= theEndColumn; l++) {
                mazeDisplay.append("**");
            }
        }
        mazeDisplay.append("*");
        return mazeDisplay.toString();
    }

    /**
     * This will print the surrounding rooms
     * if the adventurer is at the top left room
     * of the maze.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return the rooms that surround the top left room.
     */
    private String topLeftPrint(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        return surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn, theCurrentRow, theCurrentRow + 1, theCurrentColumn, theCurrentColumn + 1);
    }

    /**
     * This will print the surrounding rooms
     * if the adventurer is at the top right room
     * of the maze.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return the rooms that surround the top right room.
     */
    private String topRightPrint(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        return surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn, theCurrentRow, theCurrentRow + 1, theCurrentColumn - 1, theCurrentColumn);
    }

    /**
     * This will print the surrounding rooms
     * if the adventurer is at the bottom left room
     * of the maze.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return the rooms that surround the bottom left room.
     */
    private String bottomLeftPrint(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        return surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn, theCurrentRow - 1, theCurrentRow, theCurrentColumn, theCurrentColumn + 1);
    }

    /**
     * This will print the surrounding rooms
     * if the adventurer is at the bottom right room
     * of the maze.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return the rooms that surround the bottom right room.
     */
    private String bottomRightPrint(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        return surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn, theCurrentRow - 1, theCurrentRow, theCurrentColumn - 1, theCurrentColumn);
    }

    /**
     * This will print the surrounding rooms
     * if the adventurer is at the very top side
     * of the maze.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return the rooms that surround the top room.
     */
    private String topPrint(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        return surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn, theCurrentRow, theCurrentRow + 1, theCurrentColumn - 1, theCurrentColumn + 1);
    }

    /**
     * This will print the surrounding rooms
     * if the adventurer is at the very left side
     * of the maze.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return the rooms that surround the left room.
     */
    private String leftPrint(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        return surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn, theCurrentRow - 1, theCurrentRow + 1, theCurrentColumn, theCurrentColumn + 1);
    }

    /**
     * This will print the surrounding rooms
     * if the adventurer is at the very bottom side
     * of the maze.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return the rooms that surround the bottom room.
     */
    private String bottomPrint(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        return surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn, theCurrentRow - 1, theCurrentRow, theCurrentColumn - 1, theCurrentColumn + 1);
    }

    /**
     * This will print the surrounding rooms
     * if the adventurer is at the very right side
     * of the maze.
     *
     * @param theMaze is the dungeon maze.
     * @param theCurrentRow is the row location of the adventurer.
     * @param theCurrentColumn is the column location of the adventurer.
     * @return the rooms that surround the right room.
     */
    private String rightPrint(final Room[][] theMaze, final int theCurrentRow, final int theCurrentColumn) {
        return surroundingRoomPrinter(theMaze, theCurrentRow, theCurrentColumn, theCurrentRow - 1, theCurrentRow + 1, theCurrentColumn - 1, theCurrentColumn);
    }

    /**
     * This will print the current room but enlarged.
     *
     * @param theCurrentRoom is the current room.
     * @param theDirection is the direction the user is facing.
     * @return the enlarged current room.
     */
    public String currentRoomLarge(final Room theCurrentRoom, final String theDirection) {
        StringBuilder roomDisplay = new StringBuilder();
        if (theCurrentRoom.getNorthDoor()) {
            roomDisplay.append("/=====          =====\\\n");
        } else {
            roomDisplay.append("\\=====----------=====/\n");
        }
        roomDisplay.append("||                  ||\n" +
                           "||                  ||\n");
        if (theCurrentRoom.getWestDoor() && theCurrentRoom.getEastDoor()) {
            roomDisplay.append("                      \n" +
                               "           ");
        } else if (!theCurrentRoom.getWestDoor() && theCurrentRoom.getEastDoor()) {
            roomDisplay.append("|                     \n" +
                               "|          ");

        } else if (theCurrentRoom.getWestDoor() && !theCurrentRoom.getEastDoor()) {
            roomDisplay.append("                     |\n" +
                               "           ");
        } else {
            roomDisplay.append("|                    |\n" +
                               "|          ");
        }

        if (theDirection.equalsIgnoreCase("Up")) {
            roomDisplay.append("^");
        } else if (theDirection.equalsIgnoreCase("Left")) {
            roomDisplay.append("<");
        } else if (theDirection.equalsIgnoreCase("Down")) {
            roomDisplay.append("V");
        } else if (theDirection.equalsIgnoreCase("Right")) {
            roomDisplay.append(">");
        } else if (theDirection.equalsIgnoreCase("C")) {
            roomDisplay.append("C");
        }

        if (theCurrentRoom.getWestDoor() && theCurrentRoom.getEastDoor()) {
            roomDisplay.append("         \n" +
                               "                      \n");
        } else if (!theCurrentRoom.getWestDoor() && theCurrentRoom.getEastDoor()) {
            roomDisplay.append("         \n" +
                               "|                     \n");

        } else if (theCurrentRoom.getWestDoor() && !theCurrentRoom.getEastDoor()) {
            roomDisplay.append("         |\n" +
                               "                     |\n");
        } else {
            roomDisplay.append("         |\n" +
                               "|                    |\n");
        }


        roomDisplay.append("||                  ||\n" +
                           "||                  ||\n");

        if (theCurrentRoom.getSouthDoor()) {
            roomDisplay.append("/=====          =====\\\n");
        } else {
            roomDisplay.append("\\=====----------=====/\n");
        }

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
