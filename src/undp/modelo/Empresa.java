package undp.modelo;

public class Empresa {
    // Atributos / propiedades
    private LineaTelefonica linea1;

    private LineaTelefonica linea2;

    private LineaTelefonica linea3;

    // Metodos
    // Inicializar las lineas telefonicas de la empresa
    public void inicialiar()
    {
        // Inicializar linea1
        this.linea1 = new LineaTelefonica();
        linea1.inicializar();

        // Inicializar linea2
        this.linea2 = new LineaTelefonica();
        linea2.inicializar();

        // Inicializar linea3
        this.linea3 = new LineaTelefonica();
        linea3.inicializar();
    }

    // Devolver linea1
    public LineaTelefonica darLinea1()
    {
        return this.linea1;
    }

    // Devolver linea2
    public LineaTelefonica darLinea2()
    {
        return this.linea2;
    }

    // Devolver linea3
    public LineaTelefonica darLinea3()
    {
        return this.linea3;
    }

    // Agregar una llamada local a linea1
    public void agregarLlamadaLocalLinea1(int minutos)
    {
        this.linea1.agregarLlamadaLocal(minutos);
    }

    // Agregar una llamada local a linea2
    public void agregarLlamadaLocalLinea2(int minutos)
    {
        this.linea2.agregarLlamadaLocal(minutos);
    }

    // Agregar una llamada local a linea3
    public void agregarLlamadaLocalLinea3(int minutos)
    {
        this.linea3.agregarLlamadaLocal(minutos);
    }

    // Agregar una llamada de larga distancia a linea1
    public void agregarLlamadaLargaDistanciaLinea1(int minutos)
    {
        this.linea1.agregarLlamadaLargaDistancia(minutos);
    }

    // Agregar una llamada de larga distancia a linea2
    public void agregarLlamadaLargaDistanciaLinea2(int minutos)
    {
        this.linea2.agregarLlamadaLargaDistancia(minutos);
    }

    // Agregar una llamada de larga distancia a linea3
    public void agregarLlamadaLargaDistanciaLinea3(int minutos)
    {
        this.linea3.agregarLlamadaLargaDistancia(minutos);
    }

    // Agregar una llamada a celular a linea1
    public void agregarLlamadaCelularLinea1(int minutos)
    {
        this.linea1.agregarLlamadaCelular(minutos);
    }

    // Agregar una llamada a celular a linea2
    public void agregarLlamadaCelularLinea2(int minutos)
    {
        this.linea2.agregarLlamadaCelular(minutos);
    }

    // Agregar una llamada a celular a linea3
    public void agregarLlamadaCelularLinea3(int minutos)
    {
        this.linea3.agregarLlamadaCelular(minutos);
    }

    // Devolver total numero de llamadas
    public int darTotalNumeroLlamadas()
    {
        int total = linea1.darNumeroLlamadas() + linea2.darNumeroLlamadas() + linea3.darNumeroLlamadas();

        return total;
    }

    // Devolver total minutos
    public int darTotalMinutos()
    {
        int total = linea1.darNumeroMinutos() + linea2.darNumeroMinutos() + linea3.darNumeroMinutos();

        return total;
    }

    // Devolver el costo total de las llamadas
    public double darTotalCostoLlamadas()
    {
        double total = linea1.darCostoLlamadas() + linea2.darCostoLlamadas() + linea3.darCostoLlamadas();

        return total;
    }

    // Devolver el costo promedio por minuto
    public double darCostoPromedioMinuto()
    {
        double promedio = this.darTotalCostoLlamadas() / this.darTotalMinutos();

        return promedio;
    }

    // Reiniciar las lineas telefonicas
    public void reiniciar()
    {
        this.linea1.reiniciar();
        this.linea2.reiniciar();
        this.linea3.reiniciar();
    }
}
