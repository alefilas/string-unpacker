package ru.alefilas;

import org.junit.Assert;
import org.junit.Test;
import ru.alefilas.unpacker.StringUnpacker;

public class StringUnpackerTest {

    @Test
    public void unpackStringShouldBeRight() {
        String str = StringUnpacker.unpack("3[xyz]4[xy]z");
        Assert.assertEquals("xyzxyzxyzxyxyxyxyz", str);

        str = StringUnpacker.unpack("2[3[x]y]");
        Assert.assertEquals("xxxyxxxy", str);

        str = StringUnpacker.unpack("2[3[2[z]x]y]");
        Assert.assertEquals("zzxzzxzzxyzzxzzxzzxy", str);

        str = StringUnpacker.unpack("3[xyz]fg4[xy]z");
        Assert.assertEquals("xyzxyzxyzfgxyxyxyxyz", str);

        str = StringUnpacker.unpack("11[x]");
        Assert.assertEquals("xxxxxxxxxxx", str);

        str = StringUnpacker.unpack("2[xy2[e]z]");
        Assert.assertEquals("xyeezxyeez", str);

        str = StringUnpacker.unpack("abc");
        Assert.assertEquals("abc", str);
    }

    @Test
    public void notValidStringShouldReturnNotValid() {
        String str = StringUnpacker.unpack("3xyz]4[xy]z");
        Assert.assertEquals("Not valid!", str);

        str = StringUnpacker.unpack("2[3[x][y]");
        Assert.assertEquals("Not valid!", str);

        str = StringUnpacker.unpack("3xyz]4[xy]z!");
        Assert.assertEquals("Not valid!", str);

        str = StringUnpacker.unpack("ab[c]");
        Assert.assertEquals("Not valid!", str);

        str = StringUnpacker.unpack("2[[x]y]");
        Assert.assertEquals("Not valid!", str);

        str = StringUnpacker.unpack("111x2[x]");
        Assert.assertEquals("Not valid!", str);

        str = StringUnpacker.unpack("2[3[x]y]2s");
        Assert.assertEquals("Not valid!", str);

        str = StringUnpacker.unpack("2[3[x]y]2");
        Assert.assertEquals("Not valid!", str);

    }
}
