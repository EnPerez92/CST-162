public class Faculty {
    private int id;
    private String name;
    private String contactInfo;
    private String subject;
    private String position;
    private String availability;

    public Faculty(int id, String name, String contactInfo, String subject, String position, String availability) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.subject = subject;
        this.position = position;
        this.availability = availability;
    }

    //  here are the Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
    public String getSubject() { return subject; }
    public String getPosition() { return position; }
    public String getAvailability() { return availability; }

    // here are the Setters
    public void setName(String name) { this.name = name; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setPosition(String position) { this.position = position; }
    public void setAvailability(String availability) { this.availability = availability; }

    @Override
    public String toString() {
        return "Faculty ID: " + id +
                "\nName: " + name +
                "\nContact Info: " + contactInfo +
                "\nSubject: " + subject +
                "\nPosition: " + position +
                "\nAvailability: " + availability +
                "\n---------------------------";
    }
}

