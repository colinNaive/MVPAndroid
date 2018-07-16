package com.ctrip.mvpapplication.presenter

import android.os.Handler
import com.ctrip.mvpapplication.interfaces.ITestView
import com.ctrip.mvpapplication.interfaces.OnDataCallback
import com.ctrip.mvpapplication.model.ModelOne
import com.ctrip.mvpapplication.model.ModelThree
import com.ctrip.mvpapplication.model.ModelTwo
import com.ctrip.mvpapplication.model.TestModel

/**
 * @author Zhenhua on 2018/7/16.
 * @email zhshan@ctrip.com ^.^
 */
class TestPresenter : OnDataCallback {
    override fun requestModuleOneRes(data: ModelOne) {
        mView.initModuleOne(data)
    }

    override fun requestModuleTwoRes(data: ModelTwo) {
        mView.initModuleTwo(data)
    }

    override fun requestModuleThreeRes(data: ModelThree) {
        mView.initModuleThree(data)
    }

    private var mView: ITestView
    private var mTestModel: TestModel

    constructor(view: ITestView) {
        this.mView = view
        this.mTestModel = TestModel()
    }

    fun startDrawUI() {
        getModelOne()
        getModelTwo()
        getModelThree()
    }

    fun getModelOne() {
        mTestModel.getModelOne(this)
    }

    fun getModelTwo() {
        mTestModel.getModelTwo(this)
    }

    fun getModelThree() {
        mTestModel.getModelThree(this)
    }
}