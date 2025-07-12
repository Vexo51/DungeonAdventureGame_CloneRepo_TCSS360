package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class will be the dungeon that
 * takes the Rooms and combine them to create
 * the whole maze map.
 *
 * @author Tyler Nguyen
 * @version 11-16-23
 */
public class Dungeon implements Serializable {

    /**
     * This is the Maze.
     */
    private Room[][] myMaze;

    /**
     * This is where the Adventurer is in the maze.
     */
    private Room myAdventurePosition;

    /**
     * This is the amount of Rows in the Maze.
     */
    private int myRows;

    /**
     * This is the amount of Columns in the Maze.
     */
    private int myColumns;

    /**
     * This is the Randomizer for anything random.
     */
    private Random myRand = new Random();

    /**
     * This is a temporary Room holder.
     */
    private Room tempRoom = new Room();

    /**
     * This is the BASE_CASE for cycling.
     */
    private int BASE_CASE = 1;

    /**
     * This will contain all the OO Pillars used so far in the maze.
     */
    private List<String> myPillarHolder;

    /**
     * This will keep track if the traversal found OO Pillar A.
     */
    private boolean myFoundPillarA;

    /**
     * This will keep track if the traversal found OO Pillar E.
     */
    private boolean myFoundPillarE;

    /**
     * This will keep track if the traversal found OO Pillar I.
     */
    private boolean myFoundPillarI;

    /**
     * This will keep track if the traversal found OO Pillar P.
     */
    private boolean myFoundPillarP;

    /**
     * This will keep track if the traversal found the exit.
     */
    private boolean myFoundExit;

    /**
     * This is a constructor if we already have
     * a map layout that we want to use.
     *
     * @param theMaze is the maze for the dungeon.
     */
    public Dungeon(final Room[][] theMaze) {
        myMaze = theMaze;
        myPillarHolder = new ArrayList<>();
        myRows = theMaze.length;
        myColumns = theMaze[0].length;
        myAdventurePosition = getEntrance();
        addMonster();
    }

    /**
     * This will create the maze and generate all the
     * necessities within the maze.
     *
     * @param theRows is the amount of rows in maze.
     * @param theColumns is the amount of columns in maze.
     */
    public Dungeon(final int theRows, final int theColumns) {
        if (theRows <= 0 || theColumns <= 0 || theRows * theColumns < 6) {
            throw new IllegalArgumentException("The area of the dimensions cannot be less than 6");
        }
        myPillarHolder = new ArrayList<>();
        myRows = theRows;
        myColumns = theColumns;
        myMaze = new Room[myRows][myColumns];
        generateMaze();
        placeEntrance();
        placeExit();
        while (!isMazeTraversable(myMaze)) {
            myPillarHolder = new ArrayList<>();
            foundedRoomContains();
            generateMaze();
            placeEntrance();
            placeExit();
            while (BASE_CASE < 5) {
                placePillars();
                BASE_CASE++;
            }
            isMazeTraversable(myMaze);
            BASE_CASE = 1;
        }
        myAdventurePosition = getEntrance();
        addMonster();
    }

    /**
     * This will reset the traversal tracker that
     * keeps track on if the exit and OO Pillars
     * are found or not.
     */
    private void foundedRoomContains() {
        myFoundPillarA = false;
        myFoundPillarE = false;
        myFoundPillarI = false;
        myFoundPillarP = false;
        myFoundExit = false;
    }

    /**
     * This will get the whole maze.
     *
     * @return the maze.
     */
    public Room[][] getMaze() {
        return myMaze;
    }

    /**
     * This will give us the Adventurer location.
     *
     * @return the Adventurer location.
     */
    public Room getAdventurePosition() {
        return myAdventurePosition;
    }

    /**
     * This will update the Adventurer's location.
     *
     * @param theNewRoom is the new Room that the Adventurer is in.
     */
    public void setAdventurePosition(final Room theNewRoom) {
        myAdventurePosition = theNewRoom;
    }

