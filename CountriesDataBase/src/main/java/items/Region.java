package items;

public class Region {
    public int id;
    public String name;
    public int code;
    public int populationAmount;
    public String geoData;
    public int emblemId;

    public Region(int id, String name, int code, int populationAmount, String geoData, int emblemId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.populationAmount = populationAmount;
        this.geoData = geoData;
        this.emblemId = emblemId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getPopulationAmount() {
        return populationAmount;
    }

    public String getGeoData() {
        return geoData;
    }

    public int getEmblemId() {
        return emblemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (id != region.id) return false;
        if (code != region.code) return false;
        if (populationAmount != region.populationAmount) return false;
        if (emblemId != region.emblemId) return false;
        if (name != null ? !name.equals(region.name) : region.name != null) return false;
        return geoData != null ? geoData.equals(region.geoData) : region.geoData == null;
    }
}
