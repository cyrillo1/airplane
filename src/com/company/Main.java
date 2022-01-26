package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {
    static Connection con;
    static PreparedStatement ps;
    Main(){
        try {
            //register the driver
            Class.forName("com.mysql.jdbc.Driver");
            //establish the connectivity
            //String url="jdbc:mysql://localhost:3306/airplane";
            //String user="root";
            //String password="";
            //con= DriverManager.getConnection(url,user,password);
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airplane","root","");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*Will read all the domestic fights available */
    public static void readAlldDomesticFlights() throws SQLException {
        String query="select * from flight";
        ps=con.prepareStatement(query);
        ResultSet rs= ps.executeQuery();
        System.out.println("Flight ID\tFrom\tTo\tDepart Time\tArrival Time");
        System.out.println("************************************************************");
        while (rs.next()){
            System.out.print(rs.getString("Flight_id"));
            System.out.print("\t"+rs.getString("From_location"));
            System.out.print("\t"+rs.getString("To_location"));
            System.out.print("\t"+rs.getString("Day"));
            System.out.print("\t"+rs.getTime("start_at"));
            System.out.println("\t"+rs.getTime("end_at"));
        }
        System.out.println("*************************************************************");
    }
    /*Will read all the International fights available */
    public static void readAllInterFlights() throws SQLException {
        String query = "select * from interflight";
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        System.out.println("Flight ID\tFrom\tTo\tDepart Time\tArrival Time");
        System.out.println("************************************************************");
        while (rs.next()) {
            System.out.print(rs.getString("Flight_id"));
            System.out.print("\t" + rs.getString("From_location"));
            System.out.print("\t" + rs.getString("To_location"));
            System.out.print("\t" + rs.getString("Day"));
            System.out.print("\t" + rs.getTime("start_at"));
            System.out.println("\t" + rs.getTime("end_at"));
        }
        System.out.println("*************************************************************");
    }

    /*To search all the domestic flights available from the location till the destination*/
    public static void searchDomestic(String From_location, String To_location) throws SQLException {
        String query="select * from flight where From_location=? and To_location=?";
        ps=con.prepareStatement(query);
        ps.setString(1,From_location);
        ps.setString(2,To_location);
        ResultSet rs= ps.executeQuery();
        rs.next();
        System.out.println("Flight ID\tFrom\tTo\tDepart Time\tArrival Time");
        System.out.println("*************************************");
        System.out.print(rs.getString("Flight_id"));
        System.out.print("\t"+rs.getString("From_location"));
        System.out.print("\t"+rs.getString("To_location"));
        System.out.print("\t"+rs.getString("Day"));
        System.out.print("\t"+rs.getTime("start_at"));
        System.out.println("\t"+rs.getTime("end_at"));
        System.out.println("*************************************");
    }
    /*To search all the international flights available from the location till the destination*/
    public static void searchInternational(String From_location, String To_location) throws SQLException {
        String query="select * from interflight where From_location=? and To_location=?";
        ps=con.prepareStatement(query);
        ps.setString(1,From_location);
        ps.setString(2,To_location);
        ResultSet rs= ps.executeQuery();
        rs.next();
        System.out.println("Flight ID\tFrom\tTo\tDepart Time\tArrival Time");
        System.out.println("*************************************");
        System.out.print(rs.getString("Flight_id"));
        System.out.print("\t"+rs.getString("From_location"));
        System.out.print("\t"+rs.getString("To_location"));
        System.out.print("\t"+rs.getString("Day"));
        System.out.print("\t"+rs.getTime("start_at"));
        System.out.println("\t"+rs.getTime("end_at"));
        System.out.println("*************************************");
    }
    /*Book a domestic flight seat*/
    public static void bookFlight(String name, int age, String gender, int pan, String passport,String flight_id) throws SQLException {
        String query= "insert into bookflight values(?,?,?,?,?,?)";
        ps=con.prepareStatement(query);
        ps.setString(1,name);
        ps.setInt(2,age);
        ps.setString(3,gender);
        ps.setInt(4,pan);
        ps.setString(5,passport);
        ps.setString(6,flight_id);
        int i=ps.executeUpdate();
        System.out.println(i+" Seat booked");
    }
    /*Domestic Flight selected details*/
    public static void domesticSeat(String flight_id) throws SQLException {
        String query="select * from flight where Flight_id=?";
        ps=con.prepareStatement(query);
        ps.setString(1,flight_id);
        ResultSet rs= ps.executeQuery();
        rs.next();
        System.out.println("Flight ID\tFrom\tTo\tDepart Time\tArrival Time");
        System.out.println("*************************************");
        System.out.print(rs.getString("Flight_id"));
        System.out.print("\t"+rs.getString("From_location"));
        System.out.print("\t"+rs.getString("To_location"));
        System.out.print("\t"+rs.getString("Day"));
        System.out.print("\t"+rs.getTime("start_at"));
        System.out.println("\t"+rs.getTime("end_at"));
        System.out.println("*************************************");
    }
    /*Book international flight seat*/
    public static void bookinterFlight(String name, int age, String gender, int pan, String passport,String flight_id) throws SQLException {
        String query= "insert into bookflight values(?,?,?,?,?,?)";
        ps=con.prepareStatement(query);
        ps.setString(1,name);
        ps.setInt(2,age);
        ps.setString(3,gender);
        ps.setInt(4,pan);
        ps.setString(5,passport);
        ps.setString(6,flight_id);
        int i=ps.executeUpdate();
        System.out.println(i+ "Seat booked");
    }
    /*International Flight selected details*/
    public static void internationalSeat(String flight_id) throws SQLException {
        String query="select * from interflight where Flight_id=?";
        ps=con.prepareStatement(query);
        ps.setString(1,flight_id);
        ResultSet rs= ps.executeQuery();
        rs.next();
        System.out.println("Flight ID\tFrom\tTo\tDepart Time\tArrival Time");
        System.out.println("*************************************************************");
        System.out.print(rs.getString("Flight_id"));
        System.out.print("\t"+rs.getString("From_location"));
        System.out.print("\t"+rs.getString("To_location"));
        System.out.print("\t"+rs.getString("Day"));
        System.out.print("\t"+rs.getTime("start_at"));
        System.out.println("\t"+rs.getTime("end_at"));
        System.out.println("*************************************************************");
    }
    /*Update name of the person*/
    public static void updateName(String passport, String name) throws SQLException {
        String query="update bookflight set name= ? where passport=?";
        ps=con.prepareStatement(query);
        ps.setString(1,name);
        ps.setString(2,passport);
        int i= ps.executeUpdate();
        System.out.println(i+ " Seat updated");
    }
    /*Update age of the person*/
    public static void updateAge(String passport, int age) throws SQLException {
        String query="update bookflight set age= ? where passport=?";
        ps=con.prepareStatement(query);
        ps.setInt(1,age);
        ps.setString(2,passport);
        int i= ps.executeUpdate();
        System.out.println(i+ " Seat updated");

    }
    /*Update gender of the person*/
    public static void updateGender(String passport, String gender) throws SQLException {
        String query="update bookflight set gender= ? where passport=?";
        ps=con.prepareStatement(query);
        ps.setString(1,gender);
        ps.setString(2,passport);
        int i= ps.executeUpdate();
        System.out.println(i+ " Seat updated");

    }
    /*Update Pan of the person*/
    public static void updatePan(String passport, int pan) throws SQLException {
        String query="update bookflight set pan= ? where passport=?";
        ps=con.prepareStatement(query);
        ps.setInt(1,pan);
        ps.setString(2,passport);
        int i= ps.executeUpdate();
        System.out.println(i+ " Seat updated");

    }
    /*Cancel the seat*/
    public static void cancelTicket(String passport) throws SQLException {
        String query="delete from bookflight where passport=?";
        ps=con.prepareStatement(query);
        ps.setString(1,passport);
        int i=ps.executeUpdate();
        System.out.println(i+ " Ticket canceled with passport number "+ passport);
    }
    /*show the details of the seat confirmed*/
    public static void confirmDetails(String passport,String flight_id) throws SQLException {
        String query="select * from bookflight where passport=? and flight_id=?";
        ps=con.prepareStatement(query);
        ps.setString(1,passport);
        ps.setString(2,flight_id);
        ResultSet rs= ps.executeQuery();
        rs.next();
        System.out.println("****************************************************************************************************************2");
        System.out.print("Name: "+ rs.getString("name"));
        System.out.print("\t\tAge: "+ rs.getInt("age"));
        System.out.print("\t\tGender: "+ rs.getString("gender"));
        System.out.print("\t\tPAN: "+ rs.getInt("pan"));
        System.out.print("\t\tPassport Number: "+ rs.getString("passport"));
        System.out.println("\t\tFlight ID: "+ rs.getString("flight_id"));
        System.out.println("****************************************************************************************************************");
    }
//Main method
    public static void main(String[] args) throws SQLException {
        new Main();
        Scanner myObj= new Scanner(System.in);
        while (true){
            System.out.println("Hello! Welcome to online flight booking:");
            System.out.println("Could you please let me know if you want to travel in India or do an International travel");
            System.out.println("Select '1' for Domestic and '2' for International");
            System.out.println("Select '3' to exit");
                int ch=myObj.nextInt();
                if (ch==3)
                    break;
            try {
                switch (ch) {
                    case 1:
                        System.out.println("Flights available are:");
                        readAlldDomesticFlights();
                        System.out.println("Do you want to book a flight?");
                        System.out.println("Y/N");
                        String option = myObj.next();
                        switch (option.toUpperCase()) {
                            case "Y":
                                System.out.println("Search Flights.");
                                System.out.println("Enter nearest airport name:");
                                String From_location= myObj.next();
                                System.out.println("Destination:");
                                String To_location=myObj.next();
                                System.out.println("From: " + From_location+ "\n " + "To: " + To_location);
                                searchDomestic(From_location,To_location);
                                System.out.println("Enter name:");
                                String name = myObj.nextLine();
                                System.out.println("Enter age:");
                                int age = myObj.nextInt();
                                System.out.println("Enter gender:");
                                String gender = myObj.next();
                                System.out.println("Enter pan:");
                                int pan = myObj.nextInt();
                                System.out.println("Enter passport:");
                                String passport = myObj.next();
                                System.out.println("Enter Flight ID");
                                String flight_id = myObj.next();
                                bookFlight(name, age, gender, pan, passport,flight_id);
                                domesticSeat(flight_id);
                                System.out.println("\n");
                                System.out.println("Seat booked, please find details below");
                                System.out.println("**************************************************************************************");
                                System.out.println("Name: "+ name + "\tAge: " + age + "\tGender: " + gender + "\tPAN: " + pan + "\tPassport: " + passport + "\tFlight: " + flight_id);
                                System.out.println("**************************************************************************************");
                                System.out.println("\n");
                                System.out.println("To book another seat please select from the below again");
                                break;
                            case "N":
                                System.out.println("DO you want to update(a) or cancel(b) your flight ticket?");
                                String select= myObj.next();
                                switch (select.toLowerCase()){
                                    case "a":
                                        System.out.println("Please enter passport number for Updating:");
                                        passport=myObj.next();
                                        System.out.println("Please enter Flight ID for Updating:");
                                        flight_id=myObj.next();
                                        confirmDetails(passport,flight_id);
                                        System.out.println("What do you want to update");
                                        System.out.println("1. Name");
                                        System.out.println("2. Age");
                                        System.out.println("3. Gender");
                                        System.out.println("4. PAN");
                                        int update=myObj.nextInt();
                                        switch (update){
                                            case 1:
                                                System.out.println("Enter new name that you want to update : ");
                                                name= myObj.nextLine();
                                                updateName(passport,name);
                                                break;
                                            case 2:
                                                System.out.println("Enter new age that you want to update : ");
                                                age= myObj.nextInt();
                                                updateAge(passport, age);
                                                break;
                                            case 3:
                                                System.out.println("Enter the gender you want to update : ");
                                                gender= myObj.next();
                                                updateGender(passport,gender);
                                                break;
                                            case 4:
                                                System.out.println("Enter new PAN that you want to update : ");
                                                pan= myObj.nextInt();
                                                updatePan(passport, pan);
                                                break;
                                        }
                                        confirmDetails(passport,flight_id);
                                        break;
                                    case "b":
                                        System.out.println("Please enter passport number for cancellation.");
                                        passport=myObj.next();
                                        System.out.println("Please enter Flight ID for cancellation.");
                                        flight_id=myObj.next();
                                        cancelTicket(passport);
                                        confirmDetails(passport,flight_id);
                                        break;
                                }
                        }
                        break;
                    case 2:
                        System.out.println("Flights available are:");
                        readAllInterFlights();

                        System.out.println("Do you want to book a flight?");
                        System.out.println("Y/N");
                        option = myObj.next();
                        switch (option.toUpperCase()) {
                            case "Y":
                                System.out.println("Search Flights.");
                                System.out.println("Enter nearest airport name:");
                                String From_location= myObj.next();
                                System.out.println("To:");
                                String To_location=myObj.next();
                                System.out.println("From: " + From_location+ "\n " + "To: " + To_location);
                                searchInternational(From_location,To_location);
                                System.out.println("Enter name:");
                                String name = myObj.nextLine();
                                System.out.println("Enter age:");
                                int age = myObj.nextInt();
                                System.out.println("Enter gender:");
                                String gender = myObj.next();
                                System.out.println("Enter pan:");
                                int pan = myObj.nextInt();
                                System.out.println("Enter passport:");
                                String passport = myObj.next();
                                System.out.println("Enter Flight ID");
                                String flight_id = myObj.next();
                                bookinterFlight(name, age, gender, pan, passport,flight_id);
                                internationalSeat(flight_id);
                                System.out.println("\n");
                                System.out.println("Seat booked, please find details below");
                                System.out.println("**************************************************************************************");
                                System.out.println("Name: "+ name + "\tAge: " + age + "\tGender: " + gender + "\tPAN: " + pan + "\tPassport: " + passport + "\tFlight: " + flight_id);
                                System.out.println("**************************************************************************************");
                                System.out.println("\n");
                                System.out.println("To book another seat please select from the below again");
                                break;
                            case "N":
                                System.out.println("DO you want to update(a) or cancel(b) your flight ticket?");
                                String select= myObj.next();
                                switch (select.toLowerCase()){
                                    case "a":
                                        System.out.println("Please enter passport number for Updating:");
                                        passport=myObj.next();
                                        System.out.println("Please enter Flight ID for Updating:");
                                        flight_id=myObj.next();
                                        confirmDetails(passport,flight_id);
                                        System.out.println("What do you want to update");
                                        System.out.println("1. Name");
                                        System.out.println("2. Age");
                                        System.out.println("3. Gender");
                                        System.out.println("4. PAN");
                                        int update=myObj.nextInt();
                                        switch (update){
                                            case 1:
                                                System.out.println("Enter new name that you want to update : ");
                                                name= myObj.nextLine();
                                                updateName(passport,name);
                                                break;
                                            case 2:
                                                System.out.println("Enter new age that you want to update : ");
                                                age= myObj.nextInt();
                                                updateAge(passport, age);
                                                break;
                                            case 3:
                                                System.out.println("Enter the gender you want to update : ");
                                                gender= myObj.next();
                                                updateGender(passport,gender);
                                                break;
                                            case 4:
                                                System.out.println("Enter new PAN that you want to update : ");
                                                pan= myObj.nextInt();
                                                updatePan(passport, pan);
                                                break;
                                        }
                                        confirmDetails(passport,flight_id);
                                        break;
                                    case "b":
                                        System.out.println("Please enter passport number for cancellation.");
                                        passport=myObj.next();
                                        System.out.println("Please enter Flight ID for cancellation.");
                                        flight_id=myObj.next();
                                        cancelTicket(passport);
                                        confirmDetails(passport,flight_id);
                                        break;
                                }
                        }
                        break;
                }
            }  catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }
}
