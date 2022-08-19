public class Merchant {
    int weaponCost = 50;
    int healerCost = 20;
    public void tradeGoods() {
        Client.writeMsg("Hi, dear " + Client.getName() + "!\n" +
                "I have two points for you: \n" +
                "1. You can by doctor's staff to improve your health by 100 points for " + healerCost + " points of gold, \n" +
                "2. You can improve your weapon by 10% for " + weaponCost + " points of gold, \n" +
                "to choose between of these points, please, press 1 or 2.");

    }

}
