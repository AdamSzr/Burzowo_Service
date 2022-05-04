package microservice.storm;

import microservice.storm.burzowo.data.BurzowoInfoDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class fileOperationTests {

    @Test
    public void nameValidatorTest() throws Exception {
        BurzowoApp app = new BurzowoApp();
        app.validateFileName("obraz.jpg");
    }
@Test
    public void nameValidatorTestNegative() throws Exception {
        BurzowoApp app = new BurzowoApp();
        app.validateFileName("obraz.op.jpg");
    }

    @Test
    public void prepareFileTest() throws Exception {
        BurzowoApp app = new BurzowoApp();
        String fname = "obraz.jpg";
        var x = app.prepareFile(fname);
        Assertions.assertTrue(x.exists());
    }

    @Test
    public void downloadedFileTest() throws Exception {
        var img = new BurzowoInfoDataProvider().downloadImage();
        new BurzowoApp().saveImg(img,"obraz.jpg");
    }

}
