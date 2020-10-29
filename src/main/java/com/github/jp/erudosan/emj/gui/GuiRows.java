package com.github.jp.erudosan.emj.gui;

public enum GuiRows {
    r1(1),r2(2),r3(3),r4(4),r5(5),r6(6);

    private int rows;

    GuiRows(int rows) {
        this.rows = rows;
    }

    public int getFields() {
        return rows * 9;
    }

    public int getRows() {
        return rows;
    }

    public static GuiRows getByRows(int rows) {
        if(rows > 9) {
            rows = rows / 9;
        }

        for(GuiRows one : GuiRows.values()) {
            if(one.getRows() == rows) {
                return one;
            }
        }

        return GuiRows.r6;
    }
}
