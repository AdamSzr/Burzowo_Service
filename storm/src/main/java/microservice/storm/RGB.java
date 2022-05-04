package microservice.storm;

public class RGB {
    private final int red;
    private final int green;
    private final int blue;
    private int alpha;
    private boolean hasAlpha;

    public RGB(int r, int g, int b) {
        this.blue = b;
        this.green = g;
        this.red = r;
    }

    public RGB(int r, int g, int b, int aplha) {
        this(r, g, b);
        hasAlpha = true;
        this.alpha = aplha;
    }

    public int valueOfGreen() {
        return green;
    }

    public int valueOfBlue() {
        return blue;
    }

    public int valueOfRed() {
        return red;
    }

    public int valueOfAlpha() {
        if (hasAlpha)
            return alpha;
        else
            return (int) 0xff;
    }

    @Override
    public String toString() {
        return "RGB{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", alpha=" + alpha +
                ", hasAlpha=" + hasAlpha +
                '}';
    }
}
