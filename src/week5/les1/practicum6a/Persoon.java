package week5.les1.practicum6a;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> games = new ArrayList<Game>();


    public Persoon(String nm, double bud){
        naam = nm;
        budget = bud;
    }

    public double getBudget(){
        return budget;
    }

    public boolean koop(Game g){
        boolean result = false;

        if(!games.contains(g) && budget >= g.huidigeWaarde()){
            budget = budget - g.huidigeWaarde();
            games.add(g);
            result = true;
        }

        return result;
    }


    public boolean verkoop(Game g, Persoon koper){
        boolean result = false;

        if(!koper.games.contains(g) && games.contains(g) && koper.budget >= g.huidigeWaarde()){
            games.remove(g);
            koper.games.add(g);
            koper.budget = koper.budget - g.huidigeWaarde();
            budget = budget + g.huidigeWaarde();
            result = true;
        }

        return result;
    }

    public String toString(){
        StringBuilder allGames = new StringBuilder();

        for(Game game : games){
            allGames.append("\n");
            allGames.append(game.toString());
        }

        return String.format("%s heeft een budget van \u20AC%.2f en bezit de volgende games:%s", naam, budget, allGames);
    }

}
