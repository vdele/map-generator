package com.vdel;

import com.vdel.generator.CarteGenerator;
import com.vdel.utils.YamUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static com.vdel.Carte.HAUTEUR;
import static com.vdel.Carte.LARGEUR;

public class Main {

    public static void main(String[] args) {

        Integer[][] carte = CarteGenerator.generateCarte();

        for(int y = 0; y < HAUTEUR; y ++){
            for(int x = 0; x < LARGEUR; x++){
                if(carte[y][x] == 0){
                    System.out.print("~");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        if(true) return;

        Map<Integer, Integer> jets = new HashMap<>();


        for(int i=0; i < 1000; i++){
            Integer result = YamUtils.randomNumber(3,9);
            if(jets.containsKey(result)){
                Integer nbJet = jets.get(result);
                jets.put(result,nbJet+1);
            }
            else{
                jets.put(result,1);
            }
        }

        for (Integer integer : jets.keySet()) {
            System.out.println ( integer + "   - >" + jets.get(integer));
        }

        if(true) return;

        Objects.equals(null,null);
	// write your code here
        String s = "Hello, This is JavaTpoint.";
        //Create scanner Object and pass string in it
        Scanner scan = new Scanner(s);
        //Check if the scanner has a token
        System.out.println("Boolean Result: " + scan.hasNext());
        //Print the string
        System.out.println("String: " +scan.nextLine());
        scan.close();
        System.out.println("--------Enter Your Details-------- ");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.next();
        System.out.println("Name: " + name);
        System.out.print("Enter your age: ");
        int i = in.nextInt();
        System.out.println("Age: " + i);
        System.out.print("Enter your salary: ");
        double d = in.nextDouble();
        System.out.println("Salary: " + d);
        in.close();


        Universe.start();
    }
}
