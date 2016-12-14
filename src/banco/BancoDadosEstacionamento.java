package banco;

import java.util.ArrayList;
import java.util.List;
import models.Calcula;
import models.Cliente;

public class BancoDadosEstacionamento {
    
    private static List<Calcula> calculas;
    
    public static List<Calcula> getCalculas(){
        return calculas;
    }
    
    public static void inicializarCalcula(){
        calculas = new ArrayList<Calcula>();
    }
       
    private static List<Cliente> tabelaCliente;

    public static List<Cliente> getTabelaCliente() {
        return tabelaCliente;
    }
    
    public static void inicializarBanco(){
        tabelaCliente = new ArrayList<Cliente>();
    }
}
