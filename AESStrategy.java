

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESStrategy implements EncryptionStrategy {
    private SecretKey secretKey;

    @Override
    public String encrypt(String texto) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoBytes = texto.getBytes();
            byte[] bytesEncriptados = cipher.doFinal(textoBytes);
            String textoEncriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
            System.out.println("Encrypted text " + textoEncriptado);
            return textoEncriptado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String decrypt(String texto) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textoBytes = Base64.getDecoder().decode(texto);
            byte[] bytesDecriptados = cipher.doFinal(textoBytes);
            String textoDecriptado = new String(bytesDecriptados);
            System.out.println("Decrypt text " + textoDecriptado);
            return textoDecriptado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void init(Object secretKey) {
        if (secretKey instanceof SecretKey) {
            this.secretKey = (SecretKey) secretKey;
        } else {
            System.out.println("Wrong type for AES! The key must be a SecretKey");
        }
    }

    public SecretKey generarAESKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            return keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
