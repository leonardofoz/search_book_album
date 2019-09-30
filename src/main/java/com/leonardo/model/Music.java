package com.leonardo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Music {
	
	private int resultCount;
	private List<Results> results;
	
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		return "Music [resultCount=" + resultCount + ", results=" + results + "]";
	}

}
