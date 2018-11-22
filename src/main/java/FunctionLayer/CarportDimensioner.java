/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class CarportDimensioner {
    private int length;
    private int width;
    private int shedLength;
    private int shedWidth;
    private boolean shedChosen;
    private boolean roofChosen;
    private List<Materiale> materials;
    private List<List<Materiale>> listOfLists;

    public List<List<Materiale>> getListOfLists() {
        return listOfLists;
    }

    public void setListOfLists(List<List<Materiale>> listOfLists) {
        this.listOfLists = listOfLists;
    }

    public CarportDimensioner(int length, int width, int shedLength, int shedWidth, boolean shedChosen, boolean roofChosen) {
        this.length = length;
        this.width = width;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.shedChosen = shedChosen;
        this.roofChosen = roofChosen;
        materials = new ArrayList<>();
        materials.add(new Materiale("hest", "hej", "miav", 5));
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
    
    
    public CarportDimensioner(int length, int width, List<Materiale> materials) {
        this.length = length;
        this.width = width;
        this.materials = materials;
    }

    
    public CarportDimensioner(int length, int width) {
        this.length = length;
        this.width = width;
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

    public List<Materiale> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Materiale> materials) {
        this.materials = materials;
    }

    
    
    
    
}
