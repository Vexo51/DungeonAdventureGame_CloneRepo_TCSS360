package model;




/**
 * This class represents a Warrior type of character (inherit from Hero).
 *
 *
 *
 * @author Dung Nguyen
 * @version 11/05/2023
 */
public class Warrior extends Hero{

    private static final int WARRIOR_HIT_POINTS = 125;
    private static final int WARRIOR_MIN_DAMAGE = 35;
    private static final int WARRIOR_MAX_DAMAGE = 60;
    private static final int WARRIOR_ATTACK_SPEED = 4;
    private static final double WARRIOR_ACCURACY = 80.0;
    private static final double WARRIOR_BLOCK_CHANCE = 20.0;

    /**
     the chance to use special skill for Warrior.
     */
    private double myChanceToUseSpecialSkill;



    /**
     * Constructs the Warrior character with a specified
     * stats/fields from DungeonCharacter (the grandparent class) such as character's name, health point, attack speed,
     * the min and the max damage a character can do, the accuracy of a character.
     *
     * Initialize hero (parent-class) specified fields such the chance to block as a hero.
     *
     * Initialize Warrior specified field for the chance to use special skill.
     *
     * @param theName capture the character name for your Warrior
     */
    public Warrior(final String theName){

        super(theName, WARRIOR_HIT_POINTS, WARRIOR_MIN_DAMAGE, WARRIOR_MAX_DAMAGE,
                WARRIOR_ATTACK_SPEED, WARRIOR_ACCURACY, WARRIOR_BLOCK_CHANCE);
        setChanceToUseSpecialSkill(40.0);


    }

    /**
     * Returns the chance to use special skill for the Warrior.
     *
     * @return the chance to use special skill for the Warrior.
     */
    public double getMyChanceToUseSpecialSkill(){
        return myChanceToUseSpecialSkill;
    }


    /**
     * Set the chance to use special skill for the Warrior.
     *
     * @param theChanceForSpecialSkill capture the chance to use special skill for the Warrior.
     */
    protected void setChanceToUseSpecialSkill(final double theChanceForSpecialSkill){
        if(theChanceForSpecialSkill > 100.0 || theChanceForSpecialSkill <= 0){
            throw new IllegalArgumentException("the chance to use special skill was either greater than 100 percent or less than or equal to 0.");
        }
        myChanceToUseSpecialSkill = theChanceForSpecialSkill/100.0;
    }

    /**
     * return whether the Warrior successfully activate the special skill of Crushing Blow.
     *
     * @return true if Warrior succeed in using special skill; false otherwise
     */
    protected boolean hasWarriorSucceededInUsingCrushingBlow(){
        return MY_RANDOM.nextDouble() < myChanceToUseSpecialSkill;
    }

    /**
     * The Warrior's special skill of Crushing Blow that does 75 to 175 points of damage
     * toward the character the Warrior used their special skill on.
     * It also only has a 40% chance of succeeding (developers can adjust all numbers)
     *
     *
     * @param theCharacter capture the DungeonCharacter to use special skill on by the Warrior
     */
    @Override
    public void useSpecialSkill(final DungeonCharacter theCharacter){
        if (theCharacter == null) {
            throw new IllegalArgumentException("the opponent DungeonCharacter passed to use special skill on was null");
        }

        int specialDamage = MY_RANDOM.nextInt(176 - 75) + 75;
        if(hasWarriorSucceededInUsingCrushingBlow()){
            System.out.println("Success! " + getCharacterName() + " dealt a heavy blow to " + theCharacter.getCharacterName()
                    + " for " + specialDamage + " damages! (" + theCharacter.getHitPoints() + " - " + specialDamage + ")");
            theCharacter.subtractHitPoints(specialDamage);

        } else {
            System.out.println(getCharacterName() + " failed to use Crushing Blow");
        }

    }
}


