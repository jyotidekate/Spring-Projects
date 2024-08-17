package com.springcore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	@Value("#{22+11}")										// Primitive type value
	private int x;	
	
	@Value("#{1+9+1}")
	private int y;
	
	@Value("#{ T(java.lang.Math).sqrt(25) }")				// Static method
	private int z;

	@Value("#{ T(java.lang.Math).PI }")						// Static variable
	private double e;
	
	@Value("#{ new java.lang.String('JYOTI DEKATE') }")		// Create Object 
	private String name;
	
	@Value("#{ 8>3 }")										// Boolean type
	private boolean isActive;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", e=" + e + ", name=" + name + ", isActive=" + isActive
				+ "]";
	}

}
