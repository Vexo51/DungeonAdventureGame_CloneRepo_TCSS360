package controller;

import model.*;
import view.GameInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class will allow the game to be played.
 *
 * @author Tyler Nguyen
 * @version 12-12-13
 */
public class DungeonAdventure implements Serializable {

    /**
     * This is the serial number for Serialization.
     */
    private static final long serialVersionUID = 192837465L;

    /**
     * This is the user input console.
     */
    private static Scanner myConsole = new Scanner(System.in);

    /**
     * This is the random generator.
     */
    private static Random myRand = new Random();

    /**
     * This is the dungeon map.
     */
    private Dungeon myGameDungeon;

    /**
     * This is the user character.
     */
    private Hero myAdventurer;

    /**
     * This is Warrior hero.
     */
    private Warrior myWarrior;

    /**
     * This is Thief hero.
     */
    private Thief myThief;

    /**
     * This is Priestess hero.
     */
    private Priestess myPriestess;

    /**
     * This is the interface.
     */
    private final GameInterface myGameInterface;

    /**
     * This is the beginning dungeon layout.
     */
    private String myInitialDungeon;

    /**
     * This is the constructor for DungeonAdventure.
     */
    public DungeonAdventure() {
        myGameInterface = new GameInterface();
        myWarrior = new Warrior(" ");
        myThief = new Thief(" ");
        myPriestess = new Priestess(" ");
    }

    /**
     * This is the dungeon initialization
     * for standard play.
     */
    private void dungeonCreation() {
        myGameDungeon = new Dungeon(3, 3);
    }

    /**
     * This will get the dungeon map.
     *
     * @return the dungeon map.
     */
    public Dungeon getGameDungeon() {
        return myGameDungeon;
    }

    /**
     * This will get the adventurer hero.
     *
     * @return the adventurer hero.
     */
    public Hero getAdventurer() {
        return myAdventurer;
    }

    /**
     * This will get the beginning
     * dungeon layout.
     *
     * @return the beginning dungeon layout.
     */
    public String getInitialDungeon() {
        return myInitialDungeon;
    }

    /**
     * This will get Warrior hero.
     *
     * @return the Warrior.
     */
    public Warrior getWarrior() {
        return myWarrior;
    }

    /**
     * This will get Thief hero.
     *
     * @return the Thief.
     */
    public Thief getThief() {
        return myThief;
    }

    /**
     * This will get Priestess hero.
     *
     * @return the Priestess.
     */
    public Priestess getPriestess() {
        return myPriestess;
    }

    /**
     * This will give the user the starting prompt asking
     * if user wants to start new game, load game, or quit.
     *
     * @param theGame is the load file.
     */
    private void startMenu(DungeonAdventure theGame) {
        System.out.println(myGameInterface.getMyStartMenu());
        System.out.print(myGameInterface.getMyUserPromptInput());
        int choice = 0;
        boolean flag = true;
        do {
            try {
                choice = Integer.parseInt(myConsole.next());
                while (choice > 3 || choice < 1) {
                    System.out.println("Choose one of the following options: ");
                    System.out.println(myGameInterface.getMyStartMenu());
                    System.out.print(myGameInterface.getMyUserPromptInput());
                    choice = Integer.parseInt(myConsole.next());
                }
                flag = false;
            } catch (Exception theException) {
                System.out.println("Enter a valid integer number");
                System.out.println(myGameInterface.getMyStartMenu());
                System.out.print(myGameInterface.getMyUserPromptInput());
                myConsole.reset();
            }
        } while (flag);
        if (choice == 1) {
            gameStart(theGame, false);
        } else if (choice == 2) {
            DungeonAdventure load = SaveLoad.loadGame("saveGame.ser");
            myAdventurer = load.getAdventurer();
            myGameDungeon = load.getGameDungeon();
            myInitialDungeon = load.getInitialDungeon();
            myWarrior = load.getWarrior();
            myThief = load.getThief();
            myPriestess = load.getPriestess();
            gameStart(load, true);
        } else {
            return;
        }

    }

