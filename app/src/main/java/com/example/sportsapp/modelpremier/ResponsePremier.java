package com.example.sportsapp.modelpremier;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePremier{

	@SerializedName("teams")
	private List<TeamsItemPremier> teams;

	public void setTeams(List<TeamsItemPremier> teams){
		this.teams = teams;
	}

	public List<TeamsItemPremier> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePremier{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}