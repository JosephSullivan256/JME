package com.josephsullivan256.gmail.jme.util;

import java.util.Objects;

public class Pair<A,B> {

	private A a;
	private B b;
	
	public Pair(A a, B b){
		this.a = a;
		this.b = b;
	}
	
	public A getA(){
		return a;
	}
	
	public B getB(){
		return b;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(a,b);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj){
		if(this==obj) return true;
		Pair<A,B> p = (Pair<A,B>) obj;
		if(this.getA().equals(p.getA()) && this.getB().equals(p.getB())) return true;
		return false;
	}
}
