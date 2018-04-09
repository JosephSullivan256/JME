package com.josephsullivan256.gmail.jme.core;

public interface Action<T> {
	
	public void initialize(DependencyManager globalDependencies, DependencyManager contextDependencies);
	
	public void start();
	public void update(T parameter);
	public void stop();
}
