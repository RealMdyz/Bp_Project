// God always with me :)
import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;

import javax.imageio.IIOException;
import java.awt.*;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.util.Scanner;
public class Tile {

    int row;
    char col;
    char color = 'o';
    String name = "Nothing";
    boolean isSelected = false;
    private final boolean available;
    boolean dontMovedPawn = false;
    ArrayList<Point> attack = new ArrayList<>();
    public Tile(int row, char col, boolean available) {
        this.row = row;
        this.col = col;
        this.available = available;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public boolean isDontMovedPawn() {
        return dontMovedPawn;
    }

    public void setDontMovedPawn(boolean dontMovedPawn) {
        this.dontMovedPawn = dontMovedPawn;
    }
}