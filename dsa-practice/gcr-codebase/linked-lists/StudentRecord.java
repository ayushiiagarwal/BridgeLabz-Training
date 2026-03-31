class Student{
    String name;
    int rollNumber;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecord{
    Student head = null;

    public void addAtBeginning(int rollNumber, String name, int age, char grade){
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, char grade){
        Student newStudent = new Student(rollNumber, name, age, grade);
        if(head == null){
            head = newStudent;
            return;
        }
        Student temp = head;
        while(temp.next != null)
            temp = temp.next;
        
        temp.next = newStudent;
    }

    public void addAtPosition(int pos, int rollNumber, String name, int age, char grade){
        if(pos <= 1){
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for(int i=1; temp != null && i<pos-1;i++)
            temp = temp.next;

        if(temp == null){
            System.out.println("position out of bound");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRollNumber(int roll){
        if(head == null) return;

        if(head.rollNumber == roll){
            head = head.next;
            return;
        }
        Student temp = head;
        while(temp != null && temp.next.rollNumber != roll)
            temp = temp.next;

        if(temp == null){
            System.out.println("Roll Number not found");
            return;
        }
        temp.next = temp.next.next;
    }

    public void searchByRollNumber(int roll){
        Student temp = head;
        System.out.println("Searching for: " + roll);
        while(temp != null){
            if(temp.rollNumber == roll){
                System.out.println("Found: " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("No such Student exists.");
    }

    public void updateGrade(int roll, char newGrade){
        Student temp = head;
        System.out.println("Updating the Grade of Roll Number: " + roll);
        while(temp != null){
            if(temp.rollNumber == roll){
                temp.grade = newGrade;
                System.out.println("Updated to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("No such Student exists.");
    }

    public void displayRecords(){
        Student temp = head;
        if(temp == null){
            System.out.println("No records found");
            return;
        }

        while(temp != null){
            System.out.println("Roll Number: " + temp.rollNumber + "\nName: " + temp.name + "\nAge: " + temp.age + "\nGrade: " + temp.grade);
            System.out.println();
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        StudentRecord student = new StudentRecord();

        student.addAtBeginning(1, "Adam", 20, 'A');
        student.addAtEnd(3, "Olive", 20, 'A');
        student.addAtPosition(2, 2, "Liam", 21, 'B');
        student.searchByRollNumber(3);
        System.out.println();
        student.updateGrade(2, 'A');
        System.out.println();
        student.deleteByRollNumber(2);
        student.displayRecords();
    }
}