package transport;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

//class ExcelReader1 to store data in Excel files
//class ExcelReader1 dont have variables. It just have methods
class ExcelReader1 {
    
    //add_Seat_Request(Seat_Request Rq) add data in excel Request file when person request for seat
    public void add_Seat_Request(Request Rq) {
        File file = new File("Request.xls");
        //if file doesnt exist it creates the file
        if (!file.exists()) {
            try {
                create1();
                excelWritingSeat_Request(Rq);
            } catch (IOException | WriteException | BiffException e) {
                e.printStackTrace();
            }
        }

        try {
            excelWritingSeat_Request(Rq);
        } catch (WriteException | IOException | BiffException e) {
            e.printStackTrace();
        }
    }
    
    //add_Route_Request(Route_Request Rq) add data in excel Request file when person request for new route
    public void add_Route_Request(Request Rq) {
        File file = new File("Request.xls");
        //if file doesnt exist it creates the file
        if (!file.exists()) {
            try {
                create1();
                excelWritingRoute_Request(Rq);
            } catch (IOException | WriteException | BiffException e) {
                e.printStackTrace();
            }
        }

        try {
            excelWritingRoute_Request(Rq);
        } catch (WriteException | IOException | BiffException e) {
            e.printStackTrace();
        }
    }
    
    //add_Hiace(Hiace H1) add data in excel file when admin wants to add new hiace in the system
    public void add_Hiace(Vehicle H1) {
        File file = new File("Routes&Vans.xls");
        //if file doesnt exist it creates the file
        if (!file.exists()) {
            try {
                create();
                excelWritingHiace(H1);
            } catch (IOException | WriteException | BiffException e) {
                e.printStackTrace();
            }
        }

        try {
            excelWritingHiace(H1);
        } catch (WriteException | IOException | BiffException e) {
            e.printStackTrace();
        }
    }

    //add_Suzuki(Suzuki Su) add data in excel file when admin wants to add new suzuki vehicle in the system
    public void add_Suzuki(Vehicle Su) {
        File file = new File("Routes&Vans.xls");
        //if file doesnt exist it creates the file
        if (!file.exists()) {
            try {
                create();
                excelWritingSuzuki(Su);
            } catch (IOException | WriteException | BiffException e) {
                e.printStackTrace();
            }
        }

        try {
            excelWritingSuzuki(Su);
        } catch (WriteException | IOException | BiffException e) {
            e.printStackTrace();
        }
    }

    //add_route(Route R1) add data in excel file when admin wants to add new route for the students
    public void add_route(Route R1) {
        File file = new File("Routes&Vans.xls");
        //if file doesnt exist it creates the file
        if (!file.exists()) {
            try {
                create();
                excelWritingRoute(R1);
            } catch (IOException | WriteException | BiffException e) {
                e.printStackTrace();
            }
        }

        try {
            excelWritingRoute(R1);
        } catch (WriteException | IOException | BiffException e) {
            e.printStackTrace();
        }
    }

    //add(Student S2, Route R1) add data in excel Request file when student fill the form for the first time
    public void add(Student S2, Route R1) {

        File file = new File("Student.xls");
        //if file doesnt exist it creates the file
        if (!file.exists()) {
            try {
                create();
                excelWritingStudent(S2, R1);
            } catch (IOException | WriteException | BiffException e) {
                e.printStackTrace();
            }
        }

        try {
            excelWritingStudent(S2, R1);
        } catch (WriteException | IOException | BiffException e) {
            e.printStackTrace();
        }
    }

