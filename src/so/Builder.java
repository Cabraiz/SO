/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import Beans.Processo;
import Beans.QuickFit;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Mateus
 */
public abstract class Builder extends javax.swing.JPanel {

    JPanel Exe;
    JPanel ExePai;
    JPanel Apto;
    JPanel AptoPai;
    JPanel Finalizado;
    JPanel FinalizadoPai;
    JPanel Ram;
    JPanel RamPai;
    JPanel HD;
    JPanel HDPai;

    JComboBox ExeLista;
    JComboBox AptoLista;
    JComboBox FinalizadoLista;
    JComboBox RamLista;
    JComboBox HDLista;

    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S a");
    DecimalFormatSymbols dfSymbols = new DecimalFormatSymbols();
    DecimalFormat df = new DecimalFormat();

    int TOTALID = 0;

    Thread threadGo = new Thread();
    Thread threadBack = new Thread();

    ArrayList<Processo> AptoProcessoLista = new ArrayList<>();
    ArrayList<Processo> ExeProcessoLista = new ArrayList<>();
    ArrayList<Processo> FinalizadoProcessoLista = new ArrayList<>();

    public boolean Apto_Exe = false;
    public boolean Repaint = false;

    int diff = 2;

    JLabel infoExe;
    JLabel infoDead;
    JLabel infoID;

    boolean drawGreen = false;
    boolean drawRed = false;

    String drawGreenStr = "#66BB6A";
    String drawRedStr = "#E53935";

    boolean IsdrawQuick = false;
    String drawQuickStr = "";

    double dd;

    //MEMORIA
    int sizeMemory;
    int sizeMemoryTotal;

    ArrayList<Processo> RamProcessoLista = new ArrayList<>();
    ArrayList<Processo> RamProcessoListaAux = new ArrayList<>();

    ArrayList<QuickFit> RamQuickFit = new ArrayList<>();
    ArrayList<QuickFit> CountQuickFit = new ArrayList<>();
    boolean activeDuplicate = false;

    public boolean tt1 = true;
    public boolean tt2 = true;

    //HD
    ArrayList<Processo> HDProcessoLista = new ArrayList<>();
    ArrayList<Integer> ErrorLista = new ArrayList<>();

    public Builder() {
        dfSymbols.setDecimalSeparator('.');
        df.setGroupingUsed(false);
        df = new DecimalFormat("0.00", dfSymbols);
    }

