package view;

import java.io.Serializable;



/**
 * This class represents the game interface
 * which are console-based
 *
 * @author Dung Nguyen
 * @version 12-14-23
 */
public class GameInterface implements Serializable {




    /**
     the text art icon that represents the Priestess.
     */
    private String myPriestessIcon = "     ^ \n" +
                                     "    /_\\    v\n" +
                                     "   /___\\   |\n" +
                                     "( ~ o`_'o)~|";

    /**
     the text art icon that represents the Warrior.
     */
    private String myWarriorIcon = "              |<)\n" +
                                   "(+)('0 _ '0)~ !";

    /**
     the text art icon that represents the Thief.
     */
    private String myThiefIcon = "('- _ -)~ =[]::::>";


    /**
     the text art icon that represents an Ogre monster.
     */
    private String myOgreIcon = "                                         /`|~~|'']  \n" +
            "                         _,='`````'=/_    '/ /'` \n" +
            "                       //(  (o)/ (o) )\\\\   //\n" +
            "                      //(     (_,     )\\\\  / ";

    /**
     the text art icon that represents a Skeleton monster.
     */
    private String mySkeletonIcon = "                          /)  \n" +
            "                         //   .-.\n" +
            "                        //   (0.0)\n" +
            "                       [ ]~'=.|m|.='";


    /**
     the text art icon that represents a Gremlin monster.
     */
    private String myGremlinIcon = "                            /|        |\\ \n" +
            "                   /:      / /  .  .  \\ \\ \n" +
            "                 <(-:---= < (   o\\/o   ) >\n" +
            "                   \\:      (    V--V    )";


    /**
     This text prompt the player to choose
     */
    private String myUserPromptInput = "Enter your choice here: ";


    /**
     The start menu, which is first thing the player will see
     when they start the game
     */
    private String myStartMenu = "1 to Start \n" +
            "2 to Load \n" +
            "3 to Quit \n";


    /**
     The character's selection screen texts, which will display next
     after player entered 1 to start the game from the start menu
     */
    private String mySelectionScreen = "Select your Hero: \n" +
            "1 for Warrior \n" +
            "2 for Thief \n" +
            "3 for Priestess \n";


    /**
     Display this if player entered 1 to select Warrior as their Hero character
     */
    private String myWarriorSelectionConfirmation = "You've selected Warrior as your character!\n";

    /**
     Display this if player entered 2 to select Thief as their Hero character
     */
    private String myThiefSelectionConfirmation = "You've selected Thief as your character!\n";

    /**
     Display this if player entered 3 to select Priestess as their Hero character
     */
    private String myPriestessSelectionConfirmation = "You've selected Priestess as your character!\n";



    /**
     Display this text when the gameplay start
     */
    private String myGameBeginNotice = "Game start! \n";


    /**
     Display a text list of choices for player to choose in the gameplay
     */
    private String myChoicesMenu = "Choices: \n" +
            "1 to Move \n" +
            "2 to view Mini-map \n" + // Probably will rely on Dungeon toString method to display the mini-map
            "3 to use a Potion \n" +
            "4 to view Character's Status \n" + // just need to use toString method of the current Hero to view their stats
            "5 to Save \n" + // You'll handle this one Tyler (The ability to save during the gameplay)
            "6 to Quit \n" +  // the program will just end/close when player choose this
            "7 to activate Cheats \n";

    /**
    Display the healing potion count text
     */
    private String myHealingPotionCountDisplay = "Total # of Healing Potions: ";

    /**
     Display the vision potion count text
     */
    private String myVisionPotionCountDisplay = "Total # of Vision Potions: ";

    /**
     Display the potion options for player to choose
     */
    private String myPotionOptions = "1 to use Healing Potion \n" +
            "2 to use Vision Potion (Will last 3 turns)\n";

    /**
     Display the notice text to let player know they've used a healing potion
     */
    private String myHealingPotionUsedNotice = "You used a Healing Potion! You have healed for \n";

    /**
     Display the notice text to let player know they've used a vision potion
     */
    private String myVisionPotionUsedNotice = "You used a Vision Potion! View your Mini-map to see the effect \n";



    /**
     Display the notice text to let player know they've found a healing potion
     */
    private String myPlayerFoundHealingPotionNotice = "You've found a Healing Potion! (+1)";

    /**
     Display the notice text to let player know they've used a vision potion
     */
    private String myPlayerFoundVisionPotionNotice = "You've found a Vision Potion! (+1)";




    // Battle section here (when player encountered a monster in the maze)
    // Battle section should be a turn base where the character get to attack first, and then monster,
    // then back again and again until either side loses
    /**
     Display the notice text to let player know whenever they encounter a Monster in a Dungeon Room
     Letting them know they will have to fight it
     */
    private String myMonsterEncounteredNotice = "You encounter a Monster! Entering battle phase:";

