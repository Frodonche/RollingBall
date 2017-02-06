package fr.ul.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import fr.ul.dataFactories.TextureFactory;
import fr.ul.models.World;
import fr.ul.rollingball.RollingBall;

/**
 * Created by roth52u on 24/01/17.
 */

public class GameScreen extends ScreenAdapter {
    protected RollingBall rollingBall;
    protected SpriteBatch spriteBatch;
    protected World world;

    protected Camera camera;
    protected float accX, accY; // valeurs de l'accélérateur

    public GameScreen(RollingBall rollingBall){
        this.rollingBall = rollingBall;
        this.spriteBatch = new SpriteBatch();
        this.world = new World(this); // on créé le monde

        camera = new OrthographicCamera(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        camera.update();
        this.spriteBatch.setProjectionMatrix(camera.combined);

    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        this.update();
        spriteBatch.begin();
        spriteBatch.draw(TextureFactory.getDeco(), 0, 0);
        this.world.draw(spriteBatch); // on dessine tout ce qu'il y a dans le monde (pour l'instant juste la boule)
        spriteBatch.end();
    }

    public void dispose () {
        spriteBatch.dispose();
    }

    public SpriteBatch getSpriteBatch(){
        return this.spriteBatch;
    }

    private void update(){
        // Orientation native
        Input.Orientation nativeOrientation = Gdx.input.getNativeOrientation();

        // On récupère l'orientation par rapport à l'orientation native (0, 90, 180, 270) dans le sens des aiguille d'une montre
        int orientation = Gdx.input.getRotation();
        //System.out.println("MON ORIENTATION OMG : "+orientation);
       switch (orientation){ // On adapte les axes et leur sens en fonction
            case 0:
                accX = Gdx.input.getAccelerometerY();
                accY = -Gdx.input.getAccelerometerX();
                // pas besoin du Z
                break;
            case 90:
                accX = Gdx.input.getAccelerometerY();
                accY = -Gdx.input.getAccelerometerX();
                // pas besoin du Z
                break;
            case 180: // à l'envers = on inverse le sens des axes
                accX = -Gdx.input.getAccelerometerY();
                accY = Gdx.input.getAccelerometerX();
                // pas besoin du Z
                break;
            case 270:
                accX = -Gdx.input.getAccelerometerY();
                accY = Gdx.input.getAccelerometerX();
                // pas besoin du Z
                break;
            default:
                break;
        }
        // on limite un peu la puissance l'accélération
        accX = accX / 10;
        accY = accY / 10;

        this.world.getBoule().accelerer(new Vector3(accX, accY, 0)); // on modifie le mouvement de la boule
        this.world.getBoule().maj();
    }

}


