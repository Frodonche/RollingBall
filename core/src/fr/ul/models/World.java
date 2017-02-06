package fr.ul.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import fr.ul.dataFactories.TextureFactory;
import fr.ul.views.GameScreen;

/**
 * Created by guigu on 29/01/2017.
 */

public class World {
    protected GameScreen gameScreen;
    protected Boule boule;
    protected Pixmap labyPixmap;
    protected Texture labyTexture;
    protected int currentLabyNumber;

    public World(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        // on initialise la boule au milieu de l'écran
        this.boule = new Boule(this, new Vector3(Gdx.graphics.getWidth()/4f, Gdx.graphics.getHeight()/4f, 0f));
        this.setLaby(0);
    }

    public SpriteBatch getSpriteBatch(){
        return gameScreen.getSpriteBatch();
    }

    public Boule getBoule(){
        return this.boule;
    }

    public void draw(SpriteBatch sB){
        sB.draw(getLabyTexture(), 0, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        this.getBoule().draw(sB);
    }

    public Pixmap getLabyPixmap(){ return this.labyPixmap; }
    public Texture getLabyTexture() {return this.labyTexture; }

    public void setLaby(int param){
        this.labyPixmap = TextureFactory.getLabyPixmap(param);
        this.labyTexture = TextureFactory.getLabyTexture(param);
        this.currentLabyNumber = param;
    }

}
