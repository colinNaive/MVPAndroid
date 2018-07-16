package com.ctrip.mvpapplication.sender

import com.ctrip.mvpapplication.interfaces.OnDataCallback
import com.ctrip.mvpapplication.model.ModelOne
import java.util.*

/**
 * @author Zhenhua on 2018/7/16.
 * @email zhshan@ctrip.com ^.^
 */
class SenderOne {
    fun send(paramOne: String, listener: OnDataCallback?) {
        var modelOne = ModelOne()
        var random = Random()
        modelOne.data = paramOne + random.nextInt()
        listener?.requestModuleOneRes(modelOne)
    }
}