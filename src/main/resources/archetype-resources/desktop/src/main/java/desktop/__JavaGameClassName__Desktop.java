#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.desktop;

import ${package}.core.${JavaGameClassName};

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vyorkin.engine.GameSettings;


public class ${JavaGameClassName}Desktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		${JavaGameClassName} game = new ${JavaGameClassName}();
		GameSettings settings = game.getSettings();
		
		cfg.useGL20 = settings.useGL20;
		cfg.title = settings.title;
		cfg.width = settings.width;
		cfg.height = settings.height;
		cfg.fullscreen = settings.fullscreen;
		cfg.resizable = settings.resizable;
		cfg.vSyncEnabled = settings.vSyncEnabled;
		cfg.forceExit = settings.forceExit;
		
		new LwjglApplication(game, cfg);
	}
}
