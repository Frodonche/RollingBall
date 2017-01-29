package fr.ul.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
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
        this.update();
        spriteBatch.begin();
        spriteBatch.draw(TextureFactory.getDeco(), 0, 0);
        spriteBatch.end();
        this.world.draw(); // on dessine tout ce qu'il y a dans le monde (pour l'instant juste la boule)
    }

    public void dispose () {
        spriteBatch.dispose();
    }

    public SpriteBatch getSpriteBatch(){
        return this.spriteBatch;
    }

    private void update(){
        // On récupère l'orientation par rapport à l'orientation native (0, 90, 180, 270) dans le sens des aiguille d'une montre
        int orientation = Gdx.input.getRotation();
        System.out.println("MON ORIENTATION OMG : "+orientation);
       switch (orientation){ // On adapte les axes et leur sens en fonction
            case 0:
                accX = Gdx.input.getAccelerometerY();
                accY = -Gdx.input.getAccelerometerX();
                // pas besoin du Z
                break;
            case 90:
                accX = Gdx.input.getAccelerometerX();
                accY = Gdx.input.getAccelerometerY();
                // pas besoin du Z
                break;
            case 180: // à l'envers = on inverse le sens des axes
                accX = -Gdx.input.getAccelerometerY();
                accY = Gdx.input.getAccelerometerX();
                // pas besoin du Z
                break;
            case 270:
                accX = -Gdx.input.getAccelerometerX();
                accY = -Gdx.input.getAccelerometerY();
                // pas besoin du Z
                break;
            default:
                break;
        }
        // on limite un peu la puissance l'accélération
        accX = accX / 20;
        accY = accY / 20;

        // on empêche la boule de sortir et de booster l'accélération contre le mur
        // si la boule touche pas les bords

        boolean neTouchePasLeBord = this.world.getBoule().getPosition().x + this.world.getBoule().getCurrent_radius() <= Gdx.graphics.getWidth() &&
                this.world.getBoule().getPosition().x >= 0 &&
                this.world.getBoule().getPosition().y + this.world.getBoule().getCurrent_radius() <= Gdx.graphics.getHeight() &&
                this.world.getBoule().getPosition().y >= 0;

        if(neTouchePasLeBord) {
            this.world.getBoule().accelerer(new Vector3(accX, accY, 0)); // on modifie le mouvement de la boule
        }
        else {
            if (this.world.getBoule().getPosition().x + this.world.getBoule().getCurrent_radius() > Gdx.graphics.getWidth()) // si on touche les bords
                this.stopperBoule(); // on stoppe la balle pour qu'elle s'écrase au mur et ne rebondisse pas
                this.world.getBoule().accelerer(new Vector3(-2, 0, 0)); // on recule d'un cran pour toujours pouvoir bouger

            if (this.world.getBoule().getPosition().x < 0)
                this.stopperBoule();
                this.world.getBoule().accelerer(new Vector3(1, 0, 0));

            if (this.world.getBoule().getPosition().y + this.world.getBoule().getCurrent_radius() > Gdx.graphics.getHeight())
                this.stopperBoule();
                this.world.getBoule().accelerer(new Vector3(0, -2, 0));

            if (this.world.getBoule().getPosition().y < 0)
                this.stopperBoule();
                this.world.getBoule().accelerer(new Vector3(0, 1, 0));

        }
        this.world.getBoule().maj(); // puis on modifie sa position dans tous les cas
    }

    public void stopperBoule(){ // stopper la boule reviens à lui donner le vecteur opposé à celui de sa vitesse
        this.world.getBoule().accelerer(new Vector3(-this.world.getBoule().getVitesse().x, -this.world.getBoule().getVitesse().y, 0));
    }
}