    /**
     Display the text that let the player know it's their turn when fighting a monster in the battle phase
     */
    private String myPlayerTurnNotice = "Your turn!";


    /**
     Display a list battle options texts for the player to choose when fighting a monster
     */
    private String myBattleOptions = "Battle options: \n" +
            "1. to Attack \n" +
            "2. to use Special Skill \n" +
            "3. to use a Healing Potion \n";

    /**
     Display the text that let the player know whenever it's the monster turn in the battle phase
     */
    private String myMonsterTurnNotice = "Monster turn!";



    /**
     Display a winning screen text whenever the player successfully reach the exit of the maze
     */
    private String myWinningScreen = "Congratulation, you won! you've exited the Dungeon\n";


    /**
     Display a losing screen text if the player were to die to a Monster's attack during a battle phase
     */
    private String myLosingScreen = "Game Over!";



    /**
     * Constructs a GameInterface object
     *
     */
    public GameInterface(){}


    /**
     * Returns the text art icon that represents the Priestess.
     *
     * @return the text art icon that represents the Priestess
     */
    public String getPriestessIcon(){
        return myPriestessIcon;
    }


    /**
     * Returns the text art icon that represents the Warrior.
     *
     * @return the text art icon that represents the Warrior
     */
    public String getWarriorIcon(){
        return myWarriorIcon;
    }


    /**
     * Returns the text art icon that represents the Thief.
     *
     * @return the text art icon that represents the Thief
     */
    public String getThiefIcon(){
        return myThiefIcon;
    }

    /**
     * Returns the text art icon that represents an ogre monster.
     *
     * @return the text art icon that represents an ogre
     */
    public String getOgreIcon(){return myOgreIcon;}

    /**
     * Returns the text art icon that represents a skeleton monster.
     *
     * @return the text art icon that represents a skeleton monster
     */
    public String getSkeletonIcon(){return mySkeletonIcon;}

    /**
     * Returns the text art icon that represents a gremlin monster.
     *
     * @return the text art icon that represents a gremlin monster
     */
    public String getGremlinIcon(){return myGremlinIcon;}

    /**
     * Returns the text that prompts the player to choose.
     *
     * @return the text that prompts the player to choose
     */
    public String getMyUserPromptInput(){
        return myUserPromptInput;
    }

    /**
     * Returns the start menu
     *
     * @return the start menu
     */
    public String getMyStartMenu() {
        return myStartMenu;
    }

    /**
     * Returns the selection screen
     *
     * @return the selection screen
     */
    public String getMySelectionScreen(){
        return mySelectionScreen;
    }

    /**
     * Returns the confirmation text when player selected the Warrior
     *
     * @return the confirmation text when player selected the Warrior
     */
    public String getMyWarriorSelectionConfirmation(){
        return myWarriorSelectionConfirmation;
    }

    /**
     * Returns the confirmation text when player selected the Thief
     *
     * @return the confirmation text when player selected the Thief
     */
    public String getMyThiefSelectionConfirmation(){
        return myThiefSelectionConfirmation;
    }


    /**
     * Returns the confirmation text when player selected the Priestess
     *
     * @return the confirmation text when player selected the Priestess
     */
    public String getMyPriestessSelectionConfirmation(){
        return myPriestessSelectionConfirmation;
    }


    /**
     * Returns the text that notify the player whenever the gameplay begin
     *
     * @return the text that notify the player whenever the gameplay begin
     */
    public String getMyGameBeginNotice(){return myGameBeginNotice;}


    /**
     * Returns the choice menu
     *
     * @return the choice menu
     */
    public String getMyChoiceMenu(){
        return myChoicesMenu;
    }


    /**
     * Returns the text that display healing potion count
     *
     * @return the text that display healing potion count
     */
    public String getMyHealingPotionCountDisplay(){return myHealingPotionCountDisplay;}


    /**
     * Returns the text that display vision potion count
     *
     * @return the text that display vision potion count
     */
    public String getMyVisionPotionCountDisplay(){
        return myVisionPotionCountDisplay;
    }

    /**
     * Returns the text that potion options
     *
     * @return the text that display potion options
     */
    public String getMyPotionOptions(){
        return myPotionOptions;
    }


    /**
     * Returns the notification text that display whenever the player used a healing potion
     *
     * @return the notification text that display whenever the player used a healing potion
     */
    public String getMyHealingPotionUsedNotice(){
        return myHealingPotionUsedNotice;
    }

    /**
     * Returns the notification text that display whenever the player used a vision potion
     *
     * @return the notification text that display whenever the player used a vision potion
     */
    public String getMyVisionPotionUsedNotice(){
        return myVisionPotionUsedNotice;
    }

