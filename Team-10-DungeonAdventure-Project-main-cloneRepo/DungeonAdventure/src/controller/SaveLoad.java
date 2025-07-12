package controller;

import model.Dungeon;
import model.Hero;

import java.io.*;

public class SaveLoad {

    public static void printData(DungeonAdventure theGame) {
        Dungeon gameDungeon = theGame.getGameDungeon();
        Hero adventurer = theGame.getAdventurer();

        System.out.println("Name: " + adventurer.getCharacterName());
        System.out.println("Health: " + adventurer.getHitPoints());
        System.out.println("Healing Potions: " + adventurer.getHealingPotions());
        System.out.println("Vision Potions: " + adventurer.getVisionPotions());
        System.out.println("OO Pillars Found: " + adventurer.getFoundPillarsOfOOP());
        System.out.println();
        System.out.println("The Maze:\n" + gameDungeon.toString());


    }

    public static void saveGame(final String theFileName, final DungeonAdventure theGame) {
        try {
            FileOutputStream file = new FileOutputStream(theFileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(theGame);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"
                    + "Data before Deserialization.");
            printData(theGame);

        } catch (IOException theException) {
            System.out.println("IOException is caught");
        }
    }

    public static DungeonAdventure loadGame(final String theFileName) {
        DungeonAdventure game = null;
        try {
            FileInputStream file = new FileInputStream(theFileName);
            ObjectInputStream in = new ObjectInputStream(file);

            game = (DungeonAdventure) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printData(game);
        } catch (IOException theException) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException theException) {
            System.out.println("ClassNotFoundException is caught");
        }
        return game;
    }

}
