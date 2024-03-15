
public interface EncryptionStrategy {
    String encrypt(String texto);
    String decrypt(String texto);
    void init(Object secretKey);
}
