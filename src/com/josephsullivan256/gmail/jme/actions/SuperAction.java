package com.josephsullivan256.gmail.jme.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.josephsullivan256.gmail.jme.core.Action;
import com.josephsullivan256.gmail.jme.core.DependencyManager;

public abstract class SuperAction<A,B> implements Action<A> {
	
	private List<Action<B>> subactions;
	private List<Action<B>> immutableList;
	
	public SuperAction(){
		subactions = new ArrayList<Action<B>>();
		immutableList = Collections.unmodifiableList(subactions);
	}
	
	@Override
	public void initialize(DependencyManager globalDependencies, DependencyManager contextDependencies) {
		for(Action<B> a: getSubactions()){
			a.initialize(globalDependencies, contextDependencies);
		}
	}
	
	public void addSubaction(Action<B> es){
		subactions.add(es);
	}
	
	public void removeSubaction(Action<B> es){
		subactions.remove(es);
	}
	
	public List<Action<B>> getSubactions(){
		return immutableList;
	}
}
