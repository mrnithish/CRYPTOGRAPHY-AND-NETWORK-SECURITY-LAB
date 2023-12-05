import java.math.BigInteger; 
import java.util.Random; 
public class DiffieHellmanKeyExchange { 
public static void main(String[] args) { 
BigInteger prime = new BigInteger("23"); 
BigInteger primitiveRoot = new BigInteger("5"); 
BigInteger privateKeyAlice = generatePrivateKey(prime); 
BigInteger privateKeyBob = generatePrivateKey(prime); 
BigInteger publicKeyAlice = calculatePublicKey(primitiveRoot, privateKeyAlice, 
prime); 
BigInteger publicKeyBob = calculatePublicKey(primitiveRoot, privateKeyBob, prime); 
BigInteger sharedSecretAlice = calculateSharedSecret(publicKeyBob, privateKeyAlice, 
prime); 
BigInteger sharedSecretBob = calculateSharedSecret(publicKeyAlice, privateKeyBob, 
prime); 

if (sharedSecretAlice.equals(sharedSecretBob)) { 
System.out.println("Shared Secret Key: " + sharedSecretAlice); 
} else { 
System.out.println("Error: Shared secrets do not match.");}} 
private static BigInteger generatePrivateKey(BigInteger prime) { 
Random rand = new Random(); 
return new BigInteger(prime.bitLength() - 1, rand).add(BigInteger.ONE); 
 
} 
private static BigInteger calculatePublicKey(BigInteger primitiveRoot, BigInteger 
privateKey, BigInteger prime) { 
return primitiveRoot.modPow(privateKey, prime); 
 
} 
private static BigInteger calculateSharedSecret(BigInteger publicKey, BigInteger 
privateKey, BigInteger prime) { 
return publicKey.modPow(privateKey, prime);}}