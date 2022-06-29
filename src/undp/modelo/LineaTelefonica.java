package undp.modelo;

public class LineaTelefonica {
    // atributos / propiedades
    private int numeroLlamadas;

    private int numeroMinutos;

    private double costoLlamadas;

    // metodos
    public void inicializar()
    {
        // Inicializar los valores
        this.numeroLlamadas = 0;
        this.numeroMinutos = 0;
        this.costoLlamadas = 0;
    }

    public void reiniciar()
    {
        // Reiniciar los valores
        this.inicializar();
    }

    // Devolver el costo total de las llamadas
    public double darCostoLlamadas()
    {
        return this.costoLlamadas;
    }

    // Devolver el numero de llamadas
    public int darNumeroLlamadas()
    {
        return this.numeroLlamadas;
    }

    // Devolver el numero de minutos
    public int darNumeroMinutos()
    {
        return this.numeroMinutos;
    }

    // Agregar llamada local
    public void agregarLlamadaLocal(int minutos)
    {
        this.numeroLlamadas += 1;
        this.numeroMinutos += minutos;
        this.costoLlamadas += (minutos * 35);
    }

    // Agregar llamada larga distancia
    public void agregarLlamadaLargaDistancia(int minutos)
    {
        this.numeroLlamadas += 1;
        this.numeroMinutos += minutos;
        this.costoLlamadas += (minutos * 380);
    }

    // Agregar llamada celular
    public void agregarLlamadaCelular(int minutos)
    {
        this.numeroLlamadas += 1;
        this.numeroMinutos += minutos;
        this.costoLlamadas += (minutos * 999);
    }
}
