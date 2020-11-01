package com.github.jp.erudosan.emj.gui;

public enum GuiClickType {
    Left,LeftShift,Right,RightShift,MiddleMouse;

    public boolean isShiftClick() {
        switch (this) {
            case Left:
            case MiddleMouse:
            case Right:
                break;
            case RightShift:
            case LeftShift:
                return true;
            default:
                break;
        }
        return false;
    }

    public boolean isLeftClick() {
        switch (this) {
            case MiddleMouse:
            case Right:
            case RightShift:
                break;
            case Left:
            case LeftShift:
                return true;
            default:
                break;
        }
        return false;
    }

    public boolean isRightClick() {
        switch (this) {
            case Right:
            case RightShift:
                return true;
            case Left:
            case LeftShift:
            case MiddleMouse:
            default:
                break;
        }
        return false;
    }

    public boolean isMiddleClick() {
        switch (this) {
            case MiddleMouse:
                return true;
            case Right:
            case RightShift:
            case Left:
            case LeftShift:
            default:
                break;
        }
        return false;
    }
}
