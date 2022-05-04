package microservice.storm;

import microservice.storm.burzowo.data.BurzowoInfoDataProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class BurzowoApp {
    Image m;

    public BurzowoApp() {
        try {
            this.m = this.getMap();
            this.m = ImageAdapter.getRec(m, 100, 100, 40);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/burzowo.png", produces = "image/png")
    public byte[] getFragment() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) m, "png", bos);
        return bos.toByteArray();

    }

    public Image getMap() throws Exception {
        URL u = new URL(AppConfiguration.BURZOWO_INFO_URL);
        return ImageIO.read(u);
    }

    public void validateFileName(String fileName) throws Exception {

        if (!fileName.contains("."))
            throw new Exception("File name does not contain extension.");

        List<String> extensions = new ArrayList<>() {
            {
                add("jpg");
                add("png");
                add("bmp");
                add("jpeg");
            }
        };


        var parts = fileName.split("\\.");

        if (parts.length != 2)
            throw new Exception("File name have more then 2 parts (split by '.')");

        if (!extensions.contains(parts[1]))
            throw new Exception("File extension is not correct.");

    }

    public File prepareFile(String fileName) throws IOException {
        var file2 = new File(AppConfiguration.BURZOWO_INFO_DIR_PATH.concat(String.format("/%s", fileName)));

        if (file2.exists() && file2.isFile()) {
            var parts = fileName.split("\\.");
            fileName = parts[0] + "_" + new Date().getTime() + "." + parts[1];

            file2 = new File(AppConfiguration.BURZOWO_INFO_DIR_PATH.concat(String.format("/%s", fileName)));
        }

        file2.createNewFile();
        return file2;
    }

    public void saveImg(byte[] img, String fileName) throws Exception {
        this.validateFileName(fileName);

        var file = prepareFile(fileName);

        try (FileOutputStream fwf2 = new FileOutputStream(file)) {
            if (file.exists()) {
                fwf2.write(img);
                fwf2.close();
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public Image convertBytesToImg(byte[] imgBytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);

        return ImageIO.read(bis);
    }

    public boolean checkIsStorm(Image img) throws Exception {
        System.out.println(ImageAdapter.MAX_WIDTH(img));

        System.out.println(ImageAdapter.getRed(img, ImageAdapter.MAX_WIDTH(img), 1553));
        System.out.println(ImageAdapter.getGreen(img, 0, 0));
        System.out.println(ImageAdapter.getBlue(img, 0, 0));

        System.out.println("-------------------------------------");

        return false;
    }

}
