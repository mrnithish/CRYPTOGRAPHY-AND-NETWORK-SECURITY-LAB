import java.security.*; 
import java.security.spec.PKCS8EncodedKeySpec; 
import java.security.spec.X509EncodedKeySpec; 
import java.util.Base64; 
 
public class DSASignatureExample { 
public static void main(String[] args) { 
try { 
// Generate key pair 
KeyPair keyPair = generateKeyPair(); 
 
 
// Sign the message 
String message = "Hello, DSA!"; 
String signature = signMessage(message, keyPair.getPrivate()); 
 
 
// Verify the signature 
boolean isVerified = verifySignature(message, signature, keyPair.getPublic()); 

System.out.println("Original Message: " + message); 
System.out.println("Digital Signature: " + signature); 
System.out.println("Signature Verification: " + isVerified); 
 
} catch (Exception e) { 
e.printStackTrace(); 
} 
} 
 
 
// Method to generate DSA key pair 
private static KeyPair generateKeyPair() throws Exception { 
KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA"); 
keyPairGenerator.initialize(2048); // Key size, you can choose other sizes 
return keyPairGenerator.generateKeyPair(); 
} 
 
 
// Method to sign a message using DSA private key 
private static String signMessage(String message, PrivateKey privateKey) throws 
Exception { 
Signature dsaSignature = Signature.getInstance("SHA256withDSA"); 
dsaSignature.initSign(privateKey); 
dsaSignature.update(message.getBytes()); 
byte[] signatureBytes = dsaSignature.sign(); 
return Base64.getEncoder().encodeToString(signatureBytes); 
 
} 
 
 

private static boolean verifySignature(String message, String signature, PublicKey 
publicKey) throws Exception { 
Signature dsaSignature = Signature.getInstance("SHA256withDSA"); 
dsaSignature.initVerify(publicKey); 
dsaSignature.update(message.getBytes()); 
byte[] signatureBytes = Base64.getDecoder().decode(signature); 
return dsaSignature.verify(signatureBytes); 
} 
}