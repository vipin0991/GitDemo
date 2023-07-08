package coreJavaTraining;

import interfaceDemo.CentralTraffic;
import interfaceDemo.ContinentalTraffic;

public class InterfaceClass implements CentralTraffic, ContinentalTraffic {

	public void myMethod() {
		System.out.println("myMethod");
	}
	
	@Override
	public void greenGo() {
		// TODO Auto-generated method stub
		System.out.println("green Go");
	}

	@Override
	public void redStop() {
		// TODO Auto-generated method stub
		System.out.println("red Stop");		
	}

	public static void main(String[] args) {
		CentralTraffic ct = new InterfaceClass();
		ct.greenGo();
		ct.redStop();
		
		ContinentalTraffic cct = new InterfaceClass();
		cct.flashYellow();
		
		InterfaceClass ic = new InterfaceClass();
		ic.myMethod();
		
		System.out.println(cct.a);
	}

	@Override
	public void flashYellow() {
		// TODO Auto-generated method stub
		System.out.println("Flash Yellow");
		
	}
}
