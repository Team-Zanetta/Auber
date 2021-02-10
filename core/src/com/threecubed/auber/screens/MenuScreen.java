package com.threecubed.auber.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.threecubed.auber.AuberGame;
import com.threecubed.auber.World;
import com.threecubed.auber.save.Save;
import com.threecubed.auber.ui.Button;


/**
 * The menu screen is the first screen that shows in the game and is responsible for controlling
 * when the game begins.
 *
 * @author Joseph Krystek-Walton
 * @version 1.0
 * @since 1.0
 * */
public class MenuScreen extends ScreenAdapter {
  World world;
  AuberGame game;

  Button hardButton;
  Button mediumButton;
  Button easyButton;
  Button playButton;
  Button demoButton;
  Button loadButton;
  OrthogonalTiledMapRenderer renderer;
  Sprite background;
  Sprite instructions;
  Sprite title;
  SpriteBatch spriteBatch;

  /**
   * Instantiate the screen with the {@link AuberGame} object. Set the title and button up to be
   * rendered.
   *
   * @param game The game object
   * */
  public MenuScreen(final AuberGame game) {
    this.game = game;

    spriteBatch = new SpriteBatch();

    background = game.atlas.createSprite("stars");
    instructions = game.atlas.createSprite("instructions");
    title = game.atlas.createSprite("auber_logo");

//    Runnable onPlayClick = new Runnable() {
//      @Override
//      public void run() {
//        game.setScreen(new GameScreen(game, false, false, difficulty));
//      }
//    };

//    playButton = new Button(
//            new Vector2(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2 - 100),
//            1f, game.atlas.createSprite("playButton"), game, onPlayClick);

    Runnable onDemoClick = new Runnable() {
      @Override
      public void run() {
        game.setScreen(new GameScreen(game, true, false, World.Difficulty.HARD));
      }
    };

    demoButton = new Button(
            new Vector2(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2 - 150f),
            1f, game.atlas.createSprite("demoButton"), game, onDemoClick);

    Runnable onLoadClick = new Runnable() {
      @Override
      public void run() {
        game.setScreen(new GameScreen(game, false, true, World.Difficulty.HARD));
      }
    };

    loadButton = new Button(
            new Vector2(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2 - 300f),
            1f, new Sprite(new Texture("loadButton.png")), game, onLoadClick);



    Runnable onEasyClick = new Runnable() {
      @Override
      public void run() {
        game.setScreen(new GameScreen(game, false, false, World.Difficulty.EASY));
      }
    };

    easyButton = new Button(
            new Vector2(Gdx.graphics.getWidth() / 4 - 200, Gdx.graphics.getHeight() / 2 + 50),
            1f, new Sprite(new Texture("easyButton.png")), game, onEasyClick);

    Runnable onMediumClick = new Runnable() {
      @Override
      public void run() {
        game.setScreen(new GameScreen(game,false, false, World.Difficulty.MEDIUM));
      }
    };

    mediumButton = new Button(
            new Vector2(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2 + 50),
            1f, new Sprite(new Texture("mediumButton.png")), game, onMediumClick);

    Runnable onHardClick = new Runnable() {
      @Override
      public void run() {
        game.setScreen(new GameScreen(game,false, false, World.Difficulty.HARD));
      }
    };

    hardButton = new Button(
            new Vector2(Gdx.graphics.getWidth() / 4 + 200, Gdx.graphics.getHeight() / 2 + 50),
            1f, new Sprite(new Texture("hardButton.png")), game, onHardClick);
  }


  @Override
  public void render(float deltaTime) {
    if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
      DisplayMode currentDisplayMode = Gdx.graphics.getDisplayMode();
      Gdx.graphics.setFullscreenMode(currentDisplayMode);
    }
    if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
      game.setScreen(new GameScreen(game, true, false, World.Difficulty.HARD));
    }

    // Set the background color
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    spriteBatch.begin();

    background.setPosition(0f, 0f);
    background.draw(spriteBatch);

    instructions.setPosition(900f, 125f);
    instructions.draw(spriteBatch);

    title.setScale(0.5f);
    title.setPosition(0f, 550f);
    title.draw(spriteBatch);

//    playButton.render(spriteBatch);
    demoButton.render(spriteBatch);
    loadButton.render(spriteBatch);
    easyButton.render(spriteBatch);
    mediumButton.render(spriteBatch);
    hardButton.render(spriteBatch);

    spriteBatch.end();
  }
}
