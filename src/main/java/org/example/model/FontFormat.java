package org.example.model;

import java.awt.*;
import java.util.Map;

public class FontFormat {

    final static public String[] fontsNamesList = {"Arial", "Calibri", "Times New Roman", "Verdana", "Tahoma",
            "Courier New", "Georgia", "Impact", "Lucida Console", "Lucida Sans Unicode", "Palatino Linotype",
            "Trebuchet MS", "MS Sans Serif", "MS Serif", "Symbol", "Webdings", "Wingdings", "Wingdings 2", "Wingdings 3"};

    final static public Map<String, Integer> fontStylesList = Map.of(
            "Regular", Font.PLAIN,
            "Bold", Font.BOLD,
            "Italic", Font.ITALIC,
            "Bold Italic", Font.BOLD + Font.ITALIC
    );

    final static public Integer[] fontSizesList = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};

    private String name = fontsNamesList[0];
    private Integer size = fontSizesList[2];
    private Integer style = fontStylesList.get("Regular");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}