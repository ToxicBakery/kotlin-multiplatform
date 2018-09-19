package com.toxicbakery.multiplatform

import com.toxicbakery.multiplatform.model.NumericValue
import com.toxicbakery.multiplatform.operation.NumericOperation

class Calculator {

    fun calculate(
            left: NumericValue,
            right: NumericValue,
            operator: NumericOperation
    ): NumericValue = operator.calculate(left, right)

}
