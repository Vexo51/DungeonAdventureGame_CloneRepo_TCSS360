
package tests;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DungeonAdventureAllPlayableCharactersTest {



    @Test
    void isNameSetForPriestess(){

        Priestess priest = new Priestess("Maya");
        String name = "Maya";

        Assertions.assertEquals(name, priest.getCharacterName(), "setting name for priest didn't work");
    }

    @Test
    void isNameSetForWarrior(){

        Warrior warrior = new Warrior("Brad");
        String name = "Brad";

        Assertions.assertEquals(name, warrior.getCharacterName(), "setting name for warrior didn't work");
    }

    @Test
    void isNameSetForThief(){

        Thief thief = new Thief("Ray");
        String name = "Ray";

        Assertions.assertEquals(name, thief.getCharacterName(), "setting name for thief didn't work");
    }

    @Test // expect: HP for Warrior to be set within 100 to 125
    void isHPSetWithinRangeForWarrior(){
        Warrior warrior = new Warrior("Brad");


        boolean isWithinRange = true;
        int Hitpoints = warrior.getHitPoints();
        if (Hitpoints < 100 || Hitpoints > 125){
            isWithinRange = false;
        }

        Assertions.assertTrue(isWithinRange, "HP wasn't set within the 100 - 125 range for Warrior");
    }

    @Test // expect: HP for Thief to be set within 50 to 75
    void isHPSetWithinRangeForThief(){
        Thief thief = new Thief("Ray");


        boolean isWithinRange = true;
        int Hitpoints = thief.getHitPoints();
        if (Hitpoints < 50 || Hitpoints > 75){
            isWithinRange = false;
        }

        Assertions.assertTrue(isWithinRange, "HP wasn't set within the 50 - 75 range for Thief");
    }

    @Test // expect: HP for Priestess to be set within 50 to 75
    void isHPSetWithinRangeForPriestess(){
        Priestess priest = new Priestess("maya");


        boolean isWithinRange = true;
        int Hitpoints = priest.getHitPoints();
        if (Hitpoints < 50 || Hitpoints > 75){
            isWithinRange = false;
        }

        Assertions.assertTrue(isWithinRange, "HP wasn't set within the 50 - 75 range for Priestess");
    }


    @Test
    void didHPGetSubtractedFromWarrior(){
        Warrior warrior = new Warrior("Brad");

        boolean didWarriorHPDecreased = false;
        int characterHPBeforeSubtract = warrior.getHitPoints();

        // keep looping until hit points is decreased once
        while (warrior.getHitPoints() == characterHPBeforeSubtract){
            warrior.subtractHitPoints(30);
        }

        if (characterHPBeforeSubtract != warrior.getHitPoints()){
            didWarriorHPDecreased = true;
        }

        Assertions.assertTrue(didWarriorHPDecreased, "Warrior's health didn't get subtracted");
    }


    @Test
    void creatingMonsterUsingDataStoresInSQLite(){
        MonsterSQLiteDatabase db = MonsterSQLiteDatabase.getInstance();

        Monster monsterOne = new Monster("Ogre", 200, 30, 60,
                2, 60.0, 30, 60, 10.0);

        Monster monsterTwo = db.getMonsterFromDatabase("Ogre");

        Assertions.assertEquals(monsterOne.toString(), monsterTwo.toString(), "The stats of both monsters aren't equal");
    }


    @Test
    void didDamagesAppliedWhenWarriorAttacksMonsterCharacter(){


        Warrior warrior= new Warrior("Brad");
        Monster skeleton = MonsterFactory.createMonster("Skeleton");

        boolean hasDamageApplied = false;

        // keep looping until attack hit once in case if previous attack missed
        do {
            warrior.attack(skeleton);
            System.out.println(warrior.getAttackResult());
        } while (skeleton.getHitPoints() == 100);

        if(skeleton.getHitPoints() != 100){
            hasDamageApplied = true;
        }
        Assertions.assertTrue(hasDamageApplied, "Damage did applied when a Hero Character attacked a Monster Character");
    }


    @Test
    void doesAttackStoppedWhenCharacterHealthReachesZeroOrLess(){

        Warrior warrior = new Warrior("Brad");
        Monster skeleton = MonsterFactory.createMonster("Skeleton");

        boolean hasAttackStopped = false;

        while (skeleton.isAlive()){
            warrior.attack(skeleton);
            System.out.print(warrior.getHeroAttackResult());
        }

        if(!skeleton.isAlive()){
            hasAttackStopped = true;
        }

        Assertions.assertTrue(hasAttackStopped, "The attack didn't stop even when the attacked character reached 0 or less");

    }

    @Test
    void didDamagesAppliedWhenWarriorUsesCrushingBlow(){


        Warrior warrior = new Warrior("Brad");
        Monster skeleton = MonsterFactory.createMonster("Skeleton");

        boolean hasDamageApplied = false;
        System.out.println(skeleton.getHitPoints());


        // keep looping until special skill activate once in case if previous special skill failed
        do {
            warrior.useCrushingBlow(skeleton);
            System.out.println(warrior.getCrushingBlowAttackResult());
        } while (skeleton.getHitPoints() == 100);

        if(skeleton.getHitPoints() != 100){
            hasDamageApplied = true;
        }

        Assertions.assertTrue(hasDamageApplied, "Damage didn't applied when Warrior use his Crushing Blow on another Hero Character");

    }


    @Test
    void priestessSpecialSkillForHealing() {
        Priestess priest = new Priestess("Maya");
        boolean didHealingApplied = false;

        int originalHealthBeforeHealing = priest.getHitPoints();
        priest.heal();
        System.out.println(priest.getHealingResult());
        int healthAfterHealing = priest.getHitPoints();

        if (originalHealthBeforeHealing != healthAfterHealing){
            didHealingApplied = true;
        }

        Assertions.assertTrue(didHealingApplied, "Healing wasn't apply to Priestess character");

    }


    @Test
    void doesSurpriseAttackWorkCorrectlyForThief(){


        Thief thief = new Thief("Ray");
        Monster skeleton = MonsterFactory.createMonster("Skeleton");

        boolean hasDamageApplied = false;
        System.out.println(skeleton.getHitPoints());


        // keep looping until special skill activate once in case if previous special skill failed
        do {
            thief.useSurpriseAttack(skeleton);
            System.out.println(thief.getSurpriseAttackResult());
        } while (skeleton.getHitPoints() == 100);

        if(skeleton.getHitPoints() != 100){
            hasDamageApplied = true;
        }

        Assertions.assertTrue(hasDamageApplied, "Damage didn't applied when a Thief surprise attack another Hero Character");

    }


    @Test
    void doMonsterHealCorrectlyAfterLosingHealthPoints(){


        Warrior warrior = new Warrior("Brad");
        Monster skeleton = MonsterFactory.createMonster("Skeleton");

        boolean hasHealingAppliedAfterDamage = false;

        // make sure Hero successfully attack once
        do {
            warrior.attack(skeleton);
            System.out.println(warrior.getAttackResult());
        } while (skeleton.getHitPoints() == 100);

        int skeletonHealthBeforeHealing = skeleton.getHitPoints();

        // make sure Skeleton successfully heal once
        do{
            skeleton.heal();
            System.out.println(skeleton.getHealResult());
        } while (skeleton.getHitPoints() == skeletonHealthBeforeHealing);

        if(skeleton.getHitPoints() != skeletonHealthBeforeHealing){
            hasHealingAppliedAfterDamage = true;
        }

        Assertions.assertTrue(hasHealingAppliedAfterDamage, "Healing didn't work when a Monster character tried to heal");
    }





}
