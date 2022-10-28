package org.example.model;

import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.Map;

public class FontFormat {

     static public String[] fontNamesList = {"Arial", "Calibri", "Times New Roman", "Verdana", "Tahoma",
            "Courier New", "Georgia", "Impact", "Lucida Console", "Palatino Linotype",
            "Trebuchet MS", "MS Sans Serif", "MS Serif", "Symbol"};

    final static public Map<String, Integer> fontStylesList = Map.of(
            "Regular", 0,
            "Bold", 1,
            "Italic", 2,
            "Bold Italic", 3
    );

    static public Integer[] fontSizesList = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};

    public static String name;
    public static Integer size;
    public static Integer style;

    public static Color foregroundColor;
    public static Color backgroundColor;

    static {
        name = fontNamesList[0];
        size = fontSizesList[6];
        style = fontStylesList.get("Regular");
    }
}