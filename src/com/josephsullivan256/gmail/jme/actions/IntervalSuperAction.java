package com.josephsullivan256.gmail.jme.actions;

import com.josephsullivan256.gmail.jme.core.Action;
import com.josephsullivan256.gmail.jme.core.DependencyManager;
import com.josephsullivan256.gmail.jme.util.DTParameter;
import com.josephsullivan256.gmail.jme.util.Nothing;

public class IntervalSuperAction extends SuperAction<Nothing,DTParameter> {
	
	private DTParameter dt;
	
	private double oldTime = 0.0;
	private double currentTime = 0.0;
	private double accumulator = 0.0;
	
	private double timeScale;
	
	private boolean delay;
	
	public IntervalSuperAction(float dt, double timeScale, boolean delay){
		this.dt = new DTParameter(dt);
		this.timeScale = timeScale;
		this.delay = delay;
	}
	
	@Override
	public void initialize(DependencyManager globalDependencies, DependencyManager contextDependencies) {
		for(Action<DTParameter> a: getSubactions()){
			a.initialize(globalDependencies, contextDependencies);
		}
	}
	
	@Override
	public void start() {
		currentTime = getTime();
		oldTime = currentTime;
		accumulator = 0.0;
	}

	@Override
	public void update(Nothing n) {
		currentTime = getTime();
		accumulator += (currentTime - oldTime)*timeScale;
		oldTime = currentTime;
		
		if(delay && accumulator < dt.getDT()){
			try {
				Thread.sleep((int)(1000.0*(dt.getDT()-accumulator)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(accumulator >= dt.getDT()){
			for(Action<DTParameter> a: getSubactions()){
				a.update(dt);
			}
			accumulator-=dt.getDT();
		}
	}
	
	private static double getTime(){
		return ((double)System.nanoTime())/1_000_000_000.0;
	}

	@Override
	public void stop() {
		
	}
}
