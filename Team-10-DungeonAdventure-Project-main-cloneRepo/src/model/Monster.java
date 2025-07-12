package model;

public class Monster extends DungeonCharacter{

    private double myChanceToHeal;

    private int myMinHealPoint;

    private int myMaxHealPoint;

    private int myMonsterHealthPoint;


    public Monster(final String theMonsterName, final int theHitPoints,
                   final int theMinDamage, final int theMaxDamage,
                   final int theAttackSpeed, final double theAccuracy,
                   final int theMinPointToHeal, final int theMaxPointToHeal,
                   final double theChanceToHeal){

        super(theMonsterName, theHitPoints, theMinDamage, theMaxDamage, theAttackSpeed, theAccuracy);
        setMonsterHealthPoint(theHitPoints);
        setMonsterMinHealPoint(theMinPointToHeal);
        setMonsterMaxHealPoint(theMaxPointToHeal);
        setMonsterChanceToHeal(theChanceToHeal);

    }


    public double getMonsterChanceToHeal(){
        return myChanceToHeal;
    }

    public int getMonsterHealthPoint(){
        return myMonsterHealthPoint;
    }


    protected void setMonsterHealthPoint(final int theHealthPoint){
        if (theHealthPoint <= 0) {
            throw new IllegalArgumentException("Monster's health points shouldn't be set to negative or zero");
        }
        myMonsterHealthPoint = theHealthPoint;
    }

    protected void setMonsterMinHealPoint(final int theMinHealPoint){
        if (theMinHealPoint < 0) {
            throw new IllegalArgumentException("The minimum heal point passed to setMonsterMinHealPoint was negative.");
        }
        myMinHealPoint = theMinHealPoint;
    }

    protected void setMonsterMaxHealPoint(final int theMaxHealPoint){
        if (theMaxHealPoint < 0 || theMaxHealPoint < myMinHealPoint) {
            throw new IllegalArgumentException("The maximum heal point passed to setMonsterMaxHealPoint was negative." +
                                                "Max heal point also should not be set to be less than min heal point");
        }
        myMaxHealPoint = theMaxHealPoint;
    }

    protected void setMonsterChanceToHeal(final double theChanceToHeal){
        if(theChanceToHeal > 100.0 || theChanceToHeal <= 0){
            throw new IllegalArgumentException("the chance to heal was either greater than 100 percent or less than or equal to 0.");

        }
        myChanceToHeal = theChanceToHeal / 100;
    }

    protected int generateHealValue(){
        int healAmount = MY_RANDOM.nextInt((myMaxHealPoint+1) - myMinHealPoint) + myMinHealPoint;

        // Making sure Monster won't heal pass their maximum hit points
        if(healAmount + getHitPoints() > myMonsterHealthPoint){
            healAmount = myMonsterHealthPoint - getHitPoints();
        }
        return healAmount;


    }

    protected boolean checkChanceToHeal(){
        return MY_RANDOM.nextDouble() < myChanceToHeal;
    }

    public void heal(){
        int healAmount = generateHealValue();

        if(getHitPoints() == myMonsterHealthPoint){
            System.out.println(getCharacterName() + "'s health (" + getHitPoints() + ") is full so cannot heal");

        } else if (isAlive() && getHitPoints() < myMonsterHealthPoint) {

            if (checkChanceToHeal()){
                System.out.println(getCharacterName() + " healed for " + healAmount);
                increaseHitPoints(healAmount);
                System.out.println(getCharacterName() + "'s health is now " + getHitPoints());
                myMonsterHealthPoint  += healAmount;
            } else {
                System.out.println(getCharacterName() + "failed to heal");
            }
        }

    }

}
