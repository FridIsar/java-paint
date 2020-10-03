import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;


/**
* represente un cercle
*/
public class Cercle implements Serializable, Tracable {
    /**
    * coordonnees de l'origine
    */
    private Point origine;

    /**
    * coordonnees du rayon
    */
    private Point rayon;

    /**
    * couleur du cercle
    */
    private Color c;

    /**
    * construit un cercle
    */
    public Cercle() {    }

    /**
    * construit un cercle
    * @param start represente l'origine
    * @param end represente le rayon
    */
    public Cercle(Point start, Point end) {
        this.origine = start;
        this.rayon = end;
    }

    public Boolean isComplete(){
        return(this.origine != null && this.rayon != null);
    }

    public Boolean isDraggable(){
        return false;
    }

    public void dessine(Graphics g) {
        g.setColor(c);
        int xa = (int) origine.getX();
        int ya = (int) origine.getY();
        int xb = (int) rayon.getX();
        int yb = (int) rayon.getY();
        int ray = xb - xa;
        g.fillOval(xa-ray,ya-ray,2*ray,2*ray);
    }

    public void dessine(Graphics g, Point p, Color col, Color colFond) {
        this.c = col;
        if(p != null){
            if (origine == null){
                this.origine = new Point(p);
            }
            else {
                if (rayon == null){
                    this.rayon = new Point(p);
                }
            }
        }
        if (rayon!=null && origine!=null){
            g.setColor(c);
            int xa = (int) origine.getX();
            int ya = (int) origine.getY();
            int xb = (int) rayon.getX();
            int yb = (int) rayon.getY();
            int ray = xb - xa;
            g.fillOval(xa-ray,ya-ray,2*ray,2*ray);
        }
    }
}
