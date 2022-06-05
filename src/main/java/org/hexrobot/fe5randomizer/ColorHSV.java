package org.hexrobot.fe5randomizer;

public class ColorHSV {
    private float hue;
    private float saturation;
    private float value;

    public ColorHSV(float hue, float saturation, float value) {
        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
    }

    public ColorHSV(ColorBGR555 color) {
        float rp = color.getRed() * 8 / 255.0f;
        float gp = color.getGreen() * 8 / 255.0f;
        float bp = color.getBlue() * 8 / 255.0f;
        float cMax = Math.max(Math.max(rp,gp), bp);
        float cMin = Math.min(Math.min(rp,gp), bp);
        float delta = cMax - cMin;

        if(delta == 0) {
            hue = 0;
        } else if(cMax == rp) {

            hue = ((60 * ((((gp - bp) / delta)) % 6)) + 360) % 360;
        } else if(cMax == gp) {
            hue = 60 * ((bp - rp) / delta + 2);
        } else if(cMax == bp) {
            hue = 60 * ((rp - gp) / delta + 4);
        }

        if(cMax == 0) {
            saturation = 0;
        } else {
            saturation = delta / cMax;
        }

        value = cMax;
    }

    public void setHue(float hue) {
        this.hue = hue;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void shiftHue(float amount) {
        hue = (hue + amount + 360) % 360;
    }

    public void shiftSaturation(float amount) {
        saturation += amount;
        saturation = Math.max(Math.min(saturation, 1.0f), 0);
    }

    public void shiftValue(float amount) {
        value += amount;
        value = Math.max(Math.min(value, 1.0f), 0);
    }

    public ColorBGR555 getAsColorBGR555() {
        float c = value * saturation;
        float x = c * (1 - Math.abs(((hue / 60) % 2) - 1));
        float m = value - c;
        float rp = 0;
        float gp = 0;
        float bp = 0;

        if(hue >= 0 && hue < 60) {
            rp = c;
            gp = x;
            bp = 0;
        } else if(hue >= 60 && hue < 120) {
            rp = x;
            gp = c;
            bp = 0;
        } else if(hue >= 120 && hue < 180) {
            rp = 0;
            gp = c;
            bp = x;
        } else if(hue >= 180 && hue < 240) {
            rp = 0;
            gp = x;
            bp = c;
        } else if(hue >= 240 && hue < 300) {
            rp = x;
            gp = 0;
            bp = c;
        } else if(hue >= 300 && hue < 360) {
            rp = c;
            gp = 0;
            bp = x;
        }

        int red = (int)((rp + m) * 255);
        int green = (int)((gp + m) * 255);
        int blue = (int)((bp + m) * 255);

        return new ColorBGR555(red / 8, green / 8, blue / 8);
    }

    @Override
    public String toString() {
        return String.format("ColorHSV h: %f, s: %f, v: %f", hue, saturation, value);
    }
}
