class State {
    String text;
    State prev, next;

    State(String text) {
        this.text = text;
    }
}

public class UndoRedo {
    private State head = null;
    private State tail = null;
    private State currentState = null; 
    private int count = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String text) {
        if (currentState != null && currentState.next != null) {
            currentState.next = null;
            tail = currentState;
            updateCount();
        }

        State newState = new State(text);
        if (head == null) {
            head = tail = currentState = newState;
        }
        else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            currentState = newState;
        }
        count++;

        if (count > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            count--;
        }
    }

    private void updateCount() {
        int c = 0;
        State temp = head;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        count = c;
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Action: Undo");
        }
        else{
            System.out.println("Action: Undo (Already at oldest state)");
        }
    }

    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Action: Redo");
        }
        else {
            System.out.println("Action: Redo (Already at newest state)");
        }
    }

    public void display() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.text);
        }
        else {
            System.out.println("Current Text: [Empty]");
        }
    }

    public static void main(String[] args) {
        UndoRedo editor = new UndoRedo();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.display();

        editor.undo();
        editor.display();

        editor.undo();
        editor.display();

        editor.redo();
        editor.display();

        editor.addState("Hello Hello");
        System.out.println("New action performed. Redo history cleared.");
        editor.redo(); 
        editor.display();
    }
}