package org.d3if4010.praasessment


import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import org.d3if4010.praasessment.databinding.ActivityMainBinding
import org.d3if4010.praasessment.databinding.FragmentBangunDataBinding
import org.d3if4010.praasessment.databinding.FragmentPersegiPanjangBinding


/**
 * A simple [Fragment] subclass.
 */
class PersegiPanjangFragment : Fragment() {

    private var luas = 0
    private var keliling = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPersegiPanjangBinding>(
            inflater,
            R.layout.fragment_persegi_panjang, container, false
        )

        if (savedInstanceState != null){
            luas = savedInstanceState.getInt("luas")
            keliling = savedInstanceState.getInt("keliling")
        }

        binding.btnShare.setOnClickListener {
            val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setText(getString(R.string.share_text,luas,keliling))
                .setType("text/plain")
                .intent
            try {
                startActivity(shareIntent)
            }
        catch (ex : ActivityNotFoundException){
            Toast.makeText(context,"Htyuuy",Toast.LENGTH_LONG).show()
        }
        }
        binding.btnHitung.setOnClickListener {
            // Null safety if
            if (edtPanjang.text.toString().isEmpty()) {
                edtPanjang.error = "Panjang harus di isi"
                // Lalu langsung return atau menghentikan jalannya code, tidak dilanjutkan code berikutnya
                return@setOnClickListener
            }

            // Null safety if
            if (edtLebar.text.toString().isEmpty()) {
                edtLebar.error = "Lebar harus di isi"
                // Lalu langsung return atau menghentikan jalannya code, tidak dilanjutkan code berikutnya
                return@setOnClickListener
            }

            // Menggunakan elvis operator ?: "default" agar tidak bernilai null
            // tapi akan memberikan nilai default dari penggunaaan elvis operator
            val panjang = edtPanjang.text.toString().toInt()
            val lebar = edtLebar.text.toString().toInt()

            luas = panjang * lebar
            keliling = 2 * (panjang + lebar)

            txtHasil.text = luas.toString()
            txtHasil1.text = keliling.toString()
//            txtHasil.setText("Luas : " + hasil.toString())
//            txtHasil1.setText("Keliling : " + hasil1.toString())
        }
        binding.luaspp = luas
        binding.kelilingpp = keliling
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("luas",luas)
        outState.putInt("keliling", keliling)
        super.onSaveInstanceState(outState)
    }
}
