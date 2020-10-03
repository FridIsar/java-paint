import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* Interface pour Objet tracable.
*/
public interface Tracable   {
    /**
    * Attribue les variables si necessaires a l'objet, sinon le dessine.
    * @param g Variable de la classe Graphics contenant les outils necessaires pour dessiner.
    * @param p Represente un point sur le plan.
    * @param col Variable de type Color utilisee pour les formes.
    * @param colFond Variable de type Color utilisee pour le fond.
    */
    public void dessine(Graphics g, Point p, Color col, Color colFond);

    /**
    * Dessine l'objet.
    * @param g Variable de la classe Graphics contenant les outils necessaires pour dessiner.
    */
    public void dessine(Graphics g);

    /**
    * Verifie si l'objet est complet.
    * @return true si le ou les points de la formes sont tous definis.
    */
    public Boolean isComplete();

    /**
    * Indique si le tracable est draggable.
    * @return true si le tracable est draggable.
    */
    public Boolean isDraggable();
}
