package com.camera_rental_application.options;

import java.util.Scanner;

import com.camera_rental_application.cameras.Cameras;
import com.camera_rental_application.ui.User_Interface;
import com.camera_rental_application.userInf.Account;
import java.util.ArrayList;

public class Camera_Option implements Camera_Options{
	Cameras cameras = new Cameras();
	Account account = new Account();
	Scanner scanner = new Scanner(System.in);
	Account account1 = new Account(1000.00);
	User_Interface user = new User_Interface();
	@Override
	public void myCamera() {
		System.out.println("**************************************************");
		System.out.println("1.Add \n2.Remove \n3.View My Cameras \n4.Go To Previous Menu");
		System.out.println("**************************************************");
		int choice = scanner.nextInt();
		boolean a = true;
		do {
		switch (choice) {
		case 1: {
			int id = User_Interface.CameraList.size() + 1;
			for(Cameras c: User_Interface.CameraList) {
				if(c.getId()== id) {
					id++;
					
				}
				else {
					cameras.setId(id);
				}
			}
			System.out.println("Enter the Camera Brand: ");
			String br = scanner.next();
			System.out.println("Enter Model Name:");
			String mod =scanner.next();
			System.out.println("Enter Price:");
			double pr = scanner.nextDouble();
			String st = "Available";
			Cameras cameras1 = new Cameras(id, br, mod, pr, st);
			User_Interface.CameraList.add(cameras1);
			for(Cameras c: User_Interface.CameraList) {
				System.out.println(c);
			}
			myCamera();
		}
		break;
		case 2: {
		    System.out.println("Please Enter ID:");
		    int id = scanner.nextInt();
		    ArrayList<Cameras> camerasToRemove = new ArrayList<>(); // Create a new list
		    for (Cameras c : User_Interface.CameraList) {
		        if (c.getId() == id) {
		            camerasToRemove.add(c); // Add the camera to the new list
		            System.out.println("Your Camera is Successfully Removed.\n");
		        }
		    }
		    User_Interface.CameraList.removeAll(camerasToRemove); // Remove the cameras from the new list
		    myCamera();
		}
		break;

		case 3:{
			for(Cameras c: User_Interface.CameraList) {
				System.out.println(c);
			}
			myCamera();
		} break;
		case 4:{
			User_Interface.options();
		}break;
		
		default:
//			throw new IllegalArgumentException("Unexpected value: " + choice);
			a =false;
		}} while(a== true);
		
	}
	@Override
	public void rentCamera() {
		for(Cameras c: User_Interface.CameraList) {
			System.out.println(c);
		}
		System.out.println("\nEnter Id - to rent a Camera:"); //give camera to rent);
		int id = scanner.nextInt();
		for(Cameras c: User_Interface.CameraList) {
			if(c.getId()== id) {
				if(c.getPrice() <= account.getWallet()) {
					double amt = c.getPrice();
					amt -= account.getWallet()- c.getPrice();
					account.setWallet(amt);
					System.out.println("Your Transaction for camera - " + c.getBrand() + " with rent " + c.getPrice()+ " has successfully completed.\n");	
					c.setStatus("Rented");
					User_Interface.options();
				}
				else {
					System.out.println("Your Balnce is to low.\n");
					User_Interface.options();
				}
			}
		}
	}
	@Override
	public void myWallet() {
		

		System.out.println("\nYour current wallet balance is -: INR." + account.getWallet());
		System.out.println("\nDo you want to demoposit more amount to your wallet?(1.Yes 2.No)-");
		int n = scanner.nextInt();
		switch (n) {
		case 1: {
			System.out.println("Enter Amount(INR)-" );
			double amt = scanner.nextInt();
			amt += account.getWallet(); 
			account.setWallet(amt);
			System.out.println("Your wallet balance updated successfully. \nCurrent wallet balacnce is - INR." + account.getWallet());
			myWallet();
		}break;
		
		case 2:{
			User_Interface.options();
		} break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		}
	}
	@Override
	public void allCameras() {
		for(Cameras c: User_Interface.CameraList) {
			System.out.println(c);
		}
		myCamera();
		
	}

}
