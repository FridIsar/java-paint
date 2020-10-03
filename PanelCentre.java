import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* Classe du panneau central
*/
public class PanelCentre extends JPanel implements MouseListener,
MouseMotionListener, KeyListener, Serializable   {

    /**
    * contient les tracables precedents
    */
    private ArrayList<Tracable> memory;

    /**
    * represente la forme courante
    */
    private Tracable courant;

    /**
    * fait reference au panneau sud
    */
    private PanelSud south;

    /**
    * fait reference au panneau est
    */
    private PanelEst east;

    /**
    * fait reference au panneau ouest
    */
    private PanelOuest west;

    /**
    * couleur courante de la forme
    */
    private Color col;

    /**
    * couleur courante du fond
    */
    private Color colFond;

    /**
    * initialise le panneau centre
    */
    public PanelCentre(){
        this.setBackground(Color.white);
        colFond = Color.white;
        this.initConnections();
        clear();
    }

    /**
    * ajoute des listeners souris/clavier au panneau
    */
    public void initConnections(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    /**
    * lie le panneau Est au panneau courant
    * @param pEst panneau a lier
    */
    public void setPanelEst(PanelEst pEst){
        east = pEst;
    }

    /**
    * lie le panneau Ouest au panneau courant
    * @param pOuest panneau a lier
    */
    public void setPanelOuest(PanelOuest pOuest){
        west = pOuest;
    }

    /**
    * methode liant le panneau Sud au panneau courant
    * @param pSud panneau a lier
    */
    public void setPanelSud(PanelSud pSud){
        south = pSud;
    }

    /**
    * attribue un objet tracable au tracable courant
    * @param t tracable a rendre courant
    */
    public void setCurrentTracable(Tracable t)   {
        this.courant = t;
    }

    /**
    * definit la couleur courante du tracable
    * @param c couleur a rendre courante
    */
    public void setCurrentColor(Color c)   {
        this.col = c;
    }

    /**
    * definit la couleur courante du fond
    * @param c couleur de fond a rendre courante
    */
    public void setFondColor(Color c)   {
        this.colFond = c;
        this.setBackground(c);
        repaint();
    }

    /**
    * remplace la memoire par le contenu du fichier
    * @param file fichier a charger
    * @throws FileNotFoundException si fichier non trouve
    * @throws IOException si erreur input output
    * @throws ClassNotFoundException si classe non trouvee
    */
    public void read(File file) throws FileNotFoundException,
    IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        memory = (ArrayList<Tracable>) ois.readObject();
        ois.close();
        System.out.println("recup... "+memory);
        repaint();
    }

    /**
    * ecrit l'ArrayList de Tracables dans un fichier
    * @param file fichier dans lequel ecrire
    * @throws FileNotFoundException si fichier non trouve
    * @throws IOException si erreur input output
    */
    public void write(File file) throws FileNotFoundException,
    IOException   {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(memory);
        System.out.println("sauvegarde...");
        oos.close();
    }

    /**
    * supprime la memoire
    */
    public void clear() {
        this.memory = new ArrayList<Tracable>();
        repaint();
    }

    /**
    * supprime le dernier element de la memoire
    */
    public void undo() {
        if (this.memory.size()>0){
            this.memory.remove(this.memory.size()-1);
            repaint();
        }

        else {
            System.out.println("Rien a undo");
        }
    }

    /**
    * dessine tous les tracables contenus en memoire
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Repaint");
        for(int i = 0; i < memory.size(); i++)
        {
            memory.get(i).dessine(g);
        }
        System.out.println(memory);
    }
    public void mousePressed(MouseEvent e) {
        int xs = e.getX();
        int ys = e.getY();
        System.out.println("Enfoncement du bouton de la souris en "+xs+","+ys);
    }

    public void mouseReleased(MouseEvent e) {
        int xs = e.getX();
        int ys = e.getY();
        System.out.println("Relachement du bouton de la souris en "+xs+","+ys);
    }

    /**
    * remplit ou dessine le tracable courant a chaque clic
    */
    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();
        int xs = e.getX();
        int ys = e.getY();
        System.out.println("Clic souris en "+xs+","+ys);
        Point p = new Point(xs,ys);
        courant.dessine(g,p,col,colFond);
        if (courant.isComplete()){
            memory.add(courant);
        }
    }

    public void mouseMoved(MouseEvent e) {
        int xs = e.getX();
        int ys = e.getY();
        System.out.println("Deplacement en "+xs+","+ys);
    }

    /**
    * remplit ou dessine le tracable courant a chaque glissement
    s'il est draggable.
    */
    public void mouseDragged(MouseEvent e) {
        int xs = e.getX();
        int ys = e.getY();
        System.out.println("Glissement en "+xs+","+ys);
        if (courant.isDraggable())    {
        Graphics g = getGraphics();
        Point p = new Point(xs,ys);
        courant.dessine(g,p,col,colFond);
        memory.add(courant);
        }
    }

    public void mouseEntered(MouseEvent e) {
        this.requestFocus(); //pour avoir le focus sur le panel du centre sinon le clavier risque de ne pas repondre
        int xs = e.getX();
        int ys = e.getY();
        System.out.println("Entree de la souris en "+xs+","+ys);
    }

    public void mouseExited(MouseEvent e) {
        int xs = e.getX();
        int ys = e.getY();
        System.out.println("Sortie de la souris en "+xs+","+ys);
    }

    /**
    * definit le tracable courant en faisant
    ctrl + premiere lettre de la forme
    * raccourci clavier pour undo
    */
    public void keyPressed(KeyEvent e) {
        char car  = e.getKeyChar();
        int i = e.getKeyCode() ;
        if (e.isControlDown() && (i == KeyEvent.VK_C) ){
            System.out.println(" < Ctrl + c > pressee ");
            courant = new Cercle();
        }
        if (e.isControlDown() && (i == KeyEvent.VK_D) ){
            System.out.println(" < Ctrl + d > pressee ");
            courant = new Droite();
        }
        if (e.isControlDown() && (i == KeyEvent.VK_T) ){
            System.out.println(" < Ctrl + t > pressee ");
            courant = new Triangle();
        }

        if (e.isControlDown() && (i == KeyEvent.VK_R) ){
            System.out.println(" < Ctrl + r > pressee ");
            courant = new Rectangle();
        }

        if (e.isControlDown() && (i == KeyEvent.VK_P) ){
            System.out.println(" < Ctrl + P > pressee ");
            courant = new PetitPoint();
        }

        if (e.isControlDown() && (i == KeyEvent.VK_Z) ){
            System.out.println(" < Ctrl + z > pressee ");
            undo();
        }

        System.out.println("Enfoncement de la touche "+ car);
    }

    /**
    * indique chaque touche frappee
    */
    public void keyTyped(KeyEvent e) {
        char k = e.getKeyChar();
        System.out.println("Touche frappee "+ k);
    }

    public void keyReleased(KeyEvent e) {
        char k = e.getKeyChar();
        System.out.println("Relachement de la touche "+k);
    }
}
