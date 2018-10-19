package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlGoogle {
	
	public static final String GOOGLE_TRANSLATE_AUDIO = "http://translate.google.com/translate_tts?";
	public static final String YANDEX_TRANSLATE_TEXT = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=";
	public static final String GOOGLE_ENGLISH = "en";
	public static final String GOOGLE_VIETNAMESE = "vi";
	public static final String KEY_API ="trnsl.1.1.20181011T104902Z.88733da691ea469b.24e635a64ba1e63d7ac4e8525851775dc8877437";
	public static String  tranlateText(String text) throws IOException {
		// gui yeu cau = phuongthuc get
               
		URL url = new URL( UrlGoogle.YANDEX_TRANSLATE_TEXT+UrlGoogle.KEY_API+ "&text=" + text.trim().replace(" ","+") + "&lang=en-vi");
		URLConnection urlConn = url.openConnection();
		urlConn.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		//xu ly trả vê
        InputStream inStream = urlConn.getInputStream();
        BufferedReader a = new BufferedReader(new InputStreamReader(inStream));
        
		String result =a.readLine();
		
		inStream.close();
		;
		                System.out.println(result);
                              result=  result.replace("\"]}", "");
                            
                               
		result= result.substring(result.lastIndexOf("\"text\":["));
                         result=result.replace("\"text\":[\"", "");
                System.out.println(result);
	return result;
	}
}