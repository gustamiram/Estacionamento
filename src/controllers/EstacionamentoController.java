package controllers;

import banco.BancoDadosEstacionamento;
import models.Calcula;
import models.Cliente;

public class EstacionamentoController {
    
    public static void adicionarCliente(String placa, String nome, String modelo){
        Cliente c = new Cliente();
        
        c.setPlaca(placa);
        c.setNome(nome);
        c.setModelo(modelo);
        
        
        BancoDadosEstacionamento.getTabelaCliente().add(c);
    }
    
    public static void adicionarEntradaSaida(Calcula c){
        
        BancoDadosEstacionamento.getCalculas().add(c);
    }
    
    public static Calcula buscarVeiculoEntrada(Cliente c){
        for (Calcula calcula : BancoDadosEstacionamento.getCalculas()){
            if(calcula.getCliente() == c){
                return calcula;
            }
        }
        return null;
    }
    
    public static Cliente buscarPorPlaca(String placa){
        
        for(Cliente y : BancoDadosEstacionamento.getTabelaCliente()){
            if(y.getPlaca() == null ? placa == null : y.getPlaca().equals(placa)){
                return y;
            }
        }
        
        return null;
        
    }
}
