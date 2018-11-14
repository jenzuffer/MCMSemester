package FunctionLayer;

public class Materiale {
    private String name, description, unit;
    private int amount, length;

    public Materiale(String name, String description, String unit, int amount, int length) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.amount = amount;
        this.length = length;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


}