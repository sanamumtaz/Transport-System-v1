package transport;

//class Person is a parent class for the driver and the students contains the common attributes
abstract class Person {

    private String name, gender, contact;
    //constructors
    Person(){} // no argument constructor
    Person(String n, String g, String c) //three arguments constructor
    {
        this.name = n;
        this.gender = g;
        this.contact = c;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}

/*Student class is a child class of Person class,
  contains attriutes specific to Student */
class Student extends Person {
    // variable declaration
    private String reg_num, home_address, fathers_name,
            email_address, institute, s_class, route_name;
    //constructors
    public Student(){}
    public Student(String n, String g, String c, String r, String r_n, String h_a, String f_n,
            String e_a, String i, String s_c) 
    {
        super(n, g, c);
        this.reg_num = r_n;
        this.home_address = h_a;
        this.fathers_name = f_n;
        this.email_address = e_a;
        this.institute = i;
        this.s_class = s_c;
        this.route_name = r;

    }

    // getters and setters
    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getFathers_name() {
        return fathers_name;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

}

// Driver class is a child class of Person class
// contains attriutes specific to Driver
class Driver extends Person {

    //variable declaration
    private String CNIC, joining_date, rating;
    //constructors
    public Driver(){}
    public Driver(String n, String g, String c, String cnic, String j_d, String r) {

        super(n, g, c);
        this.CNIC = cnic;
        this.joining_date = j_d;
        this.rating = r;

    }

    // getters and setters
    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}

//Route : "a way or course taken in getting from a starting point to a destination"
//class Route contains all the attributes which defines a Route
class Route {

    // variable declaration
    private String Route_name, initial_stop, final_stop;
    private String total_stops;
    private String fare;
    private String[] stops;
    // constructors
    Route(){}
    Route(String r_n, String i_s, String f_s, String t_s, String f) {
        this.Route_name = r_n;
        this.initial_stop = i_s;
        this.final_stop = f_s;
        this.total_stops = t_s;
        this.fare = f;
    }

    //getters and setters
    public String getRoute_name() {
        return Route_name;
    }

    public void setRoute_name(String Route_name) {
        this.Route_name = Route_name;
    }

    public String getInitial_stop() {
        return initial_stop;
    }

    public void setInitial_stop(String initial_stop) {
        this.initial_stop = initial_stop;
    }

    public String getFinal_stop() {
        return final_stop;
    }

    public void setFinal_stop(String final_stop) {
        this.final_stop = final_stop;
    }

    public String getTotal_stops() {
        return total_stops;
    }

    public void setTotal_stops(String total_stops) {
        this.total_stops = total_stops;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String[] getStops() {
        return stops;
    }

    public void setStops(String[] stops) {
        this.stops = stops;
    }

}

//class Vehicle is a class for the vehicles in transport system
//it has two child classes
abstract class Vehicle {

    //variable declaration
    private String vehicle_num;
    private String driver, route;

    //constructor
    public Vehicle(String v_n, Driver d, Route r) {
        this.vehicle_num = v_n;
        this.driver = d.getName();
        this.route = r.getRoute_name();

    }

    //setters and getters
    public String getVehicle_num() {
        return vehicle_num;
    }

    public void setVehicle_num(String vehicle_num) {
        this.vehicle_num = vehicle_num;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}

//class Suzuki is a child class of Vehicle
class Suzuki extends Vehicle {

    public Suzuki(String v_n, Driver v_d, Route v_r) {
        super(v_n, v_d, v_r);
    }
}

//class Hiace is a child class of Vehicle
class Hiace extends Vehicle {

    public Hiace(String v_n, Driver v_d, Route v_r) {
        super(v_n, v_d, v_r);

    }

}

/*class Request is created for the purpose that if the route or seat is not 
  available for the person then he or she can send request for that */
abstract class Request {

    private String name;
    private String contact;
    private String route;

    Request(String n, String c, String r) {
        this.name = n;
        this.contact = c;
        this.route = r;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

}

/*when a route isn't available then person can request for the route
  class Route_Request is the child class of Request */
class Route_Request extends Request {

    Route_Request(String n, String c, String r) {
        super(n, c, r);

    }
}

/*when a seat isn't available then person can request for the seat
  class Seat_Request is the child class of Request */
class Seat_Request extends Request {

    Seat_Request(String n, String c, String r) {
        super(n, c, r);
    }
}
