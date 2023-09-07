package info.nightscout.core.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DecimalFormatterTest {

    @Test fun to0DecimalTest() {
        Assertions.assertEquals("1", decimalFormatter.to0Decimal(1.33).replace(",", "."))
        Assertions.assertEquals("1U", decimalFormatter.to0Decimal(1.33, "U").replace(",", "."))
    }

    @Test fun to1DecimalTest() {
        Assertions.assertEquals("1.3", decimalFormatter.to1Decimal(1.33).replace(",", "."))
        Assertions.assertEquals("1.3U", decimalFormatter.to1Decimal(1.33, "U").replace(",", "."))
    }

    @Test fun to2DecimalTest() {
        Assertions.assertEquals("1.33", decimalFormatter.to2Decimal(1.3333).replace(",", "."))
        Assertions.assertEquals("1.33U", decimalFormatter.to2Decimal(1.3333, "U").replace(",", "."))
    }

    @Test fun to3DecimalTest() {
        Assertions.assertEquals("1.333", decimalFormatter.to3Decimal(1.3333).replace(",", "."))
        Assertions.assertEquals("1.333U", decimalFormatter.to3Decimal(1.3333, "U").replace(",", "."))
    }
}