    /**
     * This contains the logic for the game. It will give user
     * prompts and do accordingly to the user's desire.
     *
     * @param theGame is the load file.
     * @param theLoad is if the user wants to load the load file.
     */
    private void gameStart(final DungeonAdventure theGame, final boolean theLoad) {
        if (!theLoad) {
            System.out.println("\nSelect Mode:\n1.Winning Scenario\n2.Losing Scenario\n3.Regular Scenario");
            System.out.print(myGameInterface.getMyUserPromptInput());
            int gameOption = 0;
            boolean flag = true;
            do {
                try {
                    gameOption = Integer.parseInt(myConsole.next());
                    while (gameOption != 1 && gameOption != 2 && gameOption != 3) {
                        System.out.println("Select Mode:\n1.Winning Scenario\n2.Losing Scenario\n3.Regular Scenario");
                        System.out.print(myGameInterface.getMyUserPromptInput());
                        gameOption = Integer.parseInt(myConsole.next());
                    }
                    flag = false;
                } catch (Exception theException) {
                    System.out.println("Enter a valid integer number");
                    System.out.println("Select Mode:\n1.Winning Scenario\n2.Losing Scenario\n3.Regular Scenario");
                    System.out.print(myGameInterface.getMyUserPromptInput());
                    myConsole.reset();
                }
            } while (flag);
            if (gameOption == 1) {
                scriptedDungeon();
                adventureInitialization();
            } else if (gameOption == 2) {
                scriptedDungeon();
                adventureInitialization();
                while (myAdventurer.getHitPoints() != 1) {
                    myAdventurer.subtractHitPoints(1);
                }
            } else {
                dungeonCreation();
                adventureInitialization();
            }
            myInitialDungeon = myGameDungeon.toString();
        }
        System.out.println(myGameInterface.getMyGameBeginNotice());
        String moveOption = "C";
        int choice = 0;
        int visionPotionDuration = 0;
        boolean usedVisionPotion = false;
        while (!gameOver()) {
            boolean flag = true;
            System.out.println(roomDisplay(moveOption));
            System.out.println(myGameInterface.getMyChoiceMenu());
            System.out.print(myGameInterface.getMyUserPromptInput());
            do {
                try {
                    choice = Integer.parseInt(myConsole.next());

                    //choice = myConsole.nextInt();
                    while (choice > 7 || choice < 1) {
                        System.out.println(myGameInterface.getMyChoiceMenu());
                        System.out.print(myGameInterface.getMyUserPromptInput());
                        choice = Integer.parseInt(myConsole.next());
                    }
                    flag = false;
                } catch (Exception theException) {
                    System.out.println("Enter a valid integer number");
                    System.out.println(myGameInterface.getMyChoiceMenu());
                    System.out.print(myGameInterface.getMyUserPromptInput());
                    myConsole.reset();
                }
            } while (flag);

            if (choice == 1) {
                ArrayList<String> directions = myGameDungeon.availableDirections();
                moveOption = myConsole.nextLine();
                while (!isValidDirection(moveOption)) {
                    System.out.println("Choose one of the following directions: ");
                    for (String availableDirection : directions) {
                        System.out.println(availableDirection + " Door is Available");
                    }
                    System.out.print(myGameInterface.getMyUserPromptInput());
                    moveOption = myConsole.nextLine();
                }
                myGameDungeon.move(moveOption);
                System.out.println(itemCollection());
                if (myGameDungeon.getAdventurePosition().getHasMonster()) {
                    System.out.println();
                    System.out.println(myGameInterface.getMyMonsterEncounteredNotice());
                    combat();
                }

                if (myGameDungeon.getAdventurePosition().getIsExit() && !checkOOPPillars()) {
                    System.out.println("The exit is locked. Collect at least 1 OOP Pillar to unlock the exit");
                }

                if (visionPotionDuration != 0 && visionPotionDuration != 4) {
                    visionPotionDuration++;
                } else if (visionPotionDuration == 4) {
                    usedVisionPotion = false;
                }

            } else if (choice == 2) {
                System.out.println(miniMap(usedVisionPotion));

            } else if (choice == 3) {
                System.out.println("You have " + myAdventurer.getHealingPotions() + " Healing Potions");
                System.out.println("You have " + myAdventurer.getVisionPotions() + " Vision Potions");
                System.out.println(myGameInterface.getMyPotionOptions());
                System.out.print(myGameInterface.getMyUserPromptInput());
                int potionChoice = myConsole.nextInt();
                while (potionChoice != 1 && potionChoice != 2) {
                    System.out.println(myGameInterface.getMyPotionOptions());
                    System.out.print(myGameInterface.getMyUserPromptInput());
                    potionChoice = myConsole.nextInt();
                }
                if (potionChoice == 1) {
                    if (myAdventurer.getHealingPotions() == 0) {
                        System.out.println("You have 0 Healing Potions, Cannot Heal");
                    } else {
                        int randomHealing = myRand.nextInt(5, 16);
                        myAdventurer.increaseHitPoints(randomHealing);
                        myAdventurer.useHealingPotion();
                        System.out.println(myGameInterface.getMyHealingPotionUsedNotice() + randomHealing + " hit points");
                        System.out.println("You have " + myAdventurer.getHealingPotions() + " Healing Potions");
                    }
                } else {
                    if (myAdventurer.getVisionPotions() == 0) {
                        System.out.println("You have 0 Vision Potions, Cannot Use");
                    } else {
                        usedVisionPotion = true;
                        visionPotionDuration = 1;
                        myAdventurer.useVisionPotion();
                        System.out.println(myGameInterface.getMyVisionPotionUsedNotice());
                        System.out.println("You have " + myAdventurer.getVisionPotions() + " Vision Potions");
                    }
                }


            } else if (choice == 4) {
                System.out.println(myAdventurer.heroToString());

            } else if (choice == 5) {
                String continueChoice = myConsole.nextLine();
                SaveLoad.saveGame("saveGame.ser", theGame);
                System.out.println("Would you like to continue the game?");
                continueChoice = myConsole.nextLine();
                while (!continueChoice.equalsIgnoreCase("Yes") && !continueChoice.equalsIgnoreCase("No")) {
                    System.out.println("Would you like to continue the game?");
                    continueChoice = myConsole.nextLine();
                }
                if (continueChoice.equalsIgnoreCase("No")) {
                    break;
                }
            } else if (choice == 6) {
                System.out.println("You have exited the game.");
                break;
            } else if (choice == 7) {
                String cheatChoice = myConsole.nextLine();
                while (!cheatChoice.equalsIgnoreCase("Yes") && !cheatChoice.equalsIgnoreCase("No")) {
                    System.out.println("Are you sure you want to activate cheats?");
                    cheatChoice = myConsole.nextLine();
                }
                if (cheatChoice.equalsIgnoreCase("Yes")) {
                    cheats();
                }
            }

        }
        if (gameOver()) {
            if (myAdventurer.isAlive()) {
                System.out.println(myGameInterface.getMyWinningScreen());
            } else {
                System.out.println(myGameInterface.getMyLosingScreen());
            }
        }

    }

