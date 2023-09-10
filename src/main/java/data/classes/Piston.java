package data.classes;

public class Piston {
    private String pistonCode;
    private double diameter;
    private double totalHeight;
    private double compressionHeight;
    private double pinDiameter;
    private String stroke;
    private String brand;
    private String model;

    public Piston(String pistonCode, double diameter, double totalHeight, double compressionHeight, double pinDiameter, String stroke, String brand, String model) {
        this.pistonCode = pistonCode;
        this.diameter = diameter;
        this.totalHeight = totalHeight;
        this.compressionHeight = compressionHeight;
        this.pinDiameter = pinDiameter;
        this.stroke = stroke;
        this.brand = brand;
        this.model = model;
    }

    public String getPistonCode() {
        return pistonCode;
    }

    public void setPistonCode(String pistonCode) {
        this.pistonCode = pistonCode;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getTotalHeight() {
        return totalHeight;
    }

    public void setTotalHeight(double totalHeight) {
        this.totalHeight = totalHeight;
    }

    public double getCompressionHeight() {
        return compressionHeight;
    }

    public void setCompressionHeight(double compressionHeight) {
        this.compressionHeight = compressionHeight;
    }

    public double getPinDiameter() {
        return pinDiameter;
    }

    public void setPinDiameter(double pinDiameter) {
        this.pinDiameter = pinDiameter;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
