import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        while(true) {
            exibeMenuPrincipal();
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    menuSelecionaMoedaTipo(sc, cofrinho);
                    break;
                case 2:
                    menuRemoverMoeda(sc, cofrinho);
                    break;
                case 3:
                    cofrinho.listagemMoedas();
                    break;
                case 4:
                    cofrinho.totalConvertido();
                    break;
                case 5:
                    System.out.println("\nEncerrando a aplicação.");
                    sc.close();
                    return;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente.");
                    break;
            }
        }
    }

    public static void exibeMenuPrincipal() {
        System.out.println("\n==============================");
        System.out.println("    BEM-VINDO AO COFRINHO");
        System.out.println("==============================");
        System.out.println("Selecione a opcao desejada");
        System.out.println("1 - Adicionar uma moeda ao cofrinho");
        System.out.println("2 - Remover uma moeda do cofrinho");
        System.out.println("3 - Listar todas as moedas do cofrinho");
        System.out.println("4 - Calcular o valor total de dinheiro no cofrinho");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opcão: ");
    }

    public static void menuSelecionaMoedaTipo(Scanner sc, Cofrinho cofrinho) {
        System.out.println("\nEscolha o tipo de moeda a ser colocada no cofrinho:");
        System.out.println("1 - Dolar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        System.out.println("4 - Voltar");
        System.out.print("Escolha uma opcão: ");

        int opcao2 = sc.nextInt();
        switch (opcao2) {
            case 1:
                adicionaMoedaValorEspecifico(sc, cofrinho, Dolar.class);
                break;
            case 2:
                adicionaMoedaValorEspecifico(sc, cofrinho, Euro.class);
                break;
            case 3:
                adicionaMoedaValorEspecifico(sc, cofrinho, Real.class);
                break;
            case 4:
                System.out.println("Retornando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    // cria moeda com base na classe fornecida
    public static Moeda criarMoeda(Class<? extends Moeda> moedaClass, double valor) {
        try {
            return moedaClass.getConstructor(double.class).newInstance(valor);
        }
        catch (Exception e) {
            System.out.println("\nErro ao criar moeda. Tente novamente.");
            return null;
        }
    }

    private static void adicionaMoedaValorEspecifico(Scanner sc, Cofrinho cofrinho, Class<? extends Moeda> moedaClass) {
        System.out.println("\nQual valor da moeda você deseja adicionar?");
        System.out.println("1: 5 centavos da moeda");
        System.out.println("2: 10 centavos da moeda");
        System.out.println("3: 50 centavos da moeda");
        System.out.println("4: 1 unidade da moeda");
        System.out.println("5: Voltar");
        System.out.print("Escolha uma opcão: ");

        int opcao3 = sc.nextInt();
        Moeda moeda = null;
        switch (opcao3) {
            case 1:
                moeda = criarMoeda(moedaClass, 0.05);
                break;
            case 2:
                moeda = criarMoeda(moedaClass, 0.10);
                break;
            case 3:
                moeda = criarMoeda(moedaClass, 0.50);
                break;
            case 4:
                moeda = criarMoeda(moedaClass, 1.00);
                break;
            case 5:
                return; // Voltar
            default:
                System.out.println("\nOpção inválida! Tente novamente.");
                return;
        }

        if (moeda != null) {
            cofrinho.adicionar(moeda);
        }
    }

    private static void menuRemoverMoeda(Scanner sc, Cofrinho cofrinho) {

        if (cofrinho.getListaMoedas().isEmpty()) {
            System.out.println("\n⚠ O cofrinho está vazio! Não há moedas para remover.");
        }
        else {
            System.out.println("\nSelecione a moeda a ser removida: ");
            cofrinho.listagemMoedas();
            System.out.print("\nDigite o índice da moeda a ser removida ou 0 para voltar:");
            int indice = sc.nextInt();

            if (indice > 0 && indice <= cofrinho.getListaMoedas().size()) {
                Moeda moedaRemover = cofrinho.getListaMoedas().get(indice - 1);
                cofrinho.remover(moedaRemover);
            }
            else if (indice == 0) {
                System.out.println("\nRetornando ao menu principal...");
            }
            else {
                System.out.println("\nIndice inválido. Tente novamente!");
            }
        }
    }
}
