package com.github.jp.erudosan.emj.gui;

public enum GUIRows {
    r1(1), r2(2), r3(3), r4(4), r5(5), r6(6);

    private int rows;

    GUIRows(int rows) {
        this.rows = rows;
    }

    public Integer getFields() {
        return rows * 9;
    }

    public Integer getRows() {
        return rows;
    }

    public static GUIRows getByRows(Integer rows) {
        if (rows > 9)
            rows = rows / 9;
        for (GUIRows one : GUIRows.values()) {
            if (one.getRows().equals(rows))
                return one;
        }
        return GUIRows.r6;
    }
}
