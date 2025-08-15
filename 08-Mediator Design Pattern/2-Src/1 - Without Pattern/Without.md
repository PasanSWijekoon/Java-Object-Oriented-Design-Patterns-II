```java
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message, User receiver) {
        System.out.println("From: " + this.name + " To: " + receiver.name + ": " + message);
    }
}

public class ChatApp {
    public static void main(String[] args) {
        User u1 = new User("Sahan");
        User u2 = new User("Dinuka");

        u1.sendMessage("Good Morning!", u2);
        u2.sendMessage("Same to you!", u1);
    }
}
```

**Problems:**

  * Users are tightly coupled.
  * If communication logic changes, all users must be updated.