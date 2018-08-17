package cz.chalupa.examples.piglatin;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PigLatinApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PigLatinApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("+--------------------+");
        System.out.println("| PigLatin Converter |");
        System.out.println("+--------------------+");
        System.out.println();
        System.out.println("Insert words to convert (type 'exit' to quit):");

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            if ("exit".equals(input)) {
                System.exit(0);
            }
            System.out.println("= " + convert(input) + "\n");
        }
    }

    private String convert(String input) {
        return input; // TODO: processing flow
    }
}
