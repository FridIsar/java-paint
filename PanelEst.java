import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* Panneau de selection de couleurs
*/
public class PanelEst extends JPanel {

    /**
    * fait reference au panneau central
    */
    private PanelCentre centre;

    /**
    * lie le panneau Centre au panneau courant
    * @param pCentre panneau a lier
    */
    public void setPanelCentre(PanelCentre pCentre){
        this.centre = pCentre;
    }

    /**
    * Construit le panneau Est et ses boutons
    */
    public PanelEst(){

        JPanel boutons = new JPanel();
        boutons.setLayout(new GridLayout(3,1,2,4));
        this.setBackground(Color.gray);

        /**
        * initialise une palette
        */
        JColorChooser jc = new JColorChooser();

        /**
        * bouton nomme selection couleurs
        */
        JButton boutonSelector = new JButton("Selection Couleurs");

        /**
        * bouton nomme couleur fond
        */
        JButton boutonCouleurFond = new JButton("Couleur Fond");

        /**
        * bouton nomme couleur dessin
        */
        JButton boutonCouleurDessin = new JButton("Couleur Dessin");

        /**
        * bouton nomme cacher selection
        */
        JButton boutonHideSelector = new JButton("Cacher Selection");

        boutons.add(boutonHideSelector);
        boutons.add(boutonCouleurDessin);
        boutons.add(boutonCouleurFond);
        boutons.setBackground(Color.gray);

        this.add(jc);
        this.add(boutons);
        this.add(boutonSelector);

        jc.setVisible(false);
        boutons.setVisible(false);

        /**
        * associe au bouton l'affichage de la palette et d'autres boutons
        */
        boutonSelector.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boutons.setVisible(true);
                jc.setVisible(true);
                boutonSelector.setVisible(false);
            }
        });

        /**
        * associe au bouton la disparition de la palette et d'autres boutons
        */
        boutonHideSelector.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jc.setVisible(false);
                boutonSelector.setVisible(true);
                boutons.setVisible(false);
            }
        });

        /**
        * associe au bouton le changement de couleur de fond selon la couleur selectionnee par la palette
        */
        boutonCouleurFond.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.setFondColor(jc.getColor());
            }
        });

        /**
        * associe au bouton le changement de couleur du Tracable courant selon la couleur selectionnee par la palette
        */
        boutonCouleurDessin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.setCurrentColor(jc.getColor());
            }
        });
    }
}
