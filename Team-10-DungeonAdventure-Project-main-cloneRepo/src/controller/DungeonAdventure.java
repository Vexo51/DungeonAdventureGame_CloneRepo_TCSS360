package controller;

import model.Dungeon;
import model.Hero;
import model.Warrior;

import java.util.Scanner;

public class DungeonAdventure {
    private static Scanner myConsole = new Scanner(System.in);

    public static void main(String [] args) {
        Dungeon gameDungeon = new Dungeon(2, 3);
        System.out.print("Enter Your Character's Name: ");
        //String name = myConsole.nextLine();
        String name = "H";


        Hero war = new Warrior(name);
        System.out.println();
        war.availableDirections(gameDungeon);
        System.out.println("Which Direction do you want to move to");
        //String direction = myConsole.nextLine();
        String direction = "Up";
//        while (!direction.equals("Up") || !direction.equals("Right") ||
//                !direction.equals("Down") || !direction.equals("Left")) {
//            direction = myConsole.nextLine();
//        }
        System.out.println("PREVIOUS " + gameDungeon.getAdventureRow() + " ROW " + gameDungeon.getAdventureColumn() + " COLUMN ");
        System.out.println(gameDungeon.noVisionToString());

        if (war.isValidDirection(gameDungeon, direction)) {
            war.move(gameDungeon, direction);
            System.out.println("AFTER " + gameDungeon.getAdventureRow() + " ROW " + gameDungeon.getAdventureColumn() + " COLUMN ");
        } else {
            System.out.println("INVALID");
        }
        //if (adventurerCharacter.isGameOver()) {
            System.out.println(gameDungeon);
        //}

    }


}
