package com.josephsullivan256.gmail.jme.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameUnit {
	
	private DependencyManager globalDependencies;
	private Map<String,Context> contexts;
	
	private List<Context> activeContexts;
	
	public GameUnit(DependencyManager globalDependencies){
		this.globalDependencies = globalDependencies;
		globalDependencies.addDependency("game unit", this);
		contexts = new HashMap<String,Context>();
		activeContexts = new ArrayList<Context>();
	}
	
	public void addContext(String id, Context c){
		contexts.put(id, c);
		c.initialize(globalDependencies);
	}
	
	public Context getContext(String id){
		return contexts.get(id);
	}
	
	public void activate(String id){
		Context c = contexts.get(id);
		activeContexts.add(c);
		c.start();
	}
	
	public void deactivate(String id){
		Context c = contexts.get(id);
		activeContexts.remove(c);
		c.stop();
	}
	
	public void bringToFront(String id){
		Context c = contexts.get(id);
		activeContexts.remove(c);
		activeContexts.add(c);
	}
	
	public void update(){
		for(int i = 0; i < activeContexts.size(); i++){
			activeContexts.get(i).update();
		}
	}
}
