package fr.ul.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import fr.ul.dataFactories.TextureFactory;

/**
 * Created by guigu on 29/01/2017.
 */

public class Boule extends MovableElement {
    protected static float default_radius = 20;
    protected float current_radius;
    protected World world;
    protected Texture texture;

    public Boule(World world, Vector3 position) {
        super(position);
        this.world = world;
        this.current_radius = this.default_radius;
        this.texture = TextureFactory.getBoule();
    }

    public void draw(SpriteBatch sB){
        float x = super.getPosition().x;
        float y = super.getPosition().y;
        sB.draw(texture, x-(current_radius), y-(current_radius), current_radius*2, current_radius*2);
    }

    public float getCurrent_radius(){
        return this.current_radius;
    }
}
