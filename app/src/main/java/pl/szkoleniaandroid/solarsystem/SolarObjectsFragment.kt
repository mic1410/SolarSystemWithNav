package pl.szkoleniaandroid.solarsystem

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.fragment.app.Fragment
import me.tatarka.bindingcollectionadapter2.ItemBinding
import pl.szkoleniaandroid.solarsystem.databinding.SolarObjectsFragmentBinding

abstract class SolarObjectsFragment : Fragment() {

    lateinit var binding: SolarObjectsFragmentBinding

    val objects = ObservableArrayList<SolarObject>()
    val itemBinding = ItemBinding.of<SolarObject>(BR.item, R.layout.solar_object_item)
        .bindExtra(BR.listener, object : ObjectClickedListener {
            override fun objectClicked(clickedObject: SolarObject) {
                Log.d("TAG", "clicked..........")
            }
        })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SolarObjectsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        objects.addAll(createObjects())
    }

    abstract fun createObjects(): Array<SolarObject>
}

interface ObjectClickedListener {
    fun objectClicked(clickedObject: SolarObject)
}