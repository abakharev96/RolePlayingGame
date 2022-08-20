import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.constant.Constable;
import java.net.Socket;
import java.util.Scanner;

class Client implements Runnable {
    Socket socket;
    World world;
    static String name;

    public Client(Socket socket, World world, String name){
        this.socket = socket;
        this.world = world;
        this.name = String.valueOf(name);
        new Thread(this).start();
    }

    public static String getName(){
        return name;
    }

    static Scanner in;
    static PrintStream out;

    public void run() {
        try {
            Gamer gamer = new Gamer(Client.getName(), 150, 0, 30, 0, 25, 100);
            // получаем потоки ввода и вывода
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // создаем удобные средства ввода и вывода
            in = new Scanner(is);
            out = new PrintStream(os);

            // читаем из сети и пишем в сеть
            out.println("Welcome to Role Playing Game!");
            out.println("What is your nick name?");
            name = in.nextLine();
            setName(name);
            out.println("Ok, " + name + ", its time to game! If you are ready, press Enter.");
            String input = in.nextLine();
            writeMsg("Your health is " + gamer.getHealth() + "! \n" +
                    "but enemies do not sleep...");


            while (!input.equals("3")) {
                World.writeMsg(input);
                input = in.nextLine();

                switch (input) {
                    case "1": {
                        Merchant merchant = new Merchant();
                        merchant.tradeGoods(gamer);
                    } break;
                    case "2": {
                        Fighting fight = new Fighting();
                        fight.startFighting(gamer);

                    } break;
                    default: {
                        writeMsg("Input is incorrect. You can choose between 1, 2 or 3. Please, try again");
                    }
                }
            }
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    public static Constable receiveInput() {
        String gamerInput;
        gamerInput = in.nextLine();
        return gamerInput;
    }

    public static void writeMsg(String msg){
        out.println(msg);
        out.println("");
    }
}
