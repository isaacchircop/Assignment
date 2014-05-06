package com;

import java.util.*;

public class ConcreteTeam implements AbstractTeam {

    private String visitedTilesCode = "";

    @Override
    public void uncoverTile(Position pos, String colour) {

        String cellID = pos.getID();

        visitedTilesCode = visitedTilesCode + ("td#" + cellID + "{background: " + colour + ";}\n");

    }

    @Override
    public String getVisitedTilesCode() {

        return visitedTilesCode;

    }

}
