package com;

public class Position {

    private int row, col;

    public Position (int row, int col) {

        this.row = row;
        this.col = col;

    }

    public String getID() {

        return "cell" + row + col;

    }

    public int getRow() {

        return row;

    }

    public int getCol() {

        return col;

    }

    public void incrRow() {

        row++;

    }

    public void decrRow() {

        row--;

    }

    public void incrCol() {

        col++;

    }

    public void decrCol() {

        col--;

    }

    public boolean isEqual(Position pos) {

        if ((this.row == pos.getRow()) && (this.col == pos.getCol())) {

            return true;

        } else {

            return false;

        }

    }

}
