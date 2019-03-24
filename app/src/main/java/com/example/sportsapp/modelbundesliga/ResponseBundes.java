package com.example.sportsapp.modelbundesliga;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBundes{

	@SerializedName("teams")
	private List<TeamsItemBundes> teams;

	public void setTeams(List<TeamsItemBundes> teams){
		this.teams = teams;
	}

	public List<TeamsItemBundes> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"ResponseBundes{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}