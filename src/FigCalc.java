package com.miet.pp.lab4;

public class FigCalc {
	
	public static final double pi = 3.141592;
	
	public static void main(String[] args)
	{
		if (Math.ceil(calcParallelepiped(1, 1, 1).getA())==6 && Math.ceil(calcParallelepiped(1, 1, 1).getV())==1)
			System.out.println("calcParallelepiped ok");
		else
			System.out.println("calcParallelepiped fail");
		if (Math.ceil(calcTriangle(3, 4, 5).getA())==6 && Math.ceil(calcTriangle(3, 4, 5).getP())==12)
			System.out.println("calcTriangle ok");
		else
			System.out.println("calcTriangle fail");
		if (Math.ceil(calcRectangle(1, 1).getA())==1 && Math.ceil(calcRectangle(1, 1).getP())==4)
			System.out.println("calcRectangle ok");
		else 
			System.out.println("calcRectangle fail");
		if (Math.ceil(calcSphere(1).getA())==Math.ceil(pi*4) && Math.ceil(calcSphere(1).getV())==Math.ceil(pi/3))
			System.out.println("calcSphere ok");
		else
			System.out.println("calcSphere fail");
		if (Math.ceil(calcCircle(1).getA())==Math.ceil(pi) && Math.ceil(calcCircle(1).getP())==Math.ceil(pi*2))
			System.out.println("calcCircle ok");
		else
			System.out.println("calcCircle fail");
		if (Math.ceil(calcCone(3, 4).getA())==Math.ceil(pi*24) && Math.ceil(calcCone(3, 4).getV())==Math.ceil(pi*27))
			System.out.println("calcCone ok");
		else
			System.out.println("calcCone fail");
		if (Math.ceil(calcCylinder(1, 1).getA())==Math.ceil(pi*4) && Math.ceil(calcCylinder(1, 1).getV())==Math.ceil(pi))
			System.out.println("calcCylinder ok");
		else
			System.out.println("calcCylinder fail");
	}
	
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
	
	public static Result calcRectangle(double a, double b)
	{
		double _p = (a+b)*2;
		double _a = a*b;
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
