/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Christian
 */
public class CarportDimensioner {
    private int heigth;
    private int length;
    private int width;
    private int polls;
    private int spears;

    public CarportDimensioner(int heigth, int length, int width, int polls, int spears) {
        this.heigth = heigth;
        this.length = length;
        this.width = width;
        this.polls = polls;
        this.spears = spears;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
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

    public int getPolls() {
        return polls;
    }

    public void setPolls(int polls) {
        this.polls = polls;
    }

    public int getSpears() {
        return spears;
    }

    public void setSpears(int spears) {
        this.spears = spears;
    }

}
