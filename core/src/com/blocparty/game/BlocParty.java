package com.blocparty.game;

import com.badlogic.gdx.Game;
import com.blocparty.game.screens.MenuScreen;

//a singleton, controller for the screens, and will possibly be a container for variables shared across screens...
//although variables shared across screens could possibly be a singleton as well
public class BlocParty extends Game {


	private static BlocParty GAME = null;
	private static ActionResolver actionResolver;

	private BlocParty(ActionResolver resolver) {
		actionResolver = resolver;
		//singleton
	}

	public static BlocParty getInstance(ActionResolver resolver) {
		if (GAME == null) {
			GAME = new BlocParty(resolver);
		}
		return GAME;
	}

	public static BlocParty getInstance() {

		return GAME;
	}

    public static ActionResolver getActionResolver() {
        return actionResolver;
    }


	@Override
	public void create() {
		this.setScreen(new MenuScreen());
	}

}
