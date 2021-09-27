package com.chockqiu.flextags.been;

/**
 * @author Administrator
 */
public class SelectBeen {

    private boolean selected = false;
    private String text = "";

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
