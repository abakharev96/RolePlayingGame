import java.util.ArrayList;

public class Fighting implements Runnable {
    boolean isGamerAttack = false;
    int monstersCount = getRandInt(1, 5);
    int goblinCount = getRandInt(1, 4);
    int skeletonCount = monstersCount - goblinCount;


    static ArrayList<Goblin> goblins;
    static ArrayList<Skeleton> skeletons;

    

    public void createGoblin(){
        Goblin goblin = new Goblin("Hideous goblin", 20, 30, 20, 50, 5, 0);
    }
    public void createSkeleton(){
        Skeleton skeleton = new Skeleton("Awful skeleton", 10, 20, 15, 4, 4, 0);
    }

    public static double getRandDbl(){
        double randNumDbl = Math.random();
        return randNumDbl;
    }
    public static int getRandInt(int min, int max){
        int randNumInt = (int)(Math.random() * ((max - min) + 1)) + min;
        return randNumInt;
    }



    @Override
    public void run(){

    }


}