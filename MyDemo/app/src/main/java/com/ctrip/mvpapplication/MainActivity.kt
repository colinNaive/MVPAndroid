package com.ctrip.mvpapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.ctrip.mvpapplication.delegates.ModuleOneDelegate
import com.ctrip.mvpapplication.delegates.ModuleThreeDelegate
import com.ctrip.mvpapplication.delegates.ModuleTwoDelegate
import com.ctrip.mvpapplication.interfaces.ITestView
import com.ctrip.mvpapplication.model.ModelOne
import com.ctrip.mvpapplication.model.ModelThree
import com.ctrip.mvpapplication.model.ModelTwo
import com.ctrip.mvpapplication.presenter.TestPresenter

class MainActivity : AppCompatActivity(), ITestView {
    private lateinit var mModuleOneDelegate: ModuleOneDelegate
    private lateinit var mModuleTwoDelegate: ModuleTwoDelegate
    private lateinit var mModuleThreeDelegate: ModuleThreeDelegate
    private lateinit var mPresenter: TestPresenter

    override fun initModuleOne(data: ModelOne) {
        mModuleOneDelegate.refresh(data)
    }

    override fun initModuleTwo(data: ModelTwo) {
        mModuleTwoDelegate.refresh(data)
    }

    override fun initModuleThree(data: ModelThree) {
        mModuleThreeDelegate.refresh(data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = TestPresenter(this)

        mModuleOneDelegate = ModuleOneDelegate(mPresenter, this)
        mModuleTwoDelegate = ModuleTwoDelegate(mPresenter, this)
        mModuleThreeDelegate = ModuleThreeDelegate(mPresenter, this)

        Handler().postDelayed({
            mPresenter.startDrawUI()
        }, 2000)
    }
}
