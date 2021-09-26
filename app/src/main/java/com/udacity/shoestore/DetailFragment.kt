package com.udacity.shoestore
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_detail.*
import timber.log.Timber
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private  val viewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        binding.lifecycleOwner = this

        binding.btnCancel.setOnClickListener{
            val action =DetailFragmentDirections.actionDetailFragmentToListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        binding.btnSave.setOnClickListener {
            var name = editName.text.toString()
            var size = editSize.text.toString()
            var company = editCompany.text.toString()
            var description = editDescript.text.toString()
            Log.i("agoing to","Add")
            var sizeDouble : Double = 0.0
            try {
                sizeDouble = size.toDouble()
            } catch (e: NumberFormatException) {
                Timber.i("Invalid size entered")
            }
           viewModel.addList(name,sizeDouble,company,description)
            val action =DetailFragmentDirections.actionDetailFragmentToListFragment()
            NavHostFragment.findNavController(this).navigate(action)
         //  view.findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }


        return binding.root
    }
}