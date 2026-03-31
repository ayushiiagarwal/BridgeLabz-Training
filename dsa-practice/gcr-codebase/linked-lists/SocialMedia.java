class Friend {
    int friendID;
    Friend next;

    Friend(int id) {
        this.friendID = id;
    }
}

class User {
    int userID;
    String name;
    int age;
    Friend friendsHead; 
    User next;

    User(int id, String name, int age) {
        this.userID = id;
        this.name = name;
        this.age = age;
        this.friendsHead = null;
    }
}

public class SocialMedia {
    User head = null;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
        }
        else {
            User temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    private User findUser(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            addIdToList(u1, id2);
            addIdToList(u2, id1);
        }
    }

    private void addIdToList(User user, int friendID) {
        Friend newNode = new Friend(friendID);
        if (user.friendsHead == null) {
            user.friendsHead = newNode;
        }
        else {
            Friend temp = user.friendsHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void removeFriend(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            u1.friendsHead = removeFromList(u1.friendsHead, id2);
            u2.friendsHead = removeFromList(u2.friendsHead, id1);
        }
    }

    private Friend removeFromList(Friend fHead, int id) {
        if (fHead == null) return null;
        if (fHead.friendID == id) return fHead.next;
        Friend temp = fHead;
        while (temp.next != null && temp.next.friendID != id) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
        return fHead;
    }

    public void findMutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 == null || u2 == null) return;

        System.out.print("Mutual friends of " + u1.name + " and " + u2.name + ": ");
        Friend f1 = u1.friendsHead;
        while (f1 != null) {
            Friend f2 = u2.friendsHead;
            while (f2 != null) {
                if (f1.friendID == f2.friendID) {
                    System.out.print(f1.friendID + " ");
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }
        System.out.println();
    }

    public void displayFriends(int id) {
        User u = findUser(id);

        if (u == null) return;

        System.out.print("Friends of " + u.name + ": ");

        Friend temp = u.friendsHead;
        while (temp != null) {
            System.out.print(temp.friendID + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void searchUser(String nameOrId) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equals(nameOrId) || String.valueOf(temp.userID).equals(nameOrId)) {
                System.out.println("User Found: " + temp.name + " ID: " + temp.userID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            int count = 0;
            Friend f = temp.friendsHead;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMedia a = new SocialMedia();
        a.addUser(1, "Adam", 20);
        a.addUser(2, "Olive", 21);
        a.addUser(3, "Chad", 22);
        a.addUser(4, "Liam", 23);

        a.addFriend(1, 2); 
        a.addFriend(1, 3); 
        a.addFriend(4, 2); 
        a.addFriend(4, 3); 

        a.displayFriends(1);
        a.displayFriends(4);
        
        a.findMutualFriends(1, 4);
        
        a.countFriends();
        
        a.removeFriend(1, 2);
        System.out.println("After removing friend 2 from 1:");
        a.displayFriends(1);
    }
}