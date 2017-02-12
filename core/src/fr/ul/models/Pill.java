package fr.ul.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import fr.ul.dataFactories.TextureFactory;

/**
 * Created by guigu on 11/02/2017.
 */

public abstract class Pill {
    public static float radius = 15;
    private World monde;
    private Vector3 pos;

    private Animation anim;
    private float tempsAnim;

    public Pill(World monde, Vector3 pos){
        this.monde = monde;
        this.pos = pos;
        this.anim = TextureFactory.getInstance().getAnimPastilleTemps();
        this.tempsAnim = 0;
    }

    public float getRadius(){
        return this.radius;
    }

    abstract void effect();

    //abstract void draw(SpriteBatch sb);

    public void draw (SpriteBatch sB){
        tempsAnim += Gdx.graphics.getDeltaTime();
        TextureRegion im = (TextureRegion)anim.getKeyFrame(tempsAnim);
        sB.draw(im, pos.x, pos.y, radius, radius);
    }
}
