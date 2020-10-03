import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* panneau ouest pour sauvegarder ou charger un fichier
*/
public class PanelOuest extends JPanel {


    /**
    * fait reference au panneau central
    */
    private PanelCentre centre;

    /**
    * methode liant le panneau central au panneau courant
    * @param pCentre panneau a lier
    */
    public void setPanelCentre(PanelCentre pCentre){
        this.centre = pCentre;
    }

    /**
    * Construit le panneau Ouest et ses boutons
    */
    public PanelOuest(){
        JPanel boutons = new JPanel();
        boutons.setLayout(new GridLayout(3,1,2,4));
        boutons.setBackground(Color.gray);
        this.setBackground(Color.gray);


        /**
        * nouveau file chooser sur le repertoire courant
        */
        JFileChooser jf = new JFileChooser(".");

        /**
        * bouton nomme sauver
        */
        JButton boutonSauver = new JButton("Sauver");

        /**
        * bouton nomme charger
        */
        JButton boutonCharger = new JButton("Charger");

        boutons.add(boutonSauver);
        boutons.add(boutonCharger);
        this.add(boutons);

        /**
        * associe au bouton l'apparition du file chooser et la recuperation du fichier
        entre ou selectionne et appelle la methode de sauvegarde du panneau central
        */
        boutonSauver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jf.showSaveDialog(null);
                File file = new File(jf.getSelectedFile().toString());
                try{centre.write(jf.getSelectedFile());}
                catch(FileNotFoundException a){ System.out.println("ERREUR"); }
                catch(IOException b){ b.printStackTrace(); } // utilise pour avoir les details sur l'erreur
            }
        });

        /**
        * associe au bouton l'apparition du file chooser et la recuperation du
        fichier selectionne et appelle la methode de lecture du panneau central
        */
        boutonCharger.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jf.showOpenDialog(null);
                try{centre.read(jf.getSelectedFile());}
                catch(FileNotFoundException a){ System.out.println("ERREUR"); }
                catch(IOException b){ System.out.println("ERREUR"); }
                catch(ClassNotFoundException c){ System.out.println("ERREUR"); }
            }
        });
    }
}
