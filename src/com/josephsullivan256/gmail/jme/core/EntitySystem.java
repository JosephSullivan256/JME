package com.josephsullivan256.gmail.jme.core;

public abstract class EntitySystem<T> implements Action<T> {
	private String entityCollection;
	
	public EntitySystem(String entityCollection){
		this.entityCollection = entityCollection;
	}
	
	public abstract void register(Entity e);
	public abstract void remove(Entity e);
	
	public void initialize(DependencyManager globalDependencies, DependencyManager contextDependencies){
		contextDependencies.getDependency(entityCollection, EntityCollection.class).addSystem(this);
	}
	
	public abstract void start();
	public abstract void update(T parameter);
	public abstract void stop();
}
