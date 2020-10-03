import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* panneau sud contenant des boutons determinant la forme courante
*/
public class PanelSud extends JPanel {

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
    * constructeur du panneau sud
    */
    public PanelSud(){

        this.setBackground(Color.gray);

        /**
        * bouton nomme droite
        */
        JButton buttonDroite = new JButton("Droite");
        /**
        * associe au bouton la determination du tracable courant en droite non attribuee
        */
        buttonDroite.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.setCurrentTracable(new Droite());
            }
        });

        /**
        * bouton nomme crayon
        */
        JButton buttonCrayon = new JButton("Crayon");
        /**
        * associe au bouton la determination du tracable courant en petitpoint non attribuee
        */
        buttonCrayon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.setCurrentTracable(new PetitPoint());
            }
        });

        /**
        * bouton nomme gomme
        */
        JButton buttonGomme = new JButton("Gomme");
        /**
        * associe au bouton la determination du tracable courant en gomme
        */
        buttonGomme.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.setCurrentTracable(new Gomme());
            }
        });

        /**
        * bouton nomme cercle
        */
        JButton buttonCercle = new JButton("Cercle");
        /**
        * associe au bouton la determination du tracable courant en cercle non attribuee
        */
        buttonCercle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.setCurrentTracable(new Cercle());
            }
        });

        /**
        * bouton nomme rectangle
        */
        JButton buttonRect = new JButton("Rectangle");
        /**
        * associe au bouton la determination du tracable courant en rectangle non attribuee
        */
        buttonRect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.setCurrentTracable(new Rectangle());
            }
        });

        /**
        * bouton nomme triangle
        */
        JButton buttonTri = new JButton("Triangle");
        /**
        * associe au bouton la determination du tracable courant en triangle non attribuee
        */
        buttonTri.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.setCurrentTracable(new Triangle());
            }
        });

        /**
        * bouton nomme undo
        */
        JButton buttonUndo = new JButton("Undo");
        /**
        * associe au bouton l'appel de la methode undo
        */
        buttonUndo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.undo();
            }
        });

        /**
        * bouton nomme clear
        */
        JButton buttonClear = new JButton("Clear");
        /**
        * associe au bouton l'appel de la methode clear
        */
        buttonClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                centre.clear();
            }
        });

        this.add(buttonDroite);
        this.add(buttonRect);
        this.add(buttonTri);
        this.add(buttonCercle);
        this.add(buttonCrayon);
        this.add(buttonGomme);
        this.add(buttonUndo);
        this.add(buttonClear);
    }
}
