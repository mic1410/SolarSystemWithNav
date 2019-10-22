package pl.szkoleniaandroid.solarsystem


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.solar_objects_fragment.*

/**
 * A simple [Fragment] subclass.
 */
class PlanetsFragment : SolarObjectsFragment() {

//    override fun createObjects(): Array<SolarObject> {
////        return (requireActivity() as SolarSystemActivity).objectsRepository.planets
//        return (requireActivity() as SolarSystemActivity).objectsRepository.planets
//    }

    //me: it's possible to do above but better this:
    override fun createObjects() = repository.planets
}

//me: Extension property
val Fragment.repository: SolarObjectsRepository
    get() = (requireActivity() as SolarSystemActivity).objectsRepository


abstract class SolarObjectsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.solar_objects_fragment, container, false)!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        objectsRecyclerView.adapter = SolarObjectsAdapter().apply {
            setObjects(createObjects())
        }

    }

    abstract fun createObjects(): Array<SolarObject>
}