    //excelWritingStudent(Student S1, Route R1) writes on the excel file when we add a student
    public void excelWritingStudent(Student S1, Route R1) throws WriteException, IOException, BiffException {
        
        int i;//"G, I, F & H sectors", "Laal Kurti,Adiala", "Falcon Complex,Muslim Town", "Bahria,DHA"
        Workbook aWorkBook = Workbook.getWorkbook(new File("Students.xls"));
        //creating copy of workbook
        WritableWorkbook aCopy = Workbook.createWorkbook(new File("Students.xls"), aWorkBook);
        
        //these if & else if are applied for the purpose that the excel sheet is selected according to route
        // in each value of i updated so that which is the excel 
        if (R1.getRoute_name().equals("G, I, F & H sectors") == true) {
            i = 0;

        } else if (R1.getRoute_name().equals("Laal Kurti,Adiala") == true) {
            i = 1;
            
        } else if (R1.getRoute_name().equals("Falcon Complex,Muslim Town") == true) {
            i = 2;

        } else if (R1.getRoute_name().equals("Bahria,DHA") == true) {
            i = 3;

        } else {
            return;
        }
        WritableSheet aCopySheet = aCopy.getSheet(i);//creating a writeable sheet
        aCopySheet.getRows();
        //creating writeable cells of Label format 
        Label anotherWritableCell1 = new Label(0, aCopySheet.getRows(), S1.getName());
        Label anotherWritableCell2 = new Label(1, aCopySheet.getRows(), S1.getRoute_name());
        Label anotherWritableCell3 = new Label(2, aCopySheet.getRows(), S1.getContact());
        Label anotherWritableCell4 = new Label(3, aCopySheet.getRows(), S1.getGender());
        Label anotherWritableCell5 = new Label(4, aCopySheet.getRows(), S1.getHome_address());
        Label anotherWritableCell6 = new Label(5, aCopySheet.getRows(), S1.getInstitute());

        Label anotherWritableCell7 = new Label(6, aCopySheet.getRows(), S1.getS_class());
        Label anotherWritableCell8 = new Label(7, aCopySheet.getRows(), S1.getReg_num());
        Label anotherWritableCell9 = new Label(8, aCopySheet.getRows(), S1.getFathers_name());
        Label anotherWritableCell10 = new Label(9, aCopySheet.getRows(), S1.getEmail_address());
        // adding cells to sheet
        aCopySheet.addCell(anotherWritableCell1);
        aCopySheet.addCell(anotherWritableCell2);
        aCopySheet.addCell(anotherWritableCell3);
        aCopySheet.addCell(anotherWritableCell4);
        aCopySheet.addCell(anotherWritableCell5);
        aCopySheet.addCell(anotherWritableCell6);
        aCopySheet.addCell(anotherWritableCell7);
        aCopySheet.addCell(anotherWritableCell8);
        aCopySheet.addCell(anotherWritableCell9);
        aCopySheet.addCell(anotherWritableCell10);
        aCopy.write();
        aCopy.close();
    }

    //excelWritingRoute(Route R1) writes on the excel file when we add a route
    public void excelWritingRoute(Route R1) throws WriteException, IOException, BiffException {

        Workbook aWorkBook = Workbook.getWorkbook(new File("Routes&Vans.xls"));
        //creating a writeable workbook
        WritableWorkbook aCopy = Workbook.createWorkbook(new File("Routes&Vans.xls"), aWorkBook);
        //creating a writeable sheet
        WritableSheet aCopySheet = aCopy.getSheet(0);
        //getting rows of sheet
        aCopySheet.getRows();
        
        //creating writeable cells of Label format 
        Label anotherWritableCell1 = new Label(0, aCopySheet.getRows(), R1.getRoute_name());
        Label anotherWritableCell2 = new Label(1, aCopySheet.getRows(), R1.getInitial_stop());
        Label anotherWritableCell3 = new Label(2, aCopySheet.getRows(), R1.getFinal_stop());
        Label anotherWritableCell4 = new Label(3, aCopySheet.getRows(), R1.getTotal_stops());
        Label anotherWritableCell5 = new Label(4, aCopySheet.getRows(), R1.getFare());

        // adding cells to sheet
        aCopySheet.addCell(anotherWritableCell1);
        aCopySheet.addCell(anotherWritableCell2);
        aCopySheet.addCell(anotherWritableCell3);
        aCopySheet.addCell(anotherWritableCell4);
        aCopySheet.addCell(anotherWritableCell5);

        aCopy.write();
        aCopy.close();
    }

    //excelWritingSuzuki(Suzuki Su) writes on the excel file when we add a suzuki
    public void excelWritingSuzuki(Vehicle Su) throws WriteException, IOException, BiffException {

        Workbook aWorkBook = Workbook.getWorkbook(new File("Routes&Vans.xls"));
        WritableWorkbook aCopy = Workbook.createWorkbook(new File("Routes&Vans.xls"), aWorkBook);
        WritableSheet aCopySheet = aCopy.getSheet(1);

        aCopySheet.getRows();
        Label anotherWritableCell1 = new Label(0, aCopySheet.getRows(), Su.getVehicle_num());
        Label anotherWritableCell2 = new Label(1, aCopySheet.getRows(), Su.getDriver());
        Label anotherWritableCell3 = new Label(2, aCopySheet.getRows(), Su.getRoute());
        Label anotherWritableCell5 = new Label(3, aCopySheet.getRows(), "Suzuki");

        aCopySheet.addCell(anotherWritableCell1);
        aCopySheet.addCell(anotherWritableCell2);
        aCopySheet.addCell(anotherWritableCell3);
        aCopySheet.addCell(anotherWritableCell5);

        aCopy.write();
        aCopy.close();
    }

