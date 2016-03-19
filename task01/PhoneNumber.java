package task01;


public class PhoneNumber {
    private int number = 0;
    private String type = null;

    public PhoneNumber() {
    }

    public PhoneNumber(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public void ShowPhoneNumber() {
        System.out.print(" Type: " + getType() + ". Phone number: " + getNumber());
    }
}
