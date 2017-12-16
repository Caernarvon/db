package items;

public class Locality {
    public int id;
    public String name;
    public int populationAmount;
    public boolean isCapital;
    public boolean isRegionCentre;
    public int countryId;
    public int localityTypeId;
    public int emblemId;
    public int regionId;

    public Locality(int id, String name, int populationAmount, boolean isCapital, boolean isRegionCentre,
                    int countryId, int localityTypeId, int emblemId, int regionId) {
        this.id = id;
        this.name = name;
        this.populationAmount = populationAmount;
        this.isCapital = isCapital;
        this.isRegionCentre = isRegionCentre;
        this.countryId = countryId;
        this.localityTypeId = localityTypeId;
        this.emblemId = emblemId;
        this.regionId = regionId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulationAmount() {
        return populationAmount;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public boolean isRegionCentre() {
        return isRegionCentre;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getLocalityTypeId() {
        return localityTypeId;
    }

    public int getEmblemId() {
        return emblemId;
    }

    public int getRegionId() {
        return regionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locality locality = (Locality) o;

        if (id != locality.id) return false;
        if (populationAmount != locality.populationAmount) return false;
        if (isCapital != locality.isCapital) return false;
        if (isRegionCentre != locality.isRegionCentre) return false;
        if (countryId != locality.countryId) return false;
        if (localityTypeId != locality.localityTypeId) return false;
        if (emblemId != locality.emblemId) return false;
        if (regionId != locality.regionId) return false;
        return name != null ? name.equals(locality.name) : locality.name == null;
    }
}
