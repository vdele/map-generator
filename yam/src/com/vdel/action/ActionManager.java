package com.vdel.action;

import com.vdel.Orientation;
import com.vdel.world.Universe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActionManager {
    public static Set<TypeAction> getTypeActions(){
        Set<TypeAction> typeActions = new HashSet<>();
        typeActions.add(TypeAction.QUIT);

        if(Universe.getInstance().isDevMode()){
            typeActions.add(TypeAction.STAT);
        }
        if(Universe.getInstance().getHeros() == null){
            typeActions.add(TypeAction.CREATE_HERO);
        }
        else{
            typeActions.addAll(Arrays.asList(TypeAction.OBSERVE,TypeAction.MOVE));
        }


        return typeActions;
    }


    public static void executeAction(TypeAction typeAction, List<String> args) throws Exception {

        if(typeAction.getNbArgument() != args.size()){
            throw new Exception("Ach ! Argument sind unkorrekt und programm ist kaputt");
        }

        ExecutableAction executableAction = null;
        switch (typeAction) {

            case CREATE_HERO:
                executableAction = new CreateHeroExecutableAction(args.get(0));
                break;
            case MOVE:
                executableAction = new MoveExecutableAction(Orientation.valueOf(args.get(0)));
                break;
            default:
                executableAction = new DoNothingAction();
                break;
        }

        executableAction.execute();
    }



}
