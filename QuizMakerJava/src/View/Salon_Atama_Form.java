package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Presenter.SalonAtamaPresenter;
import com.sun.glass.events.KeyEvent;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.Class.forName;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import java.util.*;

import java.text.MessageFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
        



public class Salon_Atama_Form extends javax.swing.JInternalFrame implements IViewSalonAtama {

private static Salon_Atama_Form form = new Salon_Atama_Form();
public static Salon_Atama_Form yeniFormOlustur(){
    return form;
}
 
private SalonAtamaPresenter presenter ;

    private Salon_Atama_Form() {

        presenter = new SalonAtamaPresenter(this);
        setResizable(false);
        initComponents();

       lbOgrenci_Adedi.setVisible(false);
       lbText.setVisible(false);
       presenter.setOgrenci_Adedi(0);
       presenter.cm_Ders_Doldurma();
       presenter.cm_Gozetmen_Doldurma();
       presenter.cm_Bina_Doldurma();
       cm_Bina.setSelectedIndex(0);
      presenter.setBina(cm_Bina.getSelectedItem().toString());
    
       presenter.cm_Salon_Doldurma();
       presenter.setSalon(cm_Salon.getSelectedItem().toString());
       presenter.kapasite_Al();
       lbKapasite.setText(String.valueOf(presenter.getKapasite()));
       presenter.tablo_Sil();
       presenter.yenile();
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
        btn_Ogrenci_Ata = new javax.swing.JButton();
        cm_Gozetmen = new javax.swing.JComboBox<String>();
        cm_Bina = new javax.swing.JComboBox<String>();
        lb_1 = new javax.swing.JLabel();
        lb_2 = new javax.swing.JLabel();
        cm_Salon = new javax.swing.JComboBox<String>();
        lb_3 = new javax.swing.JLabel();
        lbTex = new javax.swing.JLabel();
        lbKapasite = new javax.swing.JLabel();
        cm_Ders = new javax.swing.JComboBox<String>();
        lb_4 = new javax.swing.JLabel();
        btn_Kapat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo_Sinif = new javax.swing.JTable();
        btn_Yeni = new javax.swing.JButton();
        btn_Uygula = new javax.swing.JButton();
        btn_Rapor = new javax.swing.JButton();
        lbl_Secilen = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();
        lbOgrenci_Adedi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_Tum_Liste = new javax.swing.JButton();
        cm_Atanan_Bina = new javax.swing.JComboBox<String>();
        lb_5 = new javax.swing.JLabel();
        lb_6 = new javax.swing.JLabel();
        cm_Atanan_Salon = new javax.swing.JComboBox<String>();
        btn_Salon_Liste = new javax.swing.JButton();
        btn_Yoklama_Listesi = new javax.swing.JButton();
        btn_Liste_Al = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Sınav Listeleme");
        setPreferredSize(new java.awt.Dimension(864, 550));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/salon.png"))); // NOI18N
        jLabel3.setText("SINIF LİSTESİ OLUŞTURMA");
        jLabel3.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SALON OLUŞTURMA");

        btn_Ogrenci_Ata.setText("Salona Rastgele Öğrenci Ata");
        btn_Ogrenci_Ata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ogrenci_AtaActionPerformed(evt);
            }
        });

        cm_Bina.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cm_BinaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        lb_1.setText("Gözetmen:");

        lb_2.setText("Bina:");

        cm_Salon.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cm_SalonPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        lb_3.setText("Salon:");

        lbTex.setText("Seçilen Salonun Kapasitesi:");

        lbKapasite.setText("Kapasite");

        cm_Ders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_DersActionPerformed(evt);
            }
        });

        lb_4.setText("Ders:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cm_Gozetmen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cm_Bina, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cm_Salon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_3)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lbTex)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbKapasite)
                            .addGap(8, 8, 8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btn_Ogrenci_Ata)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lb_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cm_Ders, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm_Ders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_1)
                            .addComponent(lb_2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cm_Gozetmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cm_Bina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cm_Salon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTex)
                    .addComponent(lbKapasite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Ogrenci_Ata, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        btn_Kapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sil24x24.png"))); // NOI18N
        btn_Kapat.setText("Kapat");
        btn_Kapat.setName("btn_Cikis"); // NOI18N
        btn_Kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KapatActionPerformed(evt);
            }
        });

        tablo_Sinif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablo_Sinif.setAutoscrolls(false);
        tablo_Sinif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablo_SinifMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo_Sinif);

        btn_Yeni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yenile.png"))); // NOI18N
        btn_Yeni.setText("Seçimleri Temizle");
        btn_Yeni.setName("btn_Giris"); // NOI18N
        btn_Yeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_YeniActionPerformed(evt);
            }
        });

        btn_Uygula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/uygula.png"))); // NOI18N
        btn_Uygula.setText("Uygula");
        btn_Uygula.setName("btn_Giris"); // NOI18N
        btn_Uygula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UygulaActionPerformed(evt);
            }
        });

        btn_Rapor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yazdir.png"))); // NOI18N
        btn_Rapor.setText("Öğrenci Listesi Yazdır");
        btn_Rapor.setName("btn_Giris"); // NOI18N
        btn_Rapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RaporActionPerformed(evt);
            }
        });

        lbText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbText.setText("Salona Atanmayan Öğrenci Sayısı:");

        lbOgrenci_Adedi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbOgrenci_Adedi.setText("lbOgrenci_Adedi");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("OLUŞTURULAN SALON LİSTELERİ");

        btn_Tum_Liste.setText("Sınav Listesi");
        btn_Tum_Liste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Tum_ListeActionPerformed(evt);
            }
        });

        cm_Atanan_Bina.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cm_Atanan_BinaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        lb_5.setText("Bina:");

        lb_6.setText("Salon:");

        cm_Atanan_Salon.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cm_Atanan_SalonPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btn_Salon_Liste.setText("Salon Listesi");
        btn_Salon_Liste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Salon_ListeActionPerformed(evt);
            }
        });

        btn_Yoklama_Listesi.setText("Yoklama Listesi");
        btn_Yoklama_Listesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Yoklama_ListesiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cm_Atanan_Bina, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cm_Atanan_Salon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_Tum_Liste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Salon_Liste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Yoklama_Listesi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cm_Atanan_Bina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cm_Atanan_Salon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Tum_Liste, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Salon_Liste, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Yoklama_Listesi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_Liste_Al.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xls.png"))); // NOI18N
        btn_Liste_Al.setText("Öğrenci Listesi Al");
        btn_Liste_Al.setName("btn_Giris"); // NOI18N
        btn_Liste_Al.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Liste_AlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_Secilen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btn_Liste_Al, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addGap(115, 115, 115))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbOgrenci_Adedi))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btn_Uygula, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Yeni, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btn_Kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Rapor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Secilen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbText)
                                    .addComponent(lbOgrenci_Adedi))))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btn_Liste_Al)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Rapor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Yeni, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Uygula, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




    private void btn_KapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KapatActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_btn_KapatActionPerformed

    private void tablo_SinifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablo_SinifMouseClicked
        // TODO add your handling code here:
    

    }//GEN-LAST:event_tablo_SinifMouseClicked

    private void btn_YeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_YeniActionPerformed
        // TODO add your handling code here:
        presenter.setDersSecimi(null);
        presenter.setZorlukSecimi(null);
        presenter.setSoruTurSecimi(null);
  


       
    }//GEN-LAST:event_btn_YeniActionPerformed


    private void btn_UygulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UygulaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_UygulaActionPerformed

    private void btn_RaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RaporActionPerformed
        // TODO add your handling code here:
        presenter.raporHazirla2();
    }//GEN-LAST:event_btn_RaporActionPerformed

    private void btn_Liste_AlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Liste_AlActionPerformed
        // TODO add your handling code here:
        
        presenter.dosyaAl();
        presenter.goster();
    }//GEN-LAST:event_btn_Liste_AlActionPerformed

    private void cm_BinaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cm_BinaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
       presenter.setBina(cm_Bina.getSelectedItem().toString());
       presenter.cm_Salon_Doldurma();
    }//GEN-LAST:event_cm_BinaPopupMenuWillBecomeInvisible

    private void cm_SalonPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cm_SalonPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        presenter.kapasite_Al();
        lbKapasite.setText(String.valueOf(presenter.getKapasite()));
        
    }//GEN-LAST:event_cm_SalonPopupMenuWillBecomeInvisible

    private void btn_Ogrenci_AtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ogrenci_AtaActionPerformed
        // TODO add your handling code here:
        presenter.rastgeleAta();
        jPanel2.setVisible(true);
    }//GEN-LAST:event_btn_Ogrenci_AtaActionPerformed

    private void cm_DersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_DersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_DersActionPerformed

    private void cm_Atanan_BinaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cm_Atanan_BinaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_Atanan_BinaPopupMenuWillBecomeInvisible

    private void cm_Atanan_SalonPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cm_Atanan_SalonPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_Atanan_SalonPopupMenuWillBecomeInvisible

    private void btn_Tum_ListeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Tum_ListeActionPerformed
        // TODO add your handling code here:
        presenter.rapor_Sinav_Hazirla();
    }//GEN-LAST:event_btn_Tum_ListeActionPerformed

    private void btn_Salon_ListeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Salon_ListeActionPerformed
        // TODO add your handling code here:
        presenter.rapor_Salon_Hazirla();
    }//GEN-LAST:event_btn_Salon_ListeActionPerformed

    private void btn_Yoklama_ListesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Yoklama_ListesiActionPerformed
        // TODO add your handling code here:
        presenter.rapor_Yoklama_Hazirla();
    }//GEN-LAST:event_btn_Yoklama_ListesiActionPerformed

    public static JComboBox<String> getCm_Atanan_Bina() {
        return cm_Atanan_Bina;
    }

    public static void setCm_Atanan_Bina(JComboBox<String> cm_Atanan_Bina) {
        Salon_Atama_Form.cm_Atanan_Bina = cm_Atanan_Bina;
    }

    public static JComboBox<String> getCm_Atanan_Salon() {
        return cm_Atanan_Salon;
    }

    public static void setCm_Atanan_Salon(JComboBox<String> cm_Atanan_Salon) {
        Salon_Atama_Form.cm_Atanan_Salon = cm_Atanan_Salon;
    }

    public static JComboBox<String> getCm_Bina() {
        return cm_Bina;
    }

    public static void setCm_Bina(JComboBox<String> cm_Bina) {
        Salon_Atama_Form.cm_Bina = cm_Bina;
    }

    public static JComboBox<String> getCm_Ders() {
        return cm_Ders;
    }

    public static void setCm_Ders(JComboBox<String> cm_Ders) {
        Salon_Atama_Form.cm_Ders = cm_Ders;
    }

    public static JComboBox<String> getCm_Gozetmen() {
        return cm_Gozetmen;
    }

    public static void setCm_Gozetmen(JComboBox<String> cm_Gozetmen) {
        Salon_Atama_Form.cm_Gozetmen = cm_Gozetmen;
    }

    public static JComboBox<String> getCm_Salon() {
        return cm_Salon;
    }

    public static void setCm_Salon(JComboBox<String> cm_Salon) {
        Salon_Atama_Form.cm_Salon = cm_Salon;
    }

    public static JLabel getLbKapasite() {
        return lbKapasite;
    }

    public static void setLbKapasite(JLabel lbKapasite) {
        Salon_Atama_Form.lbKapasite = lbKapasite;
    }

    public static JLabel getLbOgrenci_Adedi() {
        return lbOgrenci_Adedi;
    }

    public static void setLbOgrenci_Adedi(JLabel lbOgrenci_Adedi) {
        Salon_Atama_Form.lbOgrenci_Adedi = lbOgrenci_Adedi;
    }

    public static JLabel getLbTex() {
        return lbTex;
    }

    public static void setLbTex(JLabel lbTex) {
        Salon_Atama_Form.lbTex = lbTex;
    }

    public static JLabel getLbText() {
        return lbText;
    }

    public static void setLbText(JLabel lbText) {
        Salon_Atama_Form.lbText = lbText;
    }

    public static JLabel getLbl_Secilen() {
        return lbl_Secilen;
    }

    public static void setLbl_Secilen(JLabel lbl_Secilen) {
        Salon_Atama_Form.lbl_Secilen = lbl_Secilen;
    }

    public static JTable getTablo_Sinif() {
        return tablo_Sinif;
    }

    public static void setTablo_Sinif(JTable tablo_Sinif) {
        Salon_Atama_Form.tablo_Sinif = tablo_Sinif;
    }

    public static JPanel getjPanel1() {
        return jPanel1;
    }

    public static void setjPanel1(JPanel jPanel1) {
        Salon_Atama_Form.jPanel1 = jPanel1;
    }

    public static JPanel getjPanel2() {
        return jPanel2;
    }

    public static void setjPanel2(JPanel jPanel2) {
        Salon_Atama_Form.jPanel2 = jPanel2;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Kapat;
    private javax.swing.JButton btn_Liste_Al;
    private javax.swing.JButton btn_Ogrenci_Ata;
    private javax.swing.JButton btn_Rapor;
    private javax.swing.JButton btn_Salon_Liste;
    private javax.swing.JButton btn_Tum_Liste;
    private javax.swing.JButton btn_Uygula;
    private javax.swing.JButton btn_Yeni;
    private javax.swing.JButton btn_Yoklama_Listesi;
    private static javax.swing.JComboBox<String> cm_Atanan_Bina;
    private static javax.swing.JComboBox<String> cm_Atanan_Salon;
    private static javax.swing.JComboBox<String> cm_Bina;
    private static javax.swing.JComboBox<String> cm_Ders;
    private static javax.swing.JComboBox<String> cm_Gozetmen;
    private static javax.swing.JComboBox<String> cm_Salon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private static javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lbKapasite;
    private static javax.swing.JLabel lbOgrenci_Adedi;
    private static javax.swing.JLabel lbTex;
    private static javax.swing.JLabel lbText;
    private javax.swing.JLabel lb_1;
    private javax.swing.JLabel lb_2;
    private javax.swing.JLabel lb_3;
    private javax.swing.JLabel lb_4;
    private javax.swing.JLabel lb_5;
    private javax.swing.JLabel lb_6;
    private static javax.swing.JLabel lbl_Secilen;
    private static javax.swing.JTable tablo_Sinif;
    // End of variables declaration//GEN-END:variables
}