package com.ctrip.mvpapplication.sender

import com.ctrip.mvpapplication.interfaces.OnDataCallback
import com.ctrip.mvpapplication.model.ModelThree
import java.util.*

/**
 * @author Zhenhua on 2018/7/16.
 * @email zhshan@ctrip.com ^.^
 */
class SenderThree {
    fun send(paramThree: String, listener: OnDataCallback?) {
        var modelThree = ModelThree()
        var random = Random()
        modelThree.data = paramThree + random.nextInt()
        listener?.requestModuleThreeRes(modelThree)
    }
}