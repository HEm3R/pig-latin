package cz.chalupa.examples.piglatin;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import cz.chalupa.examples.piglatin.conversion.ConversionContext;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class PigLatinApplication implements CommandLineRunner {

    @NonNull private ConversionContext conversionContext;

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
        return Pattern.compile("\\s").splitAsStream(input).map(conversionContext::convert).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        SpringApplication.run(PigLatinApplication.class, args);
    }
}
