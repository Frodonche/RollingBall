package fr.ul.rollingball;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import fr.ul.rollingball.RollingBall;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		config.a = 8; // Indique le nb de bits de codage du canal alpha
		//boolean disponible = Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);
		//Log.i("Dispo : ", String.valueOf(disponible)); // pour tester la valeur booléenne
		//Methode pour check si on a un accelerometre => FAIT CRASH L'APPLI

		config.useAccelerometer = true;

		initialize(new RollingBall(), config);
	}
}
