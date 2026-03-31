import java.util.*;

class InvalidResumeException extends Exception{
    public InvalidResumeException(String message){
        super(message);
    }
}

class Resume{
    private String name;
    private Set<String> skills;
    private int matchScore;

    public Resume(String name, Set<String> skills) throws InvalidResumeException{
        if(skills == null || skills.isEmpty())
            throw new InvalidResumeException("Resume must have at least one skill");

        this.name = name;
        this.skills = skills;
        this.matchScore = 0;
    }

    public String getName(){ return name; }
    public Set<String> getSkills(){ return skills; }
    public int getScore(){ return matchScore; }
    public void setScore(int score){ this.matchScore = score;}
}

class Portal{
    private List<Resume> resumes = new ArrayList<>();

    public void addResume(Resume resume){
        resumes.add(resume);
    }

    public void shortList(Set<String> requiredSkills){
        for(Resume r : resumes){
            int count = 0;
            for(String skill : r.getSkills())
                if(requiredSkills.contains(skill))
                    count++;

            r.setScore(count);
        }

        Collections.sort(resumes, new Comparator<Resume>() {
            public int compare(Resume r1, Resume r2){
                return r2.getScore() - r1.getScore();
            }
        });

        System.out.println("----ShorListed Resumes----");
        for(Resume r : resumes)
            System.out.println(r.getName() + " - Match Score: " + r.getScore());
    }
}

public class JobPortal {
    public static void main(String[] args) {
        try{
            Portal portal = new Portal();

            portal.addResume(new Resume("Adam", new HashSet<>(Arrays.asList("Java", "Python", "SQL"))));
            portal.addResume(new Resume("Liam", new HashSet<>(Arrays.asList("Django", "SQL", "Spring"))));
            portal.addResume(new Resume("Olive", new HashSet<>(Arrays.asList("Python", "Django", "Spring"))));

            Set<String> requiredSkills = new HashSet<>(Arrays.asList("Java", "SQL"));

            portal.shortList(requiredSkills);
        }
        catch(InvalidResumeException e){
            System.out.println(e.getMessage());
        }
    }
}
