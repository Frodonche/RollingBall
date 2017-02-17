package fr.ul.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import fr.ul.dataFactories.TextureFactory;

/**
 * Created by roth52u on 17/02/17.
 */

public class PillTaille extends Pill {
    private Animation anim;
    private float tempsAnim;

    public PillTaille(World monde, Vector3 pos){
        super(monde, pos);
        this.anim = TextureFactory.getInstance().getAnimPastilleTaille();
        this.tempsAnim = 0;
    }

    public void effect(){

    }

    public void draw (SpriteBatch sB){
        tempsAnim += Gdx.graphics.getDeltaTime();
        TextureRegion im = (TextureRegion)anim.getKeyFrame(tempsAnim);
        sB.draw(im, pos.x, pos.y, radius, radius);
    }
}
