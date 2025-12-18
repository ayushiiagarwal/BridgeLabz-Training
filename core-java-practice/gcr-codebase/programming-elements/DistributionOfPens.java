// divide 14 pens among 3 studentsequally. find how many pens each student will get if the pens must be distributed equally
// and how many pens will remain undistributed.
public class DistributionOfPens {
    public static void main(String[] args) {
        int totalPens = 14;
        int totalStudents = 3;

        int pensPerStudent = totalPens / totalStudents;
        int remainingPens = totalPens % totalStudents;

        System.out.println("The pen Per Student is " + pensPerStudent + " and the remaining non-distributed pens are " + remainingPens);
    }
}
