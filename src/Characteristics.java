public abstract class Characteristics implements Actions {
    private String name;
    private int health;
    private int gold;
    private int dexterity;
    private int xp;
    private int strength;
    private int mana;

    public Characteristics(String name, int health, int gold, int dexterity, int xp, int strength, int mana) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.dexterity = dexterity;
        this.xp = xp;
        this.strength = strength;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

}

