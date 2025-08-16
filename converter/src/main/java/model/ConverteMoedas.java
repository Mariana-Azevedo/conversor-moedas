package model;

import services.ConsumoApi;

public class ConverteMoedas {
    public void escolhaMenu(int opcao, Long valor) {
        String entrada = "";
        String saida = "";

        switch (opcao) {
            case 1:
                entrada = "USD";
                saida = "ARS";
                break;

            case 2:
                entrada = "ARS";
                saida = "USD";
                break;

            case 3:
                entrada = "USD";
                saida = "BRL";
                break;

            case 4:
                entrada = "BRL";
                saida = "USD";
                break;

            case 5:
                entrada = "USD";
                saida = "COP";
                break;

            case 6:
                entrada = "COP";
                saida = "USD";
                break;

            default:
                System.out.println("Essa não é uma opção válida");
                break;
        }


        ConsumoApi api = new ConsumoApi();
        DadosMoedas dados = api.ConsumoMoedaApi(entrada);

        Double taxa = dados.valor().get(saida);
        Long valorConvertido = fazConvercao(valor, taxa);

        System.out.println(String.format(
                "Valor %.6f [%s] corresponde ao valor final de =>>> %.6f [%s]",
                valor.doubleValue(), entrada, valorConvertido, saida));

    }

    public Long fazConvercao(Long valor, Double taxa) {
        return (long) (valor * taxa);
    }
}