    /**
     * This will grab the large room to display
     * the users current room.
     *
     * @param theUserDirection is the direction the user wants to go.
     * @return the large printed room.
     */
    private String roomDisplay(final String theUserDirection) {
        return myGameDungeon.getAdventurePosition().currentRoomLarge(myGameDungeon.getAdventurePosition(), theUserDirection);
    }

    /**
     * This is the cheats adjustments.
     */
    private void cheats() {
        myAdventurer.increaseHitPoints(999);
        myAdventurer.collectVisionPotions(999);
        myAdventurer.collectHealingPotions(999);
    }

    /**
     * This is the combat option and logic
     * for every class.
     */
    private void combat() {
        int coolDown = 0;
        if (myAdventurer.getClass().equals(Thief.class)) {

            while (myThief.isAlive() && myGameDungeon.getAdventurePosition().getMonster().isAlive()) {

                System.out.print("\n");
                System.out.println("                               " + myGameDungeon.getAdventurePosition().getMonster().getCharacterName());
                System.out.println("                               HP: " + myGameDungeon.getAdventurePosition().getMonster().getHitPoints());
                System.out.println(myGameInterface.generateHeroVersusMonsterScreen("Thief", myGameDungeon.getAdventurePosition().getMonster().getCharacterName()));
                System.out.println("\n" + myThief.getCharacterName() + " (" + myThief.getClass().getSimpleName() + ")");
                System.out.println("HP: " + myThief.getHitPoints());
                System.out.println();

                System.out.println(myGameInterface.getMyPlayerTurnNotice());
                System.out.println(myGameInterface.getMyBattleOptions());
                System.out.print(myGameInterface.getMyUserPromptInput());
                int choice = 0;
                boolean flag = true;
                do {
                    try {
                        choice = Integer.parseInt(myConsole.next());
                        while (choice != 1 && choice != 2 && choice != 3) {
                            System.out.println(myGameInterface.getMyBattleOptions());
                            System.out.print(myGameInterface.getMyUserPromptInput());
                            choice = Integer.parseInt(myConsole.next());
                        }
                        flag = false;
                    } catch (Exception theException) {
                        System.out.println("Enter a valid integer number");
                        System.out.println(myGameInterface.getMyBattleOptions());
                        System.out.print(myGameInterface.getMyUserPromptInput());
                        myConsole.reset();
                    }
                } while (flag);
                if (myAdventurer.getHealingPotions() == 0 && choice == 3) {
                    System.out.println("You have 0 Healing Potions, Cannot Heal." +
                            "\nYou must attack.");
                }
                if (choice == 3 && myAdventurer.getHealingPotions() != 0) {
                    myThief.increaseHitPoints(myRand.nextInt(10, 21));
                    myAdventurer.useHealingPotion();
                    System.out.println(myGameInterface.getMyHealingPotionCountDisplay() + myAdventurer.getHealingPotions());
                } else {
                    if (choice == 2 && coolDown == 0) {
                        myThief.useSurpriseAttack(myGameDungeon.getAdventurePosition().getMonster());
                        System.out.println(myThief.getSurpriseAttackResult());
                        coolDown++;
                    } else if (choice == 2 && coolDown != 0){
                        int coolDownLeft = 3 - coolDown;
                        System.out.println("Skill is on cool down: " + coolDownLeft + " more turns");
                        System.out.println("Will Normal Attack Instead");
                        myThief.attack(myGameDungeon.getAdventurePosition().getMonster());
                        System.out.println(myThief.getHeroAttackResult());
                        coolDown++;
                    } else {
                        myThief.attack(myGameDungeon.getAdventurePosition().getMonster());
                        System.out.println(myThief.getHeroAttackResult());
                        if (coolDown != 0) {
                            coolDown++;
                        }
                    }
                }

                if (myGameDungeon.getAdventurePosition().getMonster().isAlive()) {
                    System.out.println(myGameInterface.getMyMonsterTurnNotice());
                    if (myThief.hasHeroBlock()) {
                        System.out.println(myGameDungeon.getAdventurePosition().getMonster().getCharacterName() + " tried to attack, but you blocked it.");
                    } else {
                        myGameDungeon.getAdventurePosition().getMonster().attack(myThief);
                        System.out.println(myGameDungeon.getAdventurePosition().getMonster().getAttackResult());
                        System.out.println();
                    }
                    myGameDungeon.getAdventurePosition().getMonster().heal();
                    System.out.println();
                    System.out.println(myGameDungeon.getAdventurePosition().getMonster().getHealResult());
                }

                if (coolDown == 3) {
                    coolDown = 0;
                }

                System.out.println();
            }

            System.out.println(myThief.heroToString());
            myAdventurer = myThief;

        } else if (myAdventurer.getClass().equals(Warrior.class)) {


            while (myWarrior.isAlive() && myGameDungeon.getAdventurePosition().getMonster().isAlive()) {

                System.out.print("\n");
                System.out.println("                               " + myGameDungeon.getAdventurePosition().getMonster().getCharacterName());
                System.out.println("                               HP: " + myGameDungeon.getAdventurePosition().getMonster().getHitPoints());
                System.out.println(myGameInterface.generateHeroVersusMonsterScreen("Warrior", myGameDungeon.getAdventurePosition().getMonster().getCharacterName()));
                System.out.println("\n" + myWarrior.getCharacterName() + " (" + myWarrior.getClass().getSimpleName() + ")");
                System.out.println("HP: " + myWarrior.getHitPoints());
                System.out.println();

                System.out.println(myGameInterface.getMyPlayerTurnNotice());
                System.out.println(myGameInterface.getMyBattleOptions());
                System.out.print(myGameInterface.getMyUserPromptInput());
                int choice = 0;
                boolean flag = true;
                do {
                    try {
                        choice = Integer.parseInt(myConsole.next());
                        while (choice != 1 && choice != 2 && choice != 3) {
                            System.out.println(myGameInterface.getMyBattleOptions());
                            System.out.print(myGameInterface.getMyUserPromptInput());
                            choice = Integer.parseInt(myConsole.next());
                        }
                        flag = false;
                    } catch (Exception theException) {
                        System.out.println("Enter a valid integer number");
                        System.out.println(myGameInterface.getMyBattleOptions());
                        System.out.print(myGameInterface.getMyUserPromptInput());
                        myConsole.reset();
                    }
                } while (flag);

                if (myAdventurer.getHealingPotions() == 0 && choice == 3) {
                    System.out.println("You have 0 Healing Potions, Cannot Heal." +
                            "\nYou must attack.");
                }
                if (choice == 3 && myAdventurer.getHealingPotions() != 0) {
                    myWarrior.increaseHitPoints(myRand.nextInt(10, 21));
                    myAdventurer.useHealingPotion();
                    System.out.println(myGameInterface.getMyHealingPotionCountDisplay() + myAdventurer.getHealingPotions());
                } else {
                    if (choice == 2 && coolDown == 0) {
                        myWarrior.useCrushingBlow(myGameDungeon.getAdventurePosition().getMonster());
                        System.out.println(myWarrior.getCrushingBlowAttackResult());
                        coolDown++;
                    } else if (choice == 2 && coolDown != 0) {
                        int coolDownLeft = 3 - coolDown;
                        System.out.println("Skill is on cool down: " + coolDownLeft + " more turns");
                        System.out.println("Will Normal Attack Instead");
                        myWarrior.attack(myGameDungeon.getAdventurePosition().getMonster());
                        System.out.println(myWarrior.getHeroAttackResult());
                        coolDown++;
                    } else {
                        myWarrior.attack(myGameDungeon.getAdventurePosition().getMonster());
                        System.out.println(myWarrior.getHeroAttackResult());
                        if (coolDown != 0) {
                            coolDown++;
                        }
                    }

                    if (myGameDungeon.getAdventurePosition().getMonster().isAlive()) {
                        System.out.println(myGameInterface.getMyMonsterTurnNotice());
                        if (myWarrior.hasHeroBlock()) {
                            System.out.println(myGameDungeon.getAdventurePosition().getMonster().getCharacterName() + " tried to attack, but you blocked it.");
                        } else {
                            myGameDungeon.getAdventurePosition().getMonster().attack(myWarrior);
                            System.out.println(myGameDungeon.getAdventurePosition().getMonster().getAttackResult());
                            System.out.println();
                        }
                        myGameDungeon.getAdventurePosition().getMonster().heal();
                        System.out.println();
                        System.out.println(myGameDungeon.getAdventurePosition().getMonster().getHealResult());
                    }

                }

                if (coolDown == 3) {
                    coolDown = 0;
                }
                System.out.println();
            }

            System.out.println(myWarrior.heroToString());
            myAdventurer = myWarrior;

        } else {

            while (myPriestess.isAlive() && myGameDungeon.getAdventurePosition().getMonster().isAlive()) {
                System.out.print("\n");
                System.out.println("                               " + myGameDungeon.getAdventurePosition().getMonster().getCharacterName());
                System.out.println("                               HP: " + myGameDungeon.getAdventurePosition().getMonster().getHitPoints());
                System.out.println(myGameInterface.generateHeroVersusMonsterScreen("Priestess", myGameDungeon.getAdventurePosition().getMonster().getCharacterName()));
                System.out.println("\n" + myPriestess.getCharacterName() + " (" + myPriestess.getClass().getSimpleName() + ")");
                System.out.println("HP: " + myPriestess.getHitPoints());
                System.out.println();

                System.out.println(myGameInterface.getMyPlayerTurnNotice());
                System.out.println(myGameInterface.getMyBattleOptions());
                System.out.print(myGameInterface.getMyUserPromptInput());
                int choice = 0;
                boolean flag = true;
                do {
                    try {
                        choice = Integer.parseInt(myConsole.next());
                        while (choice != 1 && choice != 2 && choice != 3) {
                            System.out.println(myGameInterface.getMyBattleOptions());
                            System.out.print(myGameInterface.getMyUserPromptInput());
                            choice = Integer.parseInt(myConsole.next());
                        }
                        flag = false;
                    } catch (Exception theException) {
                        System.out.println("Enter a valid integer number");
                        System.out.println(myGameInterface.getMyBattleOptions());
                        System.out.print(myGameInterface.getMyUserPromptInput());
                        myConsole.reset();
                    }
                } while (flag);
                if (myAdventurer.getHealingPotions() == 0 && choice == 3) {
                    System.out.println("You have 0 Healing Potions, Cannot Heal." +
                            "\nYou must attack.");
                }
                if (choice == 3 && myAdventurer.getHealingPotions() != 0) {
                    myPriestess.increaseHitPoints(myRand.nextInt(10, 21));
                    myAdventurer.useHealingPotion();
                    System.out.println(myGameInterface.getMyHealingPotionCountDisplay() + myAdventurer.getHealingPotions());
                } else {
                    if (choice == 2 && coolDown == 0) {
                        myPriestess.heal();
                        System.out.println(myPriestess.getHealingResult());
                        coolDown++;
                    } else if (choice == 2 && coolDown != 0){
                        int coolDownLeft = 3 - coolDown;
                        System.out.println("Skill is on cool down: " + coolDownLeft + " more turns");
                        System.out.println("Will Normal Attack Instead");
                        myPriestess.attack(myGameDungeon.getAdventurePosition().getMonster());
                        System.out.println(myPriestess.getHeroAttackResult());
                        coolDown++;
                    } else {
                        myPriestess.attack(myGameDungeon.getAdventurePosition().getMonster());
                        System.out.println(myPriestess.getHeroAttackResult());
                        if (coolDown != 0) {
                            coolDown++;
                        }
                    }

                    if (myGameDungeon.getAdventurePosition().getMonster().isAlive()) {
                        System.out.println(myGameInterface.getMyMonsterTurnNotice());
                        if (myPriestess.hasHeroBlock()) {
                            System.out.println(myGameDungeon.getAdventurePosition().getMonster().getCharacterName() + " tried to attack, but you blocked it.");
                        } else {
                            myGameDungeon.getAdventurePosition().getMonster().attack(myPriestess);
                            System.out.println(myGameDungeon.getAdventurePosition().getMonster().getAttackResult());
                            System.out.println();
                        }
                        myGameDungeon.getAdventurePosition().getMonster().heal();
                        System.out.println();
                        System.out.println(myGameDungeon.getAdventurePosition().getMonster().getHealResult());
                    }


                    if (coolDown == 3) {
                        coolDown = 0;
                    }

                    System.out.println();
                }

                System.out.println(myPriestess.heroToString());
                myAdventurer = myPriestess;
            }
        }
        if (myAdventurer.isAlive()) {
            System.out.println("You Won the Battle!");
            myGameDungeon.getAdventurePosition().setHasMonster(false);
        } else {
            System.out.println("You have died.");
        }

    }

