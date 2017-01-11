package de.dfki.nlp;

/**
 * Created by philippe on 1/10/17.
 */
public class MiRNA {

    protected String species;
    protected String rnaId;
    protected String related;
    protected String hairpin;
    protected String precursor;

    public MiRNA(String species, String rnaId, String related, String hairpin, String precursor) {
        this.species = species;
        this.rnaId = rnaId;
        this.related = related;
        this.hairpin = hairpin;
        this.precursor = precursor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiRNA miRNA = (MiRNA) o;

        if (species != null ? !species.equals(miRNA.species) : miRNA.species != null) return false;
        if (rnaId != null ? !rnaId.equals(miRNA.rnaId) : miRNA.rnaId != null) return false;
        if (related != null ? !related.equals(miRNA.related) : miRNA.related != null) return false;
        if (hairpin != null ? !hairpin.equals(miRNA.hairpin) : miRNA.hairpin != null) return false;
        return precursor != null ? precursor.equals(miRNA.precursor) : miRNA.precursor == null;
    }

    @Override
    public int hashCode() {
        int result = species != null ? species.hashCode() : 0;
        result = 31 * result + (rnaId != null ? rnaId.hashCode() : 0);
        result = 31 * result + (related != null ? related.hashCode() : 0);
        result = 31 * result + (hairpin != null ? hairpin.hashCode() : 0);
        result = 31 * result + (precursor != null ? precursor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MiRNA{" +
                "species='" + species + '\'' +
                ", rnaId='" + rnaId + '\'' +
                ", related='" + related + '\'' +
                ", hairpin='" + hairpin + '\'' +
                ", precursor='" + precursor + '\'' +
                '}';
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRnaId() {
        return rnaId;
    }

    public void setRnaId(String rnaId) {
        this.rnaId = rnaId;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getHairpin() {
        return hairpin;
    }

    public void setHairpin(String hairpin) {
        this.hairpin = hairpin;
    }

    public String getPrecursor() {
        return precursor;
    }

    public void setPrecursor(String precursor) {
        this.precursor = precursor;
    }
}
