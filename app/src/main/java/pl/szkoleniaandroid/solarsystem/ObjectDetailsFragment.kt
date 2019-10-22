package pl.szkoleniaandroid.solarsystem


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.object_details_content.*
import java.util.zip.Inflater

/**
 * A simple [Fragment] subclass.
 */
class ObjectDetailsFragment : Fragment() {

    //me: run build was neccessary to generate ObjectDetailsFragmentArgs
    val args by navArgs<ObjectDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.object_details_fragment, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsTextView.text = args.solarObject.name
    }

}
