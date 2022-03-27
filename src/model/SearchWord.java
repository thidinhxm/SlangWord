package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SearchWord implements Serializable {
	private String keyword;
	private String result;
	private String type;
	private LocalDateTime time;
	
	public SearchWord(String keyword, String type, LocalDateTime time, String result) {
		this.keyword = keyword;
		this.type = type;
		this.time = time;
		this.result = result;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}	
	
}
