package tests;

import model.Dungeon;
import model.Room;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class DungeonTest {

    @Test
    public void testDungeonError00Dimensions() {
        try {
            Dungeon dungeonTest = new Dungeon(0, 0);
            Assert.fail("This should have thrown an exception.");
        } catch (Exception e) {
            String expectedErrorMessage = "The area of the dimensions cannot be less than 6";
            Assert.assertEquals("Correct Error Message", expectedErrorMessage, e.getMessage());
        }
    }

    @Test
    public void testDungeonErrorLessThan6Dimensions() {
        try {
            Dungeon dungeonTest = new Dungeon(2, 2);
            Assert.fail("This should have thrown an exception.");
        } catch (Exception e) {
            String expectedErrorMessage = "The area of the dimensions cannot be less than 6";
            Assert.assertEquals("Correct Error Message", expectedErrorMessage, e.getMessage());
        }
    }

    @Test
    public void testDungeonErrorNegativeDimensions() {
        try {
            Dungeon dungeonTest = new Dungeon(-2, -3);
            Assert.fail("This should have thrown an exception.");
        } catch (Exception e) {
            String expectedErrorMessage = "The area of the dimensions cannot be less than 6";
            Assert.assertEquals("Correct Error Message", expectedErrorMessage, e.getMessage());
        }
    }

    @Test
    public void testDungeonDimensions() {
        Dungeon dungeonTest = new Dungeon(4, 4);

        Assert.assertEquals(4, dungeonTest.getRows());
        Assert.assertEquals(4, dungeonTest.getColumns());
    }

    @Test
    public void testDungeonCreation() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        String correct = "*******\n" +
                "*i|O*A*\n" +
                "***-*-*\n" +
                "* *E| *\n" +
                "***-***\n" +
                "* |P|I*\n" +
                "*******";

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        Assert.assertEquals(correct, message);
    }

    @Test
    public void testDungeonTraverseThreeByThree() {
        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        Assert.assertEquals(true, dungeonTest.isMazeTraversable(test));
    }

    @Test
    public void testDungeonTraverseFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        Assert.assertEquals(true, dungeonTest.isMazeTraversable(test));
    }

    @Test
    public void testDungeonNotTraverseIBlocked() {
        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setEastDoor(false);
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        Assert.assertEquals(false, dungeonTest.isMazeTraversable(test));
    }

    @Test
    public void testDungeonTraverseEntranceBlocked() {
        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        //room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        //room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        Assert.assertEquals(false, dungeonTest.isMazeTraversable(test));
    }

    @Test
    public void testDungeonTraverseExitBlocked() {
        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.setIsExit(true);
        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        Assert.assertEquals(false, dungeonTest.isMazeTraversable(test));
    }

    @Test
    public void testTopLeftWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "*****\n" +
                "*C|O*\n" +
                "***-*\n" +
                "* *E|\n" +
                "***-*";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 0, 0);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testTopRightWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "*****\n" +
                "|O*C*\n" +
                "*-*-*\n" +
                "*E| *\n" +
                "*-***";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 0, 2);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testBottomLeftWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "***-*\n" +
                "* *E|\n" +
                "***-*\n" +
                "*C|P|\n" +
                "*****";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 2, 0);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testBottomRightWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "*-*-*\n" +
                "*E| *\n" +
                "*-***\n" +
                "|P|C*\n" +
                "*****";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 2, 2);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testTopWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "*******\n" +
                "*i|C*A*\n" +
                "***-*-*\n" +
                "* *E| *\n" +
                "***-***";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 0, 1);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testLeftWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "*****\n" +
                "*i|O*\n" +
                "***-*\n" +
                "*C*E|\n" +
                "***-*\n" +
                "* |P|\n" +
                "*****";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 1, 0);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testBottomWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "***-*-*\n" +
                "* *E| *\n" +
                "***-***\n" +
                "* |C|I*\n" +
                "*******";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 2, 1);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testRightWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "*****\n" +
                "|O*A*\n" +
                "*-*-*\n" +
                "*E|C*\n" +
                "*-***\n" +
                "|P|I*\n" +
                "*****";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 1, 2);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testCenterWithVisionThreeByThree() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();

        room00.setIsEntrance(true);
        room00.closeAllDoors();
        room00.setEastDoor(true);

        room01.setIsExit(true);
        room01.closeAllDoors();
        room01.setSouthDoor(true);
        room01.setWestDoor(true);

        room02.setHasOOPPillar(true);
        room02.setSpecificOOPPillar("A");
        room02.closeAllDoors();
        room02.setSouthDoor(true);

        room10.closeAllDoors();

        room11.setHasOOPPillar(true);
        room11.setSpecificOOPPillar("E");
        room11.openAllDoors();
        room11.setWestDoor(false);

        room12.openAllDoors();
        room12.setEastDoor(false);
        room12.setSouthDoor(false);

        room20.closeAllDoors();
        room20.setEastDoor(true);

        room21.setHasOOPPillar(true);
        room21.setSpecificOOPPillar("P");
        room21.openAllDoors();
        room21.setSouthDoor(false);

        room22.setHasOOPPillar(true);
        room22.setSpecificOOPPillar("I");
        room22.closeAllDoors();
        room22.setWestDoor(true);

        Room[][] test = {{room00, room01, room02}
                , {room10, room11, room12}
                , {room20, room21, room22}};

        String correct = "*******\n" +
                "*i|O*A*\n" +
                "***-*-*\n" +
                "* *C| *\n" +
                "***-***\n" +
                "* |P|I*\n" +
                "*******";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 1, 1);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testCenterWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);
        //room34.setWestDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct = "***-***\n" +
                "* *P|E*\n" +
                "*****-*\n" +
                "| |C|A|\n" +
                "*-*-***\n" +
                "| * | *\n" +
                "*****-*";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 2, 2);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testTopLeftWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct = "*****\n" +
                "*C* |\n" +
                "*****\n" +
                "*V* *\n" +
                "*-***";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 0, 0);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testTopRightWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct = "*****\n" +
                "| |C*\n" +
                "*****\n" +
                "|E* *\n" +
                "*-*-*";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 0, 4);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testBottomLeftWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct = "***-*\n" +
                "*O| *\n" +
                "*****\n" +
                "*C* |\n" +
                "*****";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 4, 0);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testBottomRightWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct = "***-*\n" +
                "| * *\n" +
                "*-***\n" +
                "* |C*\n" +
                "*****";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision = room00.yesVisionString(test, 4, 4);
        System.out.println();
        System.out.println(yesVision);
        Assert.assertEquals(correct, yesVision);
    }

    @Test
    public void testTopWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct1 = "*******\n" +
                "*H*C| |\n" +
                "*****-*\n" +
                "*V* *P|\n" +
                "*-*****";

        String correct2 = "*******\n" +
                "* |C| |\n" +
                "***-***\n" +
                "* *P|E*\n" +
                "*****-*";

        String correct3 = "*******\n" +
                "| |C|I*\n" +
                "*-*****\n" +
                "*P|E* *\n" +
                "***-*-*";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision1 = room00.yesVisionString(test, 0, 1);
        String yesVision2 = room00.yesVisionString(test, 0, 2);
        String yesVision3 = room00.yesVisionString(test, 0, 3);
        System.out.println();
        System.out.println(yesVision3);
        Assert.assertEquals(correct1, yesVision1);
        Assert.assertEquals(correct2, yesVision2);
        Assert.assertEquals(correct3, yesVision3);
    }

    @Test
    public void testBottomWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct1 = "***-*-*\n" +
                "*O| * |\n" +
                "*******\n" +
                "* *C| *\n" +
                "*******";

        String correct2 = "*-*-***\n" +
                "| * | *\n" +
                "*****-*\n" +
                "* |C* |\n" +
                "*******";

        String correct3 = "*-***-*\n" +
                "* | * *\n" +
                "***-***\n" +
                "| *C|i*\n" +
                "*******";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision1 = room00.yesVisionString(test, 4, 1);
        String yesVision2 = room00.yesVisionString(test, 4, 2);
        String yesVision3 = room00.yesVisionString(test, 4, 3);
        System.out.println();
        System.out.println(yesVision1);
        System.out.println();
        System.out.println(yesVision2);
        System.out.println();
        System.out.println(yesVision3);
        Assert.assertEquals(correct1, yesVision1);
        Assert.assertEquals(correct2, yesVision2);
        Assert.assertEquals(correct3, yesVision3);
    }

    @Test
    public void testLeftWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct1 = "*****\n" +
                "*H* |\n" +
                "*****\n" +
                "*C* *\n" +
                "*-***\n" +
                "* | |\n" +
                "***-*";

        String correct2 = "*****\n" +
                "*V* *\n" +
                "*-***\n" +
                "*C| |\n" +
                "***-*\n" +
                "*O| *\n" +
                "*****";

        String correct3 = "*-***\n" +
                "* | |\n" +
                "***-*\n" +
                "*C| *\n" +
                "*****\n" +
                "* * |\n" +
                "*****";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision1 = room00.yesVisionString(test, 1, 0);
        String yesVision2 = room00.yesVisionString(test, 2, 0);
        String yesVision3 = room00.yesVisionString(test, 3, 0);
        System.out.println();
        System.out.println(yesVision1);
        System.out.println();
        System.out.println(yesVision2);
        System.out.println();
        System.out.println(yesVision3);
        Assert.assertEquals(correct1, yesVision1);
        Assert.assertEquals(correct2, yesVision2);
        Assert.assertEquals(correct3, yesVision3);
    }

    @Test
    public void testRightWithVisionFiveByFive() {
        Room tester = new Room();

        Room room00 = new Room();
        Room room01 = new Room();
        Room room02 = new Room();
        Room room03 = new Room();
        Room room04 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room room20 = new Room();
        Room room21 = new Room();
        Room room22 = new Room();
        Room room23 = new Room();
        Room room24 = new Room();
        Room room30 = new Room();
        Room room31 = new Room();
        Room room32 = new Room();
        Room room33 = new Room();
        Room room34 = new Room();
        Room room40 = new Room();
        Room room41 = new Room();
        Room room42 = new Room();
        Room room43 = new Room();
        Room room44 = new Room();

        room00.setHasHealingPotion(true);
        room00.closeAllDoors();

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.openAllDoors();
        room02.setNorthDoor(false);

        room03.openAllDoors();
        room03.setNorthDoor(false);
        room03.setSouthDoor(false);

        room04.closeAllDoors();
        room04.setWestDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("I");

        room10.closeAllDoors();
        room10.setSouthDoor(true);
        room10.setHasVisionPotion(true);

        room11.closeAllDoors();

        room12.closeAllDoors();
        room12.setNorthDoor(true);
        room12.setEastDoor(true);
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("P");

        room13.openAllDoors();
        room13.setNorthDoor(false);
        room13.setEastDoor(false);
        room13.setHasOOPPillar(true);
        room13.setSpecificOOPPillar("E");

        room14.closeAllDoors();
        room14.setSouthDoor(true);

        room20.openAllDoors();
        room20.setWestDoor(false);
        room20.setSouthDoor(false);

        room21.openAllDoors();
        room21.setNorthDoor(false);

        room22.openAllDoors();
        room22.setNorthDoor(false);

        room23.openAllDoors();
        room23.setSouthDoor(false);
        room23.setHasOOPPillar(true);
        room23.setSpecificOOPPillar("A");

        room24.openAllDoors();
        room24.setEastDoor(false);

        room30.closeAllDoors();
        room30.setEastDoor(true);
        room30.setIsExit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setSouthDoor(false);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);
        room33.setEastDoor(false);

        room34.closeAllDoors();
        room34.setNorthDoor(true);

        room40.closeAllDoors();

        room41.closeAllDoors();
        room41.setEastDoor(true);

        room42.closeAllDoors();
        room42.setWestDoor(true);

        room43.openAllDoors();
        room43.setWestDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setWestDoor(true);
        room44.setIsEntrance(true);



        Room[][] test = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        String correct1 = "*****\n" +
                "| |I*\n" +
                "*****\n" +
                "|E*C*\n" +
                "*-*-*\n" +
                "|A| *\n" +
                "***-*";

        String correct2 = "*****\n" +
                "|E* *\n" +
                "*-*-*\n" +
                "|A|C*\n" +
                "***-*\n" +
                "| * *\n" +
                "*-***";

        String correct3 = "*-*-*\n" +
                "|A| *\n" +
                "***-*\n" +
                "| *C*\n" +
                "*-***\n" +
                "* |i*\n" +
                "*****";

        Dungeon dungeonTest = new Dungeon(test);
        test = dungeonTest.updateRooms(test);
        String message = tester.toString(test);
        System.out.println(message);
        String yesVision1 = room00.yesVisionString(test, 1, 4);
        String yesVision2 = room00.yesVisionString(test, 2, 4);
        String yesVision3 = room00.yesVisionString(test, 3, 4);
        Assert.assertEquals(correct1, yesVision1);
        Assert.assertEquals(correct2, yesVision2);
        Assert.assertEquals(correct3, yesVision3);
    }


}