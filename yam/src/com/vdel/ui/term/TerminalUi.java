package com.vdel.ui.term;

import com.vdel.action.ActionManager;
import com.vdel.action.TypeAction;
import com.vdel.world.Coord;
import com.vdel.world.Universe;
import com.vdel.world.tile.Zone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static com.vdel.world.Carte.HAUTEUR;
import static com.vdel.world.Carte.LARGEUR;

public class TerminalUi implements Runnable {
    @Override
    public void run() {

        TypeAction selectedAction = null;
        do{
            Set<TypeAction> typeActions = ActionManager.getTypeActions();
            System.out.println("What do you want to do ? ");

            for(TypeAction typeAction: typeActions){
                System.out.print(typeAction + "   ");
            }
            System.out.println();
            Scanner in = new Scanner(System.in);
            System.out.print("Enter action: ");
            String name = in.nextLine();
            try {
                String[] strings = name.split(" ");
                selectedAction = TypeAction.valueOf(strings[0]);
                List<String> args = new ArrayList<>();
                for(int i = 1; i< strings.length;i++){
                    args.add(strings[i]);
                }

                ActionManager.executeAction(selectedAction,args);
                displayCarte();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(" Soory, not understood, please reenter your action ");
            }
        }
        while(selectedAction != TypeAction.QUIT);
    }



    private static void displayCarte() {
        for(int y = 0; y < HAUTEUR; y ++){
            for(int x = 0; x < LARGEUR; x++){
                Zone zone = Universe.getInstance().getCarte().getZone(Coord.valueOf(x, y));
                if(zone.getVisited()){
                    switch (zone.getTile()){

                        case SEA:
                            System.out.print("~");
                            break;
                        case EARTH:
                            System.out.print(".");
                            break;
                        case TOWN:
                            System.out.print("X");
                            break;
                        case FOREST:
                            System.out.print("o");
                            break;
                    }
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

}