    /**
     * This will create the adventurer hero
     * according to the users needs. Gets the name
     * and chooses class.
     */
    private void adventureInitialization() {
        System.out.println();
        System.out.print("Enter Your Character's Name: ");
        myConsole.nextLine();
        String name = myConsole.nextLine();

        System.out.println();

        System.out.println(myGameInterface.getMySelectionScreen());
        System.out.print(myGameInterface.getMyUserPromptInput());
        int heroClass = 0;
        boolean flag = true;
        do {
            try {
                heroClass = Integer.parseInt(myConsole.next());
                while (heroClass > 3 || heroClass < 1) {
                    System.out.println("Please pick one of the following options: ");
                    System.out.println(myGameInterface.getMySelectionScreen());
                    System.out.print(myGameInterface.getMyUserPromptInput());
                    heroClass = Integer.parseInt(myConsole.next());
                }
                flag = false;
            } catch (Exception theException) {
                System.out.println("Enter a valid integer number");
                System.out.println(myGameInterface.getMySelectionScreen());
                System.out.print(myGameInterface.getMyUserPromptInput());
                myConsole.reset();
            }
        } while (flag);

        if (heroClass == 1) {
            System.out.println(myGameInterface.getMyWarriorSelectionConfirmation());
            System.out.println(myGameInterface.getWarriorIcon());;
            myWarrior = new Warrior(name);
            myAdventurer = myWarrior;
            System.out.println("\n" + myAdventurer);
        } else if (heroClass == 2) {
            System.out.println(myGameInterface.getMyThiefSelectionConfirmation());
            System.out.println(myGameInterface.getThiefIcon());
            myThief = new Thief(name);
            myAdventurer = myThief;
            System.out.println("\n" + myAdventurer);
        } else {
            System.out.println(myGameInterface.getMyPriestessSelectionConfirmation());
            System.out.println(myGameInterface.getPriestessIcon());
            myPriestess = new Priestess(name);
            myAdventurer = myPriestess;
            System.out.println("\n" + myAdventurer);
        }
    }

