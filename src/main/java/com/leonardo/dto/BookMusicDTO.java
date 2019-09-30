package com.leonardo.dto;

public class BookMusicDTO {
	
	private String title;
	private String author_artist;
	private String type;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor_artist() {
		return author_artist;
	}
	public void setAuthor_artist(String author_artist) {
		this.author_artist = author_artist;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author_artist == null) ? 0 : author_artist.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookMusicDTO other = (BookMusicDTO) obj;
		if (author_artist == null) {
			if (other.author_artist != null)
				return false;
		} else if (!author_artist.equals(other.author_artist))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BookMusicDTO [title=" + title + ", author_artist=" + author_artist + ", type=" + type + "]";
	}

}
