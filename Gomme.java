import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;


/**
* represente une gomme
*/
public class Gomme implements Serializable, Tracable {

    /**
    * coordonnees du point central de la gomme
    */
    private Point origine;

    /**
    * couleur de la gomme
    */
    private Color c;

    /**
    * construit une gomme
    */
    public Gomme() {    }

    /**
    * construit une gomme
    * @param start represente le point central
    */
    public Gomme(Point start) {
        this.origine = start;
    }

    public Boolean isComplete(){
        return(this.origine != null);
    }

    public Boolean isDraggable(){
        return true;
    }

    public void dessine(Graphics g) {
        g.setColor(c);
        int xa = (int) origine.getX();
        int ya = (int) origine.getY();
        g.fillOval(xa-10,ya-10,20,20);
    }

    public void dessine(Graphics g, Point p, Color col, Color colFond) {
        this.c = colFond;
        if(p != null){
            this.origine = new Point(p);
        }
        if (origine!=null)  {
            g.setColor(c);
            int xa = (int) origine.getX();
            int ya = (int) origine.getY();
            g.fillOval(xa-10,ya-10,20,20);
        }
    }
}
