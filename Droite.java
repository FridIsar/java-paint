import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* represente une droite
*/
public class Droite implements Serializable, Tracable {

    /**
    * coordonnees du premier point de la droite
    */
    private Point origine;

    /**
    * coordonnees du second point de la droite
    */
    private Point destination;

    /**
    * couleur de la droite
    */
    private Color c;

    /**
    * construit une droite dont les variables pointent vers null
    */
    public Droite() {
        this.origine = null;
        this.destination = null;
    }

    /**
    * construit une droite en fonction des deux points entres en parametre
    * @param start debut de la droite
    * @param end fin de la droite
    */
    public Droite(Point start, Point end) {
        this.origine = start;
        this.destination = end;
    }


    public Boolean isComplete() {
        return(this.origine != null && this.destination != null);
    }

    public Boolean isDraggable(){
        return false;
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
            g.drawLine((int) origine.getX(),(int) origine.getY(),(int) destination.getX(),(int) destination.getY());}
        }

        public void dessine(Graphics g) {
            g.setColor(c);
            g.drawLine((int) origine.getX(),(int) origine.getY(),(int) destination.getX(),(int) destination.getY());
        }


    }
