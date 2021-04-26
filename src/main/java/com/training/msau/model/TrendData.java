package com.training.msau.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TrendData {

	private String name;
	private List<String> years;
	private List<String> columns;
	private long[][] data;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getYears() {
		return years;
	}
	public void setYears(List<String> years) {
		this.years = years;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public long[][] getData() {
		return data;
	}
	public void setData(long[][] data) {
		this.data = data;
	}	
	
	
	
}
