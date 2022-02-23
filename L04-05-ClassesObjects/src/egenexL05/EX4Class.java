package egenexL05;

public class EX4Class {
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String count1;
    private String count2;


    public EX4Class(String firstName, String middleName, String lastName, String fullName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullName = fullName;
    }

    public String userName() {
        /*
        String Initial = firstName.substring(0,2);
        String InitialUC = Initial.toUpperCase();
        int length = middleName.length();
        String Final = lastName.substring(lastName.length()-2);
        String FinalLC = Final.toLowerCase();
        *
         */
        return firstName.substring(0,2).toUpperCase() +
                middleName.length() +
                lastName.substring(lastName.length()-2).toLowerCase();
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setMiddleName(String middleName){
        this.middleName = middleName;

    }

    public String getMiddleName(){
        return middleName;
    }


    public void setLastName(String lastName){
        this.lastName = lastName;

    }

    public String getLastName(){
        return lastName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getFullName(){
        return fullName;
    }

    public String getInits(){
        return firstName.substring(0,1) + lastName.substring(0,1);
    }

    public String getCryptoInits(int count){
        return count1.valueOf(firstName.substring(0, 1) + 2) +
                count2.valueOf(lastName.substring(0, 1) + 1);
    }

    public void printEX4Class() {
        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Full Name: " + fullName);
    }
}
