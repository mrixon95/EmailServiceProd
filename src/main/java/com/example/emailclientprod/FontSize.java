package com.example.emailclientprod;

public enum FontSize {
    SMALL,
    MEDIUM,
    BIG;

    public static String getCssPath(FontSize fontSize) {
        switch (fontSize) {
            case SMALL:
                return "fontSmall.css";
            case MEDIUM:
                return "fontMedium.css";
            case BIG:
                return "fontBig.css";
            default:
                return null;
        }
    }
}
