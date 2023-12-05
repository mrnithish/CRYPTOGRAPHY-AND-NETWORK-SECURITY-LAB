import java.util.*; 
public class RailFence { 
 
private final int numRails; 
 
 
public RailFence(int numRails) { 
this.numRails = numRails; 
} 
 
 
public String encrypt(String plaintext) { 
StringBuilder ciphertext = new StringBuilder(); 
int n = 0; 
for (int k = 0; k < numRails; k++) { 
int index = k; 
boolean down = true; 
while (index < plaintext.length()) { 
ciphertext.append(plaintext.charAt(index)); 
if (k == 0 || k == numRails - 1) { 
index = index + 2 * (numRails - 1); 
} else if (down) { 
index = index + 2 * (numRails - k - 1); 
down = false; 
} else { 
index = index + 2 * k; 
down = true; 
} 
} 
} 
 
return ciphertext.toString(); 
} 
 
 
public String decrypt(String ciphertext) { 
char[] decrypted = new char[ciphertext.length()]; 
int n = 0; 
for (int k = 0; k < numRails; k++) { 
int index = k; 
boolean down = true; 
while (index < ciphertext.length()) { 
decrypted[index] = ciphertext.charAt(n++); 
if (k == 0 || k == numRails - 1) { 
index = index + 2 * (numRails - 1); 
} else if (down) { 
index = index + 2 * (numRails - k - 1); 
down = false; 
} else { 
index = index + 2 * k; 
down = true; 
} 
} 
} 
 
return new String(decrypted); 
} 
 
 
public static void main(String[] args) { 
String plaintext = "Hello, World!"; 
int numRails = 3; 
 
RailFence cipher = new RailFence(numRails); 
String ciphertext = cipher.encrypt(plaintext); 
System.out.println("Ciphertext: " + ciphertext); 
 
 
String decryptedText = cipher.decrypt(ciphertext); 
System.out.println("Plaintext: " + decryptedText); 
} 
}