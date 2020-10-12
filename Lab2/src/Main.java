import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static FileReader fr;

    static {
        try {
            fr = new FileReader("src/words.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Scanner sc_file = new Scanner(fr);
    public static HashTable table = new HashTable(100);
   public static  Scanner sc_in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        while (sc_file.hasNextLine()) {
            table.add(new Node(sc_file.nextLine()));
        }

        fr.close();
        menu();
    }

    public static void menu() {
        System.out.println("\n1. Show words\n2. Find word\n3. Exit\n");
        String controller;
        while (true) {
            String regex = "\\d";
            controller = sc_in.nextLine().trim();
            if (!Pattern.matches(regex, controller) || Integer.parseInt(controller) > 6 || Integer.parseInt(controller) <= 0)
                continue;
            break;
        }
        switch (controller) {
            case "1":
                table.print();
                break;
            case "2":
                System.out.print("Enter searching word: ");
                String searching = sc_in.nextLine();
                if (table.find(searching)==null){
                    System.out.println("No such word.\n");
                    break;
                }
                System.out.println(table.find(searching).getNum()%table.getSize() + " : "+table.find(searching).getWord());
                break;

            case "3":
                System.exit(0);
        }
        menu();
    }
}
