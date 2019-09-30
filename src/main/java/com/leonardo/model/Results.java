package com.leonardo.model;

public class Results {
	
	private String artistName;
	private String collectionName;
	
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	
	@Override
	public String toString() {
		return "Results [artistName=" + artistName + ", collectionName=" + collectionName + "]";
	}
	
		
	
}
