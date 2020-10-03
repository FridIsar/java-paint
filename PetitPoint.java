import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;


/**
* represente un point
*/
public class PetitPoint implements Serializable, Tracable {

    /**
    * coordonnees du centre du point
    */
    private Point origine;

    /**
    * couleur du point
    */
    private Color c;

    /**
    * construit un point
    */
    public PetitPoint() {    }

    /**
    * construit un point
    * @param start represente le centre du point
    */
    public PetitPoint(Point start) {
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
        g.fillOval(xa-2,ya-2,4,4);
    }

    public void dessine(Graphics g, Point p, Color col, Color colFond) {
        this.c = col;
        if(p != null){
            this.origine = new Point(p);
        }
        if (origine!=null)  {
            g.setColor(c);
            int xa = (int) origine.getX();
            int ya = (int) origine.getY();
            g.fillOval(xa-2,ya-2,4,4);
        }
    }
}
