package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.databinding.ShoeDataBinding



/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    private val  viewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var binding = DataBindingUtil.inflate<FragmentListBinding>(
           inflater, R.layout.fragment_list, container, false)
     //   viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        Log.i("AM in list","before observe")

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            Log.i("AM in list","inside observe")
        for(shoe in viewModel.shoeList.value!!)
        {
           val bindinglist = ShoeDataBinding.inflate(layoutInflater)
            bindinglist.shoes = shoe
            binding.linearShoe.addView(bindinglist.root)
            Log.i("AM in list","fragment display list")
        }
        })
        binding.fabAdd.setOnClickListener{ view:View ->
            view.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.logout_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }


}