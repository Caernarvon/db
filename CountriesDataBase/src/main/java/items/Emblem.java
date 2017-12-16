package items;

import java.util.Objects;

public class Emblem {
    public int id;
    public String name;

    public Emblem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emblem emblem = (Emblem) o;

        if (id != emblem.id) return false;
        return name != null ? name.equals(emblem.name) : emblem.name == null;
    }
}