    public void Initiate(int i, JPanel paiJPanel, ArrayList<Processo> processoLista,
            JPanel painel, boolean b) {
        //Booleano 1 - Se é para encher a lista com processos

        Processo p;
        JPanel tempPanel = painel;
        JLabel(painel, 0, processoLista, i);
        String k = String.valueOf(i);
        int u = 0;
        if (processoLista.size() >= i) {
            if (processoLista.get(i - 1).ID != 0) {
                k = PrintExe(processoLista, paiJPanel, i);
                p = processoLista.get(i - 1);
                if (paiJPanel == FinalizadoPai) {
                    if (p.exe < 0) {
                        painel.setBackground(Color.decode(drawGreenStr));
                    } else {
                        painel.setBackground(Color.decode(drawRedStr));
                    }
                }

                if (RamPai == paiJPanel) {
                    if (SaveLogic.selectRam == 2) {
                        for (QuickFit quickFit : RamQuickFit) {
                            if (p.oldMemory == quickFit.number) {
                                painel.setBackground(Color.decode(quickFit.color));
                                break;
                            }
                        }
                    }
                }

                JLabel(painel, p.ID, processoLista, i);
            }
        }

        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                k, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));

        for (int j = 1 + i; j < 16 + i; j++) {
            if ((!b && j <= processoLista.size()) || b) {
                if (j <= processoLista.size()) {
                    FinalizadosMethod(paiJPanel, processoLista.get(j - 1));
                    RamMethod(paiJPanel, processoLista.get(j - 1));

                }
                k = PrintExe(processoLista, paiJPanel, j);

                if (j % (8 + i) == 0) {
                    tempPanel = CreateVer(painel, k);
                } else {
                    tempPanel = CreateHor(tempPanel, k);
                }
                JLabel jl = (JLabel) tempPanel.getComponent(0);

                if (j <= processoLista.size()) {
                    p = processoLista.get(j - 1);
                    if (p.ID != 0) {
                        if (paiJPanel == RamPai) {
                            if (p.isWorking()) {
                                jl.setText("P" + p.ID);
                            }
                        } else {
                            jl.setText("P" + p.ID);
                        }
                    }
                }
                paiJPanel.add(tempPanel);
            }
        }

        AddPags(AptoLista, AptoProcessoLista.size());
        AddPags(ExeLista, ExeProcessoLista.size());
        AddPags(FinalizadoLista, FinalizadoProcessoLista.size());
        AddPags(RamLista, RamProcessoLista.size());
        revalidate();
        repaint();

    }

    public JPanel CreateHor(JPanel jp, String title) {
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel();

        jp2.setBounds(jp.getBounds().x + jp.getBounds().width, jp.getBounds().y,
                jp.getBounds().width, jp.getBounds().height);

        jp2 = CreateGeneric(jp2, jl2, title);
        return jp2;
    }

    public JPanel CreateVer(JPanel jp, String title) {
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel();

        jp2.setBounds(jp.getBounds().x, jp.getBounds().y + jp.getBounds().height,
                jp.getBounds().width, jp.getBounds().height);

        jp2 = CreateGeneric(jp2, jl2, title);
        return jp2;
    }

    public JPanel CreateGeneric(JPanel jp, JLabel jl, String title) {
        if (drawGreen) {
            jp.setBackground(Color.decode(drawGreenStr));
            drawGreen = false;
        }
        if (drawRed) {
            jp.setBackground(Color.decode(drawRedStr));
            drawRed = false;
        }
        if (IsdrawQuick) {
            jp.setBackground(Color.decode(drawQuickStr));
            IsdrawQuick = false;
        }
        jp.setVisible(true);
        jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                title, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
        jp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AptoMousePressed(evt);
            }
        });
        jp.setLayout(new GridBagLayout());
        jp.add(jl);
        jl.setFont(new java.awt.Font("Tahoma", 0, 12));
        return jp;
    }

    public void AptoMousePressed(java.awt.event.MouseEvent evt) {
        JPanel pan = (JPanel) evt.getSource();
        JLabel jl = (JLabel) pan.getComponent(0);
        if (jl.getText().length() > 0) {
            int k = Integer.parseInt(jl.getText().substring(1, jl.getText().length()));
            infoID.setText(String.valueOf(k));
            ArrayList<Processo> aptoTempList = new ArrayList<>(AptoProcessoLista);
            ArrayList<Processo> exeTempList = new ArrayList<>(ExeProcessoLista);
            ArrayList<Processo> finalizadoTempList = new ArrayList<>(FinalizadoProcessoLista);
            for (Processo p : aptoTempList) {
                if (p.getID() == k) {
                    Write(p);
                }
            }
            for (Processo p : exeTempList) {
                if (p.getID() == k) {
                    Write(p);
                }
            }
            for (Processo p : finalizadoTempList) {
                if (p.getID() == k) {
                    Write(p);
                }
            }
        }
    }

    public String PrintExe(ArrayList<Processo> processoLista, JPanel paiJPanel, int j) {
        String k = String.valueOf(j);
        if (j <= processoLista.size()) {
            Processo p = processoLista.get(j - 1);
            if (p.ID != 0) {
                if (paiJPanel == ExePai || paiJPanel == AptoPai) {
                    if (SaveLogic.Escalonador == 1 && paiJPanel != AptoPai) {
                        k = String.valueOf(df.format((dd = System.currentTimeMillis() - p.createTime) / 1000));
                    } else if (SaveLogic.Escalonador == 2) {
                        k = String.valueOf(df.format(p.exe));
                    } else if (SaveLogic.Escalonador == 3) {
                        k = String.valueOf(df.format((dd = p.deadline.getTime() - System.currentTimeMillis()) / 1000));
                    }
                }
            }
            if (paiJPanel == RamPai || paiJPanel == HDPai) {
                k = String.valueOf(p.memory);
            }
        }
        return k;
    }

    public void Write(Processo p) {
        infoExe.setText(String.valueOf(df.format(p.getExe())) + "s");
        Date date = new Date(p.getDeadline().getTime());
        String formattedDate = sdf.format(date);
        infoDead.setText(formattedDate);
    }

    public void FinalizadosMethod(JPanel painel, Processo p) {
        if (painel == FinalizadoPai) {
            if (p.exe < 0) {
                drawGreen = true;
            } else {
                drawRed = true;
            }
        }
    }

    public void RamMethod(JPanel painel, Processo p) {
        if (RamPai == painel) {
            if (SaveLogic.selectRam == 2) {
                for (QuickFit quickFit : RamQuickFit) {
                    //System.out.println(quickFit.number);
                    if (p.oldMemory == quickFit.number) {
                        drawQuickStr = quickFit.color;
                        IsdrawQuick = true;
                        break;
                    }
                }
            }
        }
    }

    public void JLabel(JPanel jp, int i, ArrayList<Processo> processoLista, int j) {
        JLabel jl;
        if (jp.getComponentCount() == 0) {
            jl = new JLabel();
            jl.setFont(new java.awt.Font("Tahoma", 0, 12));
            jp.add(jl);
            jl.setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            jl = (JLabel) jp.getComponent(0);
        }
        if (i != 0) {
            jl.setText("P" + i);
        } else {
            jl.setText("");
        }
        if (j <= processoLista.size()) {
            Processo p = processoLista.get(j - 1);
            if (jp == Ram) {
                if (p.IsWorking) {
                    jl.setText("P" + i);
                } else {
                    jl.setText("");
                }
            }
        }
    }

    public void AddPags(JComboBox js, int i) {
        while (js.getItemCount() * 16 > i + 15 && i != 0) {
            js.removeItemAt(js.getItemCount() - 1);
        }
        while (js.getItemCount() * 16 < i) {
            js.addItem("Pag " + (js.getItemCount() + 1));
        }
    }

    public void RunPaint() {

        RunPaintAux(AptoPai, AptoLista, Apto);
        RunPaintAux(ExePai, ExeLista, Exe);
        RunPaintAux(FinalizadoPai, FinalizadoLista, Finalizado);
        RunPaintAux(RamPai, RamLista, Ram);
        RunPaintAux(HDPai, HDLista, HD);

        ArrayList<Processo> exeTempList = new ArrayList<>(ExeProcessoLista);
        ArrayList<Processo> aptoTempList = new ArrayList<>(AptoProcessoLista);
        ArrayList<Processo> finalizadoTempList = new ArrayList<>(FinalizadoProcessoLista);
        ArrayList<Processo> ramTempList = new ArrayList<>(RamProcessoLista);
        ArrayList<Processo> hdTempList = new ArrayList<>(HDProcessoLista);

        try {
            SwingUtilities.invokeAndWait(() -> {

                Initiate(FinalizadoLista.getSelectedIndex() * 16 + 1, FinalizadoPai,
                        finalizadoTempList, Finalizado, true);
                Initiate((ExeLista.getSelectedIndex() * 16) + 1, ExePai,
                        exeTempList, Exe, false);
                Initiate((AptoLista.getSelectedIndex() * 16) + 1, AptoPai,
                        aptoTempList, Apto, true);
                Initiate((RamLista.getSelectedIndex() * 16) + 1, RamPai,
                        ramTempList, Ram, false);
                Initiate((HDLista.getSelectedIndex() * 16) + 1, HDPai,
                        hdTempList, HD, false);

            });
        } catch (InterruptedException | InvocationTargetException ex) {
            Logger.getLogger(Builder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RunPaintAux(JPanel pai, JComboBox lista, JPanel filho) {
        for (Component component : pai.getComponents()) {
            if (!(component.equals(lista) || component.equals(filho))) {
                pai.remove(component);
            }
        }
    }

    Comparator<QuickFit> quickComparator = new Comparator<QuickFit>() {
        @Override
        public int compare(QuickFit o1, QuickFit o2) {
            if (o1.number < o2.number) {
                return -1;
            }
            if (o1.number > o2.number) {
                return 1;
            }
            return 0;
        }
    };

    public boolean MemoryAux(Processo p, boolean b) {
        boolean passou = true;

        if (activeDuplicate && !b) {
            Duplicate();
        } else if (!b) {
            //pq se ele já tivesse reservado a memória
            for (Processo processo : RamProcessoLista) {
                if (processo.ID == p.ID) {
                    return true;
                }
            }
        }

        if (sizeMemory - p.memory >= 0) {

            if (SaveLogic.swapping >= sizeMemory) {
                SwappingIn();
            }

            if (SaveLogic.selectRam == 1) {
                Processo bestSize = null;
                int bestValue = 0;
                int temp;

                for (Processo pp : RamProcessoListaAux) {
                    if (pp.getMemory() >= p.getMemory()) {
                        temp = pp.getMemory() - p.getMemory();
                        if (bestValue <= temp) {
                            bestValue = pp.getMemory() - p.getMemory();
                            bestSize = pp;
                            passou = false;
                        }
                    }
                }

                if (!passou) {

                    bestSize.ID = p.ID;
                    bestSize.IsWorking = true;
                    bestSize.oldMemory = bestSize.memory;
                    bestSize.memory = p.memory;
                    RamProcessoListaAux.remove(bestSize);

                } else {
                    if (sizeMemoryTotal - p.memory >= 0) {
                        sizeMemoryTotal = sizeMemoryTotal - p.memory;
                        RamProcessoLista.add(p);

                    } else {
                        if (!ErrorLista.contains(sizeMemoryTotal)) {
                            System.err.println("java.lang.OutOfMemoryError.Create-> Size Memory: "
                                    + sizeMemoryTotal + " Request: " + p.memory);
                            ErrorLista.add(sizeMemoryTotal);
                        }
                        return false;
                    }
                }

                sizeMemory = sizeMemory - p.memory;
                Main.numMemory.setText(String.valueOf(sizeMemory));
            }

            if (SaveLogic.selectRam == 2) {

                Collections.sort(RamQuickFit, quickComparator);

                boolean find = false;
                for (QuickFit quickFit : RamQuickFit) {
                    if (quickFit.number == p.memory) {
                        find = true;
                        for (Processo pp : quickFit.list) {
                            if (pp.getMemory() >= p.getMemory() && !pp.IsWorking) {
                                pp.ID = p.ID;
                                pp.IsWorking = true;
                                pp.oldMemory = pp.memory;
                                pp.memory = p.memory;
                                passou = false;
                                break;
                            }
                        }
                        if (!passou) {
                            break;
                        }
                    }
                    if (find) {
                        for (Processo pp : quickFit.list) {
                            if (pp.getMemory() >= p.getMemory() && !pp.IsWorking) {
                                pp.ID = p.ID;
                                pp.IsWorking = true;
                                pp.oldMemory = pp.memory;
                                pp.memory = p.memory;
                                passou = false;
                                break;
                            }
                        }
                        if (!passou) {
                            break;
                        }
                    }
                }

                if (passou) {

                    if (sizeMemoryTotal - p.memory >= 0) {
                        sizeMemoryTotal = sizeMemoryTotal - p.memory;
                        RamProcessoLista.add(p);

                    } else {
                        if (!ErrorLista.contains(sizeMemoryTotal)) {
                            System.err.println("java.lang.OutOfMemoryError.Create-> Size Memory: "
                                    + sizeMemoryTotal + " Request: " + p.memory);
                            ErrorLista.add(sizeMemoryTotal);
                        }
                        return false;
                    }

                    for (QuickFit counterFit : CountQuickFit) {
                        if (counterFit.number == p.memory) {
                            counterFit.count = counterFit.count + 1;
                            passou = false;
                        }

                        boolean passou2 = true;
                        if (counterFit.count >= SaveLogic.quickRestricao) {
                            //n adicionar duplicatas
                            for (QuickFit qq : RamQuickFit) {
                                if (qq.number == p.memory) {
                                    passou2 = false;
                                    break;
                                }
                            }

                            if (passou2) {
                                if (SaveLogic.quickLista == RamQuickFit.size()) {
                                    QuickFit qTemp = null;
                                    for (QuickFit quickFit : RamQuickFit) {
                                        if (counterFit.count > quickFit.count) {
                                            qTemp = quickFit;
                                            break;
                                        }
                                    }

                                    if (qTemp != null) {
                                        RamQuickFit.remove(qTemp);
                                        RamQuickFit.add(new QuickFit(p.memory));
                                    }

                                } else {
                                    RamQuickFit.add(new QuickFit(p.memory));
                                }
                            }
                        }

                    }

                    if (passou) {
                        CountQuickFit.add(new QuickFit(p.memory, 1));
                    }

                }

                for (QuickFit quickFit : RamQuickFit) {
                    quickFit.list.clear();
                    for (Processo processo : RamProcessoLista) {
                        if (processo.oldMemory == p.memory) {
                            quickFit.list.add(processo);
                        }
                    }
                }

                sizeMemory = sizeMemory - p.memory;
                Main.numMemory.setText(String.valueOf(sizeMemory));
            }

            if (SaveLogic.selectRam == 3) {

                ArrayList<Processo> neighborRemoveList = new ArrayList<>();
                Processo pTemp = null;
                int totalValue = 0;

                boolean neighbor = false;
                for (Processo pp : RamProcessoLista) {
                    if (neighbor && !pp.IsWorking) {
                        neighborRemoveList.add(pp);
                        totalValue = totalValue + pTemp.oldMemory;
                    } else {
                        if (totalValue > 0) {
                            pTemp.oldMemory = totalValue;
                            totalValue = 0;
                        }
                        neighbor = false;
                        if (!pp.IsWorking) {
                            neighbor = true;
                            pTemp = pp;
                        }
                    }
                }

                for (Processo pp : neighborRemoveList) {
                    RamProcessoLista.remove(pp);
                    sizeMemoryTotal = sizeMemoryTotal + p.oldMemory;
                }

                neighborRemoveList.clear();

                for (Processo pp : RamProcessoLista) {
                    if (pp.getMemory() >= p.getMemory() && !pp.IsWorking) {
                        pp.ID = p.ID;
                        pp.IsWorking = true;
                        pp.oldMemory = pp.memory;
                        pp.memory = p.memory;
                        passou = false;
                        break;
                    }
                }

                if (passou) {
                    if (sizeMemoryTotal - p.memory >= 0) {
                        sizeMemoryTotal = sizeMemoryTotal - p.memory;
                        RamProcessoLista.add(p);
                    } else {
                        if (!ErrorLista.contains(sizeMemoryTotal)) {
                            System.err.println("java.lang.OutOfMemoryError.Create-> Size Memory: "
                                    + sizeMemoryTotal + " Request: " + p.memory);
                            ErrorLista.add(sizeMemoryTotal);
                        }
                        return false;

                    }
                }

                sizeMemory = sizeMemory - p.memory;
                Main.numMemory.setText(String.valueOf(sizeMemory));
            }
            return true;
        }

        System.err.println("java.lang.OutOfMemoryError-> Size Memory: "
                + sizeMemory + " Request: " + p.memory);
        return false;
    }

    public void MemoryRemove(Processo p) {

        for (Processo processo : new ArrayList<>(HDProcessoLista)) {
            if (processo.ID == p.ID) {
                HDProcessoLista.remove(processo);
            }
        }

        for (Processo processo : RamProcessoLista) {
            if (processo.ID == p.ID && processo.IsWorking) {
                sizeMemory = sizeMemory + processo.memory;
                processo.memory = processo.oldMemory;
                processo.setIsWorking(false);
                RamProcessoListaAux.add(processo);
                Main.numMemory.setText(String.valueOf(sizeMemory));
            }
        }
    }

    ArrayList<Processo> tempArray = new ArrayList<>();

    public void Duplicate() {
        Random rd = new Random();
        Processo p = null;

        for (Processo processo : RamProcessoLista) {
            if (processo.IsWorking) {
                tempArray.add(processo);
            }
        }

        if (tempArray.size() > 0) {
            Processo pp = tempArray.get(rd.nextInt(tempArray.size()));
            p = new Processo(pp.ID);
            if (!MemoryAux(p, true)) {
                if (ExeProcessoLista.indexOf(pp) != -1) {
                    ExeProcessoLista.set(ExeProcessoLista.indexOf(pp), new Processo());
                }
                FinalizadoProcessoLista.add(pp);
                AptoProcessoLista.remove(pp);
                MemoryRemove(pp);
            }
        }
        tempArray.clear();
        activeDuplicate = false;
    }

    public void SwappingIn() {
        ArrayList<Integer> tempListSwap = new ArrayList<>();
        for (Processo p : RamProcessoLista) {
            if (!tempListSwap.contains(p.ID) && p.IsWorking) {
                tempListSwap.add(p.ID);
            }
        }

        for (Integer integer : tempListSwap) {
            boolean b = false;
            for (Processo processo : ExeProcessoLista) {
                if (processo.ID == integer) {
                    b = true;
                }
            }
            if (!b) {
                SwappingMemoryRemove(integer);
            }
        }
    }

    public void SwappingMemoryRemove(int index) {
        for (Processo processo : RamProcessoLista) {
            if (processo.ID == index && processo.IsWorking) {
                HDProcessoLista.add(new Processo(processo));

                sizeMemory = sizeMemory + processo.memory;
                processo.memory = processo.oldMemory;
                processo.setIsWorking(false);
                RamProcessoListaAux.add(processo);
                Main.numMemory.setText(String.valueOf(sizeMemory));

            }
        }
    }

    public void SwappingOut() {
        for (Processo pp : new ArrayList<>(HDProcessoLista)) {
            for (Processo processo : new ArrayList<>(ExeProcessoLista)) {
                if (pp.ID == processo.ID) {
                    Processo p = new Processo(pp.ID);
                    if (!MemoryAux(p, true)) {
                        if (ExeProcessoLista.indexOf(pp) != -1) {
                            ExeProcessoLista.set(ExeProcessoLista.indexOf(pp), new Processo());
                        }
                        FinalizadoProcessoLista.add(pp);
                        AptoProcessoLista.remove(pp);
                        MemoryRemove(pp);
                    }
                    HDProcessoLista.remove(pp);
                    break;
                }
            }
        }
    }

    public void Remoldar(JPanel pai, JPanel filho, JComboBox lista, ArrayList<Processo> arrayLista, boolean b) {

        for (Component component : pai.getComponents()) {
            if (!(component.equals(lista) || component.equals(filho))) {
                pai.remove(component);
            }
        }
        Initiate((lista.getSelectedIndex() * 16) + 1, pai, arrayLista, filho, b);

    }
}
