package com.example.lifeonlandassignment

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RemoteViews
import android.widget.TableRow
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.example.lifeonlandassignment.admin.ClientDataFragment
import com.example.lifeonlandassignment.admin.DonationDataFragment
import com.example.lifeonlandassignment.admin.EventDataFragment
import com.example.lifeonlandassignment.admin.ReportDataFragment

class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.notification_screen, container, false)

        val tableLayout1 : TableRow = view.findViewById(R.id.btnNotice1)
        tableLayout1.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, NotificationDescriptionFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val tableLayout2 : TableRow = view.findViewById(R.id.btnNotice2)
        tableLayout2.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, NotificationDescriptionFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val tableLayout3 : TableRow = view.findViewById(R.id.btnNotice3)
        tableLayout3.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, NotificationDescriptionFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val tableLayout4 : TableRow = view.findViewById(R.id.btnNotice4)
        tableLayout4.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, NotificationDescriptionFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }
}