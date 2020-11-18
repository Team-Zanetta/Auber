package com.threecubed.auber;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameOverScreen extends ScreenAdapter {
  AuberGame game;

  BitmapFont font = new BitmapFont();
  SpriteBatch batch = new SpriteBatch();
  GlyphLayout layout = new GlyphLayout();

  public GameOverScreen(AuberGame game) {
    this.game = game;
    font.getData().setScale(2);
    layout.setText(font, "GAME OVER");
  }

  @Override
  public void render(float deltaTime) {
    // Set the background color
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin();
    font.draw(batch, "GAME OVER", (Gdx.graphics.getWidth() - layout.width) / 2, 300 + (Gdx.graphics.getHeight() - layout.height) / 2);
    batch.end();
  }
  
}
