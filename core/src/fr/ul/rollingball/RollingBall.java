package fr.ul.rollingball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.ul.views.GameScreen;
import fr.ul.views.SplashScreen;

public class RollingBall extends Game {
	protected GameScreen gameScreen;
	protected SplashScreen splashScreen;

	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");

		/*Camera camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);*/

		this.splashScreen = new SplashScreen(this);
        this.gameScreen = new GameScreen(this);
        this.setScreen(splashScreen);
	}

	@Override
	public void dispose () {
		splashScreen.dispose();
        gameScreen.dispose();
	}

    public void toGameScreen(){
        this.setScreen(gameScreen);
    }
}
