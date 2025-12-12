package week5.les1.practicum6;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<Game>();


    public Persoon(String nm, double bud){
        naam = nm;
        budget = bud;
    }

    public double getBudget(){
        return budget;
    }

    public boolean koop(Game g){
        boolean result = false;

        if(!mijnGames.contains(g) && budget >= g.huidigeWaarde()){
            budget = budget - g.huidigeWaarde();
            mijnGames.add(g);
            result = true;
        }

        return result;
    }

    public Game zoekGameOpNaam(String nm){
        Game game = null;

        for(Game mijnGame : mijnGames){
            if(mijnGame.getNaam() == nm){
                game = mijnGame;
            }
        }

        return game;
    }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> alleGames){
        ArrayList<Game> nietInBezitGames = new ArrayList<Game>();

        for(Game game : alleGames){
            if(!mijnGames.contains(game)){
                nietInBezitGames.add(game);
            }
        }

        return nietInBezitGames;

    }


    public boolean verkoop(Game g, Persoon koper){
        boolean result = false;

        if(!koper.mijnGames.contains(g) && mijnGames.contains(g) && koper.budget >= g.huidigeWaarde()){
            mijnGames.remove(g);
            koper.mijnGames.add(g);
            koper.budget = koper.budget - g.huidigeWaarde();
            budget = budget + g.huidigeWaarde();
            result = true;
        }

        return result;
    }

    public String toString(){
        StringBuilder allGames = new StringBuilder();

        for(Game game : mijnGames){
            allGames.append("\n");
            allGames.append(game.toString());
        }

        return String.format("%s heeft een budget van \u20AC%.2f en bezit de volgende games:%s", naam, budget, allGames);
    }

}
