import java.util.ArrayList;

public class Fighting {
    int monstersCount = getRandInt(1, 3);
    ArrayList<Goblin> goblins = new ArrayList<>();
    ArrayList<Skeleton> skeletons = new ArrayList<>();
    ArrayList<Orc> orcs = new ArrayList<>();
    ArrayList<Monsters> monsters = new ArrayList<>();

    int i = 0;

    public void startFighting(Gamer gamer) {
        Thread fight = new Thread();
        fight.start();
        try {
            while (i < monstersCount) {
                double probability = getRandDbl();
                if (probability >= 0.67) {
                    goblins.add(new Goblin("Hideous goblin " + Integer.valueOf(i + 1), 30, 15, 20, 20, 15, 0));
                    Client.writeMsg("Oh no! Hideous goblin " + Integer.valueOf(i + 1) + " runs out of the dark forest and gets into fight!");
                    Thread.sleep(700);
                } else if (probability <= 0.33) {
                    skeletons.add(new Skeleton("Awful skeleton " + Integer.valueOf(i + 1), 27, 13, 15, 15, 10, 0));
                    Client.writeMsg("Oh no! Awful skeleton " + Integer.valueOf(i + 1) + " runs out of the dark forest and gets into fight!");
                    Thread.sleep(700);
                } else {
                    orcs.add(new Orc("Scary orc " + Integer.valueOf(i + 1), 40, 40, 25, 50, 30, 0));
                    Client.writeMsg("Oh no! Scary orc " + Integer.valueOf(i + 1) + " runs out of the dark forest and gets into fight!");
                    Thread.sleep(700);
                }
                i++;
            }

            for (int i = 0; i < goblins.size(); i++) {
                monsters.add(goblins.get(i));
            }
            for (int i = 0; i < skeletons.size(); i++) {
                monsters.add(skeletons.get(i));
            }
            for (int i = 0; i < orcs.size(); i++) {
                monsters.add(orcs.get(i));
            }

            if (gamer.getHealth() <= 0) {
                Client.writeMsg("The Gamer is dead");
            }

            int fightsCount = 1;
            for (Monsters monster : monsters) {
                Client.writeMsg(fightsCount + " fight is starting...");
                fight(gamer, monster);
                fightsCount++;
            }
            Client.writeMsg("This fighting was so difficult... \n" +
                    "now you have: \n" +
                    "Health: " + gamer.getHealth() + "; \n" +
                    "Gold: " + gamer.getGold() + "; \n" +
                    "XP: " + gamer.getXp() + ".");
            goblins.clear();
            skeletons.clear();
            orcs.clear();
            monsters.clear();
            Client.writeMsg("Returning to world in \n" +
                    "3...");
            Thread.sleep(1000);
            Client.writeMsg("2...");
            Thread.sleep(1000);
            Client.writeMsg("1...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fight(Gamer gamer, Characteristics monster) throws InterruptedException {
        while (gamer.getHealth() > 0 || monster.getHealth() > 0) {
            if (gamer.getHealth() <=0) return;
            gamer.attack(monster);
            Thread.sleep(700);
            if (monster.getHealth() <= 0) return;
            gamer.defence(monster);
            Thread.sleep(700);
            if (gamer.getHealth() <= 0) {
                Client.writeMsg("There was a great tragedy. \n" +
                        Client.getName() + " die!");
                gamer.setGold(0);
                gamer.setGold(0);
                Client.writeMsg("I hope you will try one more time later. \n" +
                        "Goodbye.");
                String input = (String) Client.receiveInput();
                System.exit(0);
                return;
            }
        }
    }

    public static double getRandDbl(){
        double randNumDbl = Math.random();
        return randNumDbl;
    }
    public static int getRandInt(int min, int max){
        int randNumInt = (int)(Math.random() * ((max - min) + 1)) + min;
        return randNumInt;
    }
}