public class Game extends Item{
    private int year;

    public Game(String itemName, String itemNumber, int itemQuantity, double itemPrice, int year) {
        super(itemName, itemNumber, itemQuantity, itemPrice);
        setYear(year);
        super.setType("Game");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void itemDetails(){
        super.itemDetails();
        System.out.println(", year of the first release: "+getYear());
    }

}
