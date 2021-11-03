package de.hbch.traewelling.ui.include.status

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.card.MaterialCardView
import de.hbch.traewelling.R
import de.hbch.traewelling.adapters.CheckInAdapter
import de.hbch.traewelling.databinding.CardCheckinOverviewBinding
import de.hbch.traewelling.ui.include.alert.AlertBottomSheet
import de.hbch.traewelling.ui.include.deleteStatus.DeleteStatusBottomSheet

class CardCheckInOverview(context: Context?, attrs: AttributeSet?, private val adapter: CheckInAdapter) :
    MaterialCardView(context, attrs, 0) {

        val binding: CardCheckinOverviewBinding =
            CardCheckinOverviewBinding
                .inflate(LayoutInflater.from(context), this, false)

        val fragmentManager = (context as FragmentActivity).supportFragmentManager

    fun handleDeleteClicked() {
        val bottomSheet = DeleteStatusBottomSheet { bottomSheet ->
            bottomSheet.dismiss()
            binding.viewModel?.deleteStatus({
                adapter.notifyItemRemoved(
                    adapter.checkIns.indexOf(binding.checkIn)
                )
                adapter.checkIns.remove(binding.checkIn)
                val alertBottomSheet = AlertBottomSheet("success", context.resources.getString(R.string.status_delete_success))
                alertBottomSheet.show(fragmentManager, "AlertBottomSheet")
            }, {
                val alertBottomSheet = AlertBottomSheet("error", context.resources.getString(R.string.status_delete_failure))
                alertBottomSheet.show(fragmentManager, "AlertBottomSheet")
            })
        }
        if (context is FragmentActivity) {
            bottomSheet.show(fragmentManager, "DeleteCheckInBottomSheet")
        }
    }

}