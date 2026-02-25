import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Clothing {

    // Variables and objects
    private String clothingType;
    private String size;
    private String brand;

    public Clothing(String clothingType, String size, String brand) {
        this.clothingType = clothingType;
        this.size = size;
        this.brand = brand;

    }




    // Getters and setters
    public String getClothingType() {
        return clothingType;
    }

    public void setClothingType(String clothingType) {
        this.clothingType = clothingType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toDataLine() {
        return encode(clothingType) + "|" + encode(size) + "|" + encode(brand);
    }

    public static Clothing fromDataLine(String line) {
        String[] parts = line.split("\\|", -1);
        String type = decode(parts.length > 0 ? parts[0] : "");
        String size = decode(parts.length > 1 ? parts[1] : "");
        String brand = decode(parts.length > 2 ? parts[2] : "");
        return new Clothing(type, size, brand);
    }

    private static String encode(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

    private static String decode(String s) {
        try {
            byte[] bytes = Base64.getDecoder().decode(s);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            return s;
        }
    }

    @Override
    public String toString() {
        return "Clothing [clothingType=" + clothingType + ", size=" + size + ", brand=" + brand + "]";
    }
}
