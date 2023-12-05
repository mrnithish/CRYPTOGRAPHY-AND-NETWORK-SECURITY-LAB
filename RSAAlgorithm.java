import java.security.*; 
import javax.crypto.*; 
import java.math.*; 
 
public class RSAAlgorithm { 
 
 
public static void main(String[] args) throws Exception { 

KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA"); 
generator.initialize(2048); 
KeyPair keyPair = generator.generateKeyPair(); 
PublicKey publicKey = keyPair.getPublic(); 
PrivateKey privateKey = keyPair.getPrivate(); 
 


String plaintext = "This is a secret message"; 
 

byte[] plainTextBytes = plaintext.getBytes(); 
BigInteger plaintextInteger = new BigInteger(plainTextBytes); 
 
 

Cipher cipher = Cipher.getInstance("RSA"); 
cipher.init(Cipher.ENCRYPT_MODE, publicKey); 
byte[] ciphertextBytes = cipher.doFinal(plainTextBytes); 
BigInteger ciphertext = new BigInteger(ciphertextBytes); 
 
 
cipher.init(Cipher.DECRYPT_MODE, privateKey); 
byte[] decryptedBytes = cipher.doFinal(ciphertextBytes); 
String decryptedText = new String(decryptedBytes); 
 
 
System.out.println("Plaintext: " + plaintext); 
System.out.println("Ciphertext: " + ciphertext); 
System.out.println("Decrypted Text: " + decryptedText); 
} 
}
