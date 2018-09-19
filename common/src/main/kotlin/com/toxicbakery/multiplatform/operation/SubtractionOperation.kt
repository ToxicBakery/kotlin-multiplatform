package com.toxicbakery.multiplatform.operation

import com.toxicbakery.multiplatform.model.NumericValue

class SubtractionOperation : NumericOperation {

    override fun calculate(left: NumericValue, right: NumericValue): NumericValue =
            NumericValue(left.input - right.input)

}
