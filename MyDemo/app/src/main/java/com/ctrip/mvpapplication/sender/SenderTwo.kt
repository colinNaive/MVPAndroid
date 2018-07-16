package com.ctrip.mvpapplication.sender

import com.ctrip.mvpapplication.interfaces.OnDataCallback
import com.ctrip.mvpapplication.model.ModelTwo
import java.util.*

/**
 * @author Zhenhua on 2018/7/16.
 * @email zhshan@ctrip.com ^.^
 */
class SenderTwo {
    fun send(paramTwo: String, listener: OnDataCallback?) {
        var modelTwo = ModelTwo()
        var random = Random()
        modelTwo.data = paramTwo + random.nextInt()
        listener?.requestModuleTwoRes(modelTwo)
    }
}