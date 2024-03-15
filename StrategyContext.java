
public class StrategyContext implements EncryptionStrategy {
    private EncryptionStrategy strategy;

    public void setStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String encrypt(String texto) {
        return strategy.encrypt(texto);
    }

    @Override
    public String decrypt(String texto) {
        return strategy.decrypt(texto);
    }

    @Override
    public void init(Object secretKey) {
        strategy.init(secretKey);
    }
}