    /**
     * This will get the row that the adventurer
     * is in.
     *
     * @return the row location of adventurer.
     */
    public int getAdventureRow() {
        for (int i = 0; i < myMaze.length; i++) {
            for (int j = 0; j < myMaze[i].length; j++) {
                if (myMaze[i][j].equals(getAdventurePosition())) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * This will get the column that the adventurer
     * is in.
     *
     * @return the column location of adventurer.
     */
    public int getAdventureColumn() {
        for (int i = 0; i < myMaze.length; i++) {
            for (int j = 0; j < myMaze[i].length; j++) {
                if (myMaze[i][j].equals(getAdventurePosition())) {
                    return j;
                }
            }
        }
        return -1;
    }

    /**
     * This will give us the amount of rows in maze.
     *
     * @return the amount of rows in maze.
     */
    public int getRows() {
        return myRows;
    }

    /**
     * This will give us the amount of columns in maze.
     *
     * @return the amount of columns in maze.
     */
    public int getColumns() {
        return myColumns;
    }

    /**
     * This will generate the maze based on the size
     * that we gave it and update the Rooms accordingly.
     */
    private void generateMaze() {
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myColumns; j++) {
                myMaze[i][j] = new Room().createRandomRoom();
            }
        }

        myMaze = updateRooms(myMaze);
    }

    /**
     * This will update the Rooms so that the doors are not
     * duplicated. This updates the Room's doors accordingly.
     *
     * @param theMaze is the initial maze.
     * @return the updated maze with updated doors.
     */
    public Room[][] updateRooms(final Room[][] theMaze) {
        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
                if (theMaze[i][j].getNorthDoor() && i != 0) {
                    theMaze[i - 1][j].setSouthDoor(true);
                } else if (i == 0) {
                    theMaze[i][j].setNorthDoor(false);
                } else {
//                    if (i != 0) {
                        theMaze[i - 1][j].setSouthDoor(false);
                    //}
                }
                if (i == theMaze.length - 1) {
                    theMaze[i][j].setSouthDoor(false);
                }
            }
            for (int k = 0; k < theMaze[i].length; k++) {
                if (theMaze[i][k].getEastDoor()) {
                    if (k != theMaze[i].length - 1) {
                        theMaze[i][k + 1].setWestDoor(true);
                    }
                } else {
                    if (k != theMaze[i].length - 1) {
                        theMaze[i][k + 1].setWestDoor(false);
                    }
                }
                if (k == 0) {
                    theMaze[i][k].setWestDoor(false);
                }
                if (k == theMaze[i].length - 1) {
                    theMaze[i][k].setEastDoor(false);
                }
            }
        }
        return theMaze;
    }

    /**
     * This will get the entrance of the maze and
     * check if it is valid to traverse.
     *
     * @return if the maze can be completed or not.
     */
    public boolean isMazeTraversable(final Room[][] theMaze) {
        boolean [][] visitedRooms = new boolean[theMaze.length][theMaze[0].length];
        int entranceRowConfirmation = -1;
        int entranceColumnConfirmation = -1;
        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
                if (theMaze[i][j].getIsEntrance()) {
                    entranceRowConfirmation = i;
                    entranceColumnConfirmation = j;
                    break;
                }
            }
        }
        if (entranceRowConfirmation == -1 || entranceColumnConfirmation == -1) {
            return false;
        }

        return trueMazeTraversal(visitedRooms, entranceRowConfirmation, entranceColumnConfirmation);
    }

    /**
     * This is the recursive method that will go through the
     * maze and make sure that you are able to get from
     * the entrance location to the exit location.
     *
     * @param theVisitedRooms is the Rooms that has been visited already.
     * @param theRow is the current row location that is being checked.
     * @param theColumn is the current column location that is being checked.
     * @return if the maze is able to be completed.
     */
    private boolean trueMazeTraversal(final boolean[][] theVisitedRooms, final int theRow, final int theColumn) {
        boolean mazeSolved = false;
        if (myFoundExit && myFoundPillarA && myFoundPillarE && myFoundPillarI && myFoundPillarP) {
            return true;
        }
        if (!isValidPosition(theRow, theColumn) || theVisitedRooms[theRow][theColumn]) {
            return false;
        }

        theVisitedRooms[theRow][theColumn] = true;

        if (myMaze[theRow][theColumn].getHasOOPPillar() && myMaze[theRow][theColumn].getSpecificOOPPillar().equals("A")) {
            myFoundPillarA = true;
        }
        else if (myMaze[theRow][theColumn].getHasOOPPillar() && myMaze[theRow][theColumn].getSpecificOOPPillar().equals("E")) {
            myFoundPillarE = true;
        }
        else if (myMaze[theRow][theColumn].getHasOOPPillar() && myMaze[theRow][theColumn].getSpecificOOPPillar().equals("I")) {
            myFoundPillarI = true;
        }
        else if (myMaze[theRow][theColumn].getHasOOPPillar() && myMaze[theRow][theColumn].getSpecificOOPPillar().equals("P")) {
            myFoundPillarP = true;
        }
        else if (myMaze[theRow][theColumn].getIsExit()) {
            myFoundExit = true;
        }

        if (!mazeSolved) {
            if (myMaze[theRow][theColumn].getNorthDoor()) {
                mazeSolved =  trueMazeTraversal(theVisitedRooms, theRow - 1, theColumn);
            }
            if (myMaze[theRow][theColumn].getEastDoor()) {
                mazeSolved =  trueMazeTraversal(theVisitedRooms, theRow, theColumn + 1);
            }
            if (myMaze[theRow][theColumn].getSouthDoor()) {
                mazeSolved =  trueMazeTraversal(theVisitedRooms, theRow + 1, theColumn);
            }
            if (myMaze[theRow][theColumn].getWestDoor()) {
                mazeSolved =  trueMazeTraversal(theVisitedRooms, theRow, theColumn - 1);
            }
        }
        return mazeSolved;
    }

    /**
     * This will check if the location in the maze
     * is a possible and valid location.
     *
     * @param theRow is the current row location that is being checked.
     * @param theColumn is the current column location that is being checked.
     * @return if the location is in bounds or not.
     */
    private boolean isValidPosition(final int theRow, final int theColumn) {
        return theRow >= 0 && theRow < myMaze.length &&
            theColumn >= 0 && theColumn < myMaze[theRow].length;
    }

    /**
     * This will check which direction the adventurer can
     * go to and allow them to move to that location.
     *
     * @param theDirection is the direction user wants to go.
     */
    public void move(final String theDirection) {
        //Room[][] mazeLocations = theDungeon.getMaze();
        Room roomUpdate = new Room();
        if (theDirection.compareToIgnoreCase("Up") == 0) {
            roomUpdate = myMaze[getAdventureRow() - 1][getAdventureColumn()];
        } else if (theDirection.compareToIgnoreCase("Right") == 0) {
            roomUpdate = myMaze[getAdventureRow()][getAdventureColumn() + 1];
        } else if (theDirection.compareToIgnoreCase("Down") == 0) {
            roomUpdate = myMaze[getAdventureRow() + 1][getAdventureColumn()];
        } else if (theDirection.compareToIgnoreCase("Left") == 0) {
            roomUpdate = myMaze[getAdventureRow()][getAdventureColumn() - 1];
        }
        setAdventurePosition(roomUpdate);
    }

    /**
     * This gives us the available directions
     * from where the adventurer is.
     *
     */
    public ArrayList<String> availableDirections() {
        Room currentRoom = getAdventurePosition();
        ArrayList<String> availableDirections = new ArrayList<>();
        if (currentRoom.getNorthDoor()) {
            availableDirections.add("Up");
        }
        if (currentRoom.getEastDoor()) {
            availableDirections.add("Right");
        }
        if (currentRoom.getSouthDoor()) {
            availableDirections.add("Down");
        }
        if (currentRoom.getWestDoor()) {
            availableDirections.add("Left");
        }

        return availableDirections;
    }

    /**
     * This will tell us if the adventurer
     * is allowed to go a specific direction.
     *
     * @param theDirection is the direction adventurer wants to go.
     * @return whether the direction is available or not.
     */
    public boolean isValidDirection(final String theDirection) {
        Room currentRoom = getAdventurePosition();
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
     * This will place an entrance in the maze.
     */
    private void placeEntrance() {
        int rowEntrance = myRand.nextInt(myRows);
        int columnEntrance = myRand.nextInt(myColumns);
        if (!myMaze[rowEntrance][columnEntrance].roomContains().equals(" ")) {
            myMaze[rowEntrance][columnEntrance].resetRoom();
            myMaze[rowEntrance][columnEntrance].setIsEntrance(true);
        } else {
            myMaze[rowEntrance][columnEntrance].setIsEntrance(true);
        }
    }

    /**
     * This will place an exit in the maze.
     */
    private void placeExit() {
        int rowExit = myRand.nextInt(myRows);
        int columnExit = myRand.nextInt(myColumns);
        if (myMaze[rowExit][columnExit].roomContains().equals("i")) {
            placeExit();
        } else if (myMaze[rowExit][columnExit].roomContains().equals(" ")) {
            myMaze[rowExit][columnExit].resetRoom();
            myMaze[rowExit][columnExit].setIsExit(true);
            myMaze[rowExit][columnExit].setHasMonster(true);
        } else {
            myMaze[rowExit][columnExit].setIsExit(true);
            myMaze[rowExit][columnExit].setHasMonster(true);
        }
    }

    /**
     * This will place the four unique pillars
     * in the maze.
     */
    private void placePillars() {
        int rowPillar = myRand.nextInt(myRows);
        int columnPillar = myRand.nextInt(myColumns);
        if (!myMaze[rowPillar][columnPillar].roomContains().equals("i")
            && !myMaze[rowPillar][columnPillar].roomContains().equals("O")
            && !myMaze[rowPillar][columnPillar].getHasOOPPillar()) {
            myMaze[rowPillar][columnPillar].resetRoom();
            myMaze[rowPillar][columnPillar].pillarGenerate();
            myMaze[rowPillar][columnPillar].setHasOOPPillar(true);
            myMaze[rowPillar][columnPillar].setHasMonster(true);
            if (myMaze[rowPillar][columnPillar].getSpecificOOPPillar().equals("A") && !myPillarHolder.contains("A")) {
                myPillarHolder.add("A");
            } else if (myMaze[rowPillar][columnPillar].getSpecificOOPPillar().equals("E") && !myPillarHolder.contains("E")) {
                myPillarHolder.add("E");
            } else if (myMaze[rowPillar][columnPillar].getSpecificOOPPillar().equals("I") && !myPillarHolder.contains("I")) {
                myPillarHolder.add("I");
            } else if (myMaze[rowPillar][columnPillar].getSpecificOOPPillar().equals("P") && !myPillarHolder.contains("P")) {
                myPillarHolder.add("P");
            } else {
                myMaze[rowPillar][columnPillar].setHasOOPPillar(false);
                myMaze[rowPillar][columnPillar].setHasMonster(false);
                placePillars();
            }
        } else {
            placePillars();
        }


    }

    /**
     * This will count the amount of dead ends
     * in the dungeon map.
     *
     * @return the amount of dead ends.
     */
    private int amountOfDeadEnds() {
        int doorCounter = 0;
        int deadEndCounter = 0;
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myColumns; j++) {
                if (myMaze[i][j].getNorthDoor()) {
                    doorCounter++;
                }
                if (myMaze[i][j].getEastDoor()) {
                    doorCounter++;
                }
                if (myMaze[i][j].getSouthDoor()) {
                    doorCounter++;
                }
                if (myMaze[i][j].getWestDoor()) {
                    doorCounter++;
                }
                if (doorCounter < 2) {
                    deadEndCounter++;
                }
                doorCounter = 0;
            }
        }
        return deadEndCounter;
    }

    /**
     * This will get the Room location of
     * the entrance.
     *
     * @return the Room location of entrance.
     */
    public Room getEntrance() {
        Room entranceLocation = new Room();
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myColumns; j++) {
                if (myMaze[i][j].getIsEntrance()) {
                    entranceLocation = myMaze[i][j];
                }
            }
        }
        return entranceLocation;
    }

    /**
     * This will get the Room location of
     * the exit.
     *
     * @return the Room location of exit.
     */
    public Room getExit() {
        Room exitLocation = new Room();
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myColumns; j++) {
                if (myMaze[i][j].getIsExit()) {
                    exitLocation = myMaze[i][j];
                }
            }
        }
        return exitLocation;
    }

    public void addMonster() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                if (myMaze[i][j].getHasMonster()) {
                    int randomMonster = myRand.nextInt(1, 4);
                    if (randomMonster == 1) {
                        Monster monsterType = MonsterFactory.createMonster("Skeleton");
                        myMaze[i][j].setMonster(monsterType);
                    } else if (randomMonster == 2) {
                        Monster monsterType = MonsterFactory.createMonster("Ogre");
                        myMaze[i][j].setMonster(monsterType);
                    } else {
                        Monster monsterType = MonsterFactory.createMonster("Gremlin");
                        myMaze[i][j].setMonster(monsterType);
                    }
                }
            }
        }
    }

    /**
     * Gets the String representation of the
     * current room for display with no
     * vision potion.
     *
     * @return the String representation of the room.
     */
    public String noVisionToString() {
        return myMaze[0][0].noVisionString(getAdventurePosition());
    }

    /**
     * Gets the String representation of the
     * current room and the surrounding rooms
     * for display with use of vision potion.
     *
     * @return the String representation of the room and surrounding rooms.
     */
    public String visionPotionToString() {
        return myMaze[0][0].yesVisionString(myMaze, getAdventureRow(), getAdventureColumn());
    }

    /**
     * Gets the String representation of the maze.
     *
     * @return the String representation of the maze.
     */
    public String toString() {
        return myMaze[0][0].toString(myMaze);
    }




}
