package de.dfki.nlp;

/**
 * Created by philippe on 1/11/17.
 */
public class MiRnaMention extends MiRNA{

    private int start;
    private int end;
    private String text;

    public MiRnaMention(String species, String rnaId, String related, String hairpin, String precursor, int start, int end, String text) {
        super(species, rnaId, related, hairpin, precursor);
        this.start = start;
        this.end = end;
        this.text = text;
    }

    public MiRnaMention(String species, String rnaId, String related, String hairpin, String precursor) {
        super(species, rnaId, related, hairpin, precursor);
    }

    //public String getNormalized(){
    //    species == null ?
    //}


    @Override
    public String toString() {
        return "MiRnaMention{" +
                "start=" + start +
                ", end=" + end +
                ", text='" + text + '\'' +
                '}';
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MiRnaMention that = (MiRnaMention) o;

        if (start != that.start) return false;
        if (end != that.end) return false;
        return text != null ? text.equals(that.text) : that.text == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + start;
        result = 31 * result + end;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
