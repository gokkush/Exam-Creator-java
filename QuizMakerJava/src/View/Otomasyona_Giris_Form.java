package View;



import Presenter.OtomasyonaGirisPresenter;
import View.IViewOtomasyonaGiris;
import java.awt.Color;
import java.awt.Toolkit;
import static java.lang.System.exit;
import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;
import soruhazirlama.progressP;
import soruhazirlama.progressP2;

public class Otomasyona_Giris_Form extends javax.swing.JFrame implements IViewOtomasyonaGiris{
private static Otomasyona_Giris_Form form = new Otomasyona_Giris_Form();
public static Otomasyona_Giris_Form yeniFormOlustur(){
   return form;
}
    
    
   OtomasyonaGirisPresenter presenter;
    public Otomasyona_Giris_Form() {
        setResizable(false);
        setIcon();
       
        
        initComponents();
          presenter = new   OtomasyonaGirisPresenter(this);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_Kadi = new javax.swing.JLabel();
        lb_Sifre = new javax.swing.JLabel();
        txt_Kadi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_Sifre = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Giriş Sayfası");
        setBackground(new java.awt.Color(153, 255, 255));
        setLocation(new java.awt.Point(500, 400));
        setName("frm_Giris"); // NOI18N

        lb_Kadi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kilit-1.png"))); // NOI18N
        lb_Kadi.setText("--");

        lb_Sifre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sifre-2.png"))); // NOI18N
        lb_Sifre.setText("--");

        txt_Kadi.setName("txt_Kadi"); // NOI18N
        txt_Kadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_KadiActionPerformed(evt);
            }
        });
        txt_Kadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_KadiKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/giris.png"))); // NOI18N
        jButton1.setText("Giriş");
        jButton1.setName("btn_Giris"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cikis.png"))); // NOI18N
        jButton2.setText("Çıkış");
        jButton2.setName("btn_Cikis"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_Sifre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_Sifre.setName("txt_Sifre"); // NOI18N
        txt_Sifre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SifreKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/baslik.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dpu_logo2.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/muh_logo2.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kilit.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_Kadi)
                    .addComponent(lb_Sifre, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_Sifre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_Kadi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_Kadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Kadi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_Sifre)
                            .addComponent(txt_Sifre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setSize(new java.awt.Dimension(531, 292));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_KadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_KadiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_KadiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try {
        new progressP2().setVisible(true);
        
        this.dispose();
    } catch (Exception ex) {
        Logger.getLogger(Otomasyona_Giris_Form.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

  
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        presenter.GirisYap();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_SifreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SifreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
          presenter.GirisYap();
        }
        
        
    }//GEN-LAST:event_txt_SifreKeyPressed

    private void txt_KadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_KadiKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
        txt_Sifre.requestFocus();    
        }
    }//GEN-LAST:event_txt_KadiKeyPressed

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
            java.util.logging.Logger.getLogger(Otomasyona_Giris_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Otomasyona_Giris_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Otomasyona_Giris_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Otomasyona_Giris_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Otomasyona_Giris_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private static javax.swing.JLabel lb_Kadi;
    private static javax.swing.JLabel lb_Sifre;
    private static javax.swing.JTextField txt_Kadi;
    private static javax.swing.JPasswordField txt_Sifre;
    // End of variables declaration//GEN-END:variables

    public static JLabel getLb_Kadi() {
        return lb_Kadi;
    }

    public static void setLb_Kadi(JLabel lb_Kadi) {
        Otomasyona_Giris_Form.lb_Kadi = lb_Kadi;
    }

    public static JLabel getLb_Sifre() {
        return lb_Sifre;
    }

    public static void setLb_Sifre(JLabel lb_Sifre) {
        Otomasyona_Giris_Form.lb_Sifre = lb_Sifre;
    }

    public static JTextField getTxt_Kadi() {
        return txt_Kadi;
    }

    public static void setTxt_Kadi(JTextField txt_Kadi) {
        Otomasyona_Giris_Form.txt_Kadi = txt_Kadi;
    }

    public static JPasswordField getTxt_Sifre() {
        return txt_Sifre;
    }

    public static void setTxt_Sifre(JPasswordField txt_Sifre) {
        Otomasyona_Giris_Form.txt_Sifre = txt_Sifre;
    }

    
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/logo2.png")));
    }

    @Override
    public void GirisIslemi(String mesaj) {
       JOptionPane.showConfirmDialog(null, mesaj,"Giriş Başarılı",JOptionPane.PLAIN_MESSAGE);
      
    
    }

    @Override
    public void Gir() {
         this.dispose();
    
    }
}
