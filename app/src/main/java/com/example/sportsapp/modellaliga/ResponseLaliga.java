package com.example.sportsapp.modellaliga;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLaliga{

	@SerializedName("teams")
	private List<TeamsItemLaliga> teams;

	public void setTeams(List<TeamsItemLaliga> teams){
		this.teams = teams;
	}

	public List<TeamsItemLaliga> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"ResponseLaliga{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}