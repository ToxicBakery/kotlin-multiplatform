package com.toxicbakery.multiplatform.operation

import com.toxicbakery.multiplatform.model.NumericValue

actual class PowerOperation : NumericOperation {

    override fun calculate(left: NumericValue, right: NumericValue): NumericValue =
            NumericValue(Math.pow(left.input, right.input))

}
