package models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calcula {

    private int horaEntrada;
    private int minutoEntrada;
    private int horaSaida;
    private int minutoSaida;
    private GregorianCalendar entrada;
    private GregorianCalendar saida;
    private Cliente cliente;

    public Calcula() {
        this.entrada = (GregorianCalendar) Calendar.getInstance();
    }

    public void registrarSaida() {
        this.saida = (GregorianCalendar) Calendar.getInstance();
    }

    public long obterMinutos(){
        long diff = saida.getTimeInMillis() - entrada.getTimeInMillis();
        long segundos = diff / 1000;
        long minutos = segundos / 60;
        return minutos;
    } 
    
    public void calcular() {
        long minutos = obterMinutos();
        System.out.println("");
        System.out.println("Total de permanência do veículo: " + minutos + " minutos.");
    }

    public GregorianCalendar getEntrada() {
        return entrada;
    }

    public void setEntrada(GregorianCalendar entrada) {
        this.entrada = entrada;
    }

    public GregorianCalendar getSaida() {
        return saida;
    }

    public void setSaida(GregorianCalendar saida) {
        this.saida = saida;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    public void setMinutoEntrada(int minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }

    public int getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(int horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getMinutoSaida() {
        return minutoSaida;
    }

    public void setMinutoSaida(int minutoSaida) {
        this.minutoSaida = minutoSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
