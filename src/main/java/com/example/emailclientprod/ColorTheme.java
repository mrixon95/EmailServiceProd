package com.example.emailclientprod;

public enum ColorTheme {
    LIGHT,
    DEFAULT,
    DARK;

    public static String getCssPath(ColorTheme colorTheme) {
        switch (colorTheme) {
            case LIGHT:
                return "themeLight.css";
            case DARK:
                return "themeDark.css";
            case DEFAULT:
                return "themeDefault.css";
            default:
                return null;
        }
    }
}
