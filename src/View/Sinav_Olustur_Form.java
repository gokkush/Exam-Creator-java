package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Presenter.SinavOlusturPresenter;
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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

public class Sinav_Olustur_Form extends javax.swing.JInternalFrame implements IViewSinavOlustur {

    private ResultSet res;
    private Statement st = null;

   

    private static Sinav_Olustur_Form form = new Sinav_Olustur_Form();
    public static Sinav_Olustur_Form yeniFormOlustur(){
        return form;
    }

    private SinavOlusturPresenter presenter;
    private Sinav_Olustur_Form() {

        
        setResizable(false);
        initComponents();
        presenter = new SinavOlusturPresenter(this);
        btn_Kaydet.setEnabled(false);
        lbl_Secilen.setVisible(false);
        txt_Arama.setText(null);

        
        presenter.cm_Ders_Doldurma();
        
        presenter.cm_Zorluk_Turu_Doldurma();
        
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
        cm_Ders = new javax.swing.JComboBox<String>();
        cm_Zorluk_Tip = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_gozetmen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_Tarih = new javax.swing.JTextField();
        txt_Sinav_Yeri = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cm_Coktan = new javax.swing.JComboBox<String>();
        cm_Dogru_Yanlis = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cm_Bosluk = new javax.swing.JComboBox<String>();
        txt_Soru_Sayisi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btn_Random = new javax.swing.JButton();
        btn_Kapat = new javax.swing.JButton();
        btn_Sil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_Soru = new javax.swing.JTable();
        btn_Yeni = new javax.swing.JButton();
        txt_Arama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lbl_Secilen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablo_Random_Soru = new javax.swing.JTable();
        btn_Kaydet = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Sınav Oluştur");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/soru_guncelle.png"))); // NOI18N
        jLabel3.setText("SINAV OLUŞTUR");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jLabel5.setText("Ders:");

        jLabel6.setText("Zorluk:");

        jLabel1.setText("Gözetmen Bilgisi:");

        jLabel2.setText("Sınav Tarihi:");

        jLabel4.setText("Sınav Yeri:");

        jLabel7.setText("Çoktan Seçmeli Oranı");

        cm_Coktan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "30", "40", "50", "60", "70", "80", "90", "100" }));
        cm_Coktan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cm_CoktanİtemStateChanged(evt);
            }
        });
        cm_Coktan.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cm_CoktanPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cm_Coktan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cm_CoktanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cm_CoktanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cm_CoktanMouseExited(evt);
            }
        });

        cm_Dogru_Yanlis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "30", "40", "50", "60", "70", "80", "90", "100" }));
        cm_Dogru_Yanlis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cm_Dogru_YanlisİtemStateChanged(evt);
            }
        });
        cm_Dogru_Yanlis.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cm_Dogru_YanlisPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cm_Dogru_Yanlis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cm_Dogru_YanlisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cm_Dogru_YanlisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cm_Dogru_YanlisMouseExited(evt);
            }
        });

        jLabel8.setText("Doğru Yanlış Oranı");

        jLabel9.setText("Boşluk Doldurma Oranı");

        cm_Bosluk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "30", "40", "50", "60", "70", "80", "90", "100" }));
        cm_Bosluk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cm_BoslukİtemStateChanged(evt);
            }
        });
        cm_Bosluk.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cm_BoslukPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cm_Bosluk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cm_BoslukMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cm_BoslukMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cm_BoslukMouseExited(evt);
            }
        });

        txt_Soru_Sayisi.setText("10");
        txt_Soru_Sayisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Soru_SayisiActionPerformed(evt);
            }
        });

        jLabel11.setText("Soru Sayısı:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cm_Ders, 0, 120, Short.MAX_VALUE)
                    .addComponent(cm_Zorluk_Tip, 0, 120, Short.MAX_VALUE))
                .addGap(124, 124, 124))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel11))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cm_Bosluk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cm_Dogru_Yanlis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cm_Coktan, 0, 186, Short.MAX_VALUE))))
                        .addGap(77, 77, 77))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_Soru_Sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_gozetmen)
                                .addComponent(txt_Tarih)
                                .addComponent(txt_Sinav_Yeri, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm_Ders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm_Zorluk_Tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_Soru_Sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_gozetmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txt_Tarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Sinav_Yeri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cm_Coktan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cm_Dogru_Yanlis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cm_Bosluk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_Random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Kaydet24x24.png"))); // NOI18N
        btn_Random.setText("Random Ata");
        btn_Random.setName("btn_Giris"); // NOI18N
        btn_Random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RandomActionPerformed(evt);
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

        btn_Sil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sil32x32.png"))); // NOI18N
        btn_Sil.setText("Kaydı Sil");
        btn_Sil.setName("btn_Giris"); // NOI18N
        btn_Sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SilActionPerformed(evt);
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
            tablo_Soru.getColumnModel().getColumn(2).setHeaderValue("Cevap");
            tablo_Soru.getColumnModel().getColumn(3).setHeaderValue("Doğru Cevap");
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

        tablo_Random_Soru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Soru", "Cevap"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablo_Random_Soru.setAutoscrolls(false);
        tablo_Random_Soru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_Random_SoruMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablo_Random_Soru);
        if (tablo_Random_Soru.getColumnModel().getColumnCount() > 0) {
            tablo_Random_Soru.getColumnModel().getColumn(0).setResizable(false);
        }

        btn_Kaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Kaydet24x24.png"))); // NOI18N
        btn_Kaydet.setText("Kayıt Ekle / Güncelle");
        btn_Kaydet.setName("btn_Giris"); // NOI18N
        btn_Kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KaydetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_Secilen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(txt_Arama))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Random, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Yeni, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btn_Sil, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_Arama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_Secilen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Sil)
                    .addComponent(btn_Yeni, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Random, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    
  

   

    private void btn_RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RandomActionPerformed
        // TODO add your handling code here:
        btn_Kaydet.setEnabled(true);
       // presenter.random_Olustur();
       presenter.stratejiIleRandomSoruAta();

    }//GEN-LAST:event_btn_RandomActionPerformed

    private void btn_KapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KapatActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_btn_KapatActionPerformed

    private void btn_SilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SilActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_SilActionPerformed

    private void tablo_SoruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_SoruMouseClicked
        // TODO add your handling code here:
        presenter.tablodanVeriSecme();
    }//GEN-LAST:event_tablo_SoruMouseClicked

    private void btn_YeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_YeniActionPerformed
        // TODO add your handling code here:
        txt_Arama.setText(null);
        presenter.tabloYenile();
    }//GEN-LAST:event_btn_YeniActionPerformed

    private void txt_AramaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AramaKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_AramaKeyPressed

    private void txt_AramaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_AramaCaretUpdate
        // TODO add your handling code here:
        presenter.tabloYenile();
    }//GEN-LAST:event_txt_AramaCaretUpdate

    
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
        presenter.tabloYenile();
    }//GEN-LAST:event_cm_DersPopupMenuWillBecomeInvisible

    private void tablo_Random_SoruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_Random_SoruMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablo_Random_SoruMouseClicked

    private void cm_CoktanİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cm_CoktanİtemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_CoktanİtemStateChanged

    private void cm_CoktanPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cm_CoktanPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_CoktanPopupMenuWillBecomeInvisible

    private void cm_CoktanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_CoktanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_CoktanMouseClicked

    private void cm_CoktanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_CoktanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_CoktanMouseEntered

    private void cm_CoktanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_CoktanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_CoktanMouseExited

    private void cm_Dogru_YanlisİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cm_Dogru_YanlisİtemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_Dogru_YanlisİtemStateChanged

    private void cm_Dogru_YanlisPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cm_Dogru_YanlisPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_Dogru_YanlisPopupMenuWillBecomeInvisible

    private void cm_Dogru_YanlisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_Dogru_YanlisMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_Dogru_YanlisMouseClicked

    private void cm_Dogru_YanlisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_Dogru_YanlisMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_Dogru_YanlisMouseEntered

    private void cm_Dogru_YanlisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_Dogru_YanlisMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_Dogru_YanlisMouseExited

    private void cm_BoslukİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cm_BoslukİtemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_BoslukİtemStateChanged

    private void cm_BoslukPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cm_BoslukPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_BoslukPopupMenuWillBecomeInvisible

    private void cm_BoslukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_BoslukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_BoslukMouseClicked

    private void cm_BoslukMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_BoslukMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_BoslukMouseEntered

    private void cm_BoslukMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cm_BoslukMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_BoslukMouseExited

    private void btn_KaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KaydetActionPerformed
        // TODO add your handling code here:
        presenter.sinav_Olustur();
    }//GEN-LAST:event_btn_KaydetActionPerformed

    private void txt_Soru_SayisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Soru_SayisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Soru_SayisiActionPerformed

    public static JComboBox<String> getCm_Bosluk() {
        return cm_Bosluk;
    }

    public static void setCm_Bosluk(JComboBox<String> cm_Bosluk) {
        Sinav_Olustur_Form.cm_Bosluk = cm_Bosluk;
    }

    public static JComboBox<String> getCm_Coktan() {
        return cm_Coktan;
    }

    public static void setCm_Coktan(JComboBox<String> cm_Coktan) {
        Sinav_Olustur_Form.cm_Coktan = cm_Coktan;
    }

    public static JComboBox<String> getCm_Ders() {
        return cm_Ders;
    }

    public static void setCm_Ders(JComboBox<String> cm_Ders) {
        Sinav_Olustur_Form.cm_Ders = cm_Ders;
    }

    public static JComboBox<String> getCm_Dogru_Yanlis() {
        return cm_Dogru_Yanlis;
    }

    public static void setCm_Dogru_Yanlis(JComboBox<String> cm_Dogru_Yanlis) {
        Sinav_Olustur_Form.cm_Dogru_Yanlis = cm_Dogru_Yanlis;
    }

    public static JComboBox<String> getCm_Zorluk_Tip() {
        return cm_Zorluk_Tip;
    }

    public static void setCm_Zorluk_Tip(JComboBox<String> cm_Zorluk_Tip) {
        Sinav_Olustur_Form.cm_Zorluk_Tip = cm_Zorluk_Tip;
    }

    public static JLabel getLbl_Secilen() {
        return lbl_Secilen;
    }

    public static void setLbl_Secilen(JLabel lbl_Secilen) {
        Sinav_Olustur_Form.lbl_Secilen = lbl_Secilen;
    }

    public static JTable getTablo_Random_Soru() {
        return tablo_Random_Soru;
    }

    public static void setTablo_Random_Soru(JTable tablo_Random_Soru) {
        Sinav_Olustur_Form.tablo_Random_Soru = tablo_Random_Soru;
    }

    public static JTable getTablo_Soru() {
        return tablo_Soru;
    }

    public static void setTablo_Soru(JTable tablo_Soru) {
        Sinav_Olustur_Form.tablo_Soru = tablo_Soru;
    }

    public static JTextField getTxt_Arama() {
        return txt_Arama;
    }

    public static void setTxt_Arama(JTextField txt_Arama) {
        Sinav_Olustur_Form.txt_Arama = txt_Arama;
    }

    public static JTextField getTxt_Sinav_Yeri() {
        return txt_Sinav_Yeri;
    }

    public static void setTxt_Sinav_Yeri(JTextField txt_Sinav_Yeri) {
        Sinav_Olustur_Form.txt_Sinav_Yeri = txt_Sinav_Yeri;
    }

    public static JTextField getTxt_Soru_Sayisi() {
        return txt_Soru_Sayisi;
    }

    public static void setTxt_Soru_Sayisi(JTextField txt_Soru_Sayisi) {
        Sinav_Olustur_Form.txt_Soru_Sayisi = txt_Soru_Sayisi;
    }

    public static JTextField getTxt_Tarih() {
        return txt_Tarih;
    }

    public static void setTxt_Tarih(JTextField txt_Tarih) {
        Sinav_Olustur_Form.txt_Tarih = txt_Tarih;
    }

    public static JTextField getTxt_gozetmen() {
        return txt_gozetmen;
    }

    public static void setTxt_gozetmen(JTextField txt_gozetmen) {
        Sinav_Olustur_Form.txt_gozetmen = txt_gozetmen;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Kapat;
    private javax.swing.JButton btn_Kaydet;
    private javax.swing.JButton btn_Random;
    private javax.swing.JButton btn_Sil;
    private javax.swing.JButton btn_Yeni;
    private static javax.swing.JComboBox<String> cm_Bosluk;
    private static javax.swing.JComboBox<String> cm_Coktan;
    private static javax.swing.JComboBox<String> cm_Ders;
    private static javax.swing.JComboBox<String> cm_Dogru_Yanlis;
    private static javax.swing.JComboBox<String> cm_Zorluk_Tip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel lbl_Secilen;
    private static javax.swing.JTable tablo_Random_Soru;
    private static javax.swing.JTable tablo_Soru;
    private static javax.swing.JTextField txt_Arama;
    private static javax.swing.JTextField txt_Sinav_Yeri;
    private static javax.swing.JTextField txt_Soru_Sayisi;
    private static javax.swing.JTextField txt_Tarih;
    private static javax.swing.JTextField txt_gozetmen;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mesaj(String mesaj, String tur) {
      JOptionPane.showConfirmDialog(null, mesaj, tur, JOptionPane.DEFAULT_OPTION);
                  
    
    }
}