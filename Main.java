import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import sun.misc.BASE64Encoder;

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
    public static void testInternet(StringBuffer st) {
        int pos = st.indexOf("info", 0) + 6;
        int left = st.indexOf("\"", pos);
        int right = st.indexOf("\"", pos + 2);
        // System.out.println(left);
        // System.out.println(right);
        String subs = st.substring(left+1, right);
        //System.out.println(subs);
        
        String symbol = subs.substring(2, 6);
        if (symbol.equals("7528")) {
            System.out.println("[!]" + "\u7528\u6237\u5df2\u767b\u5f55");
        } else if (symbol.equals("8ba4")) {
            System.out.println("[*]\u8ba4\u8bc1\u6210\u529f");
        } else {
            System.out.println("[!]\u767b\u9646\u5931\u8d25");
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
            //System.out.println(answer);
            testInternet(answer);

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
        String username = "";//your user name
        String password = base64Encoder("");//your password
        sendPostRequests(
            "http://a.nuist.edu.cn/index.php/index/login",
            "username=" + username + "&domain=ChinaNet&password=" + password + "&enablemacauth=0"
        );
        
    }
}