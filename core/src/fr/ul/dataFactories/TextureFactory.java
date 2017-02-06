package fr.ul.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;

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
    private static ArrayList<String> listeLaby;

    public static TextureFactory getInstance(){ return instance; }
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
    public static String getLaby(int param) { return listeLaby.get(param); }

    private TextureFactory(){
        FilenameFilter FnF = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.startsWith("Laby") && s.endsWith(".png");
            }
        };

        FileHandle[] fichier = Gdx.files.internal("images/").list(FnF);
        listeLaby = new ArrayList<String>();

        for (FileHandle f : fichier) {
            listeLaby.add(f.name());
        }

        Collections.sort(listeLaby);
        System.out.println("MA LISTE LABY : "+listeLaby.toString());
    }

    public static Texture getLabyTexture(int param){
        return new Texture(Gdx.files.internal("images/"+getLaby(param)));
    }

    public static Pixmap getLabyPixmap(int param){
        Texture temp = getLabyTexture(param);
        TextureData td = temp.getTextureData();
        if(!td.isPrepared())
            td.prepare();
        return td.consumePixmap();
    }

    public int getLabysNumber(){ return listeLaby.size(); }
}
