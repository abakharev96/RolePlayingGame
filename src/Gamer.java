public class Gamer extends Characteristics {

    public Gamer(String name, int health, int gold, int dexterity, int xp, int strength, int mana) {
        super(name, health, gold, dexterity, xp, strength, mana);
    }

    @Override
    public void fight() {
        Client.writeMsg("Fight");
    }
}
