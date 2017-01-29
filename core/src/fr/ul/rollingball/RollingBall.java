package fr.ul.rollingball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import fr.ul.views.GameScreen;
import fr.ul.views.SplashScreen;

public class RollingBall extends Game {
	protected GameScreen gameScreen;
	protected SplashScreen splashScreen;

	@Override
	public void create () {

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
