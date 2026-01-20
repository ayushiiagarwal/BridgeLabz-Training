import java.util.*;

class HistoryNode {
    String url;
    HistoryNode prev;
    HistoryNode next;

    HistoryNode(String url){
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

class Tab {
    private HistoryNode current;

    void visit(String url){
        HistoryNode newNode = new HistoryNode(url);

        if(current != null){
            current.next = null;   
            newNode.prev = current;
            current.next = newNode;
        }

        current = newNode;
        System.out.println(url);
    }

    void back(){
        if(current == null || current.prev == null){
            System.out.println("No page to go back.");
            return;
        }
        current = current.prev;
        System.out.println(current.url);
    }

    void forward(){
        if(current == null || current.next == null){
            System.out.println("No page to go forward.");
            return;
        }
        current = current.next;
        System.out.println(current.url);
    }

    String getCurrentPage(){
        return current != null ? current.url : "No page";
    }
}

class TabManager{
    private Stack<Tab> closedTabs = new Stack<>();
    private Tab activeTab = new Tab();

    Tab getActiveTab(){
        return activeTab;
    }

    void closeTab(){
        closedTabs.push(activeTab);
        activeTab = new Tab();
        System.out.println("Tab closed");
    }

    void restoreTab(){
        if(closedTabs.isEmpty()){
            System.out.println("No closed tabs to restore.");
            return;
        }
        activeTab = closedTabs.pop();
        System.out.println("\nTab restored. \nCurrent page: \n" + activeTab.getCurrentPage());
    }
}

public class BrowserBuddy{
    public static void main(String[] args) {

        TabManager manager = new TabManager();
        Tab tab = manager.getActiveTab();

        System.out.println("Visited: ");
        tab.visit(" youtube.com");
        tab.visit(" github.com");
        tab.visit(" classroom.google.com");

        System.out.println("Back to: ");
        tab.back();
        tab.back();

        System.out.println("Forward To: ");
        tab.forward();

        System.out.println();

        manager.closeTab();
        manager.restoreTab();
    }
}
