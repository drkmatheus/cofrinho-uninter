import java.util.HashMap;

public abstract class Moeda {
    private double quantidade;
    private double preco;

    public Moeda(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void info(int indice) {
        System.out.println("\n==============================");
        System.out.println("Indice: " + (indice + 1) + " | Moeda: " + getClass().getName() + " | Quantidade: " + quantidade);
        System.out.println("==============================");
    }

    public void converter(double preco) {
        double quantidadeConvertido = this.quantidade * preco;
        System.out.println("\n==============================");
        System.out.println("O valor em real de " + getClass().getName() + " é: " + quantidadeConvertido);
        System.out.println("==============================");
    }

    public abstract double getCotacao();
}
