#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core;

import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.vyorkin.game.BitmapFont;
import com.vyorkin.game.GameRunner;
import com.vyorkin.game.GameScreen;
import com.vyorkin.game.GameSettings;
import com.vyorkin.game.LoadingScreen;
import com.vyorkin.game.Skin;
import com.vyorkin.game.Sound;
import com.vyorkin.game.resources.GameFont;
import com.vyorkin.game.resources.GameSkin;
import com.vyorkin.game.resources.GameSound;
import com.vyorkin.game.screens.MenuScreen;
import com.vyorkin.game.screens.SplashScreen;

public class ${JavaGameClassName} extends GameRunner {
	public static final String VERSION = "0.0.0.01 Pre-Alpha";
	public static final String TITLE = "libgdx game template";
	
	public static final int WIDTH = 1280;	// 480
	public static final int HEIGHT = 800;	// 320
	
	private final GameSettings settings;
	
	{
		settings = new GameSettings(TITLE, VERSION, WIDTH, HEIGHT);
//		settings.cursorFileName = GameTexture.CURSOR;
		settings.fullscreen = false;
		settings.useGL20 = false;
	};
	
	@Override
	public GameSettings getSettings() {
		return settings;
	}
	
	@Override
	protected void initialize() {
		E.assets.load(GameSound.MENU_ENTER_CLICK, Sound.class);
		E.assets.load(GameSound.MENU_ENTER_HIT, Sound.class);
		E.assets.load(GameSound.MENU_EXIT, Sound.class);
		E.assets.load(GameSound.MENU_SELECT, Sound.class);
		
		E.assets.load(GameSkin.UI, Skin.class);
		E.assets.load(GameFont.CONSOLAS, BitmapFont.class);
	}
	
	@Override
	protected GameScreen getNextScreen(GameScreen screen) {
		if (screen == null) {
			return new SplashScreen();
		} else if (screen instanceof SplashScreen) {
			return new MenuScreen();
		} else if (screen instanceof MenuScreen) {
			MenuScreen menuScreen = (MenuScreen)screen;
			return menuScreen.getNextScreen();
		} else if (screen instanceof LoadingScreen) {
			LoadingScreen loadingScreen = (LoadingScreen)screen;
			return loadingScreen.getNextScreen();
		}
		
		return null;
	}
}
