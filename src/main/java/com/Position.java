package com;

public class Position {

    private int row, col;

    public Position (int row, int col) {

        this.row = row;
        this.col = col;

    }

    // Tested
    public String getID() {

        return "cell" + row + col;

    }

    // Tested
    public int getRow() {

        return row;

    }

    // Tested
    public int getCol() {

        return col;

    }

    // Tested
    public void incrRow() {

        row++;

    }

    // Tested
    public void decrRow() {

        row--;

    }

    // Tested
    public void incrCol() {

        col++;

    }

    // Tested
    public void decrCol() {

        col--;

    }

    // Tested
    public boolean isEqual(Position pos) {

        if ((this.row == pos.getRow()) && (this.col == pos.getCol())) {

            return true;

        } else {

            return false;

        }

    }

}
