package aleks;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.google.transit.realtime.GtfsRealtime;
import java.io.InputStream;
import java.net.URL;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        System.out.println("main");
        
        URL url = new URL("http://datamine.mta.info/mta_esi.php?key=bed74fa37b835544677bcddc6b4680ff");
        
        
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        
        
        byte[]  buf = new byte[4096];
        
        File file = new File("src/main/resources/gtfs");
        
        InputStream fi = url.openStream();
        
        int byteCount;
        while ((byteCount = fi.read(buf)) > 0) {
            bo.write(buf, 0, byteCount);
        }
        
        
        
        System.out.println(bo.toByteArray().length);
        
        GtfsRealtime.FeedMessage fm = GtfsRealtime.FeedMessage.parseFrom(bo.toByteArray());
        System.out.println(fm);
       
        
    }
}
