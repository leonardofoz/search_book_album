package com.leonardo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

	
	
	private String kind;
	private int totalItems;
	private List<Items> items;
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}


	

//	public Items getItems() {
//		return items;
//	}
//	public void setItems(Items items) {
//		this.items = items;
//	}

//    @Override
//    public String toString() {
//        return "{" +
//                "kind=" + kind +
//                ", totalItems='" + totalItems + '\'' +
//                //", items='" + items + '\'' +
//                '}';
//    }
	
	

}
