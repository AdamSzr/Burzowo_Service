package microservice.storm.burzowo.data;

import microservice.storm.AppConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class BurzowoInfoDataProvider {

    public byte[] downloadImage() throws Exception{
        URL url = new URL(AppConfiguration.BURZOWO_INFO_URL);

        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        return is.readAllBytes();
    }
}
