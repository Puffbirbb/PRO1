public class Ex3ChildClass {
    private int age;
    private boolean male;

    public Ex3ChildClass(int age, boolean male){
        this.age = age;
        this.male = male;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void isMale(boolean male){
        this.male = male;
    }

    public boolean getMale(){
        return male;
    }

    public String institution() {
        String result = null;
        if (age >= 1 && age <= 2) {
            result = "Nursery";
            System.out.println("You're in a Nursery");
        }
        else if (age >= 3 && age <= 5){
            result = "Kindergarten";
            System.out.println("You're in a Kindergarten");
        }
        else if (age >= 6 && age <= 16){
            result = "School";
            System.out.println("You're in a School");
        }
        else if (age >= 17){
            result = "Adult";
            System.out.println("You're an Adult");
        }

        return result;
    }

    public String gender() {
        String childgender;
        if (male){
            childgender = "Boy";
            System.out.println("You Are a Boy");
        }
        else {
            childgender = "Girl";
            System.out.println("You Are a Girl");
        }

        return childgender;
    }

    public String team() {
        String childteam;
        if (male){
            if (age < 8){
                childteam = "Young Boys";
                System.out.println("You Play on the Young Boys Team");
            }
            else {
                childteam = "Cool Boys";
                System.out.println("You Play on the Cool Boys Team");
            }

        }
        else {
            if (age < 8){
                childteam = "Tumbling Girls";
                System.out.println("You Play on the Tumbling Girls Team");
            }
            else {
                childteam = "Springy Girls";
                System.out.println("You Play on the Springy Girls Team");
            }
        }

        return childteam;
    }

    public void printEx3ChildClass(){
        System.out.println("Age: " + age);
        System.out.println("Gender Male: " + male);
    }
}
