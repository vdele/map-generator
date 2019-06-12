package com.vdel;

import com.vdel.ui.term.TerminalUi;
import com.vdel.utils.CollectionUtils;
import com.vdel.world.Coord;
import com.vdel.world.Universe;
import com.vdel.world.tile.Zone;

import java.util.*;
import java.util.stream.Collectors;

import static com.vdel.world.Carte.HAUTEUR;
import static com.vdel.world.Carte.LARGEUR;

public class Main {



    public static void main(String[] args) throws Exception {


        Thread thread = new Thread(new TerminalUi());
        thread.start();

        displayCarte();
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println();
        displayPopulation();
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println();
        displayStat();
        System.out.println();
        System.out.println();
        System.out.println( "----------");


        if(args != null && args.length > 0){
            for(String arg : args){
                System.out.println(arg);
            }
        }


    }

    private static void displayStat() {
        //List<Zone> zones = Arrays.stream(Universe.getInstance().getCarte().getCarte()).flatMap(z -> Arrays.stream(z)).collect(Collectors.toList());
        Collection<Zone> zones = Universe.getInstance().getCarte().getCarte().values();
        System.out.println("Nb de personnes créées : " + Universe.getInstance().getCarte().getPopulation().size());


        System.out.println("Nb de personnes créées en mer : " + getPopulationByTile(Zone.Tile.SEA));
        System.out.println("Nb de personnes créées en plaine : " + getPopulationByTile(Zone.Tile.EARTH));
        System.out.println("Nb de personnes créées en foret : " + getPopulationByTile(Zone.Tile.FOREST));
        System.out.println("Nb de personnes créées en ville : " + getPopulationByTile(Zone.Tile.TOWN));

        System.out.println("---------------");

        System.out.println("Surface mer : " + getSurfaceByTile(zones, Zone.Tile.SEA));
        System.out.println("Surface plaine : " + getSurfaceByTile(zones, Zone.Tile.EARTH));
        System.out.println("Surface foret : " + getSurfaceByTile(zones, Zone.Tile.FOREST));
        System.out.println("Surface ville : " + getSurfaceByTile(zones, Zone.Tile.TOWN));

        System.out.println("---------------");

        System.out.println("Densité mer : " + new Double(getPopulationByTile(Zone.Tile.SEA) / getSurfaceByTile(zones, Zone.Tile.SEA)));
        System.out.println("Densité plaine : " + new Double(getPopulationByTile(Zone.Tile.EARTH)) / new Double(getSurfaceByTile(zones, Zone.Tile.EARTH)));
        System.out.println("Densité foret : " + new Double(getPopulationByTile(Zone.Tile.FOREST)) / new Double(getSurfaceByTile(zones, Zone.Tile.FOREST)));
        System.out.println("Densité ville : " + new Double(getPopulationByTile(Zone.Tile.TOWN)) / new Double(getSurfaceByTile(zones, Zone.Tile.TOWN)));

        System.out.println("---------------");
        System.out.println("Surface mer deserte : " +zones.stream().filter(z-> z.getTile().equals(Zone.Tile.SEA) && CollectionUtils.isEmpty(z.getHabitants())).collect(Collectors.toList()).size());
        System.out.println("Surface plaine deserte : " +zones.stream().filter(z-> z.getTile().equals(Zone.Tile.EARTH) && CollectionUtils.isEmpty(z.getHabitants())).collect(Collectors.toList()).size());
        System.out.println("Surface foret deserte: " +zones.stream().filter(z-> z.getTile().equals(Zone.Tile.FOREST) && CollectionUtils.isEmpty(z.getHabitants())).collect(Collectors.toList()).size());
        System.out.println("Surface ville deserte: " +zones.stream().filter(z-> z.getTile().equals(Zone.Tile.TOWN) && CollectionUtils.isEmpty(z.getHabitants())).collect(Collectors.toList()).size());
        System.out.println("---------------");

        System.out.println("Surface mer habitée : " +zones.stream().filter(z-> z.getTile().equals(Zone.Tile.SEA) && CollectionUtils.isNotEmpty(z.getHabitants())).collect(Collectors.toList()).size());
        System.out.println("Surface plaine habitée : " +zones.stream().filter(z-> z.getTile().equals(Zone.Tile.EARTH) && CollectionUtils.isNotEmpty(z.getHabitants())).collect(Collectors.toList()).size());
        System.out.println("Surface foret habitée: " +zones.stream().filter(z-> z.getTile().equals(Zone.Tile.FOREST) && CollectionUtils.isNotEmpty(z.getHabitants())).collect(Collectors.toList()).size());
        System.out.println("Surface ville habitée: " +zones.stream().filter(z-> z.getTile().equals(Zone.Tile.TOWN) && CollectionUtils.isNotEmpty(z.getHabitants())).collect(Collectors.toList()).size());
    }

    private static int getSurfaceByTile(Collection<Zone> zones, Zone.Tile sea) {
        return zones.stream().filter(z -> z.getTile().equals(sea)).collect(Collectors.toList()).size();
    }

    private static int getPopulationByTile(Zone.Tile sea) {
        return Universe.getInstance().getCarte().getPopulation().stream().filter(p -> p.getZone().getTile().equals(sea)).collect(Collectors.toList()).size();
    }

    private static void displayCarte() {
        for(int y = 0; y < HAUTEUR; y ++){
            for(int x = 0; x < LARGEUR; x++){
                switch (Universe.getInstance().getCarte().getZone(Coord.valueOf(x,y)).getTile()){

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
            System.out.println();

        }
    }

    private static void displayPopulation() throws Exception {
        for(int y = 0; y < HAUTEUR; y ++){
            for(int x = 0; x < LARGEUR; x++){
                Zone zone = Universe.getInstance().getCarte().getZone(Coord.valueOf(x,y));
                switch (zone.getTile()){

                    case SEA:
                        if(zone.getHabitants()!= null && !zone.getHabitants().isEmpty()){
                            throw new Exception("Ach ! Es gibt ein problem ! Es gibt habitant in Zee");
                        }
                        System.out.print("~");
                        break;
                    case EARTH:
                        if(zone.getHabitants()!= null && !zone.getHabitants().isEmpty()){
                            System.out.print(zone.getHabitants().size());
                        }
                        else{
                            System.out.print(".");
                        }
                        break;
                    case TOWN:
                        if(zone.getHabitants()!= null && !zone.getHabitants().isEmpty()){
                            System.out.print(zone.getHabitants().size());
                        }
                        else{
                            System.out.print("X");
                        }
                        break;
                    case FOREST:
                        if(zone.getHabitants()!= null && !zone.getHabitants().isEmpty()){
                            System.out.print(zone.getHabitants().size());
                        }
                        else{
                            System.out.print("o");
                        }
                        break;
                }
            }
            System.out.println();

        }
    }
}
