package com.ctrip.mvpapplication.model

import com.ctrip.mvpapplication.interfaces.OnDataCallback
import com.ctrip.mvpapplication.sender.SenderOne
import com.ctrip.mvpapplication.sender.SenderThree
import com.ctrip.mvpapplication.sender.SenderTwo

/**
 * @author Zhenhua on 2018/7/16.
 * @email zhshan@ctrip.com ^.^
 */
class TestModel {
    private var mSenderOne: SenderOne
    private var mSenderTwo: SenderTwo
    private var mSenderThree: SenderThree

    constructor() {
        mSenderOne = SenderOne()
        mSenderTwo = SenderTwo()
        mSenderThree = SenderThree()
    }

    fun getModelOne(listener: OnDataCallback) {
        mSenderOne.send("paramOne", listener)
    }

    fun getModelTwo(listener: OnDataCallback) {
        mSenderTwo.send("paramTwo", listener)
    }

    fun getModelThree(listener: OnDataCallback) {
        mSenderThree.send("paramThree", listener)
    }
}