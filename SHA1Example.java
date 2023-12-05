import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
public class SHA1Example { 
public static void main(String[] args) { 
String text = "This is the text for which we want to calculate the SHA-1 hash."; 
try { 
MessageDigest sha1 = MessageDigest.getInstance("SHA-1"); 
sha1.update(text.getBytes()); 
byte[] digest = sha1.digest(); 
StringBuilder hexString = new StringBuilder(); 
for (byte b : digest) { 
hexString.append(String.format("%02x", b)); 
 
} 
System.out.println("SHA-1 Hash: " + hexString.toString()); 
} catch (NoSuchAlgorithmException e) { 
System.err.println("SHA-1 algorithm is not available."); 
}}}