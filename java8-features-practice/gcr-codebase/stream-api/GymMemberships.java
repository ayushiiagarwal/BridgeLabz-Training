import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

class Member{
    private String name;
    private LocalDate expiryDate;

    public Member(String name, LocalDate expiDate){
        this.name = name;
        this.expiryDate = expiDate;
    }

    public String getName(){ return name; }
    public LocalDate getDate(){ return expiryDate; }

    @Override
    public String toString(){
        return name + "'s Gym Membership expires on: " + expiryDate;
    }
}

public class GymMemberships {
    public static void main(String[] args) {
        List<Member> members = List.of(
            new Member("Rahul", LocalDate.now().plusDays(10)),
            new Member("Rihaan", LocalDate.now().plusDays(20)),
            new Member("Kyra", LocalDate.now().plusDays(15)),
            new Member("Siya", LocalDate.now().plusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<Member> expire = members.stream()
                        .filter(member -> !member.getDate().isBefore(today) && member.getDate().isBefore(next30Days.plusDays(1)))
                        .collect(Collectors.toList());

        expire.forEach(System.out::println);
    }
}
