import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RC4Test {
    private RC4 rc4 = new RC4("Key".getBytes());
    @Test
    void encrypt() {
        byte[] ciphertext = rc4.encrypt("Plaintext".getBytes());
        byte[] expected = new byte[] {(byte) 0xBB, (byte) 0xF3, 0x16, (byte) 0xE8, (byte) 0xD9, 0x40, (byte) 0xAF, 0x0A, (byte) 0xD3};
        assertArrayEquals(expected, ciphertext);
    }

    @Test
    void decrypt() {
        byte[] ciphertext = new byte[] {(byte) 0xBB, (byte) 0xF3, 0x16, (byte) 0xE8, (byte) 0xD9, 0x40, (byte) 0xAF, 0x0A, (byte) 0xD3};
        String actual = new String(rc4.decrypt(ciphertext));
        assertEquals("Plaintext", actual);
    }
}