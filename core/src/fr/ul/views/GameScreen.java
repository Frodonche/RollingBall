package fr.ul.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.ul.dataFactories.TextureFactory;
import fr.ul.rollingball.RollingBall;

/**
 * Created by roth52u on 24/01/17.
 */

public class GameScreen extends ScreenAdapter {
    protected RollingBall rollingBall;
    protected SpriteBatch spriteBatch;

    public GameScreen(RollingBall rollingBall){
        this.rollingBall = rollingBall;
        this.spriteBatch = new SpriteBatch();

        Camera camera = new OrthographicCamera(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        //camera.project(camera.position, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
        this.spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta){
        spriteBatch.begin();
        spriteBatch.draw(TextureFactory.getDeco(), 0, 0);
        spriteBatch.end();
    }

    public void dispose () {
        spriteBatch.dispose();
    }
}
