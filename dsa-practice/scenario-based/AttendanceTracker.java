import java.util.*;

class DuplicateAttendaceException extends Exception{
    public DuplicateAttendaceException(String message){
        super(message);
    }
}

class Attendance{
    private Map<String, Set<String>> attendance = new HashMap<>();

    public void markAtendance(String sessionId, String studentId) throws DuplicateAttendaceException{
        attendance.putIfAbsent(sessionId, new HashSet<>());

        Set<String> students = attendance.get(sessionId);

        if(!students.add(studentId)){
            throw new DuplicateAttendaceException(
                "Attendance already marked for " + studentId);
        }
    }

    public void removeAttendance(String sessionId, String studentId){
        if(attendance.containsKey(sessionId))
            attendance.get(sessionId).remove(studentId);
    }

    public void displayAttendance(){
        for(Map.Entry<String, Set<String>> entry : attendance.entrySet())
            System.out.println("Session: " + entry.getKey() + "\nStudents: " + entry.getValue());
    }
}

public class AttendanceTracker{
    public static void main(String[] args) {
        Attendance tracker = new Attendance();


        try{
            tracker.markAtendance("Session 1", "Student 1");
            tracker.markAtendance("Session 1", "Student 2");
            tracker.markAtendance("Session 1", "Student 3");
            tracker.markAtendance("Session 1", "Student 3");
        }
        catch(DuplicateAttendaceException e){
            System.out.println(e.getMessage());
        }

        tracker.removeAttendance("Session 1", "Student 3");

        tracker.displayAttendance();
    }
}