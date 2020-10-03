import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* represente un triangle
*/
public class Triangle implements Serializable, Tracable {

    /**
    * coordonnees du premier point du triangle
    */
    private Point p1;

    /**
    * coordonnees du deuxieme point du triangle
    */
    private Point p2;

    /**
    * coordonnees du troisieme point du triangle
    */
    private Point p3;

    /**
    * couleur du triangle
    */
    private Color c;

    /**
    * construit un triangle dont les variables pointent vers null
    */
    public Triangle() {
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
    }

    /**
    * construit un triangle en fonction des trois points entres en parametre
    * @param po1 premier point
    * @param po2 deuxieme point
    * @param po3 troisieme point
    */
    public Triangle(Point po1, Point po2, Point po3) {
        this.p1 = po1;
        this.p2 = po2;
        this.p3 = po3;
    }

    public Boolean isComplete() {
        return(this.p1 != null && this.p2 != null && this.p3 != null);
    }

    public Boolean isDraggable(){
        return false;
    }

    public void dessine(Graphics g, Point p, Color col, Color colFond) {
        this.c = col;
        if(p != null){
            if (p1 == null){
                this.p1 = new Point(p);
            }
            else {
                if (p2 == null){
                    this.p2 = new Point(p);
                }
                else{
                    if (p3 == null){
                        this.p3 = new Point(p);
                    }
                }
            }
        }
        if (this.p1 != null && this.p2 != null && this.p3 != null){
            g.setColor(c);
            g.drawLine((int) p1.getX(),(int) p1.getY(),(int) p2.getX(),(int) p2.getY());
            g.drawLine((int) p2.getX(),(int) p2.getY(),(int) p3.getX(),(int) p3.getY());
            g.drawLine((int) p3.getX(),(int) p3.getY(),(int) p1.getX(),(int) p1.getY());
        }
    }

    public void dessine(Graphics g) {
        g.setColor(c);
        g.drawLine((int) p1.getX(),(int) p1.getY(),(int) p2.getX(),(int) p2.getY());
        g.drawLine((int) p2.getX(),(int) p2.getY(),(int) p3.getX(),(int) p3.getY());
        g.drawLine((int) p3.getX(),(int) p3.getY(),(int) p1.getX(),(int) p1.getY());
    }
}
