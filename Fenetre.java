import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* Classe initialisant la fenetre
*/
public class Fenetre extends JFrame {
    Fenetre(String titre){
        super(titre);
        setSize(800,500);
        this.init();
        System.out.println("Initialisation");
        this.setVisible(true);
    }

    /**
    * methode remplissant une fenetre avec 2 onglets :
     1. le logiciel de dessin contenant 4 panneaux lies entre eux
     2. un panneau texte
    */
    public void init(){
        JTabbedPane tabs = new JTabbedPane();
        JPanel tab1 = new JPanel();
        JPanel tab2 = new JPanel();

        tab1.setLayout(new BorderLayout());
        tab2.setLayout(new BorderLayout());

        tab2.add(new JTextPane());

        PanelSud pSud = new PanelSud();
        PanelCentre pCentre = new PanelCentre();
        PanelEst pEst = new PanelEst();
        PanelOuest pOuest = new PanelOuest();

        pCentre.setPanelSud(pSud);
        pCentre.setPanelEst(pEst);
        pCentre.setPanelOuest(pOuest);
        pEst.setPanelCentre(pCentre);
        pOuest.setPanelCentre(pCentre);
        pSud.setPanelCentre(pCentre);

        tab1.add(pCentre,BorderLayout.CENTER);
        tab1.add(pSud,BorderLayout.SOUTH);
        tab1.add(pEst,BorderLayout.EAST);
        tab1.add(pOuest,BorderLayout.WEST);

        tabs.addTab("Logiciel de dessin",tab1);
        tabs.addTab("Notes",tab2);

        this.add(tabs);
    }
}
