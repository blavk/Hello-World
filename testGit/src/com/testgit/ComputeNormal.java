package com.testgit;

public class ComputeNormal {

	public static double comtax(double ware){
		double comtax = 0;
		if(ware <= 3500){
			return comtax;
		}else if(ware > 3500 && ware <= 5000){
			comtax = 0.03 * (ware - 3500);
		}else if(ware > 5000 && ware <= 8000){
			comtax = comtax(5000) + 0.1 * (ware - 5000);
		}else if(ware > 8000 && ware <= 12500){
			comtax = comtax(8000) + 0.2 * (ware - 8000);
		}else if(ware > 12500 && ware <= 38500){
			comtax = comtax(12500) + 0.25 * (ware - 12500);
		}else if(ware > 38500 && ware <= 58500){
			comtax = comtax(12500) + 0.35 * (ware - 38500);
		}else if(ware > 58500 ){
			comtax = comtax(58500) + 0.45 * (ware - 58500);
		}
			
		return comtax;
	}
	public static double comware(double tax){
		double comware = 0;
//		if(ware <= 3500){
//			return comtax;
//		}else if(ware > 3500 && ware <= 5000){
//			comtax = 0.03 * (ware - 3500);
//		}else if(ware > 5000 && ware <= 8000){
//			comtax = comtax(5000) + 0.1 * (ware - 5000);
//		}else if(ware > 8000 && ware <= 12500){
//			comtax = comtax(8000) + 0.2 * (ware - 5000);
//		}else if(ware > 12500 && ware <= 38500){
//			comtax = comtax(12500) + 0.25 * (ware - 12500);
//		}else if(ware > 38500 && ware <= 58500){
//			comtax = comtax(12500) + 0.35 * (ware - 38500);
//		}else if(ware > 58500 ){
//			comtax = comtax(58500) + 0.45 * (ware - 58500);
//		}
			
		return comware;
	}


	public static void main(String[] args) throws Exception{
		System.out.println(comtax(5000));
		System.out.println(comtax(8000));
		System.out.println(comtax(12500));
		System.out.println(comtax(38500));
		System.out.println(comtax(58500));
		System.out.println(comtax(18000));
		
	}

}
