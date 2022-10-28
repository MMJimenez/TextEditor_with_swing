package org.example.view;

import org.example.controller.FileHandler;
import org.example.model.FontFormat;

import javax.swing.JOptionPane;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.text.*;
/**
 * @author admin
 */

public class MainWindow extends javax.swing.JFrame {
    /**
     * Creates new form MainWindow
     */

    public static FontFormat fontFormatMainWindow;

    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneMain = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        txtFont = new javax.swing.JLabel();
        lblFontAndSize = new javax.swing.JLabel();
        txtMark = new javax.swing.JLabel();
        txtCount = new javax.swing.JLabel();
        lblCountChars = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemNew = new javax.swing.JMenuItem();
        menuItemOpen = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        menuItemSaveWith = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        menuOptions = new javax.swing.JMenu();
        menuItemFontFormat = new javax.swing.JMenuItem();
        menuItemAbout = new javax.swing.JMenuItem();

        setTitle("Editor de texto");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textPaneMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textPaneMain.setPreferredSize(new java.awt.Dimension(500, 400));
        jScrollPane1.setViewportView(textPaneMain);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        //txtFont.setText("Fuente: ");
        //txtFont.setToolTipText("");
        txtFont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 7, 0, 0));
        jPanel1.add(txtFont);

        //lblFontAndSize.setText("Helvetica (15)");
        lblFontAndSize.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 7));
        jPanel1.add(lblFontAndSize);

        //txtMark.setText("|");
        jPanel1.add(txtMark);

        //txtCount.setText("Carácteres: ");
        txtCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 7, 0, 0));
        jPanel1.add(txtCount);

        //lblCountChars.setText("100");
        lblCountChars.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 7));
        jPanel1.add(lblCountChars);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        menuFile.setText("Archivo");

        menuItemNew.setText("Nuevo");
        menuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewActionPerformed(evt);
            }
        });
        menuFile.add(menuItemNew);

        menuItemOpen.setText("Abrir");
        menuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenActionPerformed(evt);
            }
        });
        menuFile.add(menuItemOpen);

        menuItemSave.setText("Guardar");
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSave);

        menuItemSaveWith.setText("Guardar como ...");
        menuItemSaveWith.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveWithActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSaveWith);

        menuItemExit.setText("Salir");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuFile.add(menuItemExit);

        jMenuBar1.add(menuFile);

        menuOptions.setText("Opciones");

        menuItemFontFormat.setText("Formato Fuente");
        menuItemFontFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFontFormatActionPerformed(evt);
            }
        });
        menuOptions.add(menuItemFontFormat);

        menuItemAbout.setText("Acerca de ...");
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        menuOptions.add(menuItemAbout);

        jMenuBar1.add(menuOptions);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>

    private void menuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();

        var filtro = new FileNameExtensionFilter("*.TXT", "txt");

        chooser.setFileFilter(filtro);

        int selection = chooser.showOpenDialog(this);

        
        if(selection == JFileChooser.APPROVE_OPTION){
            
            File file = chooser.getSelectedFile();
            
            FileHandler.savedFile = file;
            
            try(FileReader fr = new FileReader(file)){
                String s = "";
                int value = fr.read();
                while(value != -1){
                    s += (char)value;
                    value=fr.read();
                }
                this.textPaneMain.setText(s);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private void menuItemFontFormatActionPerformed(java.awt.event.ActionEvent evt) {
        //textPaneMain.setFont(new Font("Arial", Font.PLAIN, 20));
        showFontFormat();
    }

    private void menuItemNewActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fc = new JFileChooser();

        int selection = fc.showSaveDialog(this);

        if(selection == JFileChooser.APPROVE_OPTION){

            File file = fc.getSelectedFile();
            FileHandler.savedFile = file;
        }
    }

    //este es salir

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt){
        
        if(FileHandler.savedFile == null)            showErrorDialog();
        else{
            saveAllDatta(FileHandler.savedFile);
            System.exit(0);
        }        

    }

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {
        showAboutDialog();
    }

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {

        
        if(FileHandler.savedFile == null)            showErrorDialog();
        else                                         saveAllDatta(FileHandler.savedFile);
    }

    //este es el guardar como

    private void menuItemSaveWithActionPerformed(java.awt.event.ActionEvent evt){
        
        JFileChooser fc = new JFileChooser();
 
        int selection = fc.showSaveDialog(this);

        if(selection == JFileChooser.APPROVE_OPTION){

            File file = fc.getSelectedFile();
            FileHandler.savedFile = file;

            saveAllDatta(file);            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    public void showAboutDialog() {
        String message = """
                Autores:
                Pablo Jim\u00e9nez Juarez
                Miguel Mu\u00f1oz Jim\u00e9nez
                Tecnologías usadas:
                Java y swing
                """;
        String title = "Acerca de ...";
        JOptionPane.showMessageDialog(this, message, title,
                JOptionPane.PLAIN_MESSAGE);
    }

    
    public void showErrorDialog(){
        String message = """
                         ¡No hay fichero seleccionado!
                         Prueba la opción guardar como.    
                         """;
            String title = "ERROR";
            JOptionPane.showMessageDialog(this, message, title,
                    JOptionPane.ERROR_MESSAGE);
    }
    
    public void saveAllDatta(File file) {
        try(FileWriter fw = new FileWriter(file)){

            fw.write(this.textPaneMain.getText());

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    

    public void showFontFormat() {
        var fontFormatDialog = new FontFormatDialog(this, true);
        fontFormatDialog.setVisible(true);
        insertStyleInText();
    }

    public int getPositionCaret() {
        Caret caret = textPaneMain.getCaret();
        return caret.getDot();
    }

    public void insertStyleInText() {
        SimpleAttributeSet set = changeSimpleAttributeSet();
        Document doc = textPaneMain.getStyledDocument();

        String textToInsert = "\u202C";

        try {
            doc.insertString(getPositionCaret(), textToInsert, set);
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    public SimpleAttributeSet changeSimpleAttributeSet() {
        SimpleAttributeSet set = new SimpleAttributeSet();
        textPaneMain.setCharacterAttributes(set, true);

        StyleConstants.setForeground(set, FontFormat.foregroundColor);
        StyleConstants.setBackground(set, FontFormat.backgroundColor);

        StyleConstants.setFontFamily(set, FontFormat.name);
        StyleConstants.setFontSize(set, FontFormat.size);

        switch (FontFormat.style) {
            case 1:
                StyleConstants.setBold(set, true);
                break;
            case 2:
                StyleConstants.setItalic(set, true);
                break;
            case 3:
                StyleConstants.setBold(set, true);
                StyleConstants.setItalic(set, true);
                break;
            default:
                StyleConstants.setBold(set, false);
                StyleConstants.setItalic(set, false);
                break;
        }
        return set;
    }

    // Variables declaration - do not modify
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountChars;
    private javax.swing.JLabel lblFontAndSize;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemFontFormat;
    private javax.swing.JMenuItem menuItemNew;
    private javax.swing.JMenuItem menuItemOpen;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenuItem menuItemSaveWith;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JTextPane textPaneMain;
    private javax.swing.JLabel txtCount;
    private javax.swing.JLabel txtFont;
    private javax.swing.JLabel txtMark;
    // End of variables declaration
}
