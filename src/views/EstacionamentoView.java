package views;

import banco.BancoDadosEstacionamento;
import controllers.EstacionamentoController;
import java.util.Calendar;
import java.util.Scanner;
import models.Calcula;
import models.Cliente;

public class EstacionamentoView {

    Scanner scan = new Scanner(System.in);

    public void exibirMenuCliente() {
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Selecione um número do MENU:");
        System.out.println("");
        System.out.println("1 - Cadastrar Novo Cliente");
        System.out.println("2 - Listar Clientes Cadastrados");
        System.out.println("3 - Procurar Cliente Cadastrado");
        System.out.println("4 - Registrar Entrada de Veículo");
        System.out.println("5 - Registrar Saída de Veículo");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.print("Opção desejada: ");
        int opcao = scan.nextInt();
        scan.nextLine();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        switch (opcao) {
            case 1:
                adicionarCliente();
                break;
            case 2:
                listarCliente();
                break;
            case 3:
                procurarCliente();
                break;
            case 4:
                registrarEntrada();
                break;
            case 5:
                registrarSaida();
                break;
        }
    }

    private void adicionarCliente() {

        System.out.println("");

        System.out.print("Digite o nome do Cliente : ");
        String nome = scan.nextLine();

        System.out.print("Digite a placa do Veículo: ");
        String placa = scan.nextLine();

        System.out.print("Digite o modelo do Veículo: ");
        String modelo = scan.nextLine();

        EstacionamentoController.adicionarCliente(placa, nome, modelo);

        System.out.println("");
    }

    private void listarCliente() {

        System.out.println("");
        System.out.println("{.|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|.}");

        for (Cliente c : BancoDadosEstacionamento.getTabelaCliente()) {

            System.out.println("");
            System.out.println("Sr(a): " + c.getNome());
            System.out.println("Placa: " + c.getPlaca());
            System.out.println("Modelo do Veículo: " + c.getModelo());
            System.out.println("");
        }
        System.out.println("{.|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|.}");
        System.out.println("");
    }

    private void procurarCliente() {

        System.out.println("");
        System.out.print("Digite a placa do Veículo: ");
        String placa = scan.nextLine();

        Cliente y = EstacionamentoController.buscarPorPlaca(placa);

        if (y != null) {

            System.out.println("Sr(a): " + y.getNome());
            System.out.println("Modelo do Veículo: " + y.getModelo());
            System.out.println("Placa: " + y.getPlaca());
            System.out.println("");
            System.out.println("");

        } else {

            System.out.println("Cliente não encontrado, por favor, insira a placa novamente");
            System.out.println("");
            System.out.println("");
        }
    }

    private double obterValor(long minutos) {
        if (minutos < 10) {
            return 8.00;
            } else if (minutos < 30) {
                return 10.00;
                } else if (minutos < 60 ) {
                    return 15.00;
                    } else {
                    return (minutos / 60) * 15.00 ;
                    } 
    }

    private void registrarEntrada() {

        System.out.println("");
        System.out.print("Digite a placa do Veículo: ");
        String placa = scan.nextLine();

        Cliente y = EstacionamentoController.buscarPorPlaca(placa);

        if (y != null) {

            System.out.println("Veículo encontrado");
            System.out.println("");

            Calcula e = new Calcula();
            e.setCliente(y);

            EstacionamentoController.adicionarEntradaSaida(e);

            System.out.println("Entrada registrada com Sucesso");
            System.out.println("");

            System.out.println("Proprietário(a): " + y.getNome());
            System.out.println("Placa: " + y.getPlaca());
            System.out.print(String.format("Horário de Entrada: %02d:%02d", e.getEntrada().get(Calendar.HOUR_OF_DAY), e.getEntrada().get(Calendar.MINUTE)));
            System.out.println("");
            System.out.println("");

        } else {

            System.out.println("Veículo não encontrado, por favor, insira a placa novamente");
            System.out.println("");
            System.out.println("");
        }
    }

    private void registrarSaida() {

        System.out.println("");

        System.out.print("Digite a placa do Veículo: ");
        String placa = scan.nextLine();

        Cliente y = EstacionamentoController.buscarPorPlaca(placa);

        if (y != null) {
            Calcula c = EstacionamentoController.buscarVeiculoEntrada(y);

            if (c != null) {
                System.out.println("Veículo encontrado");
                c.registrarSaida();
                System.out.println("");

                System.out.println(String.format("Horário de Entrada: %02d:%02d", c.getEntrada().get(Calendar.HOUR_OF_DAY), c.getEntrada().get(Calendar.MINUTE)));    
                System.out.println(String.format("Horário de Saída: %02d:%02d", c.getSaida().get(Calendar.HOUR_OF_DAY), c.getSaida().get(Calendar.MINUTE)));
                c.calcular();

                long minutos = c.obterMinutos();
                double valor = obterValor(minutos);
                System.out.println("Valor total a pagar R$" + valor );
                System.out.println("");
                System.out.println("Sr(a) Proprietário(a) " + y.getNome() + " -----> Agradecemos a preferência :)");
                System.out.println("");

            } else {
                System.out.println("Veículo não encontrado, por favor, insira a placa novamente");
                System.out.println("");
                System.out.println("");
            }
        }
    }
}
