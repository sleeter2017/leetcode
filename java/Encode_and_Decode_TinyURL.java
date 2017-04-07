// https://leetcode.com//problems/encode-and-decode-tinyurl/#/description		 QuestionId:535
import java.io.*; 
import java.util.*; 
public class Codec {

    Map<Long, String> urlMap = new HashMap<>();
    private  final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private  final int    BASE     = ALPHABET.length();
    long id = 0;
                 
    // Encodes a URL to a shortened URL.

    public String encode(String longUrl) {
        urlMap.put(id++, longUrl);
        
        StringBuilder sb = new StringBuilder();
        long num = id-1;
        while ( num > 0 ) {
            sb.append( ALPHABET.charAt( (int)(num % BASE) ) );
            num /= BASE;
        }
        return sb.reverse().toString();   
    }

    // Decodes a shortened URL to its original URL.

        public  String decode(String shortUrl) {
            
        long num = 0;
        for ( int i = 0; i < shortUrl.length(); i++ )
            num = num * BASE + ALPHABET.indexOf(shortUrl.charAt(i));
        return urlMap.get(num);
    } 
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
/*----------------------------------------------------------------------------------- 
 Problem: 
Note: This is a companion problem to the System Design problem: Design TinyURL.

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.*/