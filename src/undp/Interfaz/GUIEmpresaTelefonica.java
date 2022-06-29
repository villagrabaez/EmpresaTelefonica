package undp.Interfaz;

import undp.modelo.Empresa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class GUIEmpresaTelefonica extends JFrame {
    private Empresa empresa;
    private JPanel jpPrincipal;
    private JButton btnReiniciar;
    private JButton btnOpcion1;
    private JButton btnOpcion2;
    private JPanel jpOpciones;
    private JButton agregarLlamadaButtonLinea1;
    private JButton agregarLlamadaButtonLinea2;
    private JButton agregarLlamadaButtonLinea3;
    private JLabel lbTotalCostoLlamada;
    private JLabel lbTotalLlamadas;
    private JLabel lbTotalMinutos;
    private JLabel lbCostoPromedioMinuto;
    private JLabel lbCostoTotalLinea1;
    private JLabel lbNumeroLlamadasLinea1;
    private JLabel lbNumeroMinutosLinea1;
    private JLabel lbCostoTotalLinea2;
    private JLabel lbNumeroLlamadasLinea2;
    private JLabel lbNumeroMinutosLinea2;
    private JLabel lbCostoTotalLinea3;
    private JLabel lbNumeroLlamadasLinea3;
    private JLabel lbNumeroMinutosLinea3;

    public GUIEmpresaTelefonica()
    {
        // Inicializar la empresa
        empresa = new Empresa();
        empresa.inicialiar();

        setContentPane(jpPrincipal);
        setTitle("Empresa de Lineas Telefonicas");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800, 600);

        // Panel Totales
        lbTotalCostoLlamada.setText("Gs. " + empresa.darTotalCostoLlamadas());
        lbTotalLlamadas.setText("Total Llamadas: " + empresa.darTotalNumeroLlamadas());
        lbTotalMinutos.setText("Total de Minutos: " + empresa.darTotalMinutos());
        if ( ! Double.isNaN( empresa.darCostoPromedioMinuto() ) ) {
            lbCostoPromedioMinuto.setText("Costo Promedio por Minuto: " + formatearValor( empresa.darCostoPromedioMinuto() ));
        } else {
            lbCostoPromedioMinuto.setText("Costo Promedio por Minuto: N/A");
        }

        // Panel Linea1
        lbCostoTotalLinea1.setText("Gs. " + empresa.darLinea1().darCostoLlamadas());
        lbNumeroLlamadasLinea1.setText("Número Llamadas: " + empresa.darLinea1().darNumeroLlamadas());
        lbNumeroMinutosLinea1.setText("Nùmero de Minutos: " + empresa.darLinea1().darNumeroMinutos());

        // Panel Linea2
        lbCostoTotalLinea2.setText("Gs. " + empresa.darLinea2().darCostoLlamadas());
        lbNumeroLlamadasLinea2.setText("Número Llamadas: " + empresa.darLinea2().darNumeroLlamadas());
        lbNumeroMinutosLinea2.setText("Nùmero de Minutos: " + empresa.darLinea2().darNumeroMinutos());

        // Panel Linea3
        lbCostoTotalLinea3.setText("Gs. " + empresa.darLinea3().darCostoLlamadas());
        lbNumeroLlamadasLinea3.setText("Número Llamadas: " + empresa.darLinea3().darNumeroLlamadas());
        lbNumeroMinutosLinea3.setText("Nùmero de Minutos: " + empresa.darLinea3().darNumeroMinutos());

        agregarLlamadaButtonLinea1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLlamada(1 );
            }
        });
        agregarLlamadaButtonLinea2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLlamada( 2 );
            }
        });
        agregarLlamadaButtonLinea3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLlamada( 3 );
            }
        });
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciar();
            }
        });
    }

    public static void main(String[] args) {
        GUIEmpresaTelefonica empresaTelefonica = new GUIEmpresaTelefonica();
    }

    public void agregarLlamada( int numeroLinea )
    {
        String minutos = JOptionPane.showInputDialog(null, "Número de Minutos");

        if ( minutos != null ) {

            int min = Integer.parseInt(minutos);

            if ( min <= 0 ) {
                JOptionPane.showMessageDialog(this, "El número de minutos debe ser mayor a cero", "Error", JOptionPane.ERROR_MESSAGE);

                return;
            }

            Object[] possibilities = {"Local", "Larga distancia", "Celular"};
            String tipo = (String) JOptionPane.showInputDialog(null, "Tipo de Llamada", "Tipo", JOptionPane.QUESTION_MESSAGE, null, possibilities, "Local");

            if ( tipo != null ) {
                if ( numeroLinea == 1 ) {
                    if ("Local".equals( tipo )) {
                        empresa.agregarLlamadaLocalLinea1( min );
                    } else if ("Larga distancia".equals( tipo )) {
                        empresa.agregarLlamadaLargaDistanciaLinea1( min );
                    } else if ("Celular".equals( tipo )) {
                        empresa.agregarLlamadaCelularLinea1( min );
                    }
                } else if ( numeroLinea == 2 ) {
                    if ("Local".equals( tipo )) {
                        empresa.agregarLlamadaLocalLinea2( min );
                    } else if ("Larga distancia".equals( tipo )) {
                        empresa.agregarLlamadaLargaDistanciaLinea2( min );
                    } else if ("Celular".equals( tipo )) {
                        empresa.agregarLlamadaCelularLinea2( min );
                    }
                } else if ( numeroLinea == 3 ) {
                    if ("Local".equals( tipo )) {
                        empresa.agregarLlamadaLocalLinea3( min );
                    } else if ("Larga distancia".equals( tipo )) {
                        empresa.agregarLlamadaLargaDistanciaLinea3( min );
                    } else if ("Celular".equals( tipo )) {
                        empresa.agregarLlamadaCelularLinea3( min );
                    }
                }

                actualizar();

            }
        }
    }

    public void reiniciar()
    {
        empresa.reiniciar();
        actualizar();
    }

    public void actualizar()
    {
        // Panel Totales
        lbTotalCostoLlamada.setText("Gs. " + empresa.darTotalCostoLlamadas());
        lbTotalLlamadas.setText("Total Llamadas: " + empresa.darTotalNumeroLlamadas());
        lbTotalMinutos.setText("Total de Minutos: " + empresa.darTotalMinutos());
        if ( ! Double.isNaN( empresa.darCostoPromedioMinuto() ) ) {
            lbCostoPromedioMinuto.setText("Costo Promedio por Minuto: " + formatearValor( empresa.darCostoPromedioMinuto() ));
        } else {
            lbCostoPromedioMinuto.setText("Costo Promedio por Minuto: N/A");
        }

        // Panel Linea1
        lbCostoTotalLinea1.setText("Gs. " + empresa.darLinea1().darCostoLlamadas());
        lbNumeroLlamadasLinea1.setText("Número Llamadas: " + empresa.darLinea1().darNumeroLlamadas());
        lbNumeroMinutosLinea1.setText("Nùmero de Minutos: " + empresa.darLinea1().darNumeroMinutos());

        // Panel Linea2
        lbCostoTotalLinea2.setText("Gs. " + empresa.darLinea2().darCostoLlamadas());
        lbNumeroLlamadasLinea2.setText("Número Llamadas: " + empresa.darLinea2().darNumeroLlamadas());
        lbNumeroMinutosLinea2.setText("Nùmero de Minutos: " + empresa.darLinea2().darNumeroMinutos());

        // Panel Linea3
        lbCostoTotalLinea3.setText("Gs. " + empresa.darLinea3().darCostoLlamadas());
        lbNumeroLlamadasLinea3.setText("Número Llamadas: " + empresa.darLinea3().darNumeroLlamadas());
        lbNumeroMinutosLinea3.setText("Nùmero de Minutos: " + empresa.darLinea3().darNumeroMinutos());
    }

    private String formatearValor( double valor )
    {
        DecimalFormat df = ( DecimalFormat ) NumberFormat.getInstance();
        df.applyPattern( "Gs ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }
}
