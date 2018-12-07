/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Christian
 */
public class Carport {

    private int length;
    private int width;
    private int shedLength;
    private int shedWidth;
    private boolean shedChosen;
    private boolean roofChosen;
    private List<Material> materials;
    private HashMap<String, List<Material>> listOfLists;
    public HashMap<String, List<Material>> getListOfLists() {
        return listOfLists;
    }

    /**
     * Sets the HashMap to have the list of lists
     * @param listOfLists HashMap with keys being a string telling what type it is and the values related to the key being a list of materials 
     */
    public void setListOfLists(HashMap<String, List<Material>> listOfLists) {
        this.listOfLists = listOfLists;
    }

    /**
     * Carport constructor to build a carport (longest version)
     * @param length int defining the length of the carport
     * @param width int defining the width of the carport
     * @param shedLength int defining the shedlength of the carport
     * @param shedWidth int defining the shedwidth of the carport
     * @param shedChosen boolean to define if a shed should be added
     * @param roofChosen boolean to define what roof type was selected
     */
    public Carport(int length, int width, int shedLength, int shedWidth, boolean shedChosen, boolean roofChosen) {
        this.length = length;
        this.width = width;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.shedChosen = shedChosen;
        this.roofChosen = roofChosen;
    }

    /**
     * Carport constructor to build a carport (middle version)
     * @param length int defining the length of the carport
     * @param width int defining the width of the carport
     * @param materials List of Materials
     */
    public Carport(int length, int width, List<Material> materials) {
        this.length = length;
        this.width = width;
        this.materials = materials;
    }
    /**
     * Carport constructor to build a carport (short version)
     * @param length int defining the length of the carport
     * @param width int defining the width of the carport
     */
    public Carport(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public boolean isShedChosen() {
        return shedChosen;
    }

    public void setShedChosen(boolean shedChosen) {
        this.shedChosen = shedChosen;
    }

    public boolean isRoofChosen() {
        return roofChosen;
    }

    public void setRoofChosen(boolean roofChosen) {
        this.roofChosen = roofChosen;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

}