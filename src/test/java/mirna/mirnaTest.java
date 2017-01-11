package mirna;

import de.dkfi.lt.MiRNA;
import de.dkfi.lt.MiRnaMention;
import de.dkfi.lt.MirNer;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by philippe on 1/11/17.
 * Tests created from "miRCancer: a microRNA–cancer association database constructed by text mining on literature"; Table 2+3
 */
public class mirnaTest {

    private MirNer mirNer;

    @Before
    public void setUp() {
        mirNer = new MirNer();
    }


    @Test
    public void test1(){
        String rna = "We detected the following mirna hsa-miR-216a in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("hsa-miR-216a", result.get(0).getText());
    }

    @Test
    public void test2(){
        String rna = "We detected the following mirna hsa-miR-216b in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("hsa-miR-216b", result.get(0).getText());
    }

    @Test
    public void test3(){
        String rna = "We detected the following mirna hsa-miR-16-1 in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("hsa-miR-16-1", result.get(0).getText());
    }

    @Test
    public void test4(){
        String rna = "We detected the following mirna hsa-miR-16-2 in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("hsa-miR-16-2", result.get(0).getText());
    }

    @Test
    public void test5(){
        String rna = "We detected the following mirna hsa-miR-17-3p in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("hsa-miR-17-3p", result.get(0).getText());
    }

    @Test
    public void test6(){
        String rna = "We detected the following mirna hsa-miR-17-5p in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("hsa-miR-17-5p", result.get(0).getText());
    }

    @Test
    public void test7(){
        String rna = "We detected the following mirna has-miR-100* in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("has-miR-100*", result.get(0).getText());
    }

    @Test
    public void test8(){
        String rna = "We detected the following mirna miR-137 in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("miR-137", result.get(0).getText());
    }

    @Test
    public void test9(){
        String rna = "We detected the following mirna let-7b in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("let-7b", result.get(0).getText());
    }

    //Complex mention
    @Test
    public void complex(){
        String rna = "We detected the following mirna miR-let-7a/let-7b in cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
    }



    //Further tests
    @Test
    public void test10(){
        String rna = "We detected the following mirna miR-100* in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("miR-100*", result.get(0).getText());
    }

    @Test
    public void test11(){
        String rna = "We detected the following mirna miR-16-1 in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("miR-16-1", result.get(0).getText());
    }

    @Test
    public void test12(){
        String rna = "We detected the following mirna hsa-miR-216a* in human cel-lines.";
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("hsa-miR-216a*", result.get(0).getText());
    }

    @Test
    public void test14(){
        String rna = "We detected the following mirna hsa-miR-2116a* in human cel-lines."; //The last published miRNA was mouse mir-352; so Ids currently need to be between 1-3 digits
        List<MiRnaMention> result= mirNer.extractFromText(rna);

        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

}
