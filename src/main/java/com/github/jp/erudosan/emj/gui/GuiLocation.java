package com.github.jp.erudosan.emj.gui;

public enum GuiLocation {
    topLeft(0,0), topRight(0,1), bottomLeft(1,0), bottomRight(1,1);

    private int row;
    private int collumn;

    GuiLocation(int row, int collumn) {
        this.row = row;
        this.collumn = collumn;
    }

    public int getRow() {
        return row;
    }

    public int getCollumn() {
        return collumn;
    }
}
