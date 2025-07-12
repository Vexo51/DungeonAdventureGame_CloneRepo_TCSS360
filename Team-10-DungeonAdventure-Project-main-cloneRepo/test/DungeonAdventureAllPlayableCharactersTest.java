import model.Hero;
import model.Monster;
import model.MonsterSQLiteDatabase;
import model.Priestess;
import model.Thief;
import model.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DungeonAdventureAllPlayableCharactersTest {


    @Test
    void isNameSetForPrietess(){

        Hero priest = new Priestess("Maya");
        String name = "Maya";

        Assertions.assertEquals(name, priest.getCharacterName(), "setting name for priest didn't work");

    }

    @Test
    void isNameSetForWarrior(){

        Hero warrior = new Warrior("Brad");
        String name = "Brad";

        Assertions.assertEquals(name, warrior.getCharacterName(), "setting name for warrior didn't work");
    }

    @Test
    void isNameSetForThief(){

        Hero thief = new Thief("Ray");
        String name = "Ray";

        Assertions.assertEquals(name, thief.getCharacterName(), "setting name for thief didn't work");
    }

    @Test // expect: HP for Warrior to be set within 100 to 125
    void isHPSetWithinRangeForWarrior(){
        Hero warrior = new Warrior("Brad");


        boolean isWithinRange = true;
        int Hitpoints = warrior.getHeroHitPoints();
        if (Hitpoints < 100 || Hitpoints > 125){
            isWithinRange = false;
        }

        Assertions.assertTrue(isWithinRange, "HP wasn't set within the 100 - 125 range for Warrior");
    }

    @Test // expect: HP for Thief to be set within 50 to 75
    void isHPSetWithinRangeForThief(){
        Hero thief = new Thief("Ray");


        boolean isWithinRange = true;
        int Hitpoints = thief.getHeroHitPoints();
        if (Hitpoints < 50 || Hitpoints > 75){
            isWithinRange = false;
        }

        Assertions.assertTrue(isWithinRange, "HP wasn't set within the 50 - 75 range for Thief");
    }

    @Test // expect: HP for Priestess to be set within 50 to 75
    void isHPSetWithinRangeForPriestess(){
        Hero priest = new Priestess("maya");


        boolean isWithinRange = true;
        int Hitpoints = priest.getHeroHitPoints();
        if (Hitpoints < 50 || Hitpoints > 75){
            isWithinRange = false;
        }

        Assertions.assertTrue(isWithinRange, "HP wasn't set within the 50 - 75 range for Priestess");
    }


    @Test
    void didHPGetSubtractedFromWarrior(){
        Hero warrior = new Warrior("Brad");

        boolean didWarriorHPDecreased = false;
        int characterHPBeforeSubtract = warrior.getHeroHitPoints();

        // keep looping until hit points is decreased once
        while (warrior.getHeroHitPoints() == characterHPBeforeSubtract){
            warrior.decreaseHeroHitPoints(30);
        }

        if (characterHPBeforeSubtract != warrior.getHeroHitPoints()){
            didWarriorHPDecreased = true;
        }

        Assertions.assertTrue(didWarriorHPDecreased, "Warrior's health didn't get subtracted");
    }


    @Test
    void creatingMonsterUsingDataStoresInSQLite(){
        MonsterSQLiteDatabase db = new MonsterSQLiteDatabase();

        Monster monsterOne = new Monster("Ogre", 200, 30, 60,
                2, 60.0, 30, 60, 10.0);

        Monster monsterTwo = db.readSpecificMonsterAndGenerateIt("Ogre");

        Assertions.assertEquals(monsterOne.toString(), monsterTwo.toString(), "The stats of both monsters aren't equal");
    }


    @Test
    void didDamagesAppliedWhenWarriorAttacksMonsterCharacter(){
        MonsterSQLiteDatabase db = new MonsterSQLiteDatabase();

        Hero warrior= new Warrior("Brad");
        Monster skeleton = db.readSpecificMonsterAndGenerateIt("Skeleton");

        boolean hasDamageApplied = false;

        // keep looping until attack hit once in case if previous attack missed
        do {
            warrior.Attack(skeleton);
        } while (skeleton.getHitPoints() == 100);

        if(skeleton.getHitPoints() != 100){
            hasDamageApplied = true;
        }
        Assertions.assertTrue(hasDamageApplied, "Damage did applied when a Hero Character attacked a Monster Character");
    }


    @Test
    void doesAttackStoppedWhenCharacterHealthReachesZeroOrLess(){
        MonsterSQLiteDatabase db = new MonsterSQLiteDatabase();

        Hero warrior = new Warrior("Brad");
        Monster skeleton = db.readSpecificMonsterAndGenerateIt("Skeleton");

        boolean hasAttackStopped = false;

        while (skeleton.isAlive()){
            warrior.Attack(skeleton);
        }

        if(!skeleton.isAlive()){
            hasAttackStopped = true;
        }

        Assertions.assertTrue(hasAttackStopped, "The attack didn't stop even when the attacked character reached 0 or less");

    }

    @Test
    void didDamagesAppliedWhenWarriorUsesCrushingBlow(){
        MonsterSQLiteDatabase db = new MonsterSQLiteDatabase();

        Hero warrior = new Warrior("Brad");
        Monster skeleton = db.readSpecificMonsterAndGenerateIt("Skeleton");

        boolean hasDamageApplied = false;
        System.out.println(skeleton.getHitPoints());


        // keep looping until special skill activate once in case if previous special skill failed
        do {
            warrior.useSpecialSkill(skeleton);
        } while (skeleton.getHitPoints() == 100);

        if(skeleton.getHitPoints() != 100){
            hasDamageApplied = true;
        }

        Assertions.assertTrue(hasDamageApplied, "Damage didn't applied when Warrior use his Crushing Blow on another Hero Character");

    }


    @Test
    void priestessSpecialSkillForHealing() {
        Hero priest = new Priestess("Maya");
        boolean didHealingApplied = false;

        int originalHealthBeforeHealing = priest.getHeroHitPoints();
        priest.useSpecialSkill(priest);
        int healthAfterHealing = priest.getHeroHitPoints();

        if (originalHealthBeforeHealing != healthAfterHealing){
            didHealingApplied = true;
        }

        Assertions.assertTrue(didHealingApplied, "Healing wasn't apply to Priestess character");

    }


    @Test
    void doesSurpriseAttackWorkCorrectlyForThief(){
        MonsterSQLiteDatabase db = new MonsterSQLiteDatabase();

        Hero thief = new Thief("Ray");
        Monster skeleton = db.readSpecificMonsterAndGenerateIt("Skeleton");

        boolean hasDamageApplied = false;
        System.out.println(skeleton.getHitPoints());


        // keep looping until special skill activate once in case if previous special skill failed
        do {
            thief.useSpecialSkill(skeleton);
        } while (skeleton.getHitPoints() == 100);

        if(skeleton.getHitPoints() != 100){
            hasDamageApplied = true;
        }

        Assertions.assertTrue(hasDamageApplied, "Damage didn't applied when a Thief surprise attack another Hero Character");

    }


    @Test
    void doMonsterHealCorrectlyAfterLosingHealthPoints(){
        MonsterSQLiteDatabase db = new MonsterSQLiteDatabase();

        Hero warrior = new Warrior("Brad");
        Monster skeleton = db.readSpecificMonsterAndGenerateIt("Skeleton");

        boolean hasHealingAppliedAfterDamage = false;

        // make sure Hero successfully attack once
        do {
            warrior.Attack(skeleton);
        } while (skeleton.getHitPoints() == 100);

        int skeletonHealthBeforeHealing = skeleton.getHitPoints();

        // make sure Skeleton successfully heal once
        do{
            skeleton.heal();
        } while (skeleton.getHitPoints() == skeletonHealthBeforeHealing);

        if(skeleton.getHitPoints() != skeletonHealthBeforeHealing){
            hasHealingAppliedAfterDamage = true;
        }

        Assertions.assertTrue(hasHealingAppliedAfterDamage, "Healing didn't work when a Monster character tried to heal");
    }





}
