import java.util.Objects;

public final class Dish implements Item {
    private final int iPrice;
    private final String stName;
    private final String stDescription;


    Dish(int iPrice, String stName, String stDescription) {
        if(stDescription.isEmpty() || iPrice < 0 || stName.isEmpty()) {
            throw new java.lang.IllegalArgumentException();
        }
        this.stDescription = stDescription;
        this.iPrice = iPrice;
        this.stName = stName;

    }

    @Override
    public int getCost() {
        return iPrice;
    }

    @Override
    public String getName() {
        return stName;
    }

    @Override
    public String getDescription() {
        return stDescription;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Dish) obj;
        return this.iPrice == that.iPrice &&
                Objects.equals(this.stName, that.stName) &&
                Objects.equals(this.stDescription, that.stDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iPrice, stName, stDescription);
    }

    @Override
    public String toString() {
        return "Dish[" +
                "iPrice=" + iPrice + ", " +
                "stName=" + stName + ", " +
                "stDescription=" + stDescription + ']';
    }
}
