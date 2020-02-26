package org.d3if4010.praasessment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if4010.praasessment.databinding.FragmentBangunDataBinding


/**
 * A simple [Fragment] subclass.
 */
class BangunDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentBangunDataBinding>(
            inflater,
            R.layout.fragment_bangun_data, container, false
        )
        binding.persegiPanjang.setOnClickListener {
            view?.findNavController()?.navigate(
                R.id.action_bangunDataFragment_to_persegiPanjangFragment
            )
        }
        binding.Segitiga.setOnClickListener {
            view?.findNavController()?.navigate(
                R.id.action_bangunDataFragment_to_segitigaFragment
            )
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
    }
