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

    public TextureFactory getInstance(){ return this.instance; }

    public static Texture getIntro(){ return intro; }

    public static Texture getDeco(){ return deco; }
}
