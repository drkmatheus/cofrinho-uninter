public class Euro extends Moeda{
    public Euro(double quantidade) {
        super(quantidade);

    }

    @Override
    public double getCotacao() {
        // cotacao 24/02/2025
        return 6;
    }
}
