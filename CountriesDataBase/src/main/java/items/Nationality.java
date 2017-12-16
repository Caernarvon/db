package items;

public class Nationality {
    public int id;
    public String name;
    public String skinColor;

    public Nationality(int id, String name, String skinColor) {
        this.id = id;
        this.name = name;
        this.skinColor = skinColor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSkinColor() {
        return skinColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nationality that = (Nationality) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return skinColor != null ? skinColor.equals(that.skinColor) : that.skinColor == null;
    }
}
