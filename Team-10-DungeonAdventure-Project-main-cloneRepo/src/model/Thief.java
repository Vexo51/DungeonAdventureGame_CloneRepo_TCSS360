package model;



/**
 * This class represents a Thief type of character (inherit from Hero).
 *
 *
 *
 * @author Dung Nguyen
 * @version 11/05/2023
 */
public class Thief extends Hero {

    private static final int THIEF_HIT_POINTS = 75;
    private static final int THIEF_MIN_DAMAGE = 20;
    private static final int THIEF_MAX_DAMAGE = 40;
    private static final int THIEF_ATTACK_SPEED = 6;
    private static final double THIEF_ACCURACY = 80.0;
    private static final double THIEF_BLOCK_CHANCE = 40.0;

    /**
     the chance of success for using thief's special skill.
     */
    private double myChanceToUseSpecialSkill;

    /**
     the caught chance when using your thief's special attack.
     */
    private double myThiefChanceOfGettingCaught;


    /**
     * Constructs the Thief character with a specified
     * stats/fields from DungeonCharacter (the grandparent class) such as character's name, health point, attack speed,
     * the min and the max damage a character can do, the accuracy of a character.
     *
     * Initialize hero (parent-class) specified fields such the chance to block as a hero.
     *
     * Initialize Thief specified fields for the chance to use special skill, and the chance of thief getting caught.
     *
     * @param theName capture the character name for your Thief
     */
    public Thief(final String theName){
        super(theName, THIEF_HIT_POINTS, THIEF_MIN_DAMAGE, THIEF_MAX_DAMAGE,
                THIEF_ATTACK_SPEED, THIEF_ACCURACY, THIEF_BLOCK_CHANCE);
        setChanceToUseSpecialSkill(40.0);
        setCaughtChance(20.0);

    }

    /**
     * Returns the chance to use special skill for the Thief.
     *
     * @return the chance to use special skill for the Thief.
     */
    public double getMyChanceToUseSpecialSkill(){
        return myChanceToUseSpecialSkill;
    }

    /**
     Return the caught chance when using your thief's special attack.

     @return the caught chance when using your thief's special attack.
     */
    public double getThiefChanceOfGettingCaught(){
        return myThiefChanceOfGettingCaught;
    }


    /**
     Set the chance to use special skill for the thief.

     @param theChanceForSpecialSkill capture the percentage chance (double) to use special skill for the Thief.
     */
    protected void setChanceToUseSpecialSkill(final double theChanceForSpecialSkill){
        if(theChanceForSpecialSkill > 100.0 || theChanceForSpecialSkill <= 0){
            throw new IllegalArgumentException("the chance to use special skill was either greater than 100 percent or less than or equal to 0.");
        }
        myChanceToUseSpecialSkill = theChanceForSpecialSkill/100.0;
    }

    /**
     Set the caught chance when using your thief's special attack.

     @param theChanceToGetCaught capture the caught percentage chance (double) when using your thief's special attack.
     */
    protected void setCaughtChance(final double theChanceToGetCaught){
        if(theChanceToGetCaught > 100.0 || theChanceToGetCaught <= 0){
            throw new IllegalArgumentException("the chance of getting caught was either greater than 100 percent or less than or equal to 0.");
        }
        myChanceToUseSpecialSkill = theChanceToGetCaught/100.0;
    }


    /**
     Return whether your thief succeed in using surprise attack.

     @return true if your thief succeed in using surprise attack; false otherwise
     */
    protected boolean hasThiefSucceededInSurpriseAttack(){
        return MY_RANDOM.nextDouble() < myChanceToUseSpecialSkill;
    }


    /**
     Return whether the thief got caught or not when using the thief's special attack.

     @return true if your thief get caught when using your thief's special attack; false otherwise
     */
    protected boolean hasThiefGotCaught(){
        return MY_RANDOM.nextDouble() < myThiefChanceOfGettingCaught;
    }


    /**
     * Special skill for Thief is surprise attack -- 40 percent chance it is successful.
     * If it is successful, Thief gets an attack and another turn (extra attack) in the current round.
     * There is a 20 percent chance the Thief is caught in which case no attack at all is rendered.
     * The other 40 percent is just a normal attack.
     *
     * @param theCharacter capture a DungeonCharacter to use special skill on by the Thief.
     */
    @Override
    public void useSpecialSkill(final DungeonCharacter theCharacter){

        if (theCharacter == null) {
            throw new IllegalArgumentException("the DungeonCharacter passed to use special skill on was null");
        }

        int damage = generateDamagesValue();

        System.out.println(getCharacterName() + " uses surprise attack on " + theCharacter.getCharacterName());

        if(hasThiefSucceededInSurpriseAttack()){
            System.out.println("Success!(40%) " + getCharacterName() + " gained an extra attack this round!");
            System.out.println(getCharacterName() + " dealt a surprise attack on " + theCharacter.getCharacterName()
                    + " for " + damage + " damages! (" + theCharacter.getHitPoints() + " - " + damage + ")");
            theCharacter.subtractHitPoints(damage);
            super.Attack(theCharacter);

        } else if (hasThiefGotCaught()){
            System.out.println(getCharacterName() + " got caught. Surprise attack failed!(20%)");
        } else {
            System.out.println(getCharacterName() + " failed to surprise " + theCharacter.getCharacterName() + "."
                    + getCharacterName() + " switches to normal attack (40%)");
            super.Attack(theCharacter);
        }


    }

}
