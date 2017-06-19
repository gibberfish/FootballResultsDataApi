package mindbadger.football.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import mindbadger.football.domain.Division;

@JsonApiResource(type = "divisions")
public class KatharsisDivision {
	
	private Division division;
	
	public KatharsisDivision (Division division) {
		this.division = division;
	}

//	public KatharsisDivision (String id, String divisionName) {
//		this.id = id;
//		this.divisionName = divisionName;
//	}
	
	@JsonProperty("divisionName")	
	public String getDivisionName() {
		return division.getDivisionName();
	}
	public void setDivisionName(String divisionName) {
		division.setDivisionName(divisionName);
	}
	
	@JsonApiId
	public String getId() {
		return division.getDivisionId();
	}
	public void setId(String id) {
		division.setDivisionId(id);
	}
}