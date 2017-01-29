package fr.ul.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by guigu on 29/01/2017.
 */

public class MovableElement extends GameElement {
    protected Vector3 vitesse;
    protected SpriteBatch spriteBatch;

    public MovableElement(Vector3 position){
        super(position); // on passe les paramètres à la superclasse
        this.vitesse = new Vector3(); // nouveau vecteur
        this.spriteBatch = new SpriteBatch(); //spritebatch de l'élément
    }

    public void draw(SpriteBatch spriteBatch){
        // bidon pour avoir la paix avec AS
    }

    public void draw(Texture texture, float width, float height){
        spriteBatch.begin();
        spriteBatch.draw(texture, getPosition().x, getPosition().y, width, height);
        spriteBatch.end();
    }

    public Vector3 getVitesse(){ // une deuxième méthode ????
        return this.vitesse;
    }

    public void accelerer(Vector3 vecteur){ // ajout d'un vecteur accélération à la vitesse courante
        this.vitesse.add(vecteur);
    }

    public void maj(){ // on met à jour la position en y ajoutant la vitesse
        this.getPosition().add(this.getVitesse());
    }
}
