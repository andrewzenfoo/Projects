package it.unibs.pacj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BufferedReader br;

        try {

            if (args.length > 0) {
                br = new BufferedReader(new FileReader(args[0]));
            }
            else {
                br = new BufferedReader(new FileReader("src/Hello World"));
            }
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
