package fr.ul.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by guigu on 29/01/2017.
 */

public class Boule extends MovableElement {
    protected static float default_radius = 20;
    protected float current_radius;
    protected World world;

    public Boule(World world, Vector3 position) {
        super(position);
        this.world = world;
        this.current_radius = this.default_radius;
    }

    public void draw(Texture texture){
        super.draw(texture, current_radius, current_radius);
    }

    public float getCurrent_radius(){
        return this.current_radius;
    }
}
