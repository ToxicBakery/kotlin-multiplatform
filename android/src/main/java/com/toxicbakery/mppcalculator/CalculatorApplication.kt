package com.toxicbakery.mppcalculator

import android.app.Application
import com.toxicbakery.logging.Arbor
import com.toxicbakery.logging.LogCatSeedling

class CalculatorApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Arbor.sow(LogCatSeedling())
    }

}
