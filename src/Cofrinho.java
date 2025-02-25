import java.util.ArrayList;

public class Cofrinho {
    private ArrayList<Moeda> listaMoedas;

    public Cofrinho() {
        listaMoedas = new ArrayList<>();
    }

    public ArrayList<Moeda> getListaMoedas() {
        return listaMoedas;
    }

    public void setListaMoedas(ArrayList<Moeda> listaMoedas) {
        this.listaMoedas = listaMoedas;
    }

    public boolean adicionar(Moeda m) {
        boolean sucesso = this.listaMoedas.add(m);
        if (sucesso) {
            System.out.println("\n✔ Moeda adicionada com sucesso!");
        }
        return sucesso;
    }

    public boolean remover(Moeda m) {

        // Verifica se a lista está vazia
        if (listaMoedas.isEmpty()) {
            System.out.println("\n⚠ O cofrinho está vazio! Não há moedas para remover.");
            return false;  // Retorna false para indicar que a remoção não ocorreu
        }

        // Tenta remover a moeda da lista
        boolean resultado = listaMoedas.remove(m);

        // Se a moeda não foi encontrada na lista, a remoção será falsa
        if (resultado) {
            System.out.println("\n✔ Moeda removida com sucesso!");
        } else {
            System.out.println("\n❌ Moeda não encontrada no cofrinho.");
        }
        return resultado;
    }

    public void listagemMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("\n⚠ O cofrinho está vazio.");
            return;
        }

        System.out.println("\n📜 Lista de Moedas no Cofrinho:");

        int indice = 0;
        for (Moeda m : listaMoedas) {
            m.info(indice); // Exibe a informação de cada moeda com seu índice
            indice++;
        }
    }

    public void totalConvertido() {
        if (listaMoedas.isEmpty()) {
            System.out.println("\n⚠ O cofrinho está vazio.");
            return;
        }

        double total = 0.0;

        // Soma o valor de todas as moedas no cofrinho com suas respectivas cotações
        for (Moeda m : listaMoedas) {
            double cotacao = m.getCotacao();
            total += m.getQuantidade() * cotacao;
        }

        // Exibe o total convertido
        System.out.println("\n==============================");
        System.out.println("💰 Total convertido para Real: R$ " + total);
        System.out.println("==============================");
    }
}
