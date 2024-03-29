/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;




import Presenter.DersGuncellePresenter;
import com.sun.glass.events.KeyEvent;
import java.awt.Toolkit;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;




public class Ders_Guncelle_Form extends javax.swing.JInternalFrame implements IViewDersGuncelle{

    
    private DersGuncellePresenter presenter;
   
  private static Ders_Guncelle_Form form = new Ders_Guncelle_Form();
  
  public static Ders_Guncelle_Form yeniFormOlustur(){
      return form;
  }
    
   private  Ders_Guncelle_Form() {

      
        setResizable(false);
        initComponents();
       presenter = new DersGuncellePresenter(this);
      Sifirla();
          
       presenter.tabloYenile();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_Ders_Adi = new javax.swing.JTextField();
        btn_Kaydet = new javax.swing.JButton();
        btn_Kapat = new javax.swing.JButton();
        btn_Kaydet1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_Ders = new javax.swing.JTable();
        lbl_Secilen = new javax.swing.JLabel();
        btn_Yeni = new javax.swing.JButton();
        txt_Arama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ders Bilgileri Güncelleme");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ders_guncelle.png"))); // NOI18N
        jLabel3.setText("DERS GÜNCELLEME EKRANI");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Ders Adı:");

        txt_Ders_Adi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Ders_AdiKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(txt_Ders_Adi, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Ders_Adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        btn_Kaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Kaydet24x24.png"))); // NOI18N
        btn_Kaydet.setText("Kayıt Ekle / Güncelle");
        btn_Kaydet.setName("btn_Giris"); // NOI18N
        btn_Kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KaydetActionPerformed(evt);
            }
        });

        btn_Kapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sil24x24.png"))); // NOI18N
        btn_Kapat.setText("Kapat");
        btn_Kapat.setName("btn_Cikis"); // NOI18N
        btn_Kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KapatActionPerformed(evt);
            }
        });

        btn_Kaydet1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sil32x32.png"))); // NOI18N
        btn_Kaydet1.setText("Kaydı Sil");
        btn_Kaydet1.setName("btn_Giris"); // NOI18N
        btn_Kaydet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Kaydet1ActionPerformed(evt);
            }
        });

        tablo_Ders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ders Adı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_Ders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_DersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo_Ders);
        if (tablo_Ders.getColumnModel().getColumnCount() > 0) {
            tablo_Ders.getColumnModel().getColumn(0).setResizable(false);
        }

        btn_Yeni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yenile.png"))); // NOI18N
        btn_Yeni.setText("Formu Temizle");
        btn_Yeni.setName("btn_Giris"); // NOI18N
        btn_Yeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_YeniActionPerformed(evt);
            }
        });

        txt_Arama.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_AramaCaretUpdate(evt);
            }
        });
        txt_Arama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_AramaKeyPressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arama.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Arama))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Secilen))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Yeni, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btn_Kaydet1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Secilen)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Arama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Kaydet1)
                    .addComponent(btn_Kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Yeni, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
        
            
        
                                           
    
    private void btn_KaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KaydetActionPerformed
        // TODO add your handling code here:
presenter.tablodanVeriGuncelle();
presenter.tabloYenile();
    }//GEN-LAST:event_btn_KaydetActionPerformed

    private void btn_KapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KapatActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_btn_KapatActionPerformed

    private void btn_Kaydet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Kaydet1ActionPerformed
        // TODO add your handling code here:
       presenter.tablodanVeriSilme();
    }//GEN-LAST:event_btn_Kaydet1ActionPerformed

    private void tablo_DersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_DersMouseClicked
        // TODO add your handling code here:
       presenter.tablodanVeriSecme();
    }//GEN-LAST:event_tablo_DersMouseClicked

    private void btn_YeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_YeniActionPerformed
        // TODO add your handling code here:
        txt_Arama.setText(null);
     presenter.tabloYenile();
    }//GEN-LAST:event_btn_YeniActionPerformed

    private void txt_Ders_AdiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Ders_AdiKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_Ders_AdiKeyPressed

    private void txt_AramaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AramaKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txt_AramaKeyPressed

    private void txt_AramaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_AramaCaretUpdate
        // TODO add your handling code here:
   presenter.tabloYenile();
    }//GEN-LAST:event_txt_AramaCaretUpdate

    public static JLabel getLbl_Secilen() {
        return lbl_Secilen;
    }

    public static void setLbl_Secilen(JLabel lbl_Secilen) {
        Ders_Guncelle_Form.lbl_Secilen = lbl_Secilen;
    }

    public static JTextField getTxt_Arama() {
        return txt_Arama;
    }

    public static void setTxt_Arama(JTextField txt_Arama) {
        Ders_Guncelle_Form.txt_Arama = txt_Arama;
    }

    public static JTextField getTxt_Ders_Adi() {
        return txt_Ders_Adi;
    }

    public static void setTxt_Ders_Adi(JTextField txt_Ders_Adi) {
        Ders_Guncelle_Form.txt_Ders_Adi = txt_Ders_Adi;
    }

    public static JTable getTablo_Ders() {
        return tablo_Ders;
    }

    public static void setTablo_Ders(JTable tablo_Ders) {
        Ders_Guncelle_Form.tablo_Ders = tablo_Ders;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Kapat;
    private javax.swing.JButton btn_Kaydet;
    private javax.swing.JButton btn_Kaydet1;
    private javax.swing.JButton btn_Yeni;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lbl_Secilen;
    private static javax.swing.JTable tablo_Ders;
    private static javax.swing.JTextField txt_Arama;
    private static javax.swing.JTextField txt_Ders_Adi;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Sifirla() {
       
    
        lbl_Secilen.setVisible(false);
        txt_Arama.setText(null);
    }
}
