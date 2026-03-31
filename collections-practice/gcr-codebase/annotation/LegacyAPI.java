public class LegacyAPI {

    @Deprecated
    static void oldFeature(){
        System.out.println("Old Feature");
    }

    static void newFeature(){
        System.out.println("New Feature");
    }
}

class Legacy {
    public static void main(String[] args) {
        LegacyAPI.oldFeature();   
        LegacyAPI.newFeature();
    }
}
