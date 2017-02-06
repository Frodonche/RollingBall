package fr.ul.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by roth52u on 24/01/17.
 */

public class TextureFactory {
    private static TextureFactory instance = new TextureFactory();
    private static Texture intro = new Texture(Gdx.files.internal("images/Intro.jpg"));
    private static Texture deco = new Texture(Gdx.files.internal("images/Deco.jpg"));
    private static Texture boule = new Texture(Gdx.files.internal("images/badlogic.jpg"));
    private static Texture bouleAnim = new Texture(Gdx.files.internal("images/boule.bmp"));
    private static Texture bravo = new Texture(Gdx.files.internal("images/Bravo.bmp"));
    private static Texture perte = new Texture(Gdx.files.internal("images/Perte.bmp"));
    private static Texture pastilleTailleFixe = new Texture(Gdx.files.internal("images/pastilleTaille.bmp"));
    private static Texture pastilleTailleAnim = new Texture(Gdx.files.internal("images/pastilleTaille.png"));
    private static Texture pastilleNormaleFixe = new Texture(Gdx.files.internal("images/pastilleNormale.bmp"));
    private static Texture pastilleNormaleAnim = new Texture(Gdx.files.internal("images/pastilleNormale.png"));
    private static Texture pastilleTempsFixe = new Texture(Gdx.files.internal("images/pastilleTemps.bmp"));
    private static Texture pastilleTempsAnim = new Texture(Gdx.files.internal("images/pastilleTemps.png"));

    public TextureFactory getInstance(){ return this.instance; }
    public static Texture getIntro(){ return intro; }
    public static Texture getDeco(){ return deco; }
    public static Texture getBoule(){ return boule; }
    public static Texture getBouleAnim(){ return bouleAnim; }
    public static Texture getBravo(){ return bravo; }
    public static Texture getPerte(){ return perte; }
    public static Texture getPastilleTailleFixe(){ return pastilleTailleFixe; }
    public static Texture getPastilleTailleAnim(){ return pastilleTailleAnim; }
    public static Texture getPastilleNormaleFixe(){ return pastilleNormaleFixe; }
    public static Texture getPastilleNormaleAnim(){ return pastilleNormaleAnim; }
    public static Texture getPastilleTempsFixe(){ return pastilleTempsFixe; }
    public static Texture getPastilleTempsAnim(){ return pastilleTempsAnim; }
}
