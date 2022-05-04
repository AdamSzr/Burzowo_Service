package microservice.storm;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class RGBTests {

    @Test
    public  void test1() throws Exception {
        BurzowoApp ba=new BurzowoApp();
        URL u = new URL(AppConfiguration.BURZOWO_INFO_URL);
        Image m = ImageIO.read(u);

        ba.checkIsStorm(m);
    }
    @Test
    public  void test2() throws Exception {
        BurzowoApp ba=new BurzowoApp();
        URL u = new URL(AppConfiguration.BURZOWO_INFO_URL);
        Image m = ImageIO.read(u);

        ImageAdapter.scanRec(m,50,50,10);

    }
}
