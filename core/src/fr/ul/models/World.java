package fr.ul.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import fr.ul.dataFactories.TextureFactory;
import fr.ul.views.GameScreen;

import static java.awt.Color.white;

/**
 * Created by guigu on 29/01/2017.
 */

public class World {
    protected GameScreen gameScreen;
    protected Boule boule;
    protected Pixmap labyPixmap;
    protected Texture labyTexture;
    protected int currentLabyNumber;
    protected Pill pillTaille, pillNormale, pillTemps;
    protected ArrayList<Pill> listePastilles;

    public World(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        // on initialise la boule au milieu de l'écran
        this.boule = new Boule(this, new Vector3(Gdx.graphics.getWidth()/4f, Gdx.graphics.getHeight()/4f, 0f));
        this.setLaby(0);
        this.pillNormale = new PillNormal(this, new Vector3(200, 100,0));
        this.pillTaille = new PillTaille(this, new Vector3(200, 200, 0));
        this.pillTemps = new PillTime(this, new Vector3(100, 200, 0));
        this.listePastilles = new ArrayList<Pill>();
    }

    public SpriteBatch getSpriteBatch(){
        return gameScreen.getSpriteBatch();
    }

    public Boule getBoule(){
        return this.boule;
    }

    public void draw(SpriteBatch sB){
        sB.draw(getLabyTexture(), 0, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        this.boule.draw(sB);
        this.pillNormale.draw(sB);
        this.pillTaille.draw(sB);
        this.pillTemps.draw(sB);
        extractPills();
    }

    public Pixmap getLabyPixmap(){ return this.labyPixmap; }
    public Texture getLabyTexture() {return this.labyTexture; }

    public void setLaby(int param){
        this.labyPixmap = TextureFactory.getLabyPixmap(param);
        this.labyTexture = TextureFactory.getLabyTexture(param);
        this.currentLabyNumber = param;
    }


    // TYPES PASTILLES
    // 128 = normale
    // 200 = taille
    // 225 = temps
    public void extractPills(){
        for(int i = 0; i < Gdx.graphics.getHeight(); i++){
            for(int j = 0; j < Gdx.graphics.getWidth(); j+=10){
                int coul = labyPixmap.getPixel(i, j)&255;
                if(coul > 0 && coul < 255) {
                    if (coul == 200) {
                        int nouveauX = i+(int)pillTemps.getRadius();
                        int nouveauY = j+1;
                        listePastilles.add(new PillTime(this, new Vector3(nouveauX, nouveauY, 0)));

                        this.labyPixmap.setColor(0, 0, 0, 255);
                        this.labyPixmap.fillCircle(nouveauX, nouveauY, (int)pillTemps.getRadius());
                        System.out.println("pastille ouais");
                    }
                }
            }
        }
    }

}
