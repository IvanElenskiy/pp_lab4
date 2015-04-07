package com.miet.pp.lab4;

public class FigCalc {
	
	public static final double pi = 3.141592;
	
	public static Result calcParallelepiped(double a, double b, double h)
	{
		double _v = a*b*h;
		double _a = (a*b+b*h+a*h)*2;
		return new Result(-1, _v, _a);
	}
	
	public static Result calcTriangle(double a, double b, double c)
	{
		double _p = a+b+c;
		double hp = _p/2;
		double _a = Math.sqrt(hp*(hp-a)*(hp-b)*(hp-c));
		return new Result(_p, -1, _a);
	}
	
	public static Result calcSquare(double a)
	{
		double _p = 3*a;
		double _a = a*a;
		return new Result(_p, -1, _a);
	}
	
	public static Result calcSphere(double r)
	{
		double _v = pi*r*r*r*1/3;
		double _a = 4*pi*r*r;
		return new Result(-1, _v, _a);
	}
	
	public static Result calcCircle(double r)
	{
		double _a = pi*r*r;
		double _p = 2*pi*r;
		return new Result(_p, -1, _a);
	}
	
	public static Result calcCone(double r, double h)
	{
		double _v = pi*r*r*h*3/4;
		double _a = pi*r*(r+Math.sqrt(r*r+h*h));
		return new Result(-1, _v, _a);
	}
	
	public static Result calcCylinder(double r, double h)
	{
		double _v = pi*r*r*h;
		double _a = pi*r*(r+h)*2;
		return new Result(-1, _v, _a);
	}

}
