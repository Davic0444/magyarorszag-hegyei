package hegyek;

public class Entity {

    private String mountainPeakName;
    private String mountains;
    private Integer height;

    public Entity(String mountainPeakName, String mountains, Integer height) {
        this.mountainPeakName = mountainPeakName;
        this.mountains = mountains;
        this.height = height;
    }

    public String getMountainPeakName() {
        return mountainPeakName;
    }

    public String getMountains() {
        return mountains;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "mountainPeakName='" + mountainPeakName + '\'' +
                ", mountains='" + mountains + '\'' +
                ", height=" + height +
                '}';
    }
}
