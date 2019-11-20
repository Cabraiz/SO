/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import Beans.Processo;
import Image.Convert_Img;
import java.awt.Component;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class Main extends javax.swing.JFrame {

    Thread threadTime = new Thread();
    Thread threadDuplicate = new Thread();
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S a");

    Convert_Img img = new Convert_Img();
    Random rd = new Random();
    int core = 4;

    Builder builder;

    public Main() {
        initComponents();
        builder = rRobin;

        SetInfoIDJpanel(rRobin);
        SetInfoIDJpanel(SJF_Imp);
        SetInfoIDJpanel(LTG_Imp);

        Radomizar();
        Initiate(rRobin);
        Repaint(0);
        front.moveToFront(rRobin);
        IconSet();
        TimeUpdate();
    }

    public final void Radomizar() {
        for (int i = 0; i < 8; i++) {
            rRobin.ExeProcessoLista.add(new Processo());
        }
        numPro.setText(String.valueOf(core));

        for (int i = 0; i < 8; i++) {
            SJF_Imp.ExeProcessoLista.add(new Processo());
        }

        for (int i = 0; i < 8; i++) {
            LTG_Imp.ExeProcessoLista.add(new Processo());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        front = new javax.swing.JLayeredPane();
        rRobin = new so.RoundRobin();
        SJF_Imp = new so.SJF();
        LTG_Imp = new so.LTG();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NumIniProcess = new javax.swing.JTextField();
        Escalonador = new javax.swing.JComboBox<>();
        ComboMemory = new javax.swing.JComboBox<>();
        Create = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numPro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelInfoExeTime = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelInfoDeadTime = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabelInfoID = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        numMemoryQuickL = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        numMemoryQuickR = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        numMemory = new javax.swing.JTextField();
        jLabelInfoID1 = new javax.swing.JLabel();
        JLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        numPorcentagem = new javax.swing.JTextField();
        jLabelInfoID2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        PlayPause = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 720));

        jPanel5.setPreferredSize(new java.awt.Dimension(500, 740));
        java.awt.FlowLayout flowLayout4 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 1, 10);
        flowLayout4.setAlignOnBaseline(true);
        jPanel5.setLayout(flowLayout4);

        front.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        front.setMaximumSize(new java.awt.Dimension(5000, 3000));
        front.setMinimumSize(new java.awt.Dimension(650, 518));
        front.setPreferredSize(new java.awt.Dimension(520, 620));
        front.setLayout(new javax.swing.OverlayLayout(front));

        rRobin.setFocusTraversalPolicyProvider(true);
        front.add(rRobin);

        SJF_Imp.setPreferredSize(new java.awt.Dimension(400, 300));
        front.setLayer(SJF_Imp, javax.swing.JLayeredPane.DRAG_LAYER);
        front.add(SJF_Imp);
        front.setLayer(LTG_Imp, javax.swing.JLayeredPane.DRAG_LAYER);
        front.add(LTG_Imp);
        LTG_Imp.getAccessibleContext().setAccessibleDescription("");

        jPanel5.add(front);

        jPanel7.setPreferredSize(new java.awt.Dimension(532, 630));
        java.awt.FlowLayout flowLayout5 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5);
        flowLayout5.setAlignOnBaseline(true);
        jPanel7.setLayout(flowLayout5);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Pro. Iniciais:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 17));
        jPanel7.add(jLabel2);

        NumIniProcess.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NumIniProcess.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        NumIniProcess.setText("64");
        NumIniProcess.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        NumIniProcess.setPreferredSize(new java.awt.Dimension(75, 23));
        NumIniProcess.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NumIniProcessFocusLost(evt);
            }
        });
        NumIniProcess.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NumIniProcessKeyTyped(evt);
            }
        });
        jPanel7.add(NumIniProcess);

        Escalonador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Escalonador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Round Robin", "SJF", "LTG" }));
        Escalonador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscalonadorActionPerformed(evt);
            }
        });
        jPanel7.add(Escalonador);

        ComboMemory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ComboMemory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Best Fit", "Quick Fit", "Merge Fit" }));
        ComboMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMemoryActionPerformed(evt);
            }
        });
        jPanel7.add(ComboMemory);

        Create.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Create.setText("Criar");
        Create.setPreferredSize(new java.awt.Dimension(80, 35));
        Create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CreateMouseReleased(evt);
            }
        });
        jPanel7.add(Create);

        jPanel5.add(jPanel7);

        jPanel6.setPreferredSize(new java.awt.Dimension(149, 80));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 1, 4);
        flowLayout3.setAlignOnBaseline(true);
        jPanel6.setLayout(flowLayout3);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(130, 625));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 8);
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cores");
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 25));
        jPanel1.add(jLabel1);

        numPro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numPro.setText("8");
        numPro.setPreferredSize(new java.awt.Dimension(60, 30));
        numPro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numProFocusLost(evt);
            }
        });
        numPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numProKeyTyped(evt);
            }
        });
        jPanel1.add(numPro);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ExeTime");
        jLabel3.setPreferredSize(new java.awt.Dimension(58, 25));
        jPanel1.add(jLabel3);

        jLabelInfoExeTime.setFont(new java.awt.Font("Meiryo", 0, 14)); // NOI18N
        jLabelInfoExeTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoExeTime.setText("64");
        jLabelInfoExeTime.setPreferredSize(new java.awt.Dimension(60, 16));
        jPanel1.add(jLabelInfoExeTime);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DeadTime");
        jLabel4.setPreferredSize(new java.awt.Dimension(70, 25));
        jLabel4.setRequestFocusEnabled(false);
        jPanel1.add(jLabel4);

        jLabelInfoDeadTime.setFont(new java.awt.Font("Meiryo", 0, 14)); // NOI18N
        jLabelInfoDeadTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoDeadTime.setText("00:00:000 AM");
        jPanel1.add(jLabelInfoDeadTime);

        ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setText("ID");
        ID.setPreferredSize(new java.awt.Dimension(60, 25));
        ID.setRequestFocusEnabled(false);
        jPanel1.add(ID);

        jLabelInfoID.setFont(new java.awt.Font("Meiryo", 0, 14)); // NOI18N
        jLabelInfoID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoID.setText("00");
        jLabelInfoID.setPreferredSize(new java.awt.Dimension(60, 16));
        jPanel1.add(jLabelInfoID);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quick Fit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(120, 150));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 2);
        flowLayout2.setAlignOnBaseline(true);
        jPanel3.setLayout(flowLayout2);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista");
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 20));
        jPanel3.add(jLabel7);

        numMemoryQuickL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numMemoryQuickL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numMemoryQuickL.setText("3");
        numMemoryQuickL.setPreferredSize(new java.awt.Dimension(80, 30));
        numMemoryQuickL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numMemoryQuickLFocusLost(evt);
            }
        });
        numMemoryQuickL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numMemoryQuickLKeyTyped(evt);
            }
        });
        jPanel3.add(numMemoryQuickL);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Restrições");
        jLabel8.setPreferredSize(new java.awt.Dimension(80, 20));
        jPanel3.add(jLabel8);

        numMemoryQuickR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numMemoryQuickR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numMemoryQuickR.setText("3");
        numMemoryQuickR.setPreferredSize(new java.awt.Dimension(80, 30));
        numMemoryQuickR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numMemoryQuickRFocusLost(evt);
            }
        });
        numMemoryQuickR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numMemoryQuickRKeyTyped(evt);
            }
        });
        jPanel3.add(numMemoryQuickR);

        jPanel1.add(jPanel3);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Memory");
        jPanel1.add(jLabel6);

        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        numMemory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numMemory.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numMemory.setText("12000");
        numMemory.setPreferredSize(new java.awt.Dimension(60, 30));
        numMemory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numMemoryFocusLost(evt);
            }
        });
        numMemory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numMemoryKeyTyped(evt);
            }
        });
        jPanel2.add(numMemory);

        jLabelInfoID1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInfoID1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoID1.setText("MB");
        jPanel2.add(jLabelInfoID1);

        jPanel1.add(jPanel2);

        JLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel7.setText("Recriação");
        jPanel1.add(JLabel7);

        numPorcentagem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numPorcentagem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numPorcentagem.setText("50");
        numPorcentagem.setPreferredSize(new java.awt.Dimension(60, 30));
        numPorcentagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numPorcentagemFocusLost(evt);
            }
        });
        numPorcentagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numPorcentagemKeyTyped(evt);
            }
        });
        jPanel4.add(numPorcentagem);

        jLabelInfoID2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelInfoID2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoID2.setText("%");
        jPanel4.add(jLabelInfoID2);

        jPanel1.add(jPanel4);

        jLabel5.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("00:00:000 AM");
        jPanel1.add(jLabel5);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Aplicar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jButton2);

        jPanel6.add(jPanel1);

        PlayPause.setPreferredSize(new java.awt.Dimension(65, 50));
        PlayPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayPauseMouseReleased(evt);
            }
        });
        jPanel6.add(PlayPause);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 524, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EscalonadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscalonadorActionPerformed
        if (Escalonador.getSelectedIndex() == 0) {
            Repaint(0);
            SaveLogic.Escalonador = 1;
        }
        if (Escalonador.getSelectedIndex() == 1) {
            Repaint(1);
            SaveLogic.Escalonador = 2;
        }
        if (Escalonador.getSelectedIndex() == 2) {
            Repaint(2);
            SaveLogic.Escalonador = 3;
        }
    }//GEN-LAST:event_EscalonadorActionPerformed

    private void NumIniProcessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumIniProcessKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_NumIniProcessKeyTyped

    private void NumIniProcessFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NumIniProcessFocusLost
        if (NumIniProcess.getText().length() == 0) {
            NumIniProcess.setText("0");
        }
    }//GEN-LAST:event_NumIniProcessFocusLost

    public boolean PlayPauseMousePressedAux(Builder b) {
        for (Processo processo : b.ExeProcessoLista) {
            if (processo.ID != 0) {
                return false;
            }
        }

        b.sizeMemory = Integer.parseInt(numMemory.getText());
        b.sizeMemoryTotal = Integer.parseInt(numMemory.getText());
        b.RamProcessoLista.clear();
        b.Apto_Exe = true;
        return true;
    }


    private void ComboMemoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMemoryActionPerformed
        if (ComboMemory.getSelectedIndex() == 0) {
            SaveLogic.selectRam = 1;
        }

        if (ComboMemory.getSelectedIndex() == 1) {
            SaveLogic.selectRam = 2;
        }

        if (ComboMemory.getSelectedIndex() == 2) {
            SaveLogic.selectRam = 3;

        }
    }//GEN-LAST:event_ComboMemoryActionPerformed

    private void numProFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numProFocusLost
        if (Escalonador.getSelectedIndex() == 0) {
            UpdateCores(rRobin);
        }

        if (Escalonador.getSelectedIndex() == 1) {
            UpdateCores(SJF_Imp);
        }

        if (Escalonador.getSelectedIndex() == 2) {
            UpdateCores(LTG_Imp);
        }

    }//GEN-LAST:event_numProFocusLost

    private void numMemoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numMemoryFocusLost
        if (Escalonador.getSelectedIndex() == 0) {
            UpdateMemory(rRobin);
        }

        if (Escalonador.getSelectedIndex() == 1) {
            UpdateMemory(SJF_Imp);
        }

        if (Escalonador.getSelectedIndex() == 2) {
            UpdateMemory(LTG_Imp);
        }
    }//GEN-LAST:event_numMemoryFocusLost

    private void numMemoryQuickLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numMemoryQuickLFocusLost
        SaveLogic.quickRestricao = Integer.parseInt(numMemoryQuickR.getText());
    }//GEN-LAST:event_numMemoryQuickLFocusLost

    private void numMemoryQuickRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numMemoryQuickRFocusLost
        SaveLogic.quickLista = Integer.parseInt(numMemoryQuickL.getText());
    }//GEN-LAST:event_numMemoryQuickRFocusLost

    private void PlayPauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayPauseMouseReleased
        if (Escalonador.getSelectedIndex() == 0) {
            if (rRobin.AptoProcessoLista.isEmpty() && PlayPauseMousePressedAux(rRobin)) {
                InitiateProcess(0);
                rRobin.Run(rRobin.AptoProcessoLista, rRobin.ExeProcessoLista);
            }
        } else if (Escalonador.getSelectedIndex() == 1) {
            if (SJF_Imp.AptoProcessoLista.isEmpty() && PlayPauseMousePressedAux(SJF_Imp)) {
                InitiateProcess(1);
                SJF_Imp.Apto_Exe = true;
                SJF_Imp.Run(SJF_Imp.AptoProcessoLista, SJF_Imp.ExeProcessoLista);
            }
        } else if (Escalonador.getSelectedIndex() == 2) {
            if (LTG_Imp.AptoProcessoLista.isEmpty() && PlayPauseMousePressedAux(LTG_Imp)) {
                InitiateProcess(2);
                LTG_Imp.Apto_Exe = true;
                LTG_Imp.Run(LTG_Imp.AptoProcessoLista, LTG_Imp.ExeProcessoLista);
            }
        }
    }//GEN-LAST:event_PlayPauseMouseReleased

    private void numPorcentagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numPorcentagemKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_numPorcentagemKeyTyped

    private void numPorcentagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numPorcentagemFocusLost
        if (Integer.parseInt(numPorcentagem.getText()) > 100) {
            numPorcentagem.setText("100");
        }
    }//GEN-LAST:event_numPorcentagemFocusLost

    private void numMemoryQuickRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numMemoryQuickRKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_numMemoryQuickRKeyTyped

    private void numMemoryQuickLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numMemoryQuickLKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_numMemoryQuickLKeyTyped

    private void numMemoryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numMemoryKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_numMemoryKeyTyped

    private void numProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numProKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_numProKeyTyped

    private void CreateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateMouseReleased
        
        if (Escalonador.getSelectedIndex() == 0) {
            CreateAux(rRobin);
        }
        
        if (Escalonador.getSelectedIndex() == 1) {
            CreateAux(SJF_Imp);
        }
        
        if (Escalonador.getSelectedIndex() == 2) {
            CreateAux(LTG_Imp);
        }
        
    }//GEN-LAST:event_CreateMouseReleased

    public void CreateAux(Builder b) {
        System.out.println(b.threadGo.isAlive());
        if (b.threadGo.isAlive()) {
            synchronized (b.AptoProcessoLista) {
                b.AptoProcessoLista.add(new Processo(b.TOTALID = b.TOTALID + 1));
            }
        }
    }

    public void Repaint(int index) {
        if (index == 0) {
            if (!rRobin.Repaint) {
                rRobin.setVisible(true);
                rRobin.Repaint = true;
                LTG_Imp.setVisible(false);
                LTG_Imp.Repaint = false;
                SJF_Imp.setVisible(false);
                SJF_Imp.Repaint = false;

                ClearBeforeInitiateStart();

                front.moveToFront(rRobin);
                numPro.setText(String.valueOf(rRobin.ExeProcessoLista.size()));
                Initiate(rRobin);
            }
        }

        if (index == 1) {
            if (!SJF_Imp.Repaint) {
                rRobin.Repaint = false;
                rRobin.setVisible(false);
                SJF_Imp.Repaint = true;
                SJF_Imp.setVisible(true);
                LTG_Imp.Repaint = false;
                LTG_Imp.setVisible(false);

                ClearBeforeInitiateStart();

                front.moveToFront(SJF_Imp);
                numPro.setText(String.valueOf(SJF_Imp.ExeProcessoLista.size()));
                Initiate(SJF_Imp);
            }
        }

        if (index == 2) {
            if (!LTG_Imp.Repaint) {
                rRobin.Repaint = false;
                rRobin.setVisible(false);
                SJF_Imp.Repaint = false;
                SJF_Imp.setVisible(false);
                LTG_Imp.Repaint = true;
                LTG_Imp.setVisible(true);

                ClearBeforeInitiateStart();

                front.moveToFront(LTG_Imp);
                numPro.setText(String.valueOf(LTG_Imp.ExeProcessoLista.size()));
                Initiate(LTG_Imp);
            }
        }
    }

    public void InitiateProcess(int index) {
        if (NumIniProcess.getText().equalsIgnoreCase("0")) {
            NumIniProcess.setText("20");
        }
        if (index == 0) {
            InitiateProcessAux(rRobin);
        }

        if (index == 1) {
            InitiateProcessAux(SJF_Imp);
        }

        if (index == 2) {
            InitiateProcessAux(LTG_Imp);
        }
        NumIniProcess.setText("0");
    }

    public void InitiateProcessAux(Builder b) {
        synchronized (b.AptoProcessoLista) {
            for (int i = 0; i < Integer.parseInt(NumIniProcess.getText()); i++) {
                b.AptoProcessoLista.add(new Processo(b.TOTALID = b.TOTALID + 1));
            }
        }
    }

    public void ClearBeforeInitiateStart() {
        ClearBeforeInitiate(rRobin);
        ClearBeforeInitiate(SJF_Imp);
        ClearBeforeInitiate(LTG_Imp);
    }

    public void ClearBeforeInitiate(Builder b) {
        for (Component component : b.AptoPai.getComponents()) {
            if (!(component.equals(b.AptoLista) || component.equals(b.Apto))) {
                b.AptoPai.remove(component);
            }
        }

        for (Component component : b.ExePai.getComponents()) {
            if (!(component.equals(b.ExeLista) || component.equals(b.Exe))) {
                b.ExePai.remove(component);
            }
        }

        for (Component component : b.FinalizadoPai.getComponents()) {
            if (!(component.equals(b.FinalizadoLista) || component.equals(b.Finalizado))) {
                b.FinalizadoPai.remove(component);
            }
        }

        for (Component component : b.RamPai.getComponents()) {
            if (!(component.equals(b.RamLista) || component.equals(b.Ram))) {
                b.RamPai.remove(component);
            }
        }
    }

    public void Initiate(Builder b) {
        b.Initiate(b.ExeLista.getSelectedIndex() * 16 + 1,
                b.ExePai, b.ExeProcessoLista,
                b.Exe, false);
        b.Initiate(b.AptoLista.getSelectedIndex() * 16 + 1,
                b.AptoPai, b.AptoProcessoLista,
                b.Apto, true);
        b.Initiate(b.FinalizadoLista.getSelectedIndex() * 16 + 1,
                b.FinalizadoPai, b.FinalizadoProcessoLista,
                b.Finalizado, true);
        b.Initiate(b.RamLista.getSelectedIndex() * 16 + 1,
                b.RamPai, b.RamProcessoLista,
                b.Ram, false);
    }

    public void TimeUpdate() {
        threadTime = new Thread("threadTime") {
            @Override
            public void run() {
                while (true) {
                    String formattedDate = sdf.format(System.currentTimeMillis());
                    jLabel5.setText(formattedDate);
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        threadTime.start();

        threadDuplicate = new Thread("threadDuplicate") {
            @Override
            public void run() {
                while (true) {
                    int k = rd.nextInt(100) + 1;
                    if (k >= Integer.parseInt(numPorcentagem.getText())) {
                        if (Escalonador.getSelectedIndex() == 0) {
                            rRobin.activeDuplicate = true;
                        }

                        if (Escalonador.getSelectedIndex() == 1) {
                            SJF_Imp.activeDuplicate = true;
                        }

                        if (Escalonador.getSelectedIndex() == 2) {
                            LTG_Imp.activeDuplicate = true;
                        }
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        threadDuplicate.start();
    }

    public void UpdateCores(Builder b) {
        if (!b.threadGo.isAlive() && !numPro.getText().isEmpty()) {
            int number = Integer.parseInt(numPro.getText());
            int total;
            if (number < 1) {
                numPro.setText("4");
            }
            while (number != (total = b.ExeProcessoLista.size())) {
                if (number < total) {
                    b.ExeProcessoLista.remove(total - 1);
                } else {
                    b.ExeProcessoLista.add(new Processo());
                }
            }
            Initiate(b);
        } else {
            numPro.setText(String.valueOf(b.ExeProcessoLista.size()));
        }
    }

    public void UpdateMemory(Builder b) {
        if (Integer.parseInt(numMemory.getText()) < 1) {
            numMemory.setText("4000");
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public void SetInfoIDJpanel(Builder b) {
        b.infoDead = jLabelInfoDeadTime;
        b.infoExe = jLabelInfoExeTime;
        b.infoID = jLabelInfoID;
    }

    public void IconSet() {
        if (Escalonador.getSelectedIndex() == 0) {
            PlayPause = img.ScaledImage(PlayPause, rRobin.Apto_Exe);
        }
        if (Escalonador.getSelectedIndex() == 1) {
            PlayPause = img.ScaledImage(PlayPause, SJF_Imp.Apto_Exe);
        }
        if (Escalonador.getSelectedIndex() == 2) {
            PlayPause = img.ScaledImage(PlayPause, LTG_Imp.Apto_Exe);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboMemory;
    private javax.swing.JButton Create;
    private javax.swing.JComboBox<String> Escalonador;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel JLabel7;
    private so.LTG LTG_Imp;
    private javax.swing.JTextField NumIniProcess;
    private javax.swing.JButton PlayPause;
    private so.SJF SJF_Imp;
    private javax.swing.JLayeredPane front;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelInfoDeadTime;
    private javax.swing.JLabel jLabelInfoExeTime;
    private javax.swing.JLabel jLabelInfoID;
    private javax.swing.JLabel jLabelInfoID1;
    private javax.swing.JLabel jLabelInfoID2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JTextField numMemory;
    private javax.swing.JTextField numMemoryQuickL;
    private javax.swing.JTextField numMemoryQuickR;
    private javax.swing.JTextField numPorcentagem;
    private javax.swing.JTextField numPro;
    private so.RoundRobin rRobin;
    // End of variables declaration//GEN-END:variables
}
