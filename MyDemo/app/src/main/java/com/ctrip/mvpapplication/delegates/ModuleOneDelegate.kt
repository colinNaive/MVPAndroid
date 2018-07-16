package com.ctrip.mvpapplication.delegates

import android.app.Activity
import android.widget.LinearLayout
import android.widget.TextView
import com.ctrip.mvpapplication.R
import com.ctrip.mvpapplication.model.ModelOne
import com.ctrip.mvpapplication.presenter.TestPresenter

/**
 * @author Zhenhua on 2018/7/16.
 * @email zhshan@ctrip.com ^.^
 */
class ModuleOneDelegate {
    private var mPresenter: TestPresenter
    private var mActivity: Activity

    constructor(presenter: TestPresenter, activity: Activity) {
        this.mPresenter = presenter
        this.mActivity = activity
    }

    fun refresh(data: ModelOne) {
        if (data.data.isNullOrEmpty()) {
            return
        }
        mActivity.findViewById<LinearLayout>(R.id.module1).apply {
            setOnClickListener {
                mPresenter.getModelOne()
            }
        }
        mActivity.findViewById<TextView>(R.id.text1).text = data.data
    }
}