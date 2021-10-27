import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/*
borrowed from this stack overflow answer: https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
there should be some inbuilt utility for this. This is not integral to function of the blockchain so i borrowed it.
 */

public class SHA256 {
    public static String encrypt(String inp) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(inp.getBytes(StandardCharsets.UTF_8));
            final StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                final String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

