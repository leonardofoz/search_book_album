package com.leonardo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
	
	private String kind;
	private String id;
	private VolumeInfo volumeInfo;
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}
	public void setVolumeInfo(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}
	
	@Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                '}';
    }
	
}
