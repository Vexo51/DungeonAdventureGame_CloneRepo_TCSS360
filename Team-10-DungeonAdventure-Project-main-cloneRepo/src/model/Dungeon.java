package model;

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
public class Dungeon {

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
    private List<String> myPillarHolder = new ArrayList<>();

    private boolean myUseVision;

    /**
     * This will create the maze and generate all the
     * necessities within the maze.
     *
     * @param theRows is the amount of rows in maze.
     * @param theColumns is the amount of columns in maze.
     */
    public Dungeon(final int theRows, final int theColumns) {
        if (theRows == 0 || theColumns == 0) {
            throw new IllegalArgumentException("The dimensions cannot be 0");
        }
        myRows = theRows;
        myColumns = theColumns;
        myMaze = new Room[myRows][myColumns];
        generateMaze();
        placeEntrance();
        placeExit();
        while (!isMazeTraversable()) {
            generateMaze();
            placeEntrance();
            placeExit();
            isMazeTraversable();
        }
        while (BASE_CASE < 5) {
            placePillars();
            BASE_CASE++;
        }
        myAdventurePosition = getEntrance();
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
        Room[][] tempMaze = new Room[getRows()][getColumns()];
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myColumns; j++) {
                tempMaze[i][j] = new Room().createRandomRoom();
            }
        }

        myMaze = updateRooms(tempMaze);
    }

    /**
     * This will update the Rooms so that the doors are not
     * duplicated. This updates the Room's doors accordingly.
     *
     * @param theMaze is the initial maze.
     * @return the updated maze with updated doors.
     */
    private Room[][] updateRooms(final Room[][] theMaze) {
        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
                if (theMaze[i][j].getNorthDoor() && i != 0) {
                    theMaze[i - 1][j].setSouthDoor(true);
                } else {
                    if (i != 0) {
                        theMaze[i - 1][j].setSouthDoor(false);
                    }
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
    private boolean isMazeTraversable() {
        boolean [][] visitedRooms = new boolean[myRows][myColumns];
        int entranceRowConfirmation = -1;
        int entranceColumnConfirmation = -1;
        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < myColumns; j++) {
                if (myMaze[i][j] == getEntrance()) {
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
        if (!isValidPosition(theRow, theColumn) || theVisitedRooms[theRow][theColumn]) {
            return false;
        }

        theVisitedRooms[theRow][theColumn] = true;

        if (myMaze[theRow][theColumn].getIsExit()) {
            return true;
        }

        if (!mazeSolved) {
            if (myMaze[theRow][theColumn].getNorthDoor()) {
                return trueMazeTraversal(theVisitedRooms, theRow - 1, theColumn);
            }
            if (myMaze[theRow][theColumn].getEastDoor()) {
                return trueMazeTraversal(theVisitedRooms, theRow, theColumn + 1);
            }
            if (myMaze[theRow][theColumn].getSouthDoor()) {
                return trueMazeTraversal(theVisitedRooms, theRow + 1, theColumn);
            }
            if (myMaze[theRow][theColumn].getWestDoor()) {
                return trueMazeTraversal(theVisitedRooms, theRow, theColumn - 1);
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
        } else {
            myMaze[rowExit][columnExit].setIsExit(true);
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
            && !myMaze[rowPillar][columnPillar].getHasOOPillar()) {
            myMaze[rowPillar][columnPillar].resetRoom();
            myMaze[rowPillar][columnPillar].pillarGenerate();
            myMaze[rowPillar][columnPillar].setHasOOPillar(true);
            if (myMaze[rowPillar][columnPillar].getSpecificOOPillar().equals("A") && !myPillarHolder.contains("A")) {
                myPillarHolder.add("A");
            } else if (myMaze[rowPillar][columnPillar].getSpecificOOPillar().equals("E") && !myPillarHolder.contains("E")) {
                myPillarHolder.add("E");
            } else if (myMaze[rowPillar][columnPillar].getSpecificOOPillar().equals("I") && !myPillarHolder.contains("I")) {
                myPillarHolder.add("I");
            } else if (myMaze[rowPillar][columnPillar].getSpecificOOPillar().equals("P") && !myPillarHolder.contains("P")) {
                myPillarHolder.add("P");
            } else {
                myMaze[rowPillar][columnPillar].setHasOOPillar(false);
                placePillars();
            }
        } else {
            placePillars();
        }


    }

    private void placeDeadEnds() {
        int doorCounter = 0;
        int rowDeadEnd = myRand.nextInt(myRows);
        int columnDeadEnd = myRand.nextInt(myColumns);
        while (doorCounter < 1) {
            if (!myMaze[rowDeadEnd][columnDeadEnd].getIsEntrance() || !myMaze[rowDeadEnd][columnDeadEnd].getIsExit()
                || !myMaze[rowDeadEnd][columnDeadEnd].getHasOOPillar()) {
                boolean randomDoor = myRand.nextBoolean();


                doorCounter++;
            }
        }
    }

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

    /**
     * Gets the String representation of the
     * current room for display with no
     * vision potion.
     *
     * @return the String representation of the room.
     */
    public String noVisionToString() {
        return myMaze[0][0].noVisionString(myMaze[getAdventureRow()][getAdventureColumn()]);
    }

    /**
     * Gets the String representation of the maze.
     *
     * @return the String representation of the maze.
     */
    public String toString() {
        return myMaze[0][0].toString(myMaze);
    }

//    public static void main(String [] args) {
//        Dungeon tester = new Dungeon(30, 3);
//        System.out.println(tester);
//    }


}
