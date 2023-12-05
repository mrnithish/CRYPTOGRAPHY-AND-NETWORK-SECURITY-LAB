import java.util.Scanner; 
public class HillCipher { 
public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 
System.out.print("Enter the key matrix (2x2, 4 integers separated by spaces): "); 
int[][] keyMatrix = new int[2][2]; 
for (int i = 0; i < 2; i++) { 
for (int j = 0; j < 2; j++) { 
keyMatrix[i][j] = scanner.nextInt(); 
 
} 
} 
System.out.print("Enter the plaintext (in uppercase, without spaces): "); 
scanner.nextLine(); // Consume the newline left by nextInt 
String plaintext = scanner.nextLine(); 
String encryptedText = encrypt(plaintext, keyMatrix); 
System.out.println("Encrypted text: " + encryptedText); 
String decryptedText = decrypt(encryptedText, keyMatrix); 
System.out.println("Decrypted text: " + decryptedText); 
scanner.close(); 
} 
 
public static String encrypt(String plaintext, int[][] keyMatrix) { 
StringBuilder encryptedText = new StringBuilder(); 
while (plaintext.length() % 2 != 0) { 
plaintext += 'X'; // Pad the plaintext with 'X' if necessary 
 
} 
for (int i = 0; i < plaintext.length(); i += 2) { 
char char1 = plaintext.charAt(i); 
char char2 = plaintext.charAt(i + 1); 
int p1 = char1 - 'A'; 
int p2 = char2 - 'A'; 
int c1 = (keyMatrix[0][0] * p1 + keyMatrix[0][1] * p2) % 26; 
int c2 = (keyMatrix[1][0] * p1 + keyMatrix[1][1] * p2) % 26; 
encryptedText.append((char) (c1 + 'A')); 
encryptedText.append((char) (c2 + 'A')); 
} 
return encryptedText.toString(); 
} 
 
public static String decrypt(String encryptedText, int[][] keyMatrix) { 
StringBuilder decryptedText = new StringBuilder(); 
for (int i = 0; i < encryptedText.length(); i += 2) { 
char char1 = encryptedText.charAt(i); 
char char2 = encryptedText.charAt(i + 1); 
int c1 = char1 - 'A'; 
int c2 = char2 - 'A'; 
int det = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]; 
int detInverse = modInverse(det, 26); 
int p1 = (detInverse * (keyMatrix[1][1] * c1 - keyMatrix[0][1] * c2)) % 26; 
int p2 = (detInverse * (-keyMatrix[1][0] * c1 + keyMatrix[0][0] * c2)) % 26; 
if (p1 < 0) { 
p1 += 26; 
 
} 
if (p2 < 0) { 
p2 += 26; 
} 
decryptedText.append((char) (p1 + 'A')); 
decryptedText.append((char) (p2 + 'A')); 
} 
return decryptedText.toString(); 
} 
 
public static int modInverse(int a, int m) { 
for (int x = 1; x < m; x++) { 
if ((a * x) % m == 1) { 
return x; 
} 
} 
 
return -1; // Inverse doesn't exist 
} 
}