package microservice.storm;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageAdapter {

    private static void validateCords(BufferedImage bi, int x, int y) throws Exception {
        if (x > bi.getWidth() ||
                x < 0 ||
                y > bi.getHeight() ||
                y < 0
        ) {
            throw new Exception("pixel coordynates are out of image bound");
        }
    }
    public static int MAX_WIDTH(Image i)
    {
        return ((BufferedImage) i).getWidth() - 1;
    }

    public static int MAX_HEIGHT(Image i)
    {
        return ((BufferedImage) i).getHeight() - 1 ;
    }

    public static int getRed(Image i, int x, int y) throws Exception {
        BufferedImage bf = (BufferedImage) i;
        validateCords(bf, x, y);

        var c = new Color(bf.getRGB(x, y)).getRed();
        validateColor(c);
        return c;
    }
    public static int getGreen(Image i, int x, int y) throws Exception {
        BufferedImage bf = (BufferedImage) i;
        validateCords(bf, x, y);

        var c = new Color(bf.getRGB(x, y)).getGreen();
        validateColor(c);
        return c;
    }
    public static int getBlue(Image i, int x, int y) throws Exception {
        BufferedImage bf = (BufferedImage) i;
        validateCords(bf, x, y);

        var c = new Color(bf.getRGB(x, y)).getBlue();
        validateColor(c);
        return c;
    }
    public static int getAlpha(Image i, int x, int y) throws Exception {
        BufferedImage bf = (BufferedImage) i;
        validateCords(bf, x, y);

        var c = new Color(bf.getRGB(x, y)).getAlpha();
        validateColor(c);
        return c;
    }

    private static void validateColor(int color) throws Exception {
        if (color < 0 || color > 255)
            throw new Exception("Color validation failed");
    }

    public static Image getRec(Image i,int xCenter, int yCenter, int sideSize )
    {
      return  ((BufferedImage) i).getSubimage(xCenter-(sideSize/2),yCenter-(sideSize/2),sideSize,sideSize);
    }

    public static void scanRec(Image i, int xCenter, int yCenter, int sideSize )
    {
        BufferedImage bi = (BufferedImage) getRec(i,50,50,10);
        long r = 0;
        long g = 0;
        long b = 0;
        long temp = 0;
        for (int x =0;x<=MAX_HEIGHT(bi);x++)
        {
            for (int y = 0;y<=MAX_WIDTH(bi);y++)
            {
                temp = temp+1;
                r += new Color (bi.getRGB(x,y)).getRed();
                g += new Color (bi.getRGB(x,y)).getGreen();
                b += new Color (bi.getRGB(x,y)).getBlue();


            }
            System.out.println(r);
            System.out.println(g);
            System.out.println(b);
            System.out.println(temp);
        }
        System.out.println(r);
        System.out.println(g);
        System.out.println(b);
        System.out.println(temp);

        r /= temp;
        g /= temp;
        b /= temp;

        RGB avg = new RGB((int) r, (int)g,(int)b);
        System.out.println(avg.toString());
    }

}
