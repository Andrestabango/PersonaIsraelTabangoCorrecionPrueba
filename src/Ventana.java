import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JPanel Ventana;
    private JTextField cedulatextField1;
    private JTextField nombretextField1;
    private JTextField edadtextField1;
    private JComboBox cbgeneroBox1;
    private JComboBox cbregionBox2;
    private JButton AÑADIRButton;
    private JList list1;
    private JButton cbgeneroButton;
    private JButton BUSCAREDADREGIONButton;
    private JList list2;

    private Cola empleados=new Cola();

    DefaultListModel dlm =new DefaultListModel<>();
    DefaultListModel dlm1 =new DefaultListModel<>();
    public Ventana(){

        AÑADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    empleados.encolar(cedulatextField1.getText(),nombretextField1.getText(),Integer.parseInt(edadtextField1.getText()),cbgeneroBox1.getSelectedItem().toString(),cbregionBox2.getSelectedItem().toString());

                List<PersonaIsraelTabango> lista =empleados.listaPersonas();
                    llenarJlist(lista,list1,dlm);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                setearCampos();
            }
        });
        cbgeneroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<PersonaIsraelTabango>listaGE=empleados.listaEdadGenero(Integer.parseInt(edadtextField1.getText()),cbgeneroBox1.getSelectedItem().toString());
                        if(listaGE.isEmpty())
                            JOptionPane.showMessageDialog(null,"No hay elementos que coincidan con la busqueda");
                        else llenarJlist(listaGE, list2,dlm1);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                setearCampos();
            }
        });
        BUSCAREDADREGIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<PersonaIsraelTabango>listaER=empleados.listaEdadRegion(Integer.parseInt(edadtextField1.getText()),cbregionBox2.getSelectedItem().toString());
                    if(listaER.isEmpty())
                        JOptionPane.showMessageDialog(null,"No hay elementos que coincidan con la busqueda");
                    else llenarJlist(listaER, list2,dlm1);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                setearCampos();
            }
        });
    }


    public void setearCampos(){
        cedulatextField1.setText("");
        nombretextField1.setText("");
        edadtextField1.setText("");
        cbgeneroBox1.setSelectedIndex(0);
        cbregionBox2.setSelectedIndex(0);

    }

    public void llenarJlist(List<PersonaIsraelTabango> lista, JList listMostrar,DefaultListModel dl){
        dl.removeAllElements();
        Collections.sort(lista);
        for(PersonaIsraelTabango p: lista)
            dl.addElement(p);
        listMostrar.setModel(dl);//lista 1 de mi interfaz
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
