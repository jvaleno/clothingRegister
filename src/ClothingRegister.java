import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Test line to keep
public class ClothingRegister {

    private static final Path STORAGE = Paths.get("wardrobe.txt");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Clothing> wardrobe = loadFromFile(STORAGE);

        System.out.println("Welcome to your clothing register!");
        System.out.println("Loaded " + wardrobe.size() + " items from " + STORAGE.toString());
        System.out.println();

        while (true) {
            System.out.print("Enter clothing type (or 'q' to quit): ");
            String type = in.nextLine().trim();
            if (type.equalsIgnoreCase("q")) {
                break;
            }
            if (type.isEmpty()) {
                System.out.println("Clothing type cannot be empty. Please try again.");
                continue;
            }

            System.out.print("Enter clothing size: ");
            String size = in.nextLine().trim();

            System.out.print("Enter clothing brand: ");
            String brand = in.nextLine().trim();

            wardrobe.add(addClothing(type, size, brand));
            System.out.println();

        }

        System.out.println();
        ListClothes(wardrobe);
        saveToFile(wardrobe, STORAGE);
        System.out.println("Saved " + wardrobe.size() + " items to " + STORAGE.toString());
        in.close();


    }

    public static Clothing addClothing(String type, String size, String brand) {
        Clothing clothing = new Clothing(type, size, brand);
        System.out.println("Adding clothing: " + type);
        return clothing;
    }

    public static void ListClothes(List<Clothing> clothes) {
        System.out.println("Number of clothes in closet: " + clothes.toArray().length);
        System.out.println();

        for (Clothing clothesItem : clothes) {
            System.out.println("Clothing number: " + (clothes.indexOf(clothesItem) + 1));
            System.out.println("Clothing type: " + clothesItem.getClothingType());
            System.out.println("Clothing size: " + clothesItem.getSize());
            System.out.println("Clothing brand: " + clothesItem.getBrand());
            System.out.println();

        }

    }

    private static List<Clothing> loadFromFile(Path file) {
        List<Clothing> list = new ArrayList<>();
        if (!Files.exists(file)) {
            return list;
        }
        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line == null || line.trim().isEmpty()) continue;
                ;
                try {
                    list.add(Clothing.fromDataLine(line));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return list;
    }

    private static void saveToFile(List<Clothing> wardrobe, Path file) {
        try {
            Files.createDirectories(file.toAbsolutePath().getParent() == null ? file.getParent() : file.toAbsolutePath().getParent());
            List<String> lines = new ArrayList<>(wardrobe.size());
            for (Clothing c : wardrobe) {
                lines.add(c.toDataLine());
            }
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}


