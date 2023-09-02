package server;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] db = new String[100];

        for(int i=0; i<=db.length-1; i++){
            db[i] = "";
        }

        Scanner scanner = new Scanner(System.in);
        String command;

        while(true){
            System.out.println("Enter command: ");
            command = scanner.nextLine();

            if(command.startsWith("set")){
                String[] parts = command.split(" ");

                    int index = Integer.parseInt(parts[1]) - 1;
                    if(index < 0 || index > 100){
                        System.out.println("ERROR");
                    }else{
                        StringBuilder textBuilder = new StringBuilder();
                        for (int i = 2; i < parts.length; i++) {
                            textBuilder.append(parts[i]);
                            if (i < parts.length - 1) {
                                textBuilder.append(" ");
                            }
                        }
                        db[index] = textBuilder.toString();
                        System.out.println("OK");

                    }
            }else if(command.startsWith("get")){
                String[] parts = command.split(" ");{
                    int index = Integer.parseInt(parts[1]) - 1;
                    if (index < 0 || index > 100 || db[index].isEmpty()) {
                        System.out.println("ERROR");
                    } else {
                        System.out.println(db[index]);
                    }
                }
            }else if (command.startsWith("delete")) {
                String[] parts = command.split(" ");
                    int index = Integer.parseInt(parts[1]) - 1;
                    if (index < 0 || index >= 100) {
                        System.out.println("ERROR");
                    } else {
                        db[index] = "";
                        System.out.println("OK");
                    }
            } else if (command.equals("exit")) {
                break;
            }
        }

        System.out.println("Exiting the program.");
    }
}