    /**
     * This will give the user the mini-map
     * view depending on if the user has a vision
     * potion active or not.
     *
     * @param theUsedVisionPotion is if the user used a vision potion.
     * @return the mini-map view.
     */
    private String miniMap(final boolean theUsedVisionPotion) {
        if (!theUsedVisionPotion) {
            return myGameDungeon.noVisionToString();
        } else {
            return myGameDungeon.visionPotionToString();
        }
    }

    /**
     * Will check if the user has reached a game
     * ending scenario.
     *
     * @return whether game ended or not.
     */
    private boolean gameOver() {
        return !myAdventurer.isAlive() || checkOOPPillars() && myGameDungeon.getAdventurePosition().getIsExit();
    }

    /**
     * This will check if the user has all
     * the OOP Pillars.
     *
     * @return is user has all OOP Pillars.
     */
    private boolean checkOOPPillars() {
        return myAdventurer.getFoundPillarsOfOOP().contains("A") || myAdventurer.getFoundPillarsOfOOP().contains("E")
                || myAdventurer.getFoundPillarsOfOOP().contains("I") || myAdventurer.getFoundPillarsOfOOP().contains("P");
    }

    /**
     * This will automatically collect the item if
     * the user enters a room with an item.
     *
     * @return a message telling user what they collected.
     */
    private String itemCollection() {
        Room adventurerLocation = myGameDungeon.getAdventurePosition();
        StringBuilder holder = new StringBuilder();
        if (adventurerLocation.getHasHealingPotion()) {
            myAdventurer.collectHealingPotions(1);
            holder.append(myGameInterface.getMyPlayerFoundHealingPotionNotice() + "\n" );
            holder.append(myGameInterface.getMyHealingPotionCountDisplay() + " " + myAdventurer.getHealingPotions() + "\n");
        }
        if (adventurerLocation.getHasVisionPotion()) {
            myAdventurer.collectVisionPotions(1);
            holder.append(myGameInterface.getMyPlayerFoundVisionPotionNotice() + "\n");
            holder.append(myGameInterface.getMyVisionPotionCountDisplay() + " " + myAdventurer.getVisionPotions() + "\n");
        }
        if (adventurerLocation.getHasOOPPillar()) {
            String OOPPillar = adventurerLocation.getSpecificOOPPillar();
            myAdventurer.collectFoundPillarOfOOP(OOPPillar);
            holder.append("You've found a OOP Pillar!: " + adventurerLocation.getSpecificOOPPillar());
        }
        if (adventurerLocation.getHasPit()) {
            myAdventurer.subtractHitPoints(adventurerLocation.getPitDamage());
            holder.append("You've stumbled upon a pit: -" + adventurerLocation.getPitDamage() + " health.");
        }
        adventurerLocation.collectRoom();
        return holder.toString();
    }

