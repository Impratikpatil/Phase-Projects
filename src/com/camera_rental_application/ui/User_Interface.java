package com.camera_rental_application.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.camera_rental_application.cameras.Cameras;
import com.camera_rental_application.options.Camera_Option;
import com.camera_rental_application.options.Camera_Options;
import com.camera_rental_application.userInf.Account;

public class User_Interface {
	public static ArrayList<Cameras> CameraList = new ArrayList<>();
	public static Scanner scanner = new Scanner(System.in);
	public static void options() {
		Camera_Options camera_Option = new Camera_Option();
		System.out.println("\nEnter your Choices:");
		System.out.println("1.My Camera \n2.Rent a Camera \n3.View All Cameras \n4.My Wallet \n5.Exit");
		System.out.println("**************************************************");
		int op = scanner.nextInt();
		boolean a = true;
		do {
		switch (op) {
		case 1: {
			camera_Option.myCamera();
			options();
		}
		break;
		case 2: {
			camera_Option.rentCamera();
		}break;
		case 3:{
			camera_Option.allCameras();
		}break;
		case 4:{
			camera_Option.myWallet();
		}
		case 5: 
			System.out.println("Thank You for using The Camera Rental App!");
			System.out.println("**************************************************");
		    a= false; 
		    System.exit(0);
		    break;
		    
		default:
			options();
//			throw new IllegalArgumentException("Unexpected value: " + op);
		}
		
		}while(a ==true);
	}
	public static void main(String[] args) {

		CameraList.add(new Cameras(1,"Canon","XLR",5000.00,"Available"));
		CameraList.add(new Cameras(2,"Nikon","D7500",500.00,"Available"));
		CameraList.add(new Cameras(3,"Samsung","SM123",900.00,"Rented"));
		CameraList.add(new Cameras(4,"Sony","HD214",600.00,"Available"));
		CameraList.add(new Cameras(5,"LG","L123",200.00,"Available"));
		CameraList.add(new Cameras(6,"Chroma","CT",250.00,"Rented"));
		CameraList.add(new Cameras(7,"Fujitsu","J55",2000.00,"Available"));
		CameraList.add(new Cameras(8,"Panasonic","XC",1200.00,"Rented"));
		
		Account account = new Account();
		account.setUserName("Admin");
		account.setPassword("Admin123");
		
		System.out.println("WELCOME TO CAMERA RENTAL APP:-");
		System.out.println("\nEnter Your Username and Password.");
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("1.Enter Username: ");
			String name= scanner.next();
			if(name.equals(account.getUserName())) {
				System.out.println("\n2.Enter Password: ");
				String pass = scanner.next();
				if(pass.equals(account.getPassword())) {
					System.out.println("\nLOG-IN SUCCESSFULL\n");
					System.out.println("**************************************************");
					options();
				}
				else {
					System.out.println("Enter Correct Password..!");
				}
			}
			else {
				System.out.println("Enter Correct Username..! ");
			}
		}
	}
}
