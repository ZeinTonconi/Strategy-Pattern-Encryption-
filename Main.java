

import javax.crypto.SecretKey;

public class Main {
    public static void main(String[] args) {
        StrategyContext contexto = new StrategyContext();
        String texto = "Zeincho";
          
        AESStrategy AESStrategy = new AESStrategy();
        SecretKey AESKey = AESStrategy.generarAESKey();
      
        AESStrategy.init(AESKey);
        contexto.setStrategy(AESStrategy);

        System.out.println("Example with AES");
        System.out.println("Original text: " + texto);
        String textoEncriptado = contexto.encrypt(texto);
        contexto.decrypt(textoEncriptado);

        contexto.setStrategy(new CesarStrategy());
        contexto.init(9);
        System.out.println("Example of Cesar, with a displace of 9");
        System.out.println("Original text: " + texto);
        textoEncriptado = contexto.encrypt(texto);
        contexto.decrypt(textoEncriptado);

    }

