package com.vdel.action;

import com.vdel.Heros;
import com.vdel.world.Universe;

public class CreateHeroExecutableAction implements ExecutableAction{

    private String heroName;


    @Override
    public void execute() {
        Universe.getInstance().setHeros(new Heros());
        Universe.getInstance().getHeros().setName(heroName);
        Universe.getInstance().getHeros().setCoord(ActionUtils.generateStartCoord());
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }


    public CreateHeroExecutableAction(String heroName){
        super();
        this.heroName = heroName;
    }
}
