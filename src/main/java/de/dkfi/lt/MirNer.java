package de.dkfi.lt;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by philippe on 1/10/17.
 */
public class MirNer {

    final private static String prefix="(^|[\\s\\(\\)\\[\\'\"/,\\-:_])"; //>
    final private static String suffix="(?=([\\.,\\s\\)\\(\\]\\'\":;_\\-/]|$))";
    private static final String species = "((?<species>[a-z]{3})\\-)?";
    private static final String miRNA = "(miR|miRNA|microRNA|micro RNA|micro-RNA|let|miRNA-let|miR-let|has|mmu)\\-";
    private static final String details = "(?<rnaId>[1-9][0-9]{0,2})" //RNA-ID usually between 1 to 3 difits long
                                            +"(?<related>(a|b))?"   //Lettered suffixes denote closely related mature sequences -- for example hsa-miR-121a and hsa-miR-121b would be expressed from precursors hsa-mir-121a and hsa-mir-121b respectively
                                            +"(?<hairpin>\\-(1|2))?" //Distinct precursor sequences and genomic loci that express identical mature sequences get names of the form hsa-mir-121-1 and hsa-mir-121-2
                                            +"(?<precursor>\\-?(3p|5p|\\*))?"; //from the 5' or 3' arm and * is from the opposite arm of the precursor


    private final Pattern simpleMiRnaPattern = Pattern.compile(prefix +"(?<mention>" +species + miRNA + details +")" +suffix);

    public MirNer(){
        super();
    }

    public List<MiRnaMention> extractFromText(String text){
        List<MiRnaMention> result = new ArrayList<MiRnaMention>();

        Matcher matcher = simpleMiRnaPattern.matcher(text);
        while (matcher.find()){
            MiRnaMention mention = new MiRnaMention(matcher.group("species"), matcher.group("rnaId"), matcher.group("related"), matcher.group("hairpin"), matcher.group("precursor"),
                    matcher.start("mention"), matcher.end("mention"), matcher.group("mention"));
            result.add(mention);
        }

        return result;
    }

    public static void main(String[] args){
        String text = "We detected the following mirna hsa-miR-216a* in human cel-lines.";
        MirNer mir = new MirNer();
        System.out.println(mir.extractFromText(text));
    }


/** Currently missing complex RNA mentions
 * miR-123, -46, -23
 * miR-200a, b, c
 * miR-21/137
 * miR-99a/100
 * miR-99a/b
 * miR-15a/16-1
 * miR-221/-222
 * miR-23b/-27b
 * miR-221&222
 */
}
