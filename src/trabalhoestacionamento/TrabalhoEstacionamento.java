package trabalhoestacionamento;

import banco.BancoDadosEstacionamento;
import views.EstacionamentoView;

public class TrabalhoEstacionamento {
   
    public static void main(String[] args) {
        BancoDadosEstacionamento.inicializarBanco();
        BancoDadosEstacionamento.inicializarCalcula();

        EstacionamentoView estacionamentoView = new EstacionamentoView();
        
        while (true) {
            estacionamentoView.exibirMenuCliente();
        }
    }
}
