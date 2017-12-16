package items;

public class Country_nationalities {
    public int countryId;
    public int nationId;

    public Country_nationalities(int countryId, int nationId) {
        this.countryId = countryId;
        this.nationId = nationId;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getNationId() {
        return nationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country_nationalities that = (Country_nationalities) o;

        if (getCountryId() != that.getCountryId()) return false;
        return getNationId() == that.getNationId();
    }
}
