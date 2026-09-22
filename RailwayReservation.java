package miniproject;
import java.util.ArrayList;
import java.util.Scanner;

class Train{

    public int trainNumber;
    public String trainName;
    public String source;
    public String destination;
    public String departureTime;
    public double distance;
    public int availableSeats;

    public Train(int trainNumber, String trainName,String source,String destination,String departureTime,double distance,int availableSeats)
    {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.distance = distance;
        this.availableSeats = availableSeats;
    }
}

class Passenger{

    public String passengerName;
    public int passengerAge;
    public String passengerId;

    public Passenger(String passengerName, int passengerAge, String passengerId)
    {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.passengerId = passengerId;
    }
}

abstract class Ticket{

    public String pnr;
    public Passenger passenger;
    public Train train;
    public String ticketClass;
    public String seat;
    public double fare;
    public String status;

    public Ticket(String pnr, Passenger passenger, Train train, String ticketClass, String seat, double fare, String status)
    {
        this.pnr = pnr;
        this.passenger = passenger;
        this.train = train;
        this.ticketClass = ticketClass;
        this.seat = seat;
        this.fare = fare;
        this.status = status;
    }

    abstract void calculateFare();
}
class GeneralTicket extends Ticket {

    public double generalRate;
    public GeneralTicket(String pnr, Passenger passenger, Train train,String seat, double generalRate, String status) 
    {
        super(pnr, passenger, train, "General", seat, 0, status);
        this.generalRate = generalRate;
    }
    @Override
    void calculateFare() 
    {
        fare = train.distance * generalRate;
    }
}
class SleeperTicket extends Ticket {

    public double sleeperRate;
    public SleeperTicket(String pnr, Passenger passenger, Train train,String seat, double sleeperRate, String status) 
    {
        super(pnr, passenger, train, "Sleeper", seat, 0, status);
        this.sleeperRate = sleeperRate;
    }

    @Override
    void calculateFare() 
    {
        fare = train.distance * sleeperRate;
    }
}

class ACTicket extends Ticket {

    public double acRate;
    public ACTicket(String pnr, Passenger passenger, Train train,String seat, double acRate, String status) 
    {
        super(pnr, passenger, train, "AC", seat, 0, status);
        this.acRate = acRate;
    }

    @Override
    void calculateFare() 
    {
        fare = train.distance * acRate;
    }
}

public class RailwayReservation{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) {

            Train t1= new Train(12760,"Charminar Express","Hyderabad","Chennai","6:45 PM",630.0,150);
            Train t2 = new Train(12728,"Godavari Express","Hyderabad","Visakhapatnam","7:30 PM",700.0,180);
            Train t3 = new Train(12806,"janmabhoomi Express","Secunderabad","Visakhapatnam","6:00 PM",620.0,200);
            Train t4 = new Train(12740,"Garib Rath Express","Secunderabad","Vijayawada","10:15 PM",350.0,220);
            Train t5 = new Train(12603,"Chennai Express","Chennai","Hyderabad","5:30 PM",630.0,160);
            
            ArrayList<Train> trains = new ArrayList<>();
            
            trains.add(t1);
            trains.add(t2);
            trains.add(t3);
            trains.add(t4);
            trains.add(t5);
            
            System.out.print("Enter source: ");
            String userSource = sc.nextLine();
            
            System.out.print("Enter destination: ");
            String userDestination = sc.nextLine();
            
            boolean found = false;
            
            for (Train train : trains) {
                
                if (train.source.equalsIgnoreCase(userSource) &&
                        train.destination.equalsIgnoreCase(userDestination)) {
                    
                    System.out.println("\nTrain found!: ");
                    System.out.println("Train Number: " + train.trainNumber);
                    System.out.println("Train Name: " + train.trainName);
                    System.out.println("Source: " + train.source);
                    System.out.println("Destination: " + train.destination);
                    System.out.println("Departure: " + train.departureTime);
                    System.out.println("Distance: " + train.distance + " km");
                    System.out.println("Available Seats: " + train.availableSeats);
                    found = true;
                }
            }
            if (!found)
                System.out.println("\nNo trains available for this route.");
        }
    }
}