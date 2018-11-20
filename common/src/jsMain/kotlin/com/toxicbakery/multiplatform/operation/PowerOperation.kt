@file:Suppress("DEPRECATION")

package com.toxicbakery.multiplatform.operation

import com.toxicbakery.multiplatform.model.NumericValue
import kotlin.math.pow

/**
 * Example expect/actual implementation. Kotlin could provide this directly as it has the ability to calculate powers
 * as an extension function of doubles; however, this is purely for example sake.
 */
@Suppress("DEPRECATION")
actual class PowerOperation actual constructor() : NumericOperation {

    override fun calculate(left: NumericValue, right: NumericValue): NumericValue =
            NumericValue(left.input.pow(right.input))

}
