package com.josephsullivan256.gmail.jme.actions.systems;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.josephsullivan256.gmail.jme.core.Entity;

public abstract class IteratingComponentStructureSystem<K,T extends ComponentStructure> extends ComponentStructureSystem<K,T> {
	
	private List<T> structures;
	
	public IteratingComponentStructureSystem(String entityCollection){
		super(entityCollection);
		structures = new ArrayList<T>();
	}
	
	@Override
	public void remove(Entity e) {
		ListIterator<T> i = structures.listIterator();
		while(i.hasNext()){
			if(i.next().getEntity() == e){
				i.remove();
			}
		}
	}

	@Override
	public void update(K parameter) {
		for(T structure: structures){
			processComponentStructure(parameter,structure);
		}
	}
	
	public abstract void processComponentStructure(K parameter, T structure);

	@Override
	public void register(T cs) {
		structures.add(cs);
	}
	
}
