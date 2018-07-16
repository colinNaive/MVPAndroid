package com.ctrip.mvpapplication.interfaces

import com.ctrip.mvpapplication.model.ModelOne
import com.ctrip.mvpapplication.model.ModelThree
import com.ctrip.mvpapplication.model.ModelTwo

/**
 * @author Zhenhua on 2018/7/16.
 * @email zhshan@ctrip.com ^.^
 */
interface ITestView {
    fun initModuleOne(data: ModelOne)
    fun initModuleTwo(data: ModelTwo)
    fun initModuleThree(data: ModelThree)
}