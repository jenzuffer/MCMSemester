package FunctionLayer;

public class Material {
    private String name, description, unit, type;
    private int amount, length, id;
    private int price;

    public Material(String name, String description, String unit, String type, int length, int id, int price) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.type = type;
        this.length = length;
        this.id = id;
        this.price = price;
    }

    
    
    
    public Material(String name, String description, String unit, int length) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.length = length;
    }

    public Material(String name, String description, String unit, int length, int price) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.length = length;
        this.price = price;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }
    
    public void addToAmount(int amount) {
        this.amount += amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {  
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}