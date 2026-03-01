# Clothing Register

A simple command-line application to manage and organize your wardrobe. Add, store, and view your clothing items with details like type, size, and brand.

## Features

- 📝 **Add Clothing Items** - Register new clothing with type, size, and brand information
- 💾 **Persistent Storage** - Automatically saves your wardrobe to a file
- 📂 **Load Wardrobe** - Loads previously saved clothing items on startup
- 👕 **View All Items** - Display a complete list of all clothing in your closet
- 🔒 **Data Encoding** - Clothing data is encoded for basic data protection

### Prerequisites

- Java 11 or higher

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd ClothingRegister
```

2. Compile the Java files:
```bash
javac src/Clothing.java src/ClothingRegister.java
```

### Usage

Run the application:
```bash
java -cp src ClothingRegister
```

**Interactive Menu:**
1. Enter the clothing type (e.g., "Pants", "Shirt", "Socks")
2. Enter the size (e.g., "Large", "M", "42")
3. Enter the brand (e.g., "Levi's", "Nike")
4. Repeat steps 1-3 to add more items, or type `q` to quit
5. View your complete wardrobe list
6. Your wardrobe is automatically saved to `wardrobe.txt`

**Example:**
```
Welcome to your clothing register!
Loaded 2 items from wardrobe.txt

Enter clothing type (or 'q' to quit): Shirt
Enter clothing size: Medium
Enter clothing brand: Nike
Adding clothing: Shirt

Enter clothing type (or 'q' to quit): q

Number of clothes in closet: 3
Clothing number: 1
Clothing type: Pants
Clothing size: Large
Clothing brand: Levi's
...
```

## Project Structure

```
ClothingRegister/
├── src/
│   ├── Clothing.java           # Clothing item class
│   └── ClothingRegister.java    # Main application class
├── wardrobe.txt                # Data storage file (auto-generated)
└── README.md
```

## Classes

### Clothing.java
Represents a single clothing item with properties:
- **clothingType**: The type of clothing (e.g., shirt, pants)
- **size**: The size of the clothing item
- **brand**: The brand/manufacturer of the clothing

Methods:
- `getClothingType()`, `setClothingType()` - Get/set clothing type
- `getSize()`, `setSize()` - Get/set size
- `getBrand()`, `setBrand()` - Get/set brand
- `toDataLine()` - Convert item to encoded storage format
- `fromDataLine(String)` - Parse item from encoded storage format

### ClothingRegister.java
Main application class that handles:
- User input via command-line interface
- Loading wardrobe data from file
- Saving wardrobe data to file
- Displaying wardrobe contents

## Data Storage

Wardrobe items are stored in `wardrobe.txt` with Base64-encoded data in the format:
```
encodedType|encodedSize|encodedBrand
```

Each line represents one clothing item.

## Future Enhancements

- Delete or edit clothing items
- Filter wardrobe by type, size, or brand
- Search functionality
- Statistics (total items, items per category, etc.)
- Export to CSV or JSON formats
- GUI interface

## License

This project is open source. Feel free to modify and use it as needed.

## Contributing

Contributions are welcome! Feel free to fork the project and submit pull requests for any improvements.

