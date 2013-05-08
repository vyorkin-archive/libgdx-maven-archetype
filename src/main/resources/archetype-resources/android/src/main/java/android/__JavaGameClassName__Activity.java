#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.android;

import ${package}.core.${JavaGameClassName};

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import com.vyorkin.engine.GameSettings;

public class ${JavaGameClassName}Activity extends AndroidApplication {
	
	@Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
       
       ${JavaGameClassName} game = new ${JavaGameClassName}();
       GameSettings settings = game.getSettings();
       
       cfg.useGL20 = settings.useGL20;
       cfg.useAccelerometer = settings.useAccelerometer;
       cfg.useCompass = settings.useCompass;
       cfg.useWakelock = settings.useWakelock;
       cfg.hideStatusBar = settings.hideStatusBar;
       
       initialize(game, cfg);
   }
}
