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
    protected World monde;
    protected Vector3 pos;

    public Pill(World monde, Vector3 pos){
        this.monde = monde;
        this.pos = pos;
    }

    public float getRadius(){
        return this.radius;
    }

    abstract void effect();

    abstract void draw(SpriteBatch sb);

}

// TYPES PASTILLES
// 128 = normale
// 200 = taille
// 225 = temps