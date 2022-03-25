package model;

import java.time.LocalDateTime;

public class SearchWord {
	public static enum SearchType {
		DEFINITION,
		SLANGWORD
	}
	private String keyword;
	private String restString;
	private SearchType type;
	private LocalDateTime time;
	
	public SearchWord(String keyword, SearchType type, LocalDateTime time) {
		super();
		this.keyword = keyword;
		this.type = type;
		this.time = time;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public SearchType getType() {
		return type;
	}

	public void setType(SearchType type) {
		this.type = type;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getRestString() {
		return restString;
	}

	public void setRestString(String restString) {
		this.restString = restString;
	}	
	
}
