package model;


/**
 * This class is uses to create Monster.
 *
 *
 *
 * @author Dung Nguyen
 * @version 11/26/2023
 */
public class MonsterFactory {

    /**
     * A method to create specify Monster (declare as static for Singleton)
     *
     * @param theMonsterType captures the name of the requested monster
     * @return the requested Monster
     */
    public static Monster createMonster(final String theMonsterType){
        MonsterSQLiteDatabase db = MonsterSQLiteDatabase.getInstance();
        Monster monster = null;
        if (theMonsterType.equals("Ogre")){
            monster = db.getMonsterFromDatabase("Ogre");
        } else if (theMonsterType.equals("Skeleton")) {
            monster = db.getMonsterFromDatabase("Skeleton");
        } else if (theMonsterType.equals("Gremlin")) {
            monster = db.getMonsterFromDatabase("Gremlin");
        } else {
            throw new IllegalArgumentException("This monster type does not exist in the database");
        }
        return monster;
    }


    // test on main to see if we can create monster using MonsterFactory
    public static void main(String[] args) {
        Monster skeleton= MonsterFactory.createMonster("Skeleton");
        System.out.println(skeleton.toString());

    }

}