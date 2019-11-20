package so;

import Beans.Processo;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class SJF extends Builder {

    public SJF() {
        initComponents();

        super.AptoLista = AptoLista;
        super.AptoPai = AptoPai;
        super.Apto = Apto;

        super.FinalizadoLista = FinalizadoLista;
        super.FinalizadoPai = FinalizadoPai;
        super.Finalizado = Finalizado;

        super.ExeLista = ExeLista;
        super.ExePai = ExePai;
        super.Exe = Exe;

        super.RamLista = RamLista;
        super.RamPai = RamPai;
        super.Ram = Ram;

        super.HDLista = HDLista;
        super.HDPai = HDPai;
        super.HD = HD;
    }

    public void Run(ArrayList<Processo> aptoLista, ArrayList<Processo> exeLista) {
        ArrayList<Component> tempComponentArray = new ArrayList<>();

        threadBack = new Thread("threadBack") {
            @Override
            public void run() {
                while (true) {
                    while (Apto_Exe) {
                        if (Repaint) {
                            RunPaint();
                        }
                        try {
                            sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        if (tt1) {
            tt1 = false;
            threadBack.start();
        }
        threadGo = new Thread("threadGo") {
            @Override
            public void run() {
                Comparator<Processo> comparator = new Comparator<Processo>() {
                    @Override
                    public int compare(Processo o1, Processo o2) {
                        if (o1.exe < o2.exe) {
                            return -1;
                        }
                        if (o1.exe > o2.exe) {
                            return 1;
                        }
                        return 0;
                    }
                };
                while (true) {
                    SwappingOut();
                    synchronized (AptoProcessoLista) {
                        Collections.sort(aptoLista, comparator);
                    }

                    for (int i = 0; exeLista.size() > i && aptoLista.size() > i; i++) {
                        Processo p = aptoLista.get(0);
                        for (int j = 0; j < exeLista.size(); j++) {
                            long nowTime = System.currentTimeMillis();
                            if (p.deadline.getTime() < nowTime) {
                                FinalizadoProcessoLista.add(p);
                                MemoryRemove(p);
                                AptoProcessoLista.remove(p);
                                break;
                            }
                            if (exeLista.get(j).ID == 0) {
                                Processo n = new Processo(p.ID, p.exe,
                                        p.deadline, p.prior, nowTime, p.memory, p.IsWorking, p.oldMemory);

                                if (MemoryAux(n, false)) {
                                    ExeProcessoLista.set(j, n);
                                    AptoProcessoLista.remove(0);
                                } else {
                                    FinalizadoProcessoLista.add(p);
                                    MemoryRemove(p);
                                    AptoProcessoLista.remove(p);
                                }

                                break;
                            }
                        }
                    }

                    for (Processo p : exeLista) {
                        if (p.createTime != 0) {
                            long nowTime = System.currentTimeMillis();
                            double runTime = (double) (nowTime - p.createTime) / 1000;
                            if (p.exe < 0) {
                                FinalizadoProcessoLista.add(p);
                                MemoryRemove(p);
                                ExeProcessoLista.set(exeLista.indexOf(p), new Processo());
                            } else {
                                if (exeLista.indexOf(p) != -1) {
                                    exeLista.set(exeLista.indexOf(p),
                                            new Processo(p.ID, p.exe - runTime,
                                                    p.deadline, p.prior, nowTime, p.memory, p.IsWorking, p.oldMemory));
                                }
                            }
                        }
                    }
                }
            }
        };
        if (tt2) {
            tt2 = false;
            threadGo.start();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExePai = new javax.swing.JPanel();
        Exe = new javax.swing.JPanel();
        ExeLista = new javax.swing.JComboBox<>();
        RamPai = new javax.swing.JPanel();
        Ram = new javax.swing.JPanel();
        RamLista = new javax.swing.JComboBox<>();
        HDPai = new javax.swing.JPanel();
        HD = new javax.swing.JPanel();
        HDLista = new javax.swing.JComboBox<>();
        AptoPai = new javax.swing.JPanel();
        Apto = new javax.swing.JPanel();
        AptoLista = new javax.swing.JComboBox<>();
        FinalizadoPai = new javax.swing.JPanel();
        Finalizado = new javax.swing.JPanel();
        FinalizadoLista = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(500, 300));
        setLayout(new java.awt.GridLayout(0, 1, 1, 1));

        ExePai.setBorder(javax.swing.BorderFactory.createTitledBorder("Executando"));

        Exe.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Exe.setName(""); // NOI18N
        Exe.setPreferredSize(new java.awt.Dimension(50, 40));
        Exe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExeMousePressed(evt);
            }
        });
        Exe.setLayout(new java.awt.GridLayout(1, 0));

        ExeLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ExeLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pag 1" }));
        ExeLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExeListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExePaiLayout = new javax.swing.GroupLayout(ExePai);
        ExePai.setLayout(ExePaiLayout);
        ExePaiLayout.setHorizontalGroup(
            ExePaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExePaiLayout.createSequentialGroup()
                .addComponent(Exe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExeLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ExePaiLayout.setVerticalGroup(
            ExePaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExePaiLayout.createSequentialGroup()
                .addGroup(ExePaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Exe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExeLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        add(ExePai);

        RamPai.setBorder(javax.swing.BorderFactory.createTitledBorder("Ram"));
        RamPai.setPreferredSize(new java.awt.Dimension(480, 110));

        Ram.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Ram.setName(""); // NOI18N
        Ram.setPreferredSize(new java.awt.Dimension(50, 40));
        Ram.setLayout(new java.awt.GridLayout(1, 0));

        RamLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RamLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pag 1" }));
        RamLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RamListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RamPaiLayout = new javax.swing.GroupLayout(RamPai);
        RamPai.setLayout(RamPaiLayout);
        RamPaiLayout.setHorizontalGroup(
            RamPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RamPaiLayout.createSequentialGroup()
                .addComponent(Ram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RamLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        RamPaiLayout.setVerticalGroup(
            RamPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RamPaiLayout.createSequentialGroup()
                .addGroup(RamPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RamLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        add(RamPai);

        HDPai.setBorder(javax.swing.BorderFactory.createTitledBorder("Hard Disk"));

        HD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        HD.setName(""); // NOI18N
        HD.setPreferredSize(new java.awt.Dimension(50, 40));
        HD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HDMousePressedPri(evt);
            }
        });
        HD.setLayout(new java.awt.GridLayout(1, 0));

        HDLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HDLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pag 1" }));
        HDLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HDPaiLayout = new javax.swing.GroupLayout(HDPai);
        HDPai.setLayout(HDPaiLayout);
        HDPaiLayout.setHorizontalGroup(
            HDPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HDPaiLayout.createSequentialGroup()
                .addComponent(HD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HDLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HDPaiLayout.setVerticalGroup(
            HDPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HDPaiLayout.createSequentialGroup()
                .addGroup(HDPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HDLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        add(HDPai);

        AptoPai.setBorder(javax.swing.BorderFactory.createTitledBorder("Aptos"));

        Apto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Apto.setName(""); // NOI18N
        Apto.setPreferredSize(new java.awt.Dimension(50, 40));
        Apto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AptoMousePressedPri(evt);
            }
        });
        Apto.setLayout(new java.awt.GridLayout(1, 0));

        AptoLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AptoLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pag 1" }));
        AptoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AptoListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AptoPaiLayout = new javax.swing.GroupLayout(AptoPai);
        AptoPai.setLayout(AptoPaiLayout);
        AptoPaiLayout.setHorizontalGroup(
            AptoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AptoPaiLayout.createSequentialGroup()
                .addComponent(Apto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AptoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        AptoPaiLayout.setVerticalGroup(
            AptoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AptoPaiLayout.createSequentialGroup()
                .addGroup(AptoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Apto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AptoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        add(AptoPai);

        FinalizadoPai.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizados"));

        Finalizado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Finalizado.setName(""); // NOI18N
        Finalizado.setPreferredSize(new java.awt.Dimension(50, 40));
        Finalizado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FinalizadoMousePressedPri(evt);
            }
        });
        Finalizado.setLayout(new java.awt.GridLayout(1, 0));

        FinalizadoLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FinalizadoLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pag 1" }));
        FinalizadoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizadoListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FinalizadoPaiLayout = new javax.swing.GroupLayout(FinalizadoPai);
        FinalizadoPai.setLayout(FinalizadoPaiLayout);
        FinalizadoPaiLayout.setHorizontalGroup(
            FinalizadoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FinalizadoPaiLayout.createSequentialGroup()
                .addComponent(Finalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FinalizadoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        FinalizadoPaiLayout.setVerticalGroup(
            FinalizadoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FinalizadoPaiLayout.createSequentialGroup()
                .addGroup(FinalizadoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Finalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinalizadoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        add(FinalizadoPai);
    }// </editor-fold>//GEN-END:initComponents

    private void AptoMousePressedPri(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AptoMousePressedPri
        AptoMousePressed(evt);
    }//GEN-LAST:event_AptoMousePressedPri

    private void AptoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AptoListaActionPerformed
        Remoldar(AptoPai, Apto, AptoLista, AptoProcessoLista, true);
    }//GEN-LAST:event_AptoListaActionPerformed

    private void HDMousePressedPri(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HDMousePressedPri
        AptoMousePressed(evt);
    }//GEN-LAST:event_HDMousePressedPri

    private void HDListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDListaActionPerformed
        Remoldar(HDPai, HD, HDLista, HDProcessoLista, false);
    }//GEN-LAST:event_HDListaActionPerformed

    private void RamListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RamListaActionPerformed
        Remoldar(RamPai, Ram, RamLista, RamProcessoLista, false);
    }//GEN-LAST:event_RamListaActionPerformed

    private void ExeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExeMousePressed
        AptoMousePressed(evt);
    }//GEN-LAST:event_ExeMousePressed

    private void ExeListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExeListaActionPerformed
        Remoldar(ExePai, Exe, ExeLista, ExeProcessoLista, false);
    }//GEN-LAST:event_ExeListaActionPerformed

    private void FinalizadoMousePressedPri(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinalizadoMousePressedPri
        AptoMousePressed(evt);
    }//GEN-LAST:event_FinalizadoMousePressedPri

    private void FinalizadoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizadoListaActionPerformed
        Remoldar(FinalizadoPai, Finalizado, FinalizadoLista, FinalizadoProcessoLista, true);
    }//GEN-LAST:event_FinalizadoListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Apto;
    public javax.swing.JComboBox<String> AptoLista;
    public javax.swing.JPanel AptoPai;
    public javax.swing.JPanel Exe;
    public javax.swing.JComboBox<String> ExeLista;
    public javax.swing.JPanel ExePai;
    public javax.swing.JPanel Finalizado;
    public javax.swing.JComboBox<String> FinalizadoLista;
    public javax.swing.JPanel FinalizadoPai;
    public javax.swing.JPanel HD;
    public javax.swing.JComboBox<String> HDLista;
    public javax.swing.JPanel HDPai;
    public javax.swing.JPanel Ram;
    public javax.swing.JComboBox<String> RamLista;
    public javax.swing.JPanel RamPai;
    // End of variables declaration//GEN-END:variables
}
