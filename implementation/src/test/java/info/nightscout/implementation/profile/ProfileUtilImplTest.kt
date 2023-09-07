package info.nightscout.implementation.profile

import info.nightscout.database.entities.GlucoseValue
import info.nightscout.implementation.utils.DecimalFormatterImpl
import info.nightscout.interfaces.GlucoseUnit
import info.nightscout.shared.interfaces.ResourceHelper
import info.nightscout.shared.sharedPreferences.SP
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock

class ProfileUtilImplTest {

    @Mock lateinit var rh: ResourceHelper
    @Mock lateinit var sp: SP

    private val glucoseValue =
        GlucoseValue(raw = 0.0, noise = 0.0, value = 100.0, timestamp = 1514766900000, sourceSensor = GlucoseValue.SourceSensor.UNKNOWN, trendArrow = GlucoseValue.TrendArrow.FLAT)

    private lateinit var sut: ProfileUtilImpl

    @BeforeEach
    fun setup() {
        val decimalFormatter = DecimalFormatterImpl(rh)
        sut = ProfileUtilImpl(sp, decimalFormatter)
    }

    @Test
    fun toUnitsString() {
        Assertions.assertEquals("100", sut.fromMgdlToStringInUnits(glucoseValue.value, GlucoseUnit.MGDL))
        Assertions.assertEquals("5.6", sut.fromMgdlToStringInUnits(glucoseValue.value, GlucoseUnit.MMOL))
    }
}