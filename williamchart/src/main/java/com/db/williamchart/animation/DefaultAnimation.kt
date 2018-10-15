package com.db.williamchart.animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import com.db.williamchart.data.ChartEntry

class DefaultAnimation : ChartAnimation() {

    override fun animateFrom(y: Float,
                             entries: MutableList<ChartEntry>,
                             callback: () -> Unit) : ChartAnimation{

        entries.forEach { entry ->
            val eAnimator: ObjectAnimator = ObjectAnimator.ofFloat(entry, "y", y, entry.y)
            eAnimator.duration = duration
            eAnimator.interpolator = interpolator
            eAnimator.start()
        }

        val animator: ValueAnimator = ValueAnimator.ofInt(0,1)
        animator.addUpdateListener { callback.invoke() }
        animator.duration = duration
        animator.interpolator = interpolator
        animator.start()

        return this
    }
}