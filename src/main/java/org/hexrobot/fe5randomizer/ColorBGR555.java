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

    public static ColorBGR555 deadify(ColorBGR555 color) {
        final float OPACITY = 0.35f;
        ColorHSV hsv = new ColorHSV(color);
        float sat = hsv.getSaturation();
        hsv.setSaturation(sat * 0.55f);
        ColorBGR555 desaturated = hsv.getAsColorBGR555();

        int ovR = 0x60;
        int ovG = 0xFF;
        int ovB = 0;
        float mulR = (desaturated.red * 8.0f * ovR) / 255.0f;
        float mulG = (desaturated.green * 8.0f * ovG) / 255.0f;
        float mulB = (desaturated.blue * 8.0f * ovB) / 255.0f;
        float pR = (1 - OPACITY) * desaturated.red * 8.0f + mulR * OPACITY;
        float pG = (1 - OPACITY) * desaturated.green * 8.0f + mulG * OPACITY;
        float pB = (1 - OPACITY) * desaturated.blue * 8.0f + mulB * OPACITY;

        return new ColorBGR555((int)(pR / 8), (int)(pG / 8), (int)(pB / 8));
    }

    public String toRgbString() {
        return String.format("%02x%02x%02x", red * 8, green * 8, blue * 8);
    }

    @Override
    public String toString() {
        return String.format("ColorBGR555 r: %d, g: %d, b: %d", red, green, blue);
    }
}
