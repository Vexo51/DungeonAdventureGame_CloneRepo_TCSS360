package model;


import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * This class is uses to store monster name and stats in a SQLite database.
 *
 *
 *
 * @author Dung Nguyen
 * @version 11/26/2023
 */
public class MonsterSQLiteDatabase {


    /**
     Initialize MonsterSQLiteDatabase as a static unique instance for singleton ('eager' instance)
     */
    private static MonsterSQLiteDatabase monsterDatabase = new MonsterSQLiteDatabase();


    /**
     data source that represents data in a SQLite database
     */
    private SQLiteDataSource ds = null;


    /**
     A query string to be uses to request for data results from SQLite database or for action on the data
     */
    private String query = "";



    /**
     constructs a SQLite database for storing monster data
     */
    private MonsterSQLiteDatabase(){
        connect();
        createTableForMonster();
        if(readAllMonsters().isEmpty()){
            insertMonstersToTable();
        }

    }




    /**
     * Returns this class instance of monster database.
     *
     * @return this class instance of monster database
     */
    public static MonsterSQLiteDatabase getInstance(){
        return monsterDatabase;
    }


    /**
     * establish connection and creates sqlite file if it does not exist
     *
     */
    private void connect(){

        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:monsters.sqlite");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

    }


    /**
     * create a table that is uses to store monster data
     *
     */
    private void createTableForMonster(){
        // create a table
        query = "CREATE TABLE IF NOT EXISTS Monster ( " +
                "MONSTER_NAME VARCHAR NOT NULL, " +
                "MONSTER_HITPOINTS INTEGER NOT NULL, " +
                "MONSTER_MIN_DAMAGE INTEGER NOT NULL, " +
                "MONSTER_MAX_DAMAGE INTEGER NOT NULL, " +
                "MONSTER_ATTACK_SPEED INTEGER NOT NULL, " +
                "MONSTER_ACCURACY DOUBLE NOT NULL, " +
                "MONSTER_MIN_HEALPOINTS INTEGER NOT NULL, " +
                "MONSTER_MAX_HEALPOINTS INTEGER NOT NULL, " +
                "MONSTER_CHANCE_TO_HEAL DOUBLE NOT NULL )";


        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query );

        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }


    /**
     * delete specify monster from the table in the database
     *
     * @param theMonsterName captures the monster's name which will be deleted from the table
     */
    public void deleteSpecificMonsterFromDatabase(final String theMonsterName){

        query = "DELETE FROM Monster WHERE MONSTER_NAME  = '" + theMonsterName +  "'";


        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query );

            System.out.println( "Successfully deleted " + theMonsterName + " from the Monster database");

        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }


    /**
     * delete all monster data from the table in the database
     *
     *
     */
    public void deletingTheTable(){
        query = "DROP TABLE IF EXISTS Monster";


        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query );

            System.out.println( "Successfully deleted table for Monster");

        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }


    /**
     *  Create and insert various monsters with different names and stats and insert them to SQLite table
     *
     */
    public void insertMonstersToTable(){
        String query1 = "INSERT INTO Monster( MONSTER_NAME, MONSTER_HITPOINTS, " +
                "MONSTER_MIN_DAMAGE, MONSTER_MAX_DAMAGE, MONSTER_ATTACK_SPEED, MONSTER_ACCURACY, " +
                "MONSTER_MIN_HEALPOINTS, MONSTER_MAX_HEALPOINTS, MONSTER_CHANCE_TO_HEAL) VALUES ( 'Ogre', 200, 30, 60, 2, 60.0, 30, 60, 10.0 )";
        String query2 = "INSERT INTO Monster ( MONSTER_NAME, MONSTER_HITPOINTS, " +
                " MONSTER_MIN_DAMAGE, MONSTER_MAX_DAMAGE, MONSTER_ATTACK_SPEED, MONSTER_ACCURACY, " +
                " MONSTER_MIN_HEALPOINTS, MONSTER_MAX_HEALPOINTS, MONSTER_CHANCE_TO_HEAL ) VALUES ( 'Gremlin', 70, 15, 30, 5, 80.0, 20, 40, 40.0)";
        String query3 = "INSERT INTO Monster ( MONSTER_NAME, MONSTER_HITPOINTS, " +
                " MONSTER_MIN_DAMAGE, MONSTER_MAX_DAMAGE, MONSTER_ATTACK_SPEED, MONSTER_ACCURACY, " +
                " MONSTER_MIN_HEALPOINTS, MONSTER_MAX_HEALPOINTS, MONSTER_CHANCE_TO_HEAL ) VALUES ( 'Skeleton', 100, 30, 50, 3, 80.0, 30, 50, 30.0)";


        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query1 );

            rv = stmt.executeUpdate( query2 );

            rv = stmt.executeUpdate( query3 );

        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }



    /**
     * Read the database and return a string containing monster's name, health points, damage range,
     * attack speed, accuracy, heal range and heal chance
     *
     * @return a string containing monster's name, health points, damage range, attack speed, accuracy, heal range and heal chance
     */
    public String readAllMonsters(){

        // query the database table for all its contents
        query = "SELECT * FROM Monster";
        String allDataInTable = "";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {

            ResultSet rs = stmt.executeQuery(query);

            //walk through each 'row' of results, grab data by column/field name
            while ( rs.next() ) {
                String monsterName = rs.getString( "MONSTER_NAME" );
                int monsterHitPoints = rs.getInt( "MONSTER_HITPOINTS" );
                int monsterMinDamage = rs.getInt("MONSTER_MIN_DAMAGE");
                int monsterMaxDamage = rs.getInt("MONSTER_MAX_DAMAGE");
                int monsterAttackSpeed = rs.getInt( "MONSTER_ATTACK_SPEED" );
                double monsterAccuracy = rs.getDouble("MONSTER_ACCURACY");
                int monsterMinHealValue = rs.getInt("MONSTER_MIN_HEALPOINTS");
                int monsterMaxHealValue = rs.getInt("MONSTER_MAX_HEALPOINTS");
                double monsterHealChance = rs.getDouble("MONSTER_CHANCE_TO_HEAL");


                allDataInTable += "Name: " + monsterName + ", Health: "
                        + monsterHitPoints + ", Damage range: " + monsterMinDamage
                        + "-" + monsterMaxDamage + ", Attack speed: " + monsterAttackSpeed
                        + ", Accuracy: " + monsterAccuracy + ", Heal range: " + monsterMinHealValue
                        + "-" + monsterMaxHealValue + ", Heal chance: " + monsterHealChance + "\n";
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }

        return allDataInTable;
    }



    /**
     * retrieve monster data using their specify name from the database then
     * initialize a Monster object by using those retrieve data and return it.
     *
     * @return a Monster object
     */
    public Monster getMonsterFromDatabase(final String theMonsterName){

        Monster monster = null;

        query = "SELECT MONSTER_NAME, MONSTER_HITPOINTS, MONSTER_MIN_DAMAGE, MONSTER_MAX_DAMAGE," +
                "MONSTER_ATTACK_SPEED, MONSTER_ACCURACY, MONSTER_MIN_HEALPOINTS, MONSTER_MAX_HEALPOINTS," +
                "MONSTER_CHANCE_TO_HEAL FROM Monster WHERE MONSTER_NAME = '" + theMonsterName + "'";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {

            ResultSet rs = stmt.executeQuery(query);

            String monsterName = rs.getString( "MONSTER_NAME" );
            int monsterHitPoints = rs.getInt( "MONSTER_HITPOINTS" );
            int monsterMinDamage = rs.getInt("MONSTER_MIN_DAMAGE");
            int monsterMaxDamage = rs.getInt("MONSTER_MAX_DAMAGE");
            int monsterAttackSpeed = rs.getInt( "MONSTER_ATTACK_SPEED" );
            double monsterAccuracy = rs.getDouble("MONSTER_ACCURACY");
            int monsterMinHealValue = rs.getInt("MONSTER_MIN_HEALPOINTS");
            int monsterMaxHealValue = rs.getInt("MONSTER_MAX_HEALPOINTS");
            double monsterHealChance = rs.getDouble("MONSTER_CHANCE_TO_HEAL");


            monster = new Monster(monsterName, monsterHitPoints, monsterMinDamage, monsterMaxDamage,
                    monsterAttackSpeed, monsterAccuracy, monsterMinHealValue, monsterMaxHealValue,
                    monsterHealChance);


        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }

        return monster;

    }



    // test on main to see if we can retrieve monster data stores in SQLite database and use it to generate monster
    public static void main(String[] args) {
        MonsterSQLiteDatabase db = MonsterSQLiteDatabase.getInstance();
        System.out.println(db.readAllMonsters());
        Monster Ogre = db.getMonsterFromDatabase("Ogre");
        System.out.println(Ogre.toString());
    }


}