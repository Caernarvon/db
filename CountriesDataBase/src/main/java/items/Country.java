package items;

public class Country {
    public int id;
    public String shortName;
    public String fullName;
    public int emblemId;

    public Country(int id, String shortName, String fullName, int emblemId) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
        this.emblemId = emblemId;
    }

    public int getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getEmblemId() {
        return emblemId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (emblemId != country.emblemId) return false;
        if (shortName != null ? !shortName.equals(country.shortName) : country.shortName != null) return false;
        return fullName != null ? fullName.equals(country.fullName) : country.fullName == null;
    }
}
