abstract class Person {
    // Person is an abstract class with only a name
    private String name_;

    public Person(String name) {name_ = name;}

    // Getters and setters
    public void set_name(String name) {name_ = name;}
    public String get_name() {return name_;}
}

////// Cohesion: Here, every type of person that extends the person class does much more than what we see here. They use the person's name, but do much more than that. //////