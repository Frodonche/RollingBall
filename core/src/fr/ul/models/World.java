package fr.ul.models;

import com.badlogic.gdx.Gdx;
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

    public World(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        // on initialise la boule au milieu de l'écran
        this.boule = new Boule(this, new Vector3(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f, 0f));
    }

    public SpriteBatch getSpriteBatch(){
        return gameScreen.getSpriteBatch();
    }

    public Boule getBoule(){
        return this.boule;
    }

    public void draw(){
        this.getBoule().draw(TextureFactory.getBoule());
    }
}