    /**
     * Returns the notification text that display whenever the player found a healing potion
     *
     * @return the notification text that display whenever the player found a healing potion
     */
    public String getMyPlayerFoundHealingPotionNotice(){
        return myPlayerFoundHealingPotionNotice;
    }

    /**
     * Returns the notification text that display whenever the player found a vision potion
     *
     * @return the notification text that display whenever the player found a vision potion
     */
    public String getMyPlayerFoundVisionPotionNotice(){
        return myPlayerFoundVisionPotionNotice;
    }


    /**
     * Returns the notification text that display whenever the player encounter a monster
     *
     * @return the notification text that display whenever the player encounter a monstern
     */
    public String getMyMonsterEncounteredNotice(){
        return myMonsterEncounteredNotice;
    }

    /**
     * Returns the text that let the player know it's their turn during the battle phase
     *
     * @return the text that let the player know it's their turn during the battle phase
     */
    public String getMyPlayerTurnNotice(){
        return myPlayerTurnNotice;
    }

    /**
     * Returns the text that let the player know it's the monster's turn during the battle phase
     *
     * @return the text that let the player know it's the monster's turn during the battle phase
     */
    public String getMyMonsterTurnNotice(){return myMonsterTurnNotice;}

    /**
     * Returns the battle options
     *
     * @return the battle options
     */
    public String getMyBattleOptions(){
        return myBattleOptions;
    }


    /**
     * Returns the winning screen
     *
     * @return the winning screen
     */
    public String getMyWinningScreen(){
        return myWinningScreen;
    }

    /**
     * Returns the losing screen
     *
     * @return the losing screen
     */
    public String getMyLosingScreen(){
        return myLosingScreen;
    }

    /**
     * generate a string text that show a (specify) Hero versus a (specify) Monster based on a pokemon-inspired interface type of screen
     * during the battle phase that show what type of Monster the player's character are facing when doing battle
     *
     * @param theHeroClass capture the string name of the Hero class type the player is using (Warrior/Thief/Priestess)
     * @param theMonsterType capture the string name of the type of Monster (Ogre/Skeleton/Gremlin)
     * @return a string text that show a (specify) Hero versus a (specify) Monster
     */
    public String generateHeroVersusMonsterScreen(final String theHeroClass, final String theMonsterType){
        if (theHeroClass.equals("") || theMonsterType.equals("")){
            throw new IllegalArgumentException("Either theHeroClass or theMonsterType is empty");
        }
        String heroVsMonster = "";

        if (theHeroClass.equalsIgnoreCase("Warrior") && theMonsterType.equalsIgnoreCase("Ogre")){
            heroVsMonster = myOgreIcon + "\n" +
                    "                   VS \n" +
            myWarriorIcon;
        } else if (theHeroClass.equalsIgnoreCase("Warrior") && theMonsterType.equalsIgnoreCase("Skeleton")){
            heroVsMonster =  mySkeletonIcon + "\n" +
                    "                   VS \n" +
                    myWarriorIcon;
        } else if (theHeroClass.equalsIgnoreCase("Warrior") && theMonsterType.equalsIgnoreCase("Gremlin")) {
            heroVsMonster = myGremlinIcon + "\n" +
                    "                   VS \n" +
                    myWarriorIcon;
        } else if (theHeroClass.equalsIgnoreCase("Thief") && theMonsterType.equalsIgnoreCase("Ogre")){
            heroVsMonster = myOgreIcon + "\n" +
                    "                   VS \n" +
                    myThiefIcon;
        } else if (theHeroClass.equalsIgnoreCase("Thief") && theMonsterType.equalsIgnoreCase("Skeleton")) {
            heroVsMonster = mySkeletonIcon + "\n" +
                    "                   VS \n" +
                    myThiefIcon;
        } else if (theHeroClass.equalsIgnoreCase("Thief") && theMonsterType.equalsIgnoreCase("Gremlin")) {
            heroVsMonster = myGremlinIcon + "\n" +
                    "                   VS \n" +
                    myThiefIcon;
        } else if (theHeroClass.equalsIgnoreCase("Priestess") && theMonsterType.equalsIgnoreCase("Ogre")) {
            heroVsMonster = myOgreIcon + "\n" +
                    "                   VS \n" +
                    myPriestessIcon;
        } else if (theHeroClass.equalsIgnoreCase("Priestess") && theMonsterType.equalsIgnoreCase("Skeleton")) {
            heroVsMonster = mySkeletonIcon + "\n" +
                    "                   VS \n" +
                    myPriestessIcon;
        } else if (theHeroClass.equalsIgnoreCase("Priestess") && theMonsterType.equalsIgnoreCase("Gremlin")){
            heroVsMonster = myGremlinIcon + "\n" +
                    "                   VS \n" +
                    myPriestessIcon;
        } else {
            throw new IllegalArgumentException("These Hero/Monster string representation does not exist.");
        }


        return heroVsMonster;
    }
    

}
