import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import sun.misc.BASE64Encoder;
import java.net.HttpURLConnection;

public class Main {
    public static String base64Encoder(String s) {
        byte[] b = null;
        try {
            b = s.getBytes("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BASE64Encoder().encode(b);
    }
    public static void testInternet() {
        try {
            URL url = new URL("http://baidu.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            if (con.getResponseCode() == 200) {
                System.out.println("[*]Internet OK!");
            } else {
                System.out.println("[!]Connection failed!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }
    public static void sendPostRequests(String site, String param) {
        try {
            URL url = new URL(site);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

            writer.write(param);
            writer.flush();

            StringBuffer answer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                answer.append(line);
            }
            writer.close();
            reader.close();
            
            testInternet();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        /*
        Rewrite "ChinaNet" below to change domain !
        */
        String username = "";//your username
        String password = base64Encoder("");//your password
        sendPostRequests(
            "http://a.nuist.edu.cn/index.php/index/login",
            "username=" + username + "&domain=ChinaNet&password=" + password + "&enablemacauth=0"
        );
        
    }
}