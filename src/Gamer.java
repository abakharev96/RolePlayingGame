public class Gamer extends Characteristics implements Actions {

    public Gamer(String name, int health, int gold, int dexterity, int xp, int strength, int mana) {
        super(name, health, gold, dexterity, xp, strength, mana);
    }

    int health = getHealth();
    int initHealth = health;
    int gold = getGold();
    int dexterity = getDexterity();
    int initDexterity = dexterity;
    int xp = getXp();
    int strength = getStrength();
    int initStrength = strength;

    @Override
    public void attack(Characteristics monster) {
        Client.writeMsg(Client.getName() + " is attacking...");
        if (getDexterity() * 3 < Fighting.getRandInt(1, 100)){
            strength = 0;
        }
        if (monster.getHealth() > 0) {
            monster.setHealth(monster.getHealth() - strength);
            if (monster.getHealth() <= 0) {
                monster.setHealth(0);
            }
            Client.writeMsg("The gamer " + Client.getName() + " hit for " + strength + " points. \n" +
                    "The " + monster.getName() +"'s health is " + monster.getHealth());
        } else {
            return;
        }
        if (monster.getHealth() <= 0) {
            Client.writeMsg("Congratulations! Monster " + monster.getName() + " Died! \n" +
                    "You get " + Integer.valueOf(xp + monster.getXp()) + " of experience points and \n" +
                    "You get " + Integer.valueOf(gold + monster.getGold()) + " points of gold!");
            setXp(getXp() + monster.getXp());
            setGold(getGold() + monster.getGold());
        }

    }

    @Override
    public void defence(Characteristics monster) {
        if (getHealth() <= 0){
            Client.writeMsg("There was a great tragedy. \n" +
                    Client.getName() + " die!");
            setGold(0);
            setXp(0);
            Client.writeMsg("I hope you will try one more time later. \n" +
                    "Goodbye.");
            String input = (String) Client.receiveInput();
            System.exit(0);
            return;
        }
        int monsterStrength = monster.getStrength();
        int monsterDexterity = monster.getDexterity();
        if (monsterDexterity * 3 < Fighting.getRandInt(1, 100)) {
            monsterStrength = 0;
        }
        if (getHealth() > 0) {
            Client.writeMsg(monster.getName() + " is attacking...");
            setHealth(getHealth() - monsterStrength);
            if (getHealth() <= 0) {
                setHealth(0);
                return;
            }
            Client.writeMsg("The power of monster " + monster.getName() + " attack was " + monsterStrength + "! \n" +
                    "and now you have " + getHealth() + " points of health.");
        }
        health = getHealth();
        if (health <= 0){
            /*Client.writeMsg("There was a great tragedy. \n" +
                     Client.getName() + " die!");
            setGold(0);
            setXp(0);
            Client.writeMsg("I hope you will try one more time later. \n" +
                    "Goodbye.");
            String input = (String) Client.receiveInput();
            System.exit(0);*/
            return;
        }
        //setHealth(health);
    }

    /*public void improveHealth(int growth) {
        setHealth(health + growth);
    }
    public void improveDexterity(int growth) {
        setDexterity(initDexterity + growth);
    }
    public void improveStrength(int growth) {
        setStrength(initStrength + growth);
    }*/


}
