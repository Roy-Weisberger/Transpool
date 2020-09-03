package main;

import checks.FileCheck;
import classes.TranspoolSystem;
import exceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

public class Main {

    private final static String JAXB_XML_GAME_PACKAGE_NAME = "engine.schema";

    public static void main(String[] args) throws JAXBException {
        boolean isOk=true;
        Scanner scanner = new Scanner(System.in);
        boolean fileIsVaild=false;
        TranspoolSystem TPoolSystem = new TranspoolSystem();
        MenuFunctions functions = new MenuFunctions();
        System.out.println("Welcome to TranSpool system!");
        do {
            try{
            System.out.println("Please choose one of the following options:");
            System.out.println("[1] Load the system file");
            System.out.println("[2] Request a ride");
            System.out.println("[3] Show all existing trips status");
            System.out.println("[4] Show all current ride requests");
            System.out.println("[5] Find a match to a ride request");
            System.out.println("[6] Create a new trip");
            System.out.println("[7] Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    fileIsVaild = functions.loadXmlFile(scanner, TPoolSystem);
                    break;
                case 2:
                    fileIsVaild = functions.submitTripRequest(scanner, TPoolSystem);
                    break;
                case 3:
                    isOk = functions.showTripsStatus(TPoolSystem);
                    break;
                case 4:
                    isOk = functions.showTripRequestsStatus(TPoolSystem);
                    break;
                case 5:
                    isOk = functions.findTripRequestMatch(scanner, TPoolSystem);
                    break;
                case 6:
                    isOk = functions.addNewTrip(scanner,TPoolSystem);
                    break;
                case 7:
                    isOk = false;
                    break;
                default:
                    System.out.println("You must choose an option between (1-6)");
                    break;
            }
            }catch(InputMismatchException e) {
                System.out.println("The choice must be a number!");
                scanner.next();
            }
        } while(isOk);
    }
}
