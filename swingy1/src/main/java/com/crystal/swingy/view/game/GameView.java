package com.crystal.swingy.view.game;

import com.crystal.swingy.model.Game;
import com.crystal.swingy.util.Point;

/**

 */
public interface GameView {

    void start();

    void printMap(boolean[][] map, Point heroCoord);

    void update(Game game);

    void gameFinished();

    void showMessage(String message);

    void getVillainCollisionInput();

    boolean replaceArtifact(String replaceMessage);

    void switchView();
}
