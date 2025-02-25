public class Real extends Moeda {
    public Real(double quantidade) {
        super(quantidade);
    }

    @Override
    public double getCotacao() {
        // moeda base, logo vale 1
        return 1;
    }
}
