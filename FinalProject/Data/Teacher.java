package FinalProject.Data;

public class Teacher extends Person{

    //private ArrayList<Teacher> teacherList = new ArrayList<>();


    private int id;
    private double hourswork;
    private double experienceyears;
    private double baseSalary;
    private boolean teachertype;
    private String type;
    //true = full time - false = Part time


    public Teacher(String name, int id, boolean teachertype, double baseSalary, double hourswork, double experienceyears){
        super(name);
        this.id = id;
        this.hourswork = hourswork;
        this.teachertype = teachertype;
        this.experienceyears = experienceyears;
        this.baseSalary = baseSalary;
    }

    public double teacherSalary(boolean teachertype, double baseSalary, double experienceyears, double hourswork) {
        if(teachertype){
            return baseSalary + (baseSalary * (0.1 * experienceyears));
        }else {
            return ((baseSalary/160) * (hourswork*4));
        }

    }

    public String teacherTyDef(boolean teachertype){
        if(teachertype){
            return "Full time";
        } else {
            return "Part time";
        }
    }


    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHourswork() {
        return hourswork;
    }

    public void setHourswork(double hourswork) {
        this.hourswork = hourswork;
    }

    public double getExperienceyears() {
        return experienceyears;
    }

    public void setExperienceyears(double experienceyears) {
        this.experienceyears = experienceyears;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public boolean getTeachertype() {
        return teachertype;
    }

    public void setTeachertype(boolean teachertype) {
        this.teachertype = teachertype;
    }




}
