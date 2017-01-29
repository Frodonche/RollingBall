package fr.ul.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by guigu on 29/01/2017.
 */

public abstract class GameElement {
    private Vector3 position; //attribut de position

   public GameElement(Vector3 position){
        this.position = position;
    }

    public Vector3 getPosition(){
        return this.position;
    }

    public abstract void draw(SpriteBatch spriteBatch);
}
