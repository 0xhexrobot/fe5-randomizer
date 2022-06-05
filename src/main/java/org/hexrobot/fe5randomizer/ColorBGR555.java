package org.hexrobot.fe5randomizer;

public class ColorBGR555 {
    private int red;
    private int green;
    private int blue;

    public ColorBGR555(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public ColorBGR555(int rawInt) {
        this.red = rawInt & 0x1F;
        this.green = (rawInt >> 5) & 0x1F;
        this.blue = (rawInt >> 10) & 0x1F;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int toRawInt() {
        return (blue << 10) | (green << 5) | red;
    }

    public static ColorBGR555 lighten(ColorBGR555 color, float percent) {
        int newRed = (int)(Math.min(255, color.red * 8 + 255 * percent) / 8);
        int newGreen = (int)(Math.min(255, color.green * 8 + 255 * percent) / 8);
        int newBlue = (int)(Math.min(255, color.blue * 8 + 255 * percent) / 8);

        return new ColorBGR555(newRed, newGreen, newBlue);
    }

    public static ColorBGR555 darken(ColorBGR555 color, float percent) {
        int newRed = (int)(Math.max(0, color.red * 8 - 255 * percent) / 8);
        int newGreen = (int)(Math.max(0, color.green * 8 - 255 * percent) / 8);
        int newBlue = (int)(Math.max(0, color.blue * 8 - 255 * percent) / 8);

        return new ColorBGR555(newRed, newGreen, newBlue);
    }

    public String toRgbString() {
        return String.format("%02x%02x%02x", red * 8, green * 8, blue * 8);
    }

    @Override
    public String toString() {
        return String.format("ColorBGR555 r: %d, g: %d, b: %d", red, green, blue);
    }
}
