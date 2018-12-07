package com.toxicbakery.multiplatform.operation

import com.toxicbakery.multiplatform.model.NumericValue
import org.junit.Assert
import org.junit.Test

class PowerOperationTest {

    @Test
    fun calculate() {
        PowerOperation().apply {
            Assert.assertEquals(NumericValue(4.0), calculate(NumericValue(2.0), NumericValue(2.0)))
        }
    }

}