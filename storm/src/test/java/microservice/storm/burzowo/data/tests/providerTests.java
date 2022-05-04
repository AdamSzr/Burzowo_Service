package microservice.storm.burzowo.data.tests;

import microservice.storm.burzowo.data.BurzowoInfoDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;

public class providerTests {
    @Value("${burzowo.info.images.dir}")
    private String path;

    @Test
    public void getImgBytesTest() {
        try {
            BurzowoInfoDataProvider p = new BurzowoInfoDataProvider();
            Assertions.assertTrue(p.downloadImage().length > 0, "ByteArray is null");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void saveImgTest() {
        try {
            System.out.println(System.getProperties().getProperty("1234"));

            BurzowoInfoDataProvider p = new BurzowoInfoDataProvider();
            byte[] img = p.downloadImage();
            File f = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "/burzowo_info", "burze.png");
            f.createNewFile();
            var fw = new FileOutputStream(f);
            fw.write(img);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
