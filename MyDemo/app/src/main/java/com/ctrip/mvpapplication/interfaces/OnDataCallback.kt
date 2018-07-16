package com.ctrip.mvpapplication.interfaces

import com.ctrip.mvpapplication.model.ModelOne
import com.ctrip.mvpapplication.model.ModelThree
import com.ctrip.mvpapplication.model.ModelTwo

/**
 * @author Zhenhua on 2018/7/16.
 * @email zhshan@ctrip.com ^.^
 */
interface OnDataCallback {
    fun requestModuleOneRes(data: ModelOne)
    fun requestModuleTwoRes(data: ModelTwo)
    fun requestModuleThreeRes(data: ModelThree)
}