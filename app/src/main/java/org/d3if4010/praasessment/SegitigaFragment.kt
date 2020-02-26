package org.d3if4010.praasessment


import android.content.ActivityNotFoundException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import kotlinx.android.synthetic.main.fragment_persegi_panjang.txtHasil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.txtHasil1
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3if4010.praasessment.databinding.FragmentPersegiPanjangBinding
import org.d3if4010.praasessment.databinding.FragmentSegitigaBinding

/**
 * A simple [Fragment] subclass.
 */
class SegitigaFragment : Fragment() {
    private var luas2 = 0.0
    private var keliling2 = 0.0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(
            inflater,
            R.layout.fragment_segitiga, container, false
        )
        if (savedInstanceState != null) {
            luas2 = savedInstanceState.getDouble("luas2")
            keliling2 = savedInstanceState.getDouble("keliling2")
        }
        binding.bShare.setOnClickListener {
            val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setText(getString(R.string.share_text,luas2.toInt(),keliling2.toInt()))
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
            if (edtAlas.text.toString().isEmpty() && edtTinggi.text.toString().isEmpty()) {
                Toast.makeText(context, "Harus Diisi", Toast.LENGTH_LONG).show()
                // Lalu langsung return atau menghentikan jalannya code, tidak dilanjutkan code berikutnya
            }

            val alas = edtAlas.text.toString().toDouble()
            val tinggi = edtTinggi.text.toString().toDouble()
            luas2 = (alas * tinggi) / 2.0

            txtHasil.text = luas2.toString()
            var sisimiring =
                Math.sqrt(Math.pow(alas, 2.0) + Math.pow(tinggi, 2.0))
            keliling2 = alas + tinggi + sisimiring
            txtHasil1.text = keliling2.toString()

            // Null safety if

        }


        binding.luassegitiga = luas2
        binding.kelilingsegitiga = keliling2
        // Menggunakan elvis operator ?: "default" agar tidak bernilai null
        // tapi akan memberikan nilai default dari penggunaaan elvis operator
        return binding.root
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("luas2",luas2)
        outState.putDouble("keliling2",keliling2)
        super.onSaveInstanceState(outState)
    }
}
