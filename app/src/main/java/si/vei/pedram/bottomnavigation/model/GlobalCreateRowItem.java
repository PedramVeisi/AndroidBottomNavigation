package si.vei.pedram.bottomnavigation.model;

public class GlobalCreateRowItem {

    private String rowTtile;
    private int imageResId;

    public GlobalCreateRowItem(String rowTtile, int imageResId) {
        this.rowTtile = rowTtile;
        this.imageResId = imageResId;
    }

    public String getRowTtile() {
        return rowTtile;
    }

    public int getImageResId() {
        return imageResId;
    }
}
