public class Dolar extends Moeda{

    public Dolar(double quantidade) {
        super(quantidade);
    }

    @Override
    public double getCotacao() {
        // cotacao 24/02/2025
        return 5.73;
    }
}
