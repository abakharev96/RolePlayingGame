public class Merchant {
    String gamerInput = "";
    int weaponCost = 50;
    int healerCost = 20;
    int manaCost = 10;

    public void tradeGoods(Gamer gamer) {
        Client.writeMsg("Hi, dear " + Client.getName() + "!\n" +
                "I have two points for you: \n" +
                "1. You can buy doctor's staff to improve your health by 100 points for " + healerCost + " points of gold, \n" +
                "2. You can buy 100 points of magic mana for "+ manaCost + " points of gold \n" +
                "it improve your dexterity by 2 points. \n" +
                "3. You can improve your weapon by 2 points " + weaponCost + " points of gold, \n" +
                "to choose between of these points, please, press 1, 2 or 3. You can press by Enter all items that you want. \n" +
                "To return in World, please, press 4.");

        while (!gamerInput.equals("4")) {
            String gamerInput = (String) Client.receiveInput();
            switch (gamerInput) {
                case "1": {
                    if (gamer.getGold() - healerCost < 0) {
                        Client.writeMsg(Client.getName() + " does not have enough money.");
                        return;
                    }
                    int currentHealth = gamer.getHealth();
                    gamer.setHealth(currentHealth + 100);
                    gamer.setGold(gamer.getGold() - healerCost);
                    Client.writeMsg("Health was improved. Now you have " + gamer.getHealth() + " points of health.");

                }break;
                case "2": {
                    if (gamer.getGold() - manaCost < 0) {
                        Client.writeMsg(Client.getName() + " does not have enough money.");
                        return;
                    }
                    //gamer.improveDexterity(2);
                    gamer.setDexterity(gamer.getDexterity() + 2);
                    gamer.setGold(gamer.getGold() - manaCost);
                    Client.writeMsg("Dexterity was improved. Now you have " + gamer.getDexterity() + " points of dexterity.");
                }break;
                case "3": {
                    if (gamer.getGold() - weaponCost < 0) {
                        Client.writeMsg(Client.getName() + " does not have enough money.");
                        return;
                    }
                    gamer.setStrength(gamer.getStrength() + 2);
                    //gamer.improveStrength(2);
                    gamer.setGold(gamer.getGold() - weaponCost);
                    Client.writeMsg("Strength was improved. Now you have " + gamer.getStrength() + " points of strength.");
                }break;
                case "4": return;
                default: {
                    Client.writeMsg("Input is incorrect. You can choose between 1, 2 or 3. Please, try again");
                }
            }
        }

    }

}
