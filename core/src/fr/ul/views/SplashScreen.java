package fr.ul.views;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.concurrent.TimeUnit;

import fr.ul.dataFactories.SoundFactory;
import fr.ul.dataFactories.TextureFactory;
import fr.ul.rollingball.RollingBall;

import com.badlogic.gdx.Gdx;

/**
 * Created by roth52u on 24/01/17.
 */

public class SplashScreen extends ScreenAdapter {
    protected RollingBall rollingBall;
    protected SpriteBatch spriteBatch;
    protected int duree;

    public SplashScreen(RollingBall rollingBall){
        this.rollingBall = rollingBall;
        this.spriteBatch = new SpriteBatch();
        this.duree = 0;
    }

    @Override
    public void render(float delta){
        spriteBatch.begin();
        spriteBatch.draw(TextureFactory.getIntro(), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
        // si met la lecture du son dans un if, ça lit pas... Pourquoi ?

        if(duree < 2)
            SoundFactory.lireVictoire(50);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        duree ++;
        if (duree == 3){
            rollingBall.toGameScreen();

        }
    }

    public void dispose () {
        spriteBatch.dispose();
    }

    public void show(){
        this.duree = 0;
    }
}
