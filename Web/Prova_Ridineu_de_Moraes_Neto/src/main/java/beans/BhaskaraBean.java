package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BhaskaraBean {
	private double a, b, c, x1, x2, delta;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getX1() {
		return x1;
	}
	public double getX2() {
		return x2;
	}

	public void calcular() {
		if(a != 0){
			delta = Math.pow(b, 2)-4*a*c;
			if(delta < 0){
				x1 = -999.999;
				x2 = -999.999;
			}else{
				x1=(-b + Math.sqrt(delta))/(2*a);
		    	x2=(-b - Math.sqrt(delta))/(2*a);
			}
		}
	}
}
