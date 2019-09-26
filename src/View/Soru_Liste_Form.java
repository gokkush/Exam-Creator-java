/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;



import Model.SoruDetaylari;
import Presenter.SoruListelePresenter;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

public class Soru_Liste_Form extends javax.swing.JInternalFrame implements IViewSoruListele{
 
    
   private static Soru_Liste_Form form = new Soru_Liste_Form();
  public static Soru_Liste_Form yeniFormOlustur(){
      return form;
  }
    
 
        private SoruListelePresenter presenter;
    private Soru_Liste_Form() {
       
        
        setResizable(false);
        initComponents();
        presenter = new SoruListelePresenter(this);
        
        txt_Arama.setText(null);

        //cmDersDoldurma.cm_Ders_Doldurma();
        presenter.cm_Ders_Doldurma();
        //cmSoruTipDoldurma.cm_Soru_Tip_Doldurma();
        presenter.cm_Soru_Tip_Doldurma();
        //cmZorlukTuruDoldurma.cm_Zorluk_Turu_Doldurma();
        presenter.cm_Zorluk_Turu_Doldurma();

        //tabloYenile.tabloYenile();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cm_Ders = new javax.swing.JComboBox<String>();
        chb_Ders = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        cm_Zorluk_Tip = new javax.swing.JComboBox<String>();
        chb_Zorluk = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        chb_Soru = new javax.swing.JCheckBox();
        cm_Soru_Tip = new javax.swing.JComboBox<String>();
        btn_Kapat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_Soru = new javax.swing.JTable();
        btn_Yeni = new javax.swing.JButton();
        txt_Arama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_Uygula = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Soru Listeleme");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/liste.png"))); // NOI18N
        jLabel3.setText("SORU LİSTELEME EKRANI");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LİSTELEME KRİTERLERİ");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));

        cm_Ders.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cm_DersİtemStateChanged(evt);
            }
        });
        cm_Ders.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cm_DersPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cm_Ders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cm_DersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cm_DersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cm_DersMouseExited(evt);
            }
        });

        chb_Ders.setText("Ders:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chb_Ders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cm_Ders, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm_Ders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chb_Ders))
                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));

        chb_Zorluk.setText("Zorluk:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chb_Zorluk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cm_Zorluk_Tip, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm_Zorluk_Tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chb_Zorluk))
                .addContainerGap())
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));

        chb_Soru.setText("Soru Tipi:");

        cm_Soru_Tip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cm_Soru_TipİtemStateChanged(evt);
            }
        });
        cm_Soru_Tip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cm_Soru_TipMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cm_Soru_TipMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chb_Soru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(cm_Soru_Tip, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chb_Soru)
                    .addComponent(cm_Soru_Tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        btn_Kapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sil24x24.png"))); // NOI18N
        btn_Kapat.setText("Kapat");
        btn_Kapat.setName("btn_Cikis"); // NOI18N
        btn_Kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KapatActionPerformed(evt);
            }
        });

        tablo_Soru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Soru", "Cevap", "Doğru Cevap"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_Soru.setAutoscrolls(false);
        tablo_Soru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_SoruMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo_Soru);
        if (tablo_Soru.getColumnModel().getColumnCount() > 0) {
            tablo_Soru.getColumnModel().getColumn(0).setResizable(false);
        }

        btn_Yeni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yenile.png"))); // NOI18N
        btn_Yeni.setText("Seçimleri Temizle");
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

        btn_Uygula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/uygula.png"))); // NOI18N
        btn_Uygula.setText("Uygula");
        btn_Uygula.setName("btn_Giris"); // NOI18N
        btn_Uygula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UygulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_Uygula, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Yeni, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Arama, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Arama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Yeni, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Uygula, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void btn_KapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KapatActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_btn_KapatActionPerformed

    private void tablo_SoruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_SoruMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tablo_SoruMouseClicked

    private void btn_YeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_YeniActionPerformed
        // TODO add your handling code here:
        SecimTemizle();
       // tabloYenile.tabloYenile();
       presenter.tabloYenile();
    }//GEN-LAST:event_btn_YeniActionPerformed

    private void txt_AramaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AramaKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_AramaKeyPressed

    private void txt_AramaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_AramaCaretUpdate
        // TODO add your handling code here:
     //  tabloYenile.tabloYenile();
        presenter.tabloYenile();
    }//GEN-LAST:event_txt_AramaCaretUpdate

    private void cm_Soru_TipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_Soru_TipMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cm_Soru_TipMouseClicked

    private void cm_Soru_TipMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_Soru_TipMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cm_Soru_TipMouseReleased

    private void cm_Soru_TipİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cm_Soru_TipİtemStateChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_cm_Soru_TipİtemStateChanged


    private void cm_DersİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cm_DersİtemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cm_DersİtemStateChanged

    private void cm_DersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_DersMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_cm_DersMouseExited

    private void cm_DersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_DersMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cm_DersMouseClicked

    private void cm_DersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_DersMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_cm_DersMouseEntered

    private void cm_DersPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cm_DersPopupMenuWillBecomeInvisible
        // TODO add your handling code here:

    }//GEN-LAST:event_cm_DersPopupMenuWillBecomeInvisible

    private void btn_UygulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UygulaActionPerformed
        // TODO add your handling code here:
      // new  tabloYenile().tabloYenile();
        presenter.tabloYenile();
    }//GEN-LAST:event_btn_UygulaActionPerformed

    public static JCheckBox getChb_Ders() {
        return chb_Ders;
    }

    public static void setChb_Ders(JCheckBox chb_Ders) {
        Soru_Liste_Form.chb_Ders = chb_Ders;
    }

    public static JComboBox<String> getCm_Ders() {
        return cm_Ders;
    }

    public static void setCm_Ders(JComboBox<String> cm_Ders) {
        Soru_Liste_Form.cm_Ders = cm_Ders;
    }

    public static JComboBox<String> getCm_Zorluk_Tip() {
        return cm_Zorluk_Tip;
    }

    public static void setCm_Zorluk_Tip(JComboBox<String> cm_Zorluk_Tip) {
        Soru_Liste_Form.cm_Zorluk_Tip = cm_Zorluk_Tip;
    }

    public static JCheckBox getChb_Zorluk() {
        return chb_Zorluk;
    }

    public static void setChb_Zorluk(JCheckBox chb_Zorluk) {
        Soru_Liste_Form.chb_Zorluk = chb_Zorluk;
    }

    public static JCheckBox getChb_Soru() {
        return chb_Soru;
    }

    public static void setChb_Soru(JCheckBox chb_Soru) {
        Soru_Liste_Form.chb_Soru = chb_Soru;
    }

    public static JComboBox<String> getCm_Soru_Tip() {
        return cm_Soru_Tip;
    }

    public static void setCm_Soru_Tip(JComboBox<String> cm_Soru_Tip) {
        Soru_Liste_Form.cm_Soru_Tip = cm_Soru_Tip;
    }

    public static JTextField getTxt_Arama() {
        return txt_Arama;
    }

    public static void setTxt_Arama(JTextField txt_Arama) {
        Soru_Liste_Form.txt_Arama = txt_Arama;
    }

    public static JTable getTablo_Soru() {
        return tablo_Soru;
    }

    public static void setTablo_Soru(JTable tablo_Soru) {
        Soru_Liste_Form.tablo_Soru = tablo_Soru;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Kapat;
    private javax.swing.JButton btn_Uygula;
    private javax.swing.JButton btn_Yeni;
    private static javax.swing.JCheckBox chb_Ders;
    private static javax.swing.JCheckBox chb_Soru;
    private static javax.swing.JCheckBox chb_Zorluk;
    private static javax.swing.JComboBox<String> cm_Ders;
    private static javax.swing.JComboBox<String> cm_Soru_Tip;
    private static javax.swing.JComboBox<String> cm_Zorluk_Tip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tablo_Soru;
    private static javax.swing.JTextField txt_Arama;
    // End of variables declaration//GEN-END:variables

    @Override
    public void SecimTemizle() {
       txt_Arama.setText(null);
        presenter.setDersSecim(null);
        presenter.setZorlukSecim(null);
        presenter.setSoruTurSecim(null);
        chb_Ders.setSelected(false);
        chb_Soru.setSelected(false);
        chb_Zorluk.setSelected(false);
        cm_Ders.setSelectedIndex(0);
        cm_Soru_Tip.setSelectedIndex(0);
        cm_Zorluk_Tip.setSelectedIndex(0); 
    
    }
}