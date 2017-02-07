package fr.ul.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by guigu on 06/02/2017.
 */

public class SoundFactory {
    private static SoundFactory instance = new SoundFactory();

    private static Sound alerte = Gdx.audio.newSound(Gdx.files.internal("sounds/alerte.mp3"));
    private static Sound victoire = Gdx.audio.newSound(Gdx.files.internal("sounds/victoire.mp3"));
    private static Sound perte = Gdx.audio.newSound(Gdx.files.internal("sounds/perte.mp3"));
    private static Sound collision = Gdx.audio.newSound(Gdx.files.internal("sounds/collision.wav"));
    private static Sound pastille = Gdx.audio.newSound(Gdx.files.internal("sounds/pastille.wav"));
    private static Sound ptaille = Gdx.audio.newSound(Gdx.files.internal("sounds/ptaille.wav"));
    private static Sound ptemps = Gdx.audio.newSound(Gdx.files.internal("sounds/ptemps.wav"));


    public static SoundFactory getInstance(){ return instance; }

    public static void lireAlerte(float volume){ alerte.play(volume); }
    public static void lireVictoire(float volume){ victoire.play(volume); }
    public static void lirePerte(float volume){ perte.play(volume); }
    public static void lireCollision(float volume){ collision.play(volume); }
    public static void lirePastille(float volume){ pastille.play(volume); }
    public static void lirePtaille(float volume){ ptaille.play(volume); }
    public static void lirePtemps(float volume){ ptemps.play(volume); }

}
