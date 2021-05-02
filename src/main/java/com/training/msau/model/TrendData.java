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
	public TrendData setName(String name) {
		this.name = name;
		return this;
	}
	public List<String> getYears() {
		return years;
	}
	public TrendData setYears(List<String> years) {
		this.years = years;
		return this;
	}
	public List<String> getColumns() {
		return columns;
	}
	public TrendData setColumns(List<String> columns) {
		this.columns = columns;
		return this;
	}
	public long[][] getData() {
		return data;
	}
	public TrendData setData(long[][] data) {
		this.data = data;
		return this;
	}	
	
}
