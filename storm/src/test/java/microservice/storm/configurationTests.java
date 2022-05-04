package microservice.storm;

import org.apache.tomcat.jni.Directory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.stream.StreamSupport;

public class configurationTests {
    @Test
    public void getNotExistingAttrTest()
    {

    }

    @Test
    public void getAttrTest() throws Exception {
        System.out.println(new File(AppConfiguration.BURZOWO_INFO_DIR_PATH).exists());
        var file1 = new File(AppConfiguration.BURZOWO_INFO_DIR_PATH.concat("/obraz1.png"));
        var dataf1 =new FileInputStream(file1).readAllBytes();

        var file2 = new File(AppConfiguration.BURZOWO_INFO_DIR_PATH.concat("/copy.png"));
        file2.createNewFile();

        if(file2.exists())
        {
            var fwf2 = new FileOutputStream(file2);
            fwf2.write(dataf1);
            fwf2.close();
        }

        //Assertions.assertEquals(AppConfiguration.getAttr("path"),"","Got some value");
    }
}
