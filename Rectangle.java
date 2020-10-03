import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;


/**
* represente un rectangle
*/
public class Rectangle implements Serializable, Tracable {
    /**
    * coordonnees du premier point du rectangle
    */
    private Point origine;

    /**
    * coordonnees du second point du rectangle
    */
    private Point destination;

    /**
    * couleur du rectangle
    */
    private Color c;

    /**
    * construit un rectangle dont les variables pointent vers null
    */
    public Rectangle() {    }

    /**
    * construit un rectangle en fonction des deux points entres en parametre
    * @param start debut du rectangle
    * @param end fin du rectangle
    */
    public Rectangle(Point start, Point end) {
        this.origine = start;
        this.destination = end;
    }

    public Boolean isComplete(){
        return(this.origine != null && this.destination != null);
    }

    public Boolean isDraggable(){
        return false;
    }

    public void dessine(Graphics g) {
        g.setColor(c);
        int xa = (int) origine.getX();
        int ya = (int) origine.getY();
        int xb = (int) destination.getX();
        int yb = (int) destination.getY();
        g.drawRect(xa,ya,(xb-xa),(yb-ya));
    }

    public void dessine(Graphics g, Point p, Color col, Color colFond) {
        this.c = col;
        if(p != null){
            if (origine == null){
                this.origine = new Point(p);
            }
            else {
                if (destination == null){
                    this.destination = new Point(p);
                }
            }
        }
        if (destination!=null && origine!=null){
            g.setColor(c);
            int xa = (int) origine.getX();
            int ya = (int) origine.getY();
            int xb = (int) destination.getX();
            int yb = (int) destination.getY();
            g.drawRect(xa,ya,(xb-xa),(yb-ya));}
        }
    }
