package com.josephsullivan256.gmail.jme.core;

import java.util.ArrayList;
import java.util.List;

import com.josephsullivan256.gmail.jme.util.Nothing;

public class Context {
	
	private DependencyManager contextDependencies;
	
	private List<Action<Nothing>> actions;
	
	public Context(DependencyManager contextDependencies){
		this.contextDependencies = contextDependencies;
		actions = new ArrayList<Action<Nothing>>();
	}
	
	public void initialize(DependencyManager globalDependencies){
		for(Action<Nothing> es: actions){
			es.initialize(globalDependencies,contextDependencies);
		}
	}
	
	public void update(){
		for(Action<Nothing> step : actions){
			step.update(null);
		}
	}
	
	public Context addAction(Action<Nothing> action){
		actions.add(action);
		return this;
	}
	
	public void start(){
		for(Action<Nothing> es: actions){
			es.start();
		}
	}
	
	public void stop(){
		for(Action<Nothing> es: actions){
			es.stop();
		}
	}
}