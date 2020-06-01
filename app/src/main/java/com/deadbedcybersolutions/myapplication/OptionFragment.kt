package com.deadbedcybersolutions.myapplication


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.deadbedcybersolutions.myapplication.Signing_activities.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_option.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
//Signing Out Button code

/**
 * A simple [Fragment] subclass.
 * Use the [OptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OptionFragment : Fragment(){
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View=inflater.inflate(R.layout.fragment_option, container, false)
        val signout: Button=view.findViewById(R.id.signout)
        signout.setOnClickListener {
            Toast.makeText(activity,"Logged Out",Toast.LENGTH_SHORT).show()
            FirebaseAuth.getInstance().signOut()
            val i: Intent= Intent(activity,MainActivity::class.java)
            startActivity(i)
        }
       val Call1: Button=view.findViewById(R.id.Call)
        Call1.setOnClickListener {
            Toast.makeText(activity,"Opening Dialer!",Toast.LENGTH_SHORT).show()
            val num: String="+918925760280"
            val m= Uri.parse("tel:"+Uri.encode(num))
            val g: Intent=Intent(Intent.ACTION_DIAL,m)
            startActivity(g)
        }
        val Mail: Button=view.findViewById(R.id.Mail)
        Mail.setOnClickListener {
            Toast.makeText(activity,"Opening Mail",Toast.LENGTH_SHORT).show()
            val m: Intent= Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+"deadbedcybersolutions@gmail.com"))
            startActivity(Intent.createChooser(m,"send Mail"))
        }
        val Whatsapp: Button=view.findViewById(R.id.Whatsapp)
        Whatsapp.setOnClickListener {
            Toast.makeText(activity,"Opening Whatsapp",Toast.LENGTH_SHORT).show()
            val m: Uri=Uri.parse("smsto:"+"+918925760280")
            val g: Intent= Intent(Intent.ACTION_SENDTO,m)
            g.setPackage("com.whatsapp")
            startActivity(g)
        }
        // Inflate the layout for this fragment
        return view

    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OptionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OptionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}
