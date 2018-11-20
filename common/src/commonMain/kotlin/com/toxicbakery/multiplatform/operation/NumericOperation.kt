package com.toxicbakery.multiplatform.operation

import com.toxicbakery.multiplatform.model.NumericValue

interface NumericOperation {

    fun calculate(
            left: NumericValue,
            right: NumericValue
    ): NumericValue

}