    /**
     * This will check if the direction the user
     * wants to go to is valid or not.
     *
     * @param theDirection is the direction user wants to go to.
     * @return is if direction is possible or not.
     */
    private boolean isValidDirection(final String theDirection) {
        String intendedDirection = theDirection.toUpperCase();
        ArrayList<String> allValidDirections = myGameDungeon.availableDirections();
        ArrayList<String> ignoreCaps = new ArrayList<>();
        for (String availableDirection : allValidDirections) {
            ignoreCaps.add(availableDirection.toUpperCase());
        }
        return ignoreCaps.contains(intendedDirection);
    }

    /**
     * This is the scripted map for presenting.
     */
    private void scriptedDungeon() {
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

        room00.closeAllDoors();
        room00.setIsEntrance(true);
        room00.setSouthDoor(true);

        room01.closeAllDoors();
        room01.setEastDoor(true);

        room02.closeAllDoors();
        room02.setWestDoor(true);
        room02.setSouthDoor(true);

        room03.closeAllDoors();
        room03.setSouthDoor(true);

        room04.closeAllDoors();
        room04.setSouthDoor(true);
        room04.setHasOOPPillar(true);
        room04.setSpecificOOPPillar("E");
        room04.setHasMonster(true);

        room10.closeAllDoors();
        room10.setNorthDoor(true);
        room10.setEastDoor(true);
        room10.setHasHealingPotion(true);

        room11.openAllDoors();
        room11.setNorthDoor(false);

        room12.openAllDoors();
        room12.setHasOOPPillar(true);
        room12.setSpecificOOPPillar("I");
        room12.setHasMonster(true);

        room13.closeAllDoors();
        room13.setNorthDoor(true);
        room13.setWestDoor(true);

        room14.closeAllDoors();
        room14.setNorthDoor(true);
        room14.setSouthDoor(true);

        room20.closeAllDoors();
        room20.setSouthDoor(true);
        room20.setHasOOPPillar(true);
        room20.setSpecificOOPPillar("A");
        room20.setHasMonster(true);

        room21.openAllDoors();
        room21.setWestDoor(false);
        room21.setEastDoor(false);

        room22.openAllDoors();
        room22.setWestDoor(false);

        room23.closeAllDoors();
        room23.setWestDoor(true);

        room24.closeAllDoors();
        room24.setNorthDoor(true);
        room24.setSouthDoor(true);

        room30.openAllDoors();
        room30.setWestDoor(false);
        room30.setHasPit(true);

        room31.openAllDoors();
        room31.setEastDoor(false);
        room31.setHasVisionPotion(true);

        room32.openAllDoors();
        room32.setWestDoor(false);
        room32.setSouthDoor(false);

        room33.openAllDoors();
        room33.setNorthDoor(false);

        room34.openAllDoors();
        room34.setEastDoor(false);

        room40.closeAllDoors();
        room40.setNorthDoor(true);
        room40.setEastDoor(true);
        room40.setIsExit(true);
        room40.setHasMonster(true);

        room41.openAllDoors();
        room41.setSouthDoor(false);

        room42.openAllDoors();
        room42.setNorthDoor(false);
        room42.setSouthDoor(false);

        room43.openAllDoors();
        room43.setEastDoor(false);
        room43.setSouthDoor(false);

        room44.closeAllDoors();
        room44.setNorthDoor(true);
        room44.setHasOOPPillar(true);
        room44.setSpecificOOPPillar("P");
        room44.setHasMonster(true);



        Room[][] script = {{room00, room01, room02, room03, room04}
                , {room10, room11, room12, room13, room14}
                , {room20, room21, room22, room23, room24}
                , {room30, room31, room32, room33, room34}
                , {room40, room41, room42, room43, room44}};

        myGameDungeon = new Dungeon(script);
    }

    /**
     * This will run the code.
     *
     * @param args is the argument.
     */
    public static void main(String [] args) {
        DungeonAdventure game = new DungeonAdventure();
        game.startMenu(game);
        if (game.gameOver()) {
            System.out.println(game.myInitialDungeon);
        }
        System.out.println("FINISH");
    }


}