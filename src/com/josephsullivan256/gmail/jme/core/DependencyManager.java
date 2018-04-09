package com.josephsullivan256.gmail.jme.core;

import java.util.HashMap;
import java.util.Map;

import com.josephsullivan256.gmail.jme.util.Pair;

public class DependencyManager {
	
	private Map<Pair<String,Class<?>>,Object> dependencies;
	
	public DependencyManager(){
		dependencies = new HashMap<Pair<String,Class<?>>,Object>();
	}
	
	public <T> void addDependency(String id, T dependency){
		dependencies.put(new Pair<String,Class<?>>(id,dependency.getClass()), dependency);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getDependency(String id, Class<T> type){
		return (T) dependencies.get(new Pair<String,Class<?>>(id,type));
	}
}