    //excelWritingHiace(Hiace H1)  writes on the excel file when we add a hiace
    public void excelWritingHiace(Vehicle H1) throws WriteException, IOException, BiffException {

        Workbook aWorkBook = Workbook.getWorkbook(new File("Routes&Vans.xls"));
        WritableWorkbook aCopy = Workbook.createWorkbook(new File("Routes&Vans.xls"), aWorkBook);
        WritableSheet aCopySheet = aCopy.getSheet(1);

        aCopySheet.getRows();
        Label anotherWritableCell1 = new Label(0, aCopySheet.getRows(), H1.getVehicle_num());
        Label anotherWritableCell2 = new Label(1, aCopySheet.getRows(), H1.getDriver());
        Label anotherWritableCell3 = new Label(2, aCopySheet.getRows(), H1.getRoute());
        Label anotherWritableCell5 = new Label(3, aCopySheet.getRows(), "Hiace");

        aCopySheet.addCell(anotherWritableCell1);
        aCopySheet.addCell(anotherWritableCell2);
        aCopySheet.addCell(anotherWritableCell3);
        aCopySheet.addCell(anotherWritableCell5);

        aCopy.write();
        aCopy.close();
    }

    //excelWritingRoute_Request(Route_Request Rq)  writes on the excel file when we add a route request
    public void excelWritingRoute_Request(Request Rq) throws WriteException, IOException, BiffException {

        Workbook aWorkBook = Workbook.getWorkbook(new File("Request.xls"));
        WritableWorkbook aCopy = Workbook.createWorkbook(new File("Request.xls"), aWorkBook);
        WritableSheet aCopySheet = aCopy.getSheet(1);

        aCopySheet.getRows();
        Label anotherWritableCell1 = new Label(0, aCopySheet.getRows(), Rq.getName());
        Label anotherWritableCell2 = new Label(1, aCopySheet.getRows(), Rq.getContact());
        Label anotherWritableCell3 = new Label(2, aCopySheet.getRows(), Rq.getRoute());

        aCopySheet.addCell(anotherWritableCell1);
        aCopySheet.addCell(anotherWritableCell2);
        aCopySheet.addCell(anotherWritableCell3);

        aCopy.write();
        aCopy.close();
    }

    //excelWritingSeat_Request(Seat_Request Rq)  writes on the excel file when we add a seat request
    public void excelWritingSeat_Request(Request Rq) throws WriteException, IOException, BiffException {

        Workbook aWorkBook = Workbook.getWorkbook(new File("Request.xls"));
        WritableWorkbook aCopy = Workbook.createWorkbook(new File("Request.xls"), aWorkBook);
        WritableSheet aCopySheet = aCopy.getSheet(0);

        aCopySheet.getRows();
        Label anotherWritableCell1 = new Label(0, aCopySheet.getRows(), Rq.getName());
        Label anotherWritableCell2 = new Label(1, aCopySheet.getRows(), Rq.getContact());
        Label anotherWritableCell3 = new Label(2, aCopySheet.getRows(), Rq.getRoute());

        aCopySheet.addCell(anotherWritableCell1);
        aCopySheet.addCell(anotherWritableCell2);
        aCopySheet.addCell(anotherWritableCell3);

        aCopy.write();
        aCopy.close();
    }

    //create() creates a "Routes&Vans.xls" file
    public void create() throws IOException, WriteException {

        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("Routes&Vans.xls"));
        writableWorkbook.createSheet("Routes&Vans.xls", 0);
        writableWorkbook.write();
        writableWorkbook.close();

    }

    //create1() creates a "Request.xls" file
    public void create1() throws IOException, WriteException {

        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("Request.xls"));
        writableWorkbook.createSheet("Request.xls", 0);
        writableWorkbook.write();
        writableWorkbook.close();
    }

    //create2() creates a "Student.xls" file
    public void create2() throws IOException, WriteException {

        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("Student.xls"));
        writableWorkbook.createSheet("Student.xls", 0);
        writableWorkbook.write();
        writableWorkbook.close();

    }

    //getRows(int i) count the number of rows of excel sheet
    //where input argument is the sheet number
    public int getRows(int i) throws WriteException, IOException, BiffException {
        int a;
        jxl.Workbook workbook = null;
        jxl.Sheet sheet = null;
        workbook = jxl.Workbook.getWorkbook(new File("Students.xls"));
        sheet = workbook.getSheet(i);

        a = sheet.getRows();
        return a;
    }
}
