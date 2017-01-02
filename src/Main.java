import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {

  public static void main(String[] args) {

    int size = 0x0fffffff;
    Random random = new Random();
    StringBuilder string = new StringBuilder(size);
    for (int i = size; i > 0; --i) {
      string.append((char) (random.nextInt(26) + 'a'));
    }

    byte[] text = string.toString().getBytes(StandardCharsets.UTF_8);

    byte[] hash = SHA256.getHash(text);

    StringBuilder sh = new StringBuilder(64);
    for (int i = 0; i < 32; i++) {
      sh.append(String.format("%02x", hash[i]));
    }

    System.out.println("hash: " + sh);
  }
}
