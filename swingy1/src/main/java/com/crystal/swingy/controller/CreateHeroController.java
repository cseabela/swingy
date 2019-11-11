package com.crystal.swingy.controller;

import com.crystal.swingy.model.Game;
import com.crystal.swingy.model.character.HeroFactory;
import com.crystal.swingy.util.DataBase;
import com.crystal.swingy.view.create.CreateHeroView;
import com.crystal.swingy.exception.HeroValidationException;
import com.crystal.swingy.model.character.Hero;


public class CreateHeroController {

    private CreateHeroView view;
    private Game game;

    public CreateHeroController(CreateHeroView view) {
        this.view = view;
        game = Game.getInstance();
    }

    public void onCreateButtonPressed(String name, String heroClass) {

        Hero hero;
        try {
            hero = HeroFactory.newHero(name, heroClass);
            hero.validateHero();
        } catch (IllegalArgumentException | HeroValidationException e) {
            view.showErrorMessage(e.getMessage());
            view.getUserInput();
            return;
        }

        int id = DataBase.insert(hero.getName(), hero.getHeroClass(), hero.getLevel(), hero.getExperience(), hero.getAttack(), hero.getDefense(), hero.getHitPoints());
        hero.setId(id);
        game.initGame(hero);
        view.openGame();
    }

    public void onExitButtonPressed() {
        System.exit(0);
    }
}
