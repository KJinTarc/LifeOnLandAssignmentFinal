package com.example.lifeonlandassignment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.lifeonlandassignment.database.AssignmentDatabase
import com.example.lifeonlandassignment.database.AssignmentDatabaseRepository
import com.example.lifeonlandassignment.database.Event
import com.example.lifeonlandassignment.databinding.EventDescriptionScreen2Binding
import com.example.lifeonlandassignment.userHome.EventFragment
import com.example.lifeonlandassignment.userHome.EventHappenViewModel
import com.example.lifeonlandassignment.userHome.EventHappenViewModelFactory
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EventHappenFragment : Fragment() {
    private lateinit var eventHappenViewModel: EventHappenViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: EventDescriptionScreen2Binding = DataBindingUtil.inflate(
            inflater, R.layout.event_description_screen_2, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = AssignmentDatabase.getInstance(application).assignmentDatabaseDao
        val repository = AssignmentDatabaseRepository(dataSource)
        val factory = EventHappenViewModelFactory(repository, application)

        eventHappenViewModel = ViewModelProvider(this, factory).get(EventHappenViewModel::class.java)
        binding.eventHappenViewModel = eventHappenViewModel
        binding.lifecycleOwner = this

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = Date()
        val eventList: Event? = runBlocking { eventHappenViewModel.getHappenEvent(dateFormat.format(currentDate)) }
        Log.i("Testing", eventList!!.eventImage + "123")
        if(eventList != null){
            Glide.with(requireContext())
                .load(eventList.eventImage)
                .placeholder(R.drawable.sunde_island2)
                .into(binding.picEventHappenHarimau)

            binding.txtEventHappenTitle.text = eventList.eventName
            binding.txtEventHappenTitle3.text = "Duration : " + eventList.eventStartDate + " to " + eventList.eventEndDate
            binding.txtEventHappen.text = eventList.eventDescription
        }
        else{
            binding.picEventHappenHarimau.visibility = View.GONE
            binding.txtEventHappenTitle.visibility = View.GONE
            binding.txtEventHappenTitle3.visibility = View.GONE
            binding.txtEventHappen.text = "Currently no event."
            binding.textView.visibility = View.GONE
            binding.tableLayout.visibility = View.GONE
            binding.btnJoinEvent.visibility = View.GONE
            binding.btnDonate.visibility = View.GONE
            binding.btnLeaveEvent.visibility = View.GONE
        }

        val button: Button = binding.btnDonate
        button.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, DonationFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        // Initialize the back button ImageView
        val backButton: ImageView = binding.backButtonEventHappen
        // Set click listener for back button
        backButton.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, EventFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return binding.root
    }